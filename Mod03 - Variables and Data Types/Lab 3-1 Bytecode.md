# Lab 3-1: Grokking Bytecode
#### Introduction to Java
---
## Lab Objectives

This lab works with Java code outside the IDE. No not use an IDE for this lab, you are going to have work with your Java code the way your grandparents did.

---
<br/>
<br/>

## Part One: Setup

At the command line, create a new directory to use. Do not use Eclipse or any other IDE. For this lab, I have used `D:\lab3-1`, but use what ever directory you want

Open up a text editor and cut and paste your HelloWorld code from the very first lab like this.

```java
public class HelloWorld {
    public static void main(String []args) {
        System.out.println("Hello World");
    }
}
```
Then save the file as HelloWorld.java an exit the editor and confirm the file is there.

```console
D:\lab3-1>dir
 
 Directory of D:\lab3-1

2023-08-10  07:22 PM    <DIR>          .
2023-08-10  07:22 PM    <DIR>          ..
2023-08-10  07:22 PM               125 HelloWorld.java
               1 File(s)            125 bytes
               2 Dir(s)  3,780,919,820,288 bytes free

```

---
<br/>
<br/>

## Part Two: Compile and Execute

### _Step 1 - Compile the file_

Use the `javac` command to compile the file as shown. Confirm there is a corresponding class file.

```console

D:\lab3-1>javac HelloWorld.java

D:\lab3-1>dir
 Volume in drive D is Working
 Volume Serial Number is 021F-6867

 Directory of D:\lab3-1

2023-08-10  07:26 PM               425 HelloWorld.class
2023-08-10  07:22 PM               125 HelloWorld.java
               2 File(s)            550 bytes
               2 Dir(s)  3,780,919,820,288 bytes free

```
<br/>
<br/>

### _Step 2 - Execute the file_
Use the `java` command to start a JVM to execute the class file. Note that you do _not_ use the `.class` extension when executing the command

```console

D:\lab3-1>java HelloWorld
Hello World

```
<br/>
<br/>

### _Step 3 - Decompile the file_

To see what the byte code actually looks like, decompile the class file using the Java decompiler as shown

```console

D:\lab3-1>javap -c  HelloWorld.class
Compiled from "HelloWorld.java"
public class HelloWorld {
  public HelloWorld();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #13                 // String Hello World
       5: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}

```
This is just some of what is the class file. To see more run the command with the `-verbose option`

```console

D:\lab3-1>javap -verbose  HelloWorld.class
Classfile /D:/lab3-1/HelloWorld.class
  Last modified Aug. 10, 2023; size 425 bytes
  SHA-256 checksum af9318b020ee8e7f2c11c69e8ec6dd2ebb9c430bb36a39085325c9cae2cdd194
  Compiled from "HelloWorld.java"
public class HelloWorld
  minor version: 0
  major version: 64
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #21                         // HelloWorld
  super_class: #2                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
   #2 = Class              #4             // java/lang/Object
   #3 = NameAndType        #5:#6          // "<init>":()V
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Fieldref           #8.#9          // java/lang/System.out:Ljava/io/PrintStream;
   #8 = Class              #10            // java/lang/System
   #9 = NameAndType        #11:#12        // out:Ljava/io/PrintStream;
  #10 = Utf8               java/lang/System
  #11 = Utf8               out
  #12 = Utf8               Ljava/io/PrintStream;
  #13 = String             #14            // Hello World
  #14 = Utf8               Hello World
  #15 = Methodref          #16.#17        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #16 = Class              #18            // java/io/PrintStream
  #17 = NameAndType        #19:#20        // println:(Ljava/lang/String;)V
  #18 = Utf8               java/io/PrintStream
  #19 = Utf8               println
  #20 = Utf8               (Ljava/lang/String;)V
  #21 = Class              #22            // HelloWorld
  #22 = Utf8               HelloWorld
  #23 = Utf8               Code
  #24 = Utf8               LineNumberTable
  #25 = Utf8               main
  #26 = Utf8               ([Ljava/lang/String;)V
  #27 = Utf8               SourceFile
  #28 = Utf8               HelloWorld.java
{
  public HelloWorld();
      descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 1: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #13                 // String Hello World
         5: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 3: 0
        line 4: 8
}
SourceFile: "HelloWorld.java"
```
After this course, you should be able to come back and understand a lot of what is in this output.

In real life, it is higly unlikely that you will ever be decompiling Java, but it is important to see what bytecode is at least once in your career
 
 ---
 <br/>
 <br/>
 
 ## Part Three: Jar Files

 Nowadays most Java apps are distributed in Jar (Java Archive) files. These are zip files with additional information about the contents of the file that the JVM needs to execute the contents.

 Configuration information about the application, like which class has the `main()` method are in a special manifest file. There is a manifest file for you to use called `manifest.txt` located in the lab assets folder for this lab in the lab repository.

 The contents of the manifest.txt look like this

```text
Main-Class: HelloWorld

```
Make sure the `manifest.txt` file is in your working directory

```console
D:\lab3-1>dir
 
 Directory of D:\lab3-1

2023-08-10  07:53 PM    <DIR>          .
2023-08-10  07:53 PM    <DIR>          ..
2023-08-10  07:26 PM               425 HelloWorld.class
2023-08-10  07:22 PM               125 HelloWorld.java
2023-08-10  07:53 PM                24 manifest.txt
              
```
To create the jar file, use the jar creation tool from the JDK. Check to see that the jar file has been created and run it in a JVM.  The `-jar` switch lets the class loader know that we are trying to run a jar file and not just plain class files

```console
D:\lab3-1>jar cfm Hi.jar manifest.txt HelloWorld.class

D:\lab3-1>dir
 
2023-08-10  07:26 PM               425 HelloWorld.class
2023-08-10  07:22 PM               125 HelloWorld.java
2023-08-10  07:56 PM               774 Hi.jar
2023-08-10  07:53 PM                24 manifest.txt
               4 File(s)          1,348 bytes
               2 Dir(s)  3,780,919,816,192 bytes free

D:\lab3-1>java -jar Hi.jar
Hello World
```
---

# Done