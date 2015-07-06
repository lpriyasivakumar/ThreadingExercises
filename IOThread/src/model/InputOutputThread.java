package model;

public class InputOutputThread extends Thread {
	@Override
	public void run() {
		System.out.println(this.getName() + " has started.");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){}
		System.out.println(this.getName()+" has finished.");

	}

}
