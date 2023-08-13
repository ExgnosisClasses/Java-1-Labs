# Lab 3-3: Variable Types
#### Introduction to Java
---
## Lab Objectives

Compares the use of different storage classes of Java variables

---
<br/>
<br/>

## Part One: Automatic Extent

Create a java project with a single class, in the demos this was called `Runner`, with a `main()` method. All of your work will be done in the main method.

Create a new lexical scope by adding a couple of {}.  The following code defines two integer variables. The first, `i1` has the lexical scope of the body of the `main()` method since those are the {} that enclose it directly

The second variable, `i2` has the lexical scope you defined since those are the {} that enclose it directly. Notice that `i1` is still defined since your {} scope is nested in the scope of `i1`

```java 
	public static void main(String[] args) {
		int i1 = 89;
		
		{ // Define a new scope
			int i2 = -112;
			System.out.println("Inner scope i1 " + i1);
			System.out.println("Inner scope i2 " + i2);
		} // end defined scope
		
		System.out.println("Outer scope i1 " + i1);
		//System.out.println("Outer scope  i2" + i2); // out of scope
	}
```

As soon as the flow of control passes through the closing } for the defined scope, `i2` is no longer in scope and automatically destroyed.

---

<br/>
<br/>

## Part Two: Static Extent and Scope

Create a class called `Runner` with a `main()` method as in past labs

Define a new package, called `util` in this example. In this package define a class `Params` which will have a static variable `cpus`.

Make the variable `public` (we will discuss why later in the course) and initialize it using a static initialization block as shown.

```java
package util;

public class Params {
	public static int cpus;
	
	static {
		Params.cpus = 42;
	}

}
```

Reference this variable in the main method of the `Runner` class. Notice that it is in lexical scope of the `main()` method only if the `Params` class is imported. `Params.cpus` exists because it has static extent, but is only in scope in the executing code when `main()` can figure out what the symbol `Params.cpus`is referring to.

```java
import util.Params;

public class Runner {

	public static void main(String[] args) {
		System.out.println(Params.cpus);
	}
}
```
Comment out the `import` statement and the compiler complains about an unresolved reference. This clearly shows the difference between:

1. _Scope:_ where the variable can be referenced from
2. _Extent:_ how long the variable exists in memory

---
<br/>
<br/>

## Part Three: Managed Variables

### _Step 1 - Heap Variables_

Create a `Runner` class with a main method just like we have been doing so far.

In the same file, create a `Student` class. There doesn't need to be anythin in the class, we just want to declare a user defined type.

```java
public class Runner {
	public static void main(String[] args) {
	}
}

class Student {}
```

Int the `main()` method, create two student objects and print them out. Java has no idea how to print out a `Student` objectm so it just prints out the address of the object instead.

```java
public static void main(String[] args) {
		
		Student plato = new Student();
		System.out.println("Plato is at " + plato);
		Student euclid = new Student();
		System.out.println("Euclid is at " + euclid);
	}
```
Which should produce output that looks similar to this:

```console 
Plato is at Student@4517d9a3
Euclid is at Student@372f7a8d
```
The output consists of the type of the object on the heap plus the memory location of the obect on the heap.

Notice that the variables `plato` and `euclid` are automatic variables on the stack that contain the addresses of the corresponding objects on the heap.

The objects on the heap will exist until they can no longer be referenced

### _Step 2 - Going out of scope

Continuing from the code you have from part one but you can delete the code relating to the variable `euclid`.

Add a new variable scope with a set of braces {} as shown.

Define a `Student` variable `pythagoras` at the start of the main method initialized to `null`. This variable _can_ point to a `Student` object but doesn't point to anything yet.

```java 
	public static void main(String[] args) {
		
		Student pythagoras = null;
		{
		}
	}
}
```
 Inside the scope you created, create the `plato` student like you did before. Assigne `plato` to  `pythagoras` and then print out addresses. They should be the same because the assignment statement copied the contents of `plato` (the address below) to `pythagoras`.

 ```java
 
 public static void main(String[] args) {
		
		Student pythagoras = null;
		{
			Student plato = new Student();
			pythagoras = plato;
			System.out.println("Address of plato = " +  plato);
			System.out.println("Address of pythagoras = " +  pythagoras
		}
	}
 ```
Which should look something like this:

```console
Address of plato = Student@4517d9a3
Address of pythagoras = Student@4517d9a3
```

The object `Student@4517d9a3` now has a reference count of 2 since there are two variables that know the memory address.

However, outside the scope block, the variable `plato` is destroyed and can no longer be used.  However `pythagorus` still has the location so Java decrements the reference count of `Student@4517d9a3` to 1.

```java
public static void main(String[] args) {
		
		Student pythagoras = null;
		{
			Student plato = new Student();
			pythagoras = plato;
			System.out.println("Address of plato = " +  plato);
			System.out.println("Address of pythagoras = " +  pythagoras);
			
		}
		// plato is out of scope
		//System.out.println("Address of plato = " +  plato);
		System.out.println("Address of pythagoras = " +  pythagoras);
	}
```

Once the `main()` method exits, then `pythagoras` also goes out of scope, the reference count og `Student@4517d9a3` goes to zero and Java marks the obect as deleted. The actual memory is reclaimed the next time the garbage collector runs.

---

##  DONE

