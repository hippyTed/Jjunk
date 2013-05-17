public abstract class Animal {
	private String name;
	
	Animal(String n) {
		name = n;
	}
	
	protected String getName() {
		return name;
	}
	
	protected void putName(String n) {
		name = n;
	}
	
	protected abstract void speak();
	
	protected abstract void scram();
}