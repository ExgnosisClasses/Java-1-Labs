# Lab 7-4: Generalization  
#### Introduction to Java
---
## Lab Objectives

This lab introduces the idea of using inheritance for generalization.

---
<br/>
<br/>

## Part One: Define the Concrete Classes

Create a set of concrete unrealistic animal classes.

```java
class Dog {
	public void speak() {
		System.out.println("Bark");
	}
	public void walk() {
		System.out.println("Walking");
	}
}

class Cat {
	public void speak() {
		System.out.println("Meow");
	}
	public void walk() {
		System.out.println("Walking");
	}
}

class Fish {
	public void speak() {
		System.out.println(".....");
	}
   public void swim() {
	   System.out.println("Swimming");
   }
}

class Bird {
	public void speak() {
		System.out.println("tweet");
	}
   public void fly() {
	   System.out.println("Flying");
   }
}
```
<br/>
<br/>

## Part Two: Creating the Abstract Class.


What we want to do is create a generalization category called `Pet` which is the superclass of all of these concrete types.

The `Pet` class has no attributes or methods, it is just creating a general category.  Now we can make all of the animal types `Pets` by just using `extends`

```java
class Pet {}

class Dog extends Pet {
	public void speak() {
		System.out.println("Bark");
	}
	public void walk() {
		System.out.println("Walking");
	}
}

class Cat extends Pet{
	public void speak() {
		System.out.println("Meow");
	}
	public void walk() {
		System.out.println("Walking");
	}
}

class Fish extends Pet{
	public void speak() {
		System.out.println(".....");
	}
   public void swim() {
	   System.out.println("Swimming");
   }
}

class Bird extends Pet{
	public void speak() {
		System.out.println("tweet");
	}
   public void fly() {
	   System.out.println("Flying");
   }
}
```
Since we never want to actually create an object of type `Pet`, we can declare the class to be `abstract`

```java
abstract class Pet {}
```

Now we can create a bunch of pets of different types in the same array. notice that we cannot create an object of just type `Pet`

```java
	public static void main(String[] args) {
		//Pet p = new Pet(); // error because Pet is abstract
		Pet[] critters = { new Dog(), new Cat(), new Fish(), new Bird() };
		for(Pet critter : critters) {
			System.out.println(critter); 
			//critter.speak(); //doesn't work
		}
	}
```

```console
gen1.Dog@58644d46
gen1.Cat@14dad5dc
gen1.Fish@18b4aac2
gen1.Bird@764c12b6
```

However, there is still a problem. We cannot call the `speak()` method can't be called on any `Pet` object because the `Pet` class doesn't have that method.

<br/>
<br/>

## Part Three : Generalizing Methods

Since all the concrete classes have a `speak()` method, we can put a generic `speak()` method in the `Pet` class and let each concrete class override it.

Notice the use of the `@Override` annotation to tell both Java and anyone reading the code that the `speak()` methods in the concrete classes overrides the superclass definition.

```java
abstract class Pet {
	public void speak() {
		System.out.println("Just a placeholder");
	}
}

class Dog extends Pet {
	
	@Override
	public void speak() {
		System.out.println("Bark");
	}
	public void walk() {
		System.out.println("Walking");
	}
}

class Cat extends Pet {
	@Override
	public void speak() {
		System.out.println("Meow");
	}
	public void walk() {
		System.out.println("Walking");
	}
}

class Fish extends Pet {
	@Override
	public void speak() {
		System.out.println(".....");
	}
	public void swim() {
		System.out.println("Swimming");
	}
}

class Bird extends Pet {
	@Override
	public void speak() {
		System.out.println("tweet");
	}
	public void fly() {
		System.out.println("Flying");
	}
}

```

Now we can call the `speak()` method on any type of `Pet`

```java
	public static void main(String[] args) {
		//Pet p = new Pet(); // error because Pet is abstract
		Pet[] critters = { new Dog(), new Cat(), new Fish(), new Bird() };
		for(Pet critter : critters) {
			System.out.println(critter); 
			critter.speak(); 
		}
	}
}
```

```console
gen1.Dog@58644d46
Bark
gen1.Cat@14dad5dc
Meow
gen1.Fish@18b4aac2
.....
gen1.Bird@764c12b6
tweet
```
<br/>
<br/>

## Part Four: Abstract Method

We don't really need a `speak()` method in `Pet` because we are never going to have a concrete `Pet` object. It's just acting as a placeholder for the subclasses to override.

What we can do is use an abstract method instead that just specifies a method signature that every subclass has to implement. If we try create a subclass that does not implement the abstract method, Java will consider that subclass to also be abstract.

```java
abstract class Pet {
	abstract public void speak();
}
```
No other changes have to be made and the code works exactly the same as before.

However, if we try to create a new subclass that doesn't implement `speak() ` then we will bet an error

** Save your work for the  next lab **
## DONE!!