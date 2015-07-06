package app;

import model.InputOutputThread;

public class InputOutputThreadTest {

	public static void main(String[] args) {
		
		Thread t1 = Thread.currentThread();		
		System.out.println(t1.getName()+" has started.");
		
		Thread t2 = new InputOutputThread();
		t2.start();
		System.out.println(t1.getName()+ " has started "+t2.getName());
		
		System.out.println(t1.getName() +" has finished.");
		
	}

}
