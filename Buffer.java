import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Buffer {
	
	
//buffer	
public static int NUM_ITEMS = 5;
private String [] buffer = new String[NUM_ITEMS];


//ponteiros do buffer
private int count = 0;
private int uI=0,iI=0;

//array que recebe o nome dos itens exlcuidos e são passados pro consumidor
ArrayList<String> frtux = new ArrayList();




boolean insert_item(String z){
	
	if (count == NUM_ITEMS) { // confere se esta cheio e sai caso esteja
		System.out.println("buffer cheio");
		return false;
		}
	
	try{
		// mutex.acquire();  tentei fazer o mutex no buffer não estava fluindo
		
		uI = (uI + 1) % buffer.length; // ponteiro read
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
		iI = (iI + 1) % buffer.length; //ponteiro write
		if(buffer[iI] != null)
		frtux.add(z, buffer[iI]);	 //add na array list no index passado pelo metodo remove_item	
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