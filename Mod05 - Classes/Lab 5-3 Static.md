# Lab 5-3: Static Data and Methods
#### Introduction to Java
---
## Lab Objectives

In this lab, we add some some static methods and data to our student class
---
<br/>
<br/>

## Part One: Set Up

Either start with your code from the last lab or use the starter code from the lab assets folder in the repository.

## Part Two: Student Count

If we have a requirement to count the number of students created, this is clearly a property of the whole class, not an individual student.

We can create a `count` variable to hold the count. Since this is not an instance variable, the syntax for referring to it is `Student.count`. Static variables are prefixed by the name of the class they are defined in.

Also create a constant called `MAX_COUNT` that will set the maximum number of students that can be created.

Start by adding the constant and the static variable, initializing it in a static block.

```java
package remote;

public class Student {
	// Static Section
	public static final int MAX_COUNT = 2;
	public static int count; // we could initialize here too
	static {
		Student.count = 0;
	}
	
	private String name = "Marcus";
```

Then we can use it in the `main()` method.

```java
	public static void main(String[] args) {
		Student igor = new Student();
		Student.count++;
		igor.printme();
		System.out.println("Student.count = " + Student.count);
	}
```
But this is not a good solution since anyone can manipulate the data.  The solution is to make the data private and add a getter. Instead of a setter, we implement an "incrementor" that bumps up the count by instead of resetting it.

```java
	public class Student {
	// Static Section
	    public static final int MAX_COUNT = 2;
	    private static int count = 0; 
	    public static int getCount() {
		    return Student.count;
	    }
	    public static void incrementCount() {
		    Student.count++;
	    }
	    private String name = "Marcus";
	
```
The only problem this solution is that we are making the client `Runner` class responsible for 

```java
	public static void main(String[] args) {
		Student igor = new Student();
		Student.incrementCount();
		igor.printme();
		System.out.println("Student.count = " + Student.getCount());
	}
```

In order to fix this, we have to make the `Student` class responsible for managing all the overheads of creating new `Student` objects.

That will be the next lab. Save your work from this one.

---

## DONE
