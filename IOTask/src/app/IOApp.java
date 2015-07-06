package app;

import model.InputOutputTask;

public class IOApp {

	public static void main(String[] args) {
		Thread ct = Thread.currentThread();
		System.out.println(ct.getName()+" has started.");
		
		Thread t = new Thread(new InputOutputTask());
		t.start();
		System.out.println(ct.getName()+" starts "+t.getName()+".");
		System.out.println(ct.getName()+" finished.");
	}

}
