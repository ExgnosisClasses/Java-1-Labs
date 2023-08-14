# Lab 5-1: Visibility
#### Introduction to Java
---
## Lab Objectives

This lab explores how visibility works with Java classes. Save your code after the lab since you will be using it in the next lab too.

---
<br/>
<br/>

## Part One: Different Packages

Create a `lab5` package. In that package, create a `Runner` class with a `main()` method.

Create a new package at the same level as the `lab5` package called `remote` and create a class in that package called `Student` with a `public` String instance variable called `name` that is initialized to whatever you want.

```java
package remote;

public class Student {
	public String name = "Marcus";
}
```
In the `main()` method, print create a student object and print out the name as shown here.

```java
	public static void main(String[] args) {
		Student flamel = new Student();
		System.out.println(flamel.name);
	}
```
Now change the name variable in the `Student` class to `package` which means no modifier as shown here.

```java
public class Student {
	String name = "Marcus";
}
```
As soon as you save this change, there will be an error in the `Runner` class saying that the `Student.name` field is not visible.
<br/>
<br/>

## Part Two: Same Packages
Create a new `Student` class in the `lab5` package exactly like the one in the `remote` package. Make sure this class is _not_ `public`.

Remove the import from the `Runner` class file that accesses the `Student` class in the `remote`
package.

Your new `Student` looks like this

```java
package lab5;

class Student {
	String name = "Igor";
}
```
Your `Runner` class should look like this.

```java
package lab5;

public class Runner {

	public static void main(String[] args) {
		Student igor = new Student();
		System.out.println(igor.name);
	}
}
```
Because the two classes are in the same package
Notice that if you change the visibility of `Student.name` from `package` to `public`, nothing happens because `public` is also automatically `package`.

However, if you change the visibility to `private` then `Student.name` cannot be accessed anywhere except in the `Student` class definition.

```java
class Student {
	private String name = "Igor";
}
```
---

## DONE
