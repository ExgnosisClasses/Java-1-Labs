# Lab 6-2: String Basics
#### Introduction to Java
---
## Lab Objectives

This lab explores some interesting features of Strings
---
<br/>
<br/>

## Part One: String Definitions

Just like arrays, there are two different ways to create a String, using the shorthand form a String constructor.

```java
	public static void main(String[] args) {
		// This form
		String s1 = "Hello World";
		// is a short hand for
        String s2 = new String("Hello World");
	}    
```
The literal "Hello World" is interned in the string literal pool
<br/>
<br/>

The following is a very inefficient way to build up a string. In each iteration, we are creating a new string, not adding on to the end of the target string

```java
    public static void main(String[] args) {       
        String s = "";
        for (int i = 1 ; i <= 10; i++) {
        	s = s + " " + i;
        }
        System.out.println(s);
	}
   
```
Using a StringBuilder is more efficient way to construct a String


```java
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i <= 10; i++) {
			sb.append(" ");
			sb.append(i);
		}
		String s = sb.toString();
		System.out.println(s);
	}
```


---

## DONE!!