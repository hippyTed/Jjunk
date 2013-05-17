public class VacuumCleaner {
	private Motor motor = new Motor();
	
	public void switchon() {
		if (motor.isStopped()) {
			System.out.println("CLICK ON!");
			motor.run();
		} else {
			System.out.println("Already on!");
		}
	}
	
	public void switchoff() {
		if (motor.isRunning()) {
			System.out.println("CLICK OFF!");
			motor.stop();
		} else {
			System.out.println("Already off!");
		}
	}
}
