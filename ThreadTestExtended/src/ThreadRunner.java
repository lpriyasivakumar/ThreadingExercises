public class ThreadRunner implements Runnable {
	private String name;
	private int value;
	private int speed;

	public ThreadRunner(String name, int value, int speed) {
		this.name = name;
		// setName(name);
		this.value = value;
		this.speed = speed;
	}

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		ct.setName(name);
		for (int i = 0; i < 3; i++) {
			int distance = 0;
			int rest;
			while ((distance < 1000) && (!ct.isInterrupted())) {
				rest = (int) ((Math.random() * 100) + 1);
				if (rest > value) {

					distance += speed;
					System.out.println(this.name + ": " + distance);
				}

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					break;
				}

			}
			if (distance >= 1000) {
				System.out.println(this.name + ": I finished.");
				Race.finished(this);

			}

		}
		Race.printWinners();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
