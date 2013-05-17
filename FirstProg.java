public class FirstProg {
	public static void main(String[] args) {
		VacuumCleaner vac =  new VacuumCleaner();
		Animal[] pets = new Animal[2];
		pets[0] = new Dog("SammyGirl");
		pets[1] = new Cat("DublTrubl");
		
		for (Animal p: pets)
			p.scram();
		
		vac.switchon();
		
		for (Animal p: pets)
			p.speak();
		
		vac.switchoff();
	}
}
