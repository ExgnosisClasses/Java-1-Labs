# Lab 3-2: Data Types
#### Introduction to Java
---
## Lab Objectives

Exploring some of the data typing rules of Java

---
<br/>
<br/>

## Part One: Casting and Type Safety

Create a java project with a single class, in the demos this was called `Runner`, with a `main()` method. All of your work will be done in the main method.

Experiment with the following code snippets.

**Integer and Float Data Types**

The literal `1L` is interpreted by Java to mean that this value should be represented by 64 bits as opposed to the literal `1` which should be represented by 32 bits.  

In the following code, Java will not allow the first assignment since it breaks type safety, but will allow the second.

```java
    int i = 1L;     // error
    int i = 1;      // works
```
The same is true for floats. The value `1.0` is interpreted as needing 64 bits so cannot be assigned to a float variable. However `1.0F` is interpreted as needing 32 bits and can be assigned to a float variable.

```java
    float f32 = 1.9;   // error 1.9 is a double
    float f32 = 1.9F;  // works  
```

We can also assign any integer to a float variable but there will be a loss of precision.

```java
    long i32 = 1282788272777377445L;
   float f32 = i32;
   System.out.println(f32); // prints 1.2827883E18
```
<br/>

**Casting**

In the following code, a float is converted to an int with a loss in precision.

A long value is converted to an int with an overflow result meaning the value was too big to fit into 32 bits so some data was lost.

```java
    long i64 = 193847947443L;
    int i32 = (int)i64;
    System.out.println(i32); // prints 574419123
    
    float f32 = 12.887F;
    i32 = (int)f32;
    System.out.println(i32); // prints 12
```
<br/>


**Floating Point Numbers**

Since floating point numbers are used for scientific calculations, we often find that the get very close to 0 without actually being 0. In other words we often see a series of floating point calculations having a limit of 0.

To reflect this asymptotic behavior, division by zero for floating point numbers (NaN means 'not a number')

```java
   System.out.println(1.0/0.0);   // prints Infinity 
   System.out.println(-1.0/0.0);  // prints -Infinity
   System.out.println(.0/0.0);    // NaN  
```
**UTF-16**

```java 
   String π = "Τη γλώσσα μου έδωσαν ελληνική";
   System.out.println(π);
```

---
## DONE!