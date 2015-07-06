import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class Race {
		public static ArrayList<Thread> threads=new ArrayList<Thread>();	
		public static HashMap<String,Integer> map = new HashMap<String,Integer>();

	public static void main(String[] args) {
		for (int n = 1; n <= 10; n++) {
		    Thread t = new Thread(new ThreadRunner("Thread"+n, n*10, n*20));
		    map.put(t.getName(),0);
		    threads.add(t);		    
		    t.start();
		 }	
		for(Entry<String, Integer> entry : map.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println(key + " won "+value+" times.");
		}

				
	}
	
	synchronized public static void finished(ThreadRunner threadRunner) {
		String name = threadRunner.getName();
		int count = map.get(name);
		map.replace(name, count, count+1);
		for(Thread t:threads){
			if(!t.getName().equalsIgnoreCase(threadRunner.getName()))
				t.interrupt();
			}
		
	}
	
	public static void printWinners(){
		for(Entry<String, Integer> entry : map.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println(key + " won "+value+" times.");
		}
	}

}
