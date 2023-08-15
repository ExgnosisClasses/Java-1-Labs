package remote;

public class Student {

	private String name = null;
	private boolean isValid = false;
	
	public Student() {
		this("");
	}
	public Student(String name) {
		this.setName(name);
		Student.incrementCount();
	}
	
	
	
	public boolean isValid() { return this.isValid;}

	public String getName() {
		return this.name;
	}

	public void printme() {
		System.out.println("Student #"+Student.getCount() +" Hi! My name - " + this.name +   " " + (this.isValid ? "Valid" : "Invalid"));
	}
	

	private boolean nameValidator(String s) {
		if (s == null)
			return false;
		if (s == "")
			return false;
		return true;
	}

	public void setName(String name) {
		this.isValid = this.nameValidator(name);
		this.name = name;
	}

	// Static Section
	public static final int MAX_COUNT = 2;
	private static int count = 0;

	public static int getCount() {
		return Student.count;
	}

	private static void incrementCount() {
		Student.count++;
	}

}