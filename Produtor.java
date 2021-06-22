import java.util.Random;
import java.util.concurrent.Semaphore;

class Produtor extends Thread{
	
	
	private int id;
	String[] frutas = {"Banana","Morango","Abacate","Abacaxi","Pera","Laranja","Uva","Tomate","Acerola","Maça"};
	
	Buffer buffer;
	Semaphore semaphore;   // tentei a implementação do semaforo nas classes produtora e consumidora e funcionou um pouco melhor "descrito no relatorio"
	
	public Produtor(int id, Buffer buffer, Semaphore s) {
		this.id = id;
		this.buffer = buffer;
		this.semaphore = s;
	}

public void run(){
	
	
	
	
	
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

	int idx = new Random().nextInt(frutas.length);         // escolhe um item do array da fruta e poe como elemento
	String produto = (frutas[idx]);
	
if (buffer.insert_item(produto)) 

System.out.println("produtor "+ id +" produziu " + produto);

else

	System.out.println("não produziu");


semaphore.release();
}
}

}
