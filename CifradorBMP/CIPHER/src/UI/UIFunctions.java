package UI;

import static java.awt.Frame.ICONIFIED;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class UIFunctions {
    
    public void closeWindow(){
        System.exit(0);
    }
    
    public void minimizeWindow(JFrame frame){
        frame.setExtendedState(ICONIFIED);
    }    
    
     public void informationMessage(String message, String window){
          JOptionPane.showMessageDialog(null, message, window, JOptionPane.INFORMATION_MESSAGE);
    }
    
   public void warningMessage(String message, String window){
          JOptionPane.showMessageDialog(null,message,window, JOptionPane.WARNING_MESSAGE);
    }
   
   
    
}
