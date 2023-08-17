# Lab 7-3: Upcasting and Downcasting  
#### Introduction to Java
---
## Lab Objectives

This lab explores upcasting and downcasting in inheritance hierarchies
---
<br/>
<br/>

## Part One: Continue from last lab.

The final version of the code at the end of the last lab was:

```java
public class Runner {

	public static void main(String[] args) {
		Dog fido = new Dog("Fido");
		ServiceDog lassie = new ServiceDog("Lassie");
		fido.speak();
		lassie.speak();
	}

}

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

class ServiceDog extends Dog {
	public ServiceDog(String name) {
		super(name);
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " Looks for permission to speak");
		super.speak();
	}

	public void work() {
		System.out.println(this.getName() + " is hard at work");
	}
}
```
<br/>
<br/>

## Part Two: Using a Dog Variable

In keeping with the idea of an inheritance relationship, a `ServiceDog` is a `Dog`, create both a `Dog` and `ServiceDog` object assigned the variables `fido` and `lassie` respectively.

Also create a new `Dog` variable `someDog` and a `ServiceDog` variable `workDog`

```java
	public static void main(String[] args) {
		Dog fido = new Dog("Fido");
		ServiceDog lassie = new ServiceDog("Lassie");
		Dog someDog = null;
		ServiceDog workDog = null;
	}
```
As expected, we can assign `fido` to `someDog` but we can't assign `fido` to `workDog`.

This is type safety because an arbitrary `Dog` is not a `ServiceDog`.


```java
	someDog = fido;  // ok since they are the same type
	//workDog = fido;  // error because an arbitrary dog is not a service dog
```
However, we can assign a `ServiceDog` object to a `Dog` variable.  Why? Because the inheritance relationship says that all service dogs are also dogs, because service dogs are just a special type of dog. 

To assign an object to a variable that is the type of one of its superclasses is called _upcasting_ because we are considering the object as a type higher in the inheritance hierarchy.

Notice that if we try to assign `someDog` back to `workDog`, Java is blocking it because of type safety.

```java 
	someDog = lassie;  // Upcasting 
	//workDog = someDog; // error like before
```

Why block this? Because we know that `someDog` contains a `ServiceDog` object because we put it there earlier, but Java can't figure that out just by looking that the statement. It might be that the object in `someDog` isn't really a `ServiceDog` at some point.

We can do the same sort of thing we did with primitive data types and _downcast_ the `Dog` to a `ServiceDog`

```java
	someDog = lassie; // Upcasting 
	workDog = (ServiceDog)someDog; // Downcasting
```
Just like casting before, this has the potential to go very wrong.  Suppose we have a cast a plain old `Dog` as a `ServiceDog`, then Java will allow us to call the `work()` method on it, which it doesn't have.

```java
	workDog = (ServiceDog)fido;  // Fido is not a ServiceDog
	workDog.work();     // danger zone
```

The problem is that Java can't figure this out until runtime when it realized you lied about `fido` being a `ServiceDog`

```console
Exception in thread "main" java.lang.ClassCastException: 
class Dog cannot be cast to class ServiceDog 

```
<br/>
<br/>

## Part Three: Generic Arrays

This allows us to create collections of dogs whether or not they are service dogs or just plain old dogs.

We can tell which type of dog a generic dog entry is by using the `instanceof` binary operator. If we do have a `ServiceDog` then we can downcast safely and call the `work()` method

```java
	public static void main(String[] args) {
		Dog [] kennel = { new ServiceDog("Lassie"), new Dog("Fido"), new Dog("Rolf") };
		
		for(Dog puppy : kennel) {
			puppy.speak();
			if (puppy instanceof ServiceDog) {
				((ServiceDog) puppy).work();
			}
		}
	}
```

---

## DONE!!