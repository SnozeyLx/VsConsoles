import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Buffer {
	
public static int NUM_ITEMS = 5;
private String [] buffer = new String[NUM_ITEMS];
private int count = 0;
private int uI=0,iI=0;


ArrayList<String> frtux = new ArrayList();




boolean insert_item(String z){
	
	if (count == NUM_ITEMS) {
		System.out.println("buffer cheio");
		return false;
		}
	
	try{
		// mutex.acquire();
		uI = (uI + 1) % buffer.length;
		buffer[uI] = z;
		count++;
		  return true;
		
					
	}
		catch(Exception e){
		
	}
	
	finally {
       // mutex.release();
    }
	return false;
	
/* insere o item no buffer
retorna true em caso de sucesso
retorna false em caso de fracasso */
}


boolean remove_item(int z){
/* remove um item no buffer
colocando o mesmo em item

retorna true em caso de sucesso
retorna false em caso de fracasso */
	
	if (count == 0) {
		System.out.println("buffer vazio");

		return false;
		}
	
	try{
		// mutex.acquire();
		iI = (iI + 1) % buffer.length;
		frtux.add(z, buffer[iI]);		
		count--;
		buffer[iI] = "";
		return true;
		
		
	
	}
		catch(Exception Ie){
		
	}
	finally {
       // mutex.release();
    }
	return false;
	
}
}