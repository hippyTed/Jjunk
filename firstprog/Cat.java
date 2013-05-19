package firstprog;

public class Cat extends Animal {
	
	Cat(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.println(getName() + " says Meow!");
	}
	
	public void scram() {
		System.out.println(getName() + " runs away.");
	}
}