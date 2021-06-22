import java.util.Scanner;
import java.util.concurrent.Semaphore;



public class Main {
	

	Produtor produtor;
	Buffer buffer;
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Semaphore mutex = new Semaphore(1);
	
	     Buffer bf = new Buffer();
	     
	 	Produtor p1 = new Produtor(1, bf, mutex);
	 	Produtor p2 = new Produtor(2, bf, mutex);
	 	Produtor p3 = new Produtor(3, bf, mutex);
	 	Consumidor c1 = new Consumidor(1, bf, mutex);
	 	Consumidor c2 = new Consumidor(2, bf, mutex);
	 	Consumidor c3 = new Consumidor(3, bf, mutex);
	 	
	 	Thread.sleep(100);
	 	
	 	p1.start();
	 	p2.start();
	 	p3.start();
	 	c1.start();
	 	c2.start();
	 	c3.start();
	 	
	   		
		
	}
	
   
}
