


public class Runner {

	public static void main(String[] args) {
		Dog fido = new Dog("Fido");
		ServiceDog lassie = new ServiceDog("Lassie");
		fido.speak();
		lassie.speak();
	}

}

class Dog {
	private String name;

	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void speak() {
		System.out.println(this.getName() + " BARK!");
	}
}

class ServiceDog extends Dog {
	public ServiceDog(String name) {
		super(name);
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " Looks for permission to speak");
		super.speak();
	}

	public void work() {
		System.out.println(this.getName() + " is hard at work");
	}
