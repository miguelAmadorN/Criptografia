
package UI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
    File image=null;
    
    public File openFile() {
        int val;
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Open");
        jfc.setApproveButtonText("Open");

                
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("Image bmp","bmp");
        jfc.setFileFilter(filtro);
        val=jfc.showOpenDialog(null);
        /**
         * abrimos el archivo seleccionado
         */
        File open = null; 
        if(val== JFileChooser.APPROVE_OPTION) {
               open = jfc.getSelectedFile();   
               image=open;
        }
        return open;
    }
    
   public File saveFile() {
        JFileChooser jfc = new JFileChooser();
        jfc.setLocale(Locale.ENGLISH);
        jfc.setDialogTitle("Save");
        jfc.setApproveButtonText("Save");
        jfc.showSaveDialog(null);
        File save = jfc.getSelectedFile();
        return save;
    }
    
}
