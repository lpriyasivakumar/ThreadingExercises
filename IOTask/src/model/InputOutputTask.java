package model;

public class InputOutputTask implements Runnable {

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		System.out.println(ct.getName() + " started.");
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){}
		
		System.out.println(ct.getName()+" finished.");

	}

}
