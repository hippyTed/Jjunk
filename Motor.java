public class Motor {
	private int running = 0;
	
	protected void run() {
		running = 1;
	}
	
	protected void stop() {
		running = 0;
	}

	protected boolean isRunning() {
		return running == 1;
	}
	
	protected boolean isStopped() {
		return running == 0;
	}
}
