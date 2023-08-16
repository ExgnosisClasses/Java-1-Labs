# Lab 5-4: Constructor
#### Introduction to Java
---
## Lab Objectives

In this lab, we add two constructors to our `Student` class
---
<br/>
<br/>

## Part One: Set Up

Either start with your code from the last lab. The class as it was at the end of the last lab is in the folder Lab5-3 Solution.

Which is also here:

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
	private boolean nameValidator(String s) {
		if (s == null) return false;
		if (s == "") return false;
		return true;
	}
	public void setName(String name) {
		if (!this.nameValidator(name)) return;
		this.name = name;
	}
	// Static Section
    public static final int MAX_COUNT = 2;
    private static int count = 0; 
    public static int getCount() {
	    return Student.count;
    }
    public static void incrementCount() {
	    Student.count++;
    }
	
}
```

## Part Two: Add the constructor with a name parameter

The constructor does not return a type and has the same name as the class. Generally, the constructors we want clients to use are the same visibility of the class.  Since `Student` is `public`, we will make the constructor `public` as well. 

Set the `Student.name` instance variable to `null`.


```java
package remote;

public class Student {
	     
private String name = null;
	
	public Student(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	/// and so on
}
```
As soon as you add this constructor, the code in the `Runner` class has an error since the constructor `Student()` no longer exists.

Use our new constructor instead which produced the right result.

```java
public class Runner {

	public static void main(String[] args) {
		Student igor = new Student("Igor");
		igor.printme();	private String name = null;
```	
	
validator which we used int the `setName()` method and we should use it here to be consistent.

There are two ways we can do this, we can call it from the constructor directly or we can call like this

```java
	private String name = null;

	public Student(String name) {
		//if(this.nameValidator(name)) this.name = name;
		// or
		this.setName(name);
	}
```
<br/>
<br/>
It may be a domain rule that all students have names. Clearly, it is possible to wind up with a student object that violates that rule like this.

```java
	public static void main(String[] args) {
		Student igor = new Student("");
		igor.printme();
	}
```
Which gives us an _invalid_ object - one we created but it's not quite right from the domain perspective.

There will be two ways we approach this problem

1. In the exceptions section, we can throw an exception from the constructor that will roll back the creation of the object including releasing all the memory allocated to it. We will see this in the exceptions section.

2. It might be that we can create an student object with a placeholder name "TBD" if we don't know the name at the time of creation and will be set later.

The problem with the second approach is that we need to know if the object is valid. So we can add a `boolean` valid `isValid` to tell us. 

So now lets implement the constructor with no arguments and a default name value.

```java
private String name = "TBD";
	
	public Student() {
		
	}

```
It doesn't do anything because there is already a default value. And this works.

```java 
	public static void main(String[] args) {
		Student igor = new Student();
		igor.printme();
		Student anish = new Student("Anish");
		anish.printme();
		igor.setName("Igor");
	    igor.printme();
	}
```
```console
Hi! My name - TBD
Hi! My name - Anish
Hi! My name - Igor
```
Now let's add that valid indicator

```java 

	private String name = "TBD";
	private boolean isValid = false;
	
	public boolean isValid() { return this.isValid;}
	
	public Student() {
		// creating a student with no name is invalid
		// so leave isvalid as false
	}
```
Thinking ahead we may have a number of validity checks if we add more data like GPA, birth date and we want to avoid students with `null` names, or GPAs of 897 or birth dates of January 78th 2323

We will often put a list of these rules, which we technically call specifications into a special method that runs all the checks after all the data has been input.

We will do this in a later lab for a Bank Account class, but for now, we will just use the one validator because we only have one data item. 

The place to do this is in the `setName()` method

```java
	public void setName(String name) {
		this.isValid = this.nameValidator(name);
		this.name = name;
	}
```
Lets also alter the `printme` method to show the validity of the object.

```java
public void printme() {
		System.out.println("Hi! My name - " + this.name +   " " + (this.isValid ? "Valid" : "Invalid"));
	}

```
Now test it

```java
	public static void main(String[] args) {
		Student igor = new Student();
		igor.printme();
		Student anish = new Student("Anish");
		anish.printme();
		igor.setName("Igor");
	    igor.printme();
	    igor.setName(null);
	    igor.printme();

	}
```
And we get

```console
Hi! My name - TBD Invalid
Hi! My name - Anish Valid
Hi! My name - Igor Valid
Hi! My name - null Invalid
````
<br/>
<br/>

## Part 3: Fix the Static issue

Remember we had a problem with where to increment the count for the class.

Now we can fix that by having the constructor responsible for doing that.

Start by making the increment function private and call it from the constructor.

In order to do this, we are going to use a trick where one constructor calls the other so we don't repeat code.

First, refactor the static method

```java
 private static void incrementCount() {
   Student.count++;
	}
```
Now add this call into the constructor with one parameter. Because the constructor is a member of the Student class, it can call any private method even if the method is static. Remember, being public or private is about visiblity

```java
	public Student(String name) {
		this.setName(name);
		Student.incrementCount();
	}
```
Let's also modify `printme()` to print out the count as well

```java
public void printme() {
		System.out.println("Student #"+Student.getCount() +" Hi! My name - " + this.name +   " " + (this.isValid ? "Valid" : "Invalid"));
	}
```
Instead initializing `Student.name` to "TBD" the constructor with no arguments will call the constructor with one argument passing null as the name. We really didn't need "TBD" as it turns out.

However, the syntax for one constructor calling another is weird, instead of the constructor name we use `this` as shown here

```java

	private String name = null;
	private boolean isValid = false;
	
	public Student() {
		this("");
	}
	public Student(String name) {
		this.setName(name);
		Student.incrementCount();
	}
	
```

Check to make sure it's all working

```java
	public static void main(String[] args) {
		Student igor = new Student();
		igor.printme();
		Student anish = new Student("Anish");
		anish.printme();
	    Student kyle = new Student("Kyle");
	    kyle.printme();

	}
```
```console
Student #1 Hi! My name -  Invalid
Student #2 Hi! My name - Anish Valid
Student #3 Hi! My name - Kyle Valid
```
---
**The final code is available in the folder Lab5-4 Solutions**

## DONE
