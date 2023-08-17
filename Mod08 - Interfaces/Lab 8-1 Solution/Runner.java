




public class Runner {

	public static void main(String[] args) {
		Pet[] critters = { new Dog(), new Cat(), new Fish(), new Bird() };
		for(Pet critter : critters) {
			System.out.println(critter); 
			critter.speak(); 
		}

	}

}
interface Pet {
	public void speak();
}
interface Walker {
	public void walk();
}
interface Flyer {
    public void fly();
}

class Dog implements Pet, Walker {
	
	@Override
	public void speak() {
		System.out.println("Bark");
	}
    @Override
	public void walk() {
		System.out.println("Walking");
	}
}

class Cat implements Pet, Walker{
	@Override
	public void speak() {
		System.out.println("Meow");
	}
   @Override
	public void walk() {
		System.out.println("Walking");
	}
}

class Fish implements Pet {
	@Override
	public void speak() {
		System.out.println(".....");
	}
	public void swim() {
		System.out.println("Swimming");
	}
}

class Bird implements Pet, Flyer {
	@Override
	public void speak() {
		System.out.println("tweet");
	}
	public void fly() {
		System.out.println("Flying");
	}
}
