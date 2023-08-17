

public class Runner {

	public static void main(String[] args) {
		//Pet p = new Pet(); // error because Pet is abstract
		Pet[] critters = { new Dog(), new Cat(), new Fish(), new Bird() };
		for(Pet critter : critters) {
			System.out.println(critter); 
			critter.speak(); 
		}
	}
}

abstract class Pet {
	abstract public void speak();
}

class Dog extends Pet {
	
	@Override
	public void speak() {
		System.out.println("Bark");
	}

	public void walk() {
		System.out.println("Walking");
	}
}

class Cat extends Pet {
	@Override
	public void speak() {
		System.out.println("Meow");
	}

	public void walk() {
		System.out.println("Walking");
	}
}

class Fish extends Pet {
	@Override
	public void speak() {
		System.out.println(".....");
	}

	public void swim() {
		System.out.println("Swimming");
	}
}

class Bird extends Pet {
	@Override
	public void speak() {
		System.out.println("tweet");
	}

	public void fly() {
		System.out.println("Flying");
	}
}
