# Lab 7-1: Specialization 
#### Introduction to Java
---
## Lab Objectives

In this lab, you will work with specializing a `Dog` class to create a `ServiceDog` class

---
<br/>
<br/>

## Part One: Define the Dog Class

The `Dog` class is very basic

```java
class Dog {
	 private String name;

	public Dog(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void speak() {
		System.out.println(this.getName() + " BARK!");
	}
 }
```
Test it to see it works.

```java
	public static void main(String[] args) {
	Dog fido = new Dog("Fido");
	fido.speak();
	}
```
<br/>
<br/>

## Part Two: Create a subclass without inheritance

A `ServiceDog` does everything a dog does with the addition of adding a `work()` method.

We could construct our own `ServiceDog` class by wrapping a `Dog` object in this extra functionality. The code below does this, and is very similar to what Java actually does with inheritance.

The methods in the `Dog` class's interface are now hidden to the world so we have to replicate them in the interface of the `ServiceDog` class and forward the messages to the embedded `Dog` class

```java 

class ServiceDog {
	 private Dog d;

	 ServiceDog(Dog d) { // dependency injection
		 this.d = d;
	 }
	 public String getName() {
		 return this.d.getName();
	 }
	 
	 public void speak() {
		 this.d.speak();
     } 
     	 
	 public void work() {
		 System.out.println(this.getName() + " is hard at work");
	 }
 }
```
Now we can test this class.

```java
	public static void main(String[] args) {
		ServiceDog lassie = new ServiceDog(new Dog("Lassie"));
		lassie.speak();
		lassie.work();
	}
```
<br/>
<br/>

## Part Three: Using extends

What we have done is used some rather standard methods for object construction. In fact, this wrapping an object in another object to add functionality is called the Decorator Design Pattern.

The problem is that this a solution that requires a LOT of work and boiler plate code.

Inheritance in Java leverages the intuitive type relationship between `Dog` and `ServiceDog` (specifically a service dog _is_ a dog).

So we let Java do the heavy lifting for us by using inheritance

```java
class ServiceDog extends Dog {

	public ServiceDog(String name) {
		super(name);
	}
	public void work() {
		 System.out.println(this.getName() + " is hard at work");
	}
}
```

`ServiceDog` has access to all of the non-private data and methods of `Dog`.

The only tweak we have to make is that we still have to set the name of the `Dog` with the `Dog` constructor. We do this in the constructor of the `ServiceDog` class by calling the constructor in the parent `Dog` class, where we use the `super()` construct to do this.

Now test it to see if it works

```java
	public static void main(String[] args) {
		
		ServiceDog lassie = new ServiceDog("Lassie");
		lassie.speak();
		lassie.work();
	}
```
**Save your work, you will add to it in the next lab**
---

## DONE!!
