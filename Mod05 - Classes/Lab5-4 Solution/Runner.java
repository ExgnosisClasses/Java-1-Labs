package lab5;

import remote.Student;

public class Runner {

	public static void main(String[] args) {
		Student igor = new Student();
		igor.printme();
		Student anish = new Student("Anish");
		anish.printme();
	    Student kyle = new Student("Kyle");
	    kyle.printme();

	}

}
