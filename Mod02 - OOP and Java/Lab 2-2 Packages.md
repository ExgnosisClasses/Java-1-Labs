# Lab 2-2: Visibility
#### Introduction to Java
---
## Lab Objectives

This lab is focused on the ideas of public versus package visibility and referring to classes in other packages via importing

---
<br/>
<br/>

## Part One: Setup

You can start with where you left off in the previous lab. If you don't have your code, then you can use the code in the `src` directory in the lab folder which contains a solution to lab 2-1.

From this lab on, screenshots of Eclipse will not be included since it will be assumed that, by this point, you can follow the basic directions without them.

---
<br/>
<br/>

## Part Two: Create and Use a Public Class

### _Step 1 - Create the Coder_

Just like you did for the `Boot` class in the previous lab, create a public class called `Coder` using this code:

```java
package com.mycorp.dev;

public class Coder {}
```
Note that eclipse will automatically insert the package statement if you create the class using the new menu from the `com.mycorp.dev` package.
<br/>
<br/>
### _Step 2 - Use the class in the main() method_

In the `main()` method in the boot class, try to create a `Coder` object. We will cover actual object creation later.

```java
public class Boot {

	public static void main(String[] args) {
		Coder kent = new Coder();	
	}
}
```
Eclipse should be complaining that it doesn't what what a `Coder` is because Java doesn't know where the class definition is. 

Also note that the `dev` package is as sub-package of `com.mycorp` but it still can't find it. Parent packages do not have access rights to child packages, they are still separate namespaces.

This may seem inconvenient but it allows us to reorganize package structure without introducing dependency errors.
<br/>
<br/>

### _Step 3 - Use the fully qualified name_

Edit your code to use the fully qualified name like so:

```java
public class Boot {

	public static void main(String[] args) {
		com.mycorp.dev.Coder kent = new com.mycorp.dev.Coder();
	}
}
```

Note that as soon as you make the change, the error goes away.
<br/>
<br/>

### _Step 4 - Unpublic the Coder_

Remove the `public` declaration from the `Coder` class definition

```java
package com.mycorp.dev;

 class Coder {}

```
As soon as you save the changes, the attempt to use the `Coder` class in the `main()` method now produces the error that the definition of Coder is not visible.

Replace the `public` declaration, save and the error vanishes.

Even though the fully qualified name `com.mycorp.dev.Coder` told Java exactly where to find the class definition, it couldn't see it because it was not public.

---

<br/>
<br/>


## Part Three: Import Statements

### _Step 1 - Use a Qualified import_

In the `main()` method, import the fully qualified name for the `Coder` class instead of using the fully qualified name in the code. Verify it works.

```java
package com.mycorp;
import com.mycorp.dev.Coder;

public class Boot {

	public static void main(String[] args) {
		Coder kent = new Coder();
	}

}
```
<br/>
<br/>

### _Step 2 - Use a Wildcard import_

Replace the qualified import with a wildcard import as shown. Verify that it works.

```java
package com.mycorp;
import com.mycorp.dev.*;

public class Boot {

	public static void main(String[] args) {
		Coder kent = new Coder();
	}

}
```
<br/>
<br/>

## Part Four: Naming Conflicts

### _Step 1 - Create a second Coder_

In the `com.mycorp.dev.backend` package create another public `Coder` class as shown.

```java
package com.mycorp.dev.backend;

public class Coder {}

```
Now add a second coder called `bjarne` which will use the second `Coder` definition from the `backend` package into the `main()` method

Now try to import both class definitions of `Coder` into the `com.mycorp` package.

```java
package com.mycorp;
import com.mycorp.dev.Coder;
import com.mycorp.dev.backend.Coder;

public class Boot {

	public static void main(String[] args) {
		Coder kent = new Coder();    // ??? Which coder??
		Coder bjarne = new Coder();  // Again.. which?
	}
}
```

Java will report a collision error which means that the two different classes are trying to both use the local name `Coder` as an alias, which is ambiguous to Java and anyone reading the code.

<br/>
<br/>

### _Step 2 - Resolving the Collision_

To solve this, we have to remove one of the `import` statements and use a fully qualified name instead. Which one to remove is up to you, Java doesn't care.

Just using the fully qualified name in the code won't solve the problem because Java only determines namespace collisions _only_ by looking at and comparing the `import` statement.  You have to remove the corresponding `import` as well. Like this

```java

package com.mycorp;
import com.mycorp.dev.backend.Coder;

public class Boot {

	public static void main(String[] args) {
		com.mycorp.dev.Coder kent = new com.mycorp.dev.Coder(); 
		Coder bjarne = new Coder(); // again.. which"
	}
}

```

Confirm this works.

The general rule is that when we are importing symbols into a package, and they all have the same name, then only one symbol can be imported and the other symbols must use there fully qualified name.

---
<br/>
<br/>

## Challenge Question

The following code compiles and executes when we replace `Coder` in one import with the wildcard `*`. Explain why this is ok but what we did earlier causes a collision.

```java
package com.mycorp;
import com.mycorp.dev.backend.Coder;
import com.mycorp.dev.*;

public class Boot {

	public static void main(String[] args) {
		com.mycorp.dev.Coder kent = new com.mycorp.dev.Coder(); 
		Coder bjarne = new Coder(); 
	}
}
```

<sub>Hint: Run the code and look at the warning messages about unused imports.</sub>
