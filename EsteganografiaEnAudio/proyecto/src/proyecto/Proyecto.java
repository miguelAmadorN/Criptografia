
package proyecto;

import Hash.Hash;
import WAVE.Wav;
import java.io.File;
import java.io.IOException;
import Process.Process;
import java.util.Arrays;

/**
 *
 * @author miguel
 */
public class Proyecto {


    
    
    
    public static void main(String[] args) throws IOException {
        File fileWave=new File("/home/miguel/Música/e1.wav");
        File fileToHide=new File("/home/miguel/Música/mensaje.txt");
        File outputFile=new File("/home/miguel/Música/salida.wav");
        String instance="AES";
        String mode="OFB";//"ECB", "CBC", "OFB", "CFB"
        String keyAES="asdfghjklzxcvbnm";
         String keyDES="asdfghjk";
        String nombre="salida.txt";
        Process p=new Process();
       // p.hide(fileWave, fileToHide, outputFile, instance, mode, keyAES,nombre);
        p.uncover(outputFile,  keyAES, instance, mode);
     }
    /**
     * Cuando se recupera el archivo, este se guarda en el directorio raíz del proyecto. 
     * Se puede cifrar casi 1 GB, por cada byte a ocultar se necesitan 4 bytes de audio 
     * descomprimido. 
     * Falta:
     *          optimizar las clases y su implementación (crear interfaces)
     *          interfaz de usuario
     *          
     */
}
