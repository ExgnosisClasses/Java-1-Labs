# Lab 7-2: Method Overriding 
#### Introduction to Java
---
## Lab Objectives

This lab builds on the last lab where we override a method to change the behaviour of the `ServiceDog` class
---
<br/>
<br/>

## Part One: Override a method

We want `ServiceDog` objects to speak softly because they are working. We can replace the original `Dog.speak()` with a new `ServiceDog.speak()` method. 

The `Dog.speak()` method is still there, but the `ServiceDog.speak()` method overrides it rather than replacing it.

It is important that the new method have exactly the same signature as the parent method, or else we are just overloading the method.

We can use the `@Override` annotation to tell to check to make sure we are doing the override properly.

```java
class ServiceDog extends Dog {
	public ServiceDog(String name) {
		super(name);
	}

    @Override
    public void speak() {
    	System.out.println(this.getName() + " sits quietly");
    }

	public void work() {
		System.out.println(this.getName() + " is hard at work");
	}
}
```
Test it to see it works.

```java
	public static void main(String[] args) {
		Dog fido = new Dog("Fido");
		ServiceDog lassie = new ServiceDog("Lassie");
		fido.speak();
		lassie.speak();
	}
```
The Liskov Substitution principle states (more or less) that overriding a method in a child class should not change the behavior of the parent class. You've just shown that your override satisfies the Liskov substitution principle

`
```
Now we can test this class.

```java
	public static void main(String[] args) {
		ServiceDog lassie = new ServiceDog(new Dog("Lassie"));
		lassie.speak();
		lassie.work();
	}
```

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
<br/>
<br/>

## Part Three: Extending a method

Sometimes we just want to add to the functionality of the parent method. The is called extending a method.

We can access the parent method with `super.speak()` in our child `speak()` method.  For example.

```java
   @Override
    public void speak() {
    	System.out.println(this.getName() + " Looks for permission to speak");
    	super.speak();
    }
```
Test this to see that it works. Notice that the behavior of the superclass or parent class in unaffected.

Another way to express the Liskov Substitution principle is that the child class should never restrict or do less than the parent class.

```java 
	public static void main(String[] args) {
		Dog fido = new Dog("Fido");
		ServiceDog lassie = new ServiceDog("Lassie");
		fido.speak();
		lassie.speak();

	}
```

**Save your work, you will add to it in the next lab**

---

## DONE!!