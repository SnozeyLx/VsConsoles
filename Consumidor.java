import java.util.Random;
import java.util.concurrent.Semaphore;

class Consumidor extends Thread{

	private String itemConsumido;
	Buffer buffer;
	private int id;
	
	private  int idx = new Random().nextInt(100);
	
	Semaphore semaphore;
	
	public Consumidor(int id, Buffer buffer, Semaphore s) {
		this.id = id;
		this.buffer = buffer;
		this.semaphore = s;
	}

public void run(){
	
	
	
//Item item;
while (true){
/* adormecer por um período aleatório de tempo */
try {
	 
	sleep(new Random().nextInt(200));
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	semaphore.acquire();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

/* gerar um elemento aleatório */
//item = random();
  
  System.out.println(idx);

if (buffer.remove_item(idx)) {
	
	itemConsumido = buffer.frtux.get(idx);
	buffer.frtux.remove(idx);
	
	System.out.println("consumidor "+id+" consumiu " + itemConsumido );
    
	


}

else
	System.out.println("nao consumiu");


semaphore.release();
}
}
}
