# Lab 5-2: Visibility
#### Introduction to Java
---
## Lab Objectives

In this lab, we add some methods to our Student Class

---
<br/>
<br/>

## Part One: Set Up

Use the same setup as before with a `lab5` package, a `remote` package, a `Runner` class in the `lab5` package and the `Student` class in the `remote` package

Delete the `Student` class in the `lab5` package to avoid confusion.

The next lab is a continuation of this lab so save your code!

## Part Two: Getter and Setters

In this first version of `Student`, the `name` instance variable will be private and be accessible only through a getter. In addition, we will add a `printme()` public method that prints out the name of the student.

```java
package remote;

public class Student {
	private String name = "Marcus";
	
	public String getName() {
		return this.name;
	}
	public void printme() {
		System.out.println("Hi! My name - " + this.name);
	}
}
```

Note the use of the `this` keyword. You can remove the keyword and the code will still run, but as Java code gets more complex, using `this` helps disambiguate where the variable comes from.

Now modify the `main()` class as shown and execute.

```java
package lab5;
import remote.*;
public class Runner {

	public static void main(String[] args) {
		Student igor = new Student();
		System.out.println(igor.getName());
		igor.printme();
	}
}
```
Now we add a setter. However, the student name cannot be blank so we have to ensure no once reset the name field to either an empty string or a null pointer.

We start by creating a private method with the validation logic. It returns a `boolean` to indicate if the name is allowable or not.

Then the setter checks with the validator method to see whether or not to reset the name property.

We can add the following code to the `Student` class

```java
	private boolean nameValidator(String s) {
		if (s == null) return false;
		if (s == "") return false;
		return true;
	}
	
	public void setName(String name) {
		if (!this.nameValidator(name)) return;
		this.name = name;
	}
```
This code uses a bit of common Java style. When we are passing a parameter in a method that will be assigned to an instance variable, the same name is used for both with the instance variable being identified by the `this` prefix.

Now update the `Runner` class.

```java
	public static void main(String[] args) {
		Student igor = new Student();
		igor.printme();
		igor.setName("");
		igor.printme();
		igor.setName("Igor");
		igor.printme();
	}
```

Run the code and ensure it works.

For a bonus challenge, modify the code so that no one is allowed to name a student "PoopyPants"

---

## DONE
