import fileSystem.utils.*;
import java.nio.channels.FileChannel;

/**
 *Implementaci�n de una memoria intermedia con pol�tica de liberaci�n aleatoria
 */

public class RABuffer extends Buffer{
    
        /**
         *Constructor de una memoria intermedia con pol�tica de liberaci�n 
         *aleatoria de 16 p�ginas de 1024 bytes cada una.
         */
        public RABuffer(){
            super();
        }
        
        /**
         * Constructor de una memoria intermedia con pol�tica de liberaci�n 
         * aleatoria con un n�mero de p�ginas y tama�o de bloque a definir.
         * 
         * @param numberOfpages N�mero de p�ginas de la memoria intermedia
         * @param blockSize Tama�o de bloque de las p�ginas de la memoria 
         * intermedia.
         */
        public RABuffer(int numberOfpages, int blockSize){
            super(numberOfpages,blockSize);
        }
        
        /**
         *M�todo devuelve el identificador de la p�gina a liberar durante 
         *la carga de un bloque de memoria, cuando no quedan p�ginas libres, 
         *siguiendo una pol�tica aleatoria.
         *@param fc El descriptor del fichero al que pertenece el bloque que se desea cargar.
         *@param blockNumber El n�mero del bloque que se desea cargar del fichero identificado por fc.
         *@return el identificador de la p�gina en la que se escribir� el bloque.
         */
        public int releasePagePolicy(FileChannel fc, int blockNumber) {
                int pagina =(int)Math.floor(Math.random()*this.getNumberOfPages());
                System.out.println("\tFull memory. Page "+pagina+" is released to load block "+blockNumber+" (file "+fc+").");
		return pagina;
        }
        
        /**
         *M�todo que permite controlar cu�ndo una p�gina es utilizada. 
         *Cada vez que se utiliza una determinada p�gina de la memoria 
         *intermedia se invoca este m�todo.
         *@param i P�gina que ha sido utilizada.
         */
        public void referencedPage(int i) {
            System.out.println("\tReferenced page "+i);
            //Esta memoria no realiza ninguna acci�n cuando se utiliza alguna p�gina.
        }
}
