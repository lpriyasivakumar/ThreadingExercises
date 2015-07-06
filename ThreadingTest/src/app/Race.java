package app;

import model.*;

public class Race {
	private static final String HARE = "Hare";
	private static final String TORTOISE = "Tortoise";
	public static Thread runner1;
	public static Thread runner2;

	public static void main(String[] args) {
		runner1 = new Thread(new ThreadRunner(TORTOISE, 0, 10));
		runner2 = new Thread(new ThreadRunner(HARE, 10, 100));
		runner1.start();
		runner2.start();

	}

	synchronized public static void finished(Thread runner) {
		System.out.println( runner.getName() + " has finished.");
		if (runner.getName().equals(TORTOISE)) {
			runner2.interrupt();
			System.out.println(runner.getName() + " is the winner.");

		} else {
			System.out.println(runner2.getName() +" is the winner.");
			runner1.interrupt();
		}

	}

}
