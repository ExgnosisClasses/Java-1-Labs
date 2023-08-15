package remote;

public class Student {
	     
private String name = "Marcus";
	
	public String getName() {
		return this.name;
	}
	public void printme() {
		System.out.println("Hi! My name - " + this.name);
	}
	private boolean nameValidator(String s) {
		if (s == null) return false;
		if (s == "") return false;
		return true;
	}
	public void setName(String name) {
		if (!this.nameValidator(name)) return;
		this.name = name;
	}
	// Static Section
    public static final int MAX_COUNT = 2;
    private static int count = 0; 
    public static int getCount() {
	    return Student.count;
    }
    public static void incrementCount() {
	    Student.count++;
    }
	
}