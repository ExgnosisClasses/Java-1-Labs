# Lab 9-1: Exceptions 
#### Introduction to Java
---
## Lab Objectives

This lab will emulate a hardware exception that will be raised when the temperature is too hot on a coffee maker

---
<br/>
<br/>

## Part One: Setup

Start a new project and create a `Runner` class with a main method as before.


<br/>
<br/>

## Part Two: Create the Exception

The `OverHeating` exception is going to be derived from the `Exception` class. We don't want to use an unchecked exception because we want to make sure we respond to the exception and don't burn the place down.

Since we want our exception to print out  message, we have to implement the corresponding constructors to the `Exception` class.

```java
 class OverHeatingException extends Exception {
	
	OverHeatingException(String message) {
		super(message);
	}
	
	OverHeatingException() {
		super();
	}	
}

```
<br/>
<br/>

## Part Three: Create the Heater Interface

Since a coffee pot is kind of heater, we can define a reusable `Heater` interface that we expect on all objects that heat stuff up.

```java
interface Heater {
	void turnOn();
	void turnOff();
	void turnTempUp();
	void turnTempDown();
	int getTemp();
	boolean isOn();
}

```

<br/>
<br/>

## Part Four: Create the CoffeMaker class

For the coffee maker, we will need a couple of items of data stored as instance variables

1. Whether the device is on or off

2. The current temperature of the device

We won't need getters and setters since the interface methods already serve that function. To keep the code simple, we will not add any constructors.

And we will need a constant that tells us what the maximum temperature the coffee maker can be set to, and another constant that tells us increments we increase and decrease the temperature by.


The initial code for the coffee maker is.

Filling in the methods is straightforward.

```java
class CoffeeMaker implements Heater {
	private static final int MAXIMUM_TEMP = 100;
	private static final int TEMP_INCREMENT = 25;
	private int currentTemp = 0;
	private boolean isOn = false;
	
	@Override
	public void turnOn() {
		this.isOn = true;
	}
	
	@Override
	public void turnOff() {
		this.isOn = false;
		this.currentTemp = 0;
	}

	@Override
	public void turnTempUp() {
		if (!this.isOn) return;
		this.currentTemp += CoffeeMaker.TEMP_INCREMENT;
		// We need to add the overheating code here
		
	}

	@Override
	public void turnTempDown() {
		// Only turn the temperature down if the the 
		// coffee maker is on and the temp is > 0
		if (!this.isOn) return;
		if (this.currentTemp == 0) return;
		this.currentTemp -= CoffeeMaker.TEMP_INCREMENT;
		
	}
	@Override
	public int getTemp() {
		return this.currentTemp;
	}
	
	@Override
	public boolean isOn() {
		return this.isOn;
	}

	public String toString() {
		return "Status = " + this.isOn() + " Temp = " + this.getTemp();
	}
}
```

<br/>
<br/>

## Part Five: Add the overheating code

In real life, this exception would be thrown as a result of some internal sensor monitoring the actual temperature of the coffee maker.  We will cheat here and put it into the method that increments the temperature.

When the exception is thrown, a message will be printed out and the coffee maker shut down.

We will also anticipate any other exception that might be thrown that we don't recognize, may due to an electrical fault or some other physical problem.

```java
	@Override
	public void turnTempUp() {
		if (!this.isOn) return;
		try {
		     this.currentTemp += CoffeeMaker.TEMP_INCREMENT;
		     if (this.currentTemp >= CoffeeMaker.MAXIMUM_TEMP) {
		    	 throw new OverHeatingException("Coffee maker temperature too high");
		     }
		     } catch (OverHeatingException e) {
		    	 System.out.println(e.getMessage());
		    	 System.out.println("Turning coffee maker off");
		    	 this.turnOff();
		     } catch (Exception e) {
		    	 System.out.println("Unknown fault detected. Turning maker off");
		}		
	}
```
<br/>
<br/>

## Part Six: Test the code

Check to make sure things are working right.

```java
public class Runner {

	public static void main(String[] args) {
		CoffeeMaker c = new CoffeeMaker();
		System.out.println(c);
		c.turnOn();
		System.out.println(c);
		
    	for (int i = 0; i < 6; i++) {
    		c.turnTempUp();
    		System.out.println(c);	
    	}
	}
}
```

Which should produce the following

```console
Status=off Temp=0
Status=on Temp=0
Status=on Temp=25
Status=on Temp=50
Status=on Temp=75
Coffee maker temperature too high
Turning coffee maker off
Status=off Temp=0
Status=off Temp=0
Status=off Temp=0
```

---

## DONE!!