# Lab 4-1: Operators
#### Introduction to Java
---
## Lab Objectives

This lab explores some of the Java operators. For this lab, all you need to do is create a project with a single `Runner` class with a `main()` method. We won't be using any classes since we are just doing some procedural code.


---
<br/>
<br/>

## Part One: Floating Point Operations

Experiment with division by zero with integers. No mater what the numerator is, if the denominator is `0` we get a divide by zero error because it is integer division

```java
	public static void main(String[] args) {
		System.out.println(1/0);
	}
```
Produces

```console
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Runner.main(Runner.java:5)
```

Now try the same with floating point numbers.

```java
	public static void main(String[] args) {
		System.out.println(1.0/0.0);
		System.out.println(-1.0/0.0);
		System.out.println(0.0/0.0);
	}
```
Produces

```console
Infinity
-Infinity
NaN
```
<br/>

Explain what is happening in this code and why the final result is _not_ `.9999999`

```java
	public static void main(String[] args) {
		double r = (1.0/9);
	    System.out.printf("%10.8f\n", r);
	    System.out.printf("%10.8f\n", r * 9);
	}
```
```console
0.11111111
1.00000000
```

<br/>
<br/>

## Part Two: Mixed Mode Arithmetic

Explain the following result:

```java
	public static void main(String[] args) {
		System.out.println(0.0/(int) 0.09);
		System.out.println(Math.cos(45)/0);
	}
```
Produces

```console
NaN
Infinity
```

How would you fix the error in this code. Hint, there are two different solutions.

```java
	public static void main(String[] args) {
		int i = 1;
		int j = 3;
		int k = i + (long)j;
	}

```
---

## DONE
