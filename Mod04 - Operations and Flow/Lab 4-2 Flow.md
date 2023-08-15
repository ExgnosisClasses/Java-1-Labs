# Lab 4-2: Flow Control
#### Introduction to Java
---
## Lab Objectives

This lab explores the basic flow control statements

Solutions are provided in the 'lab 4-1 Solutions' folder.

---
<br/>
<br/>

## Part One: Problem Statement

Write a loop that sums up the square of the even numbers between 1 and 20 inclusive. 

Then add a condition that halts the loop as soon as the sum is greater that 30.


### Hints

1. You need to declare a variable `sum` before the loop starts and initialize it to `0`

2. Set up your `for` loop
```java
   int sum = 0;
   for (int i =1 ; i <= 20; i++ ) {
	}
```

3. Each time through the loop, you have to check to see if the number is even. The following test will do that by seeing if there is a non-zero remainder on division by 2 and then skip that iteration if there is.

```java
	if (0 != i % 2) continue;
```
3. The number is even, add the square to the sum

```
   sum += (i * i);
```

4. Check the condition for termination

```java
   if (sum > 30) break;
```
5. Print out the sume

```java
System.out.println("Sum = "+ sum);
```

## Part Two

Implement the code as a `for` loop

## Part Three

Implement the code as a `while` loop

## DONE
