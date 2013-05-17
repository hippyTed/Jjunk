public class Dog extends Animal {
	
	Dog(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.println(getName() + " says Woof!");
	}
	
	public void scram() {
		System.out.println(getName() + " goes on mat.");
	}
}