# Lab 2-1: Java Packages
#### Introduction to Java
---
## Lab Objectives

In this lab you set up the Java packages required to represent a hierarchical organizational structure.

The MyCorp company has two main divisions, development and qa. The development division has two sub-divisions; frontend and backend.

---
<br/>
<br/>

## Part One: Setup

Create a Java Project in Eclipse the same way you did with the Hello World lab. 

if you are starting a new workspace, remember to unselect the modules option and choose the jdk-20 option when you create the project. Eclipse remembers your choices and uses those and the default for subsequent projects you create in that workspace.

**Note:** Don't delete your work at the end of the lab, you will be adding to it in the next lab.

---
<br/>
<br/>

## Part Two: Creating the packages

### _Step 1 - Create the top level package_

In keeping with naming conventions, the top level package will be MyCorp's domain name `mycorp.com` reversed

Right click on the `src` folder in your project and choose the `new` option and select `package`

![New Package](images/Lab2-1_1_TopPackage.png?raw=true)

<br/>

In the package dialogue box that comes up enter `com.mycorp` and select finish

![Top level package](images/Lab2-1_2_commycorp.png?raw=true)
<br/>
<br/>

### _Step 2 - Create the dev and qa packages_

Create the `dev` and `qa` packages in the same way. However, _because these are sub-packages of `com.mycorp` right mouse click on the `com.mycorp` package instead of the `src` folder._

You can tell you are in the right when you see `com.mycorp` already in the name field and all you have to do is add `.dev` at the end.

![Dev Package](images/Lab2-1_3_dev.png?raws=true)

<br/>

Repeat the process to create the `com.mycorp.qa` package.
<br/>
<br/>

### _Step 3 - Create the fontend and backend packages_

Create a `frontend` package under the `dev` package the same way you created the `dev` package under the `com.mycorp` package.  Right mouse click on the `com.mycorp.dev` package and select `new` and then `package`

You know that you have it right when the package dialog name box is prefilled with `com.mycorp.dev` and all you have to do is add `.frontend` 

![Frontend](images/Lab2-1_4_frontend.png?raw=true)

<br/>

Repeat the process to add the `com.mycorp.dev.backend` package

<br/>

### _Step 4 - Confirm the package structure_

Your package structure should look like this:

![Package Structure](images/Lab2-1_5_struct.png?raw=true)

---

<br/>
<br/>

## Part Three: Adding the main() method

Recall that the `main()` method is only used to boot up the application, but it has to be in _some_ class, and it seems a poor choice from a design perspective to just shove it into some arbitrary class in an arbitrary package. 

One option might be to have a special `boot` package that contains all of the code needed to get the application up and running, which would be a good place to stick the `main()` method.  In fact, if we have a lot of initialization, perhaps setting up and calibrating hardware and bringing various sub-systems on line, a `boot` package that does that makes sense.

In our case, it would be a lot of unnecessary work to implement a `boot` package so we will put the main method somewhere else.

It doesn't seem that the responsibility of starting the application should be a dev or qa responsibility, but more one that is done by the company.

So you will add a special class called `Boot` to the `com.mycorp` package that will have the sole purpose of being the location of the `main()` method.

### _Step 1 - Add the Boot class_

You will use the same process you used to create the `HelloWorld` class in Lab 1-1. 

Right mouse click on the `com.mycorp` package and select `new` and `class`.

In the dialogue box, confirm that you are the right package in in the `Package` field. If not, use the `Browse` button to select the right package. Ensure the box to create a `main()` method is selected.

Call the class `Boot` so that it is clear what its responsibility is.

![Class Spec](images/Lab2-1_BootClass.png?raw=true)

<br/>

### _Step 2 - Test and run_

Add the code into the class as shown below. Notice that the package statement was auto-generated for you by Eclipse.

```java
package com.mycorp;

public class Boot {

	public static void main(String[] args) {
		System.out.println("Welcome to MyCorp");

	}

}

```
Run the code and enure it works.

### _Step 3 - Final Check_

Your project structure should now look like this:

![Structure](images/Lab2-1-package.png?raw=true)
<br/>

Go into the Windows file explore and confirm the corresponding directory structure for your project structure as shown below.

![Project Structure](images/Lab2-1_7_files.png?raw=true)

---

# DONE!

**Do not delete your work, the next lab will start with this package structure**

