package UI;

import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UI extends javax.swing.JFrame implements ActionListener {

    int x;
    int y;
    UIFunctions uif;
    FileChooser fc;
    ImageCipher ic;
    File image;
  
    public UI() {
        this.setUndecorated(true);//Elimina los bordes de la ventana
        initComponents();
        init();
        this.setResizable(false);//no permite que sea redimincionable
        this.setLocationRelativeTo(this);//la ventana aparece al centro de la pantalla
        AWTUtilities.setWindowOpaque(this, false);// Genera transparencia
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UI/logo.png"));
        setIconImage(icon);
        setVisible(true);
      
    }

    private void init(){
        uif=new UIFunctions();
        fc=new FileChooser();
        this.Close.addActionListener(this);
        this.Minimize.addActionListener(this);
        this.Show.addActionListener(this);
        this.JCB_AES_DES.addActionListener(this);
        this.JCB_C_D.addActionListener(this);
        this.ChooseFile.addActionListener(this);
        this.Run.addActionListener(this);
        this.ic=new ImageCipher();
        JPB_C_D.setMaximum(0);
        JPB_C_D.setMaximum(100);
        
        //JPB_C_D.setValue(50);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        JPB_C_D = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        ChooseFile = new javax.swing.JButton();
        JCB_AES_DES = new javax.swing.JComboBox<>();
        JCBMode = new javax.swing.JComboBox<>();
        JLKey = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        JCB_C_D = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        Run = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        JPF = new javax.swing.JPasswordField();
        Show = new javax.swing.JCheckBox();
        Close = new javax.swing.JButton();
        Minimize = new javax.swing.JButton();
        UIImg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JLFile = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(61, 181, 171));

        ChooseFile.setText("Choose File");

        JCB_AES_DES.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AES", "DES" }));

        JCBMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ECB", "CBC", "OFB", "CFB" }));

        JLKey.setText("Insert key 16 bytes");

        JCB_C_D.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Encrypt", "Decrypt" }));

        Run.setText("Run");

        Show.setText("Show");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLKey, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCBMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCB_AES_DES, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCB_C_D, 0, 122, Short.MAX_VALUE)
                            .addComponent(Show)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(Run, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JPF)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(ChooseFile)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChooseFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCB_AES_DES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCBMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JLKey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Show)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCB_C_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Run)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        Close.setText("X");

        Minimize.setText("_");

        UIImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/AES_CRYPT.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/titulo.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        jPanel2.setBackground(new java.awt.Color(61, 171, 181));

        JLFile.setText("File:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(JLFile, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLFile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JPB_C_D, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UIImg))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addGap(46, 46, 46)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Minimize)
                                .addComponent(Close)))
                        .addGap(18, 18, 18)
                        .addComponent(UIImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JPB_C_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x=evt.getX();
        y=evt.getY();
        
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x+evt.getX()-x, this.getLocation().y+evt.getY()-y);
    }//GEN-LAST:event_formMouseDragged

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChooseFile;
    private javax.swing.JButton Close;
    private javax.swing.JComboBox<String> JCBMode;
    private javax.swing.JComboBox<String> JCB_AES_DES;
    private javax.swing.JComboBox<String> JCB_C_D;
    private javax.swing.JLabel JLFile;
    private javax.swing.JLabel JLKey;
    private javax.swing.JProgressBar JPB_C_D;
    private javax.swing.JPasswordField JPF;
    private javax.swing.JButton Minimize;
    private javax.swing.JButton Run;
    private javax.swing.JCheckBox Show;
    private javax.swing.JLabel UIImg;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables

    
    
    private void setImages() {
        if (this.JCB_AES_DES.getSelectedIndex() == 0) {//AES
            JLKey.setText("Insert key 16 bytes");
            if (this.JCB_C_D.getSelectedIndex() == 0) {//Crypt
                UIImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/AES_CRYPT.png")));
            } else {
                UIImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/AES_DECRYPT.png")));

            }

        } else {//DES
            JLKey.setText("Insert key 8 bytes");
            if (this.JCB_C_D.getSelectedIndex() == 0) {//Crypt
                UIImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/DES_CRYPT.png")));
            } else {
                UIImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/DES_DECRYPT.png")));

            }
        }
    }
    
    private void showPassword(){
         if(Show.isSelected()){
                this.JPF.setEchoChar((char)0);
                
            }else{
                 this.JPF.setEchoChar('*');
            }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.Close)){
            uif.closeWindow();
            
        }
        else if(ae.getSource().equals(this.Minimize)){
            uif.minimizeWindow(this);
        }
         else if(ae.getSource().equals(this.Show)){
           this.showPassword();
        }
        else if(ae.getSource().equals(this.JCB_AES_DES)){
            this.setImages();      
        }
        else if(ae.getSource().equals(this.JCB_C_D)){
            this.setImages();      
        }
        else if(ae.getSource().equals(this.ChooseFile)){
           image= fc.openFile();
           if(image!=null){
            JLFile.setText("File: "+image.getName());
            
           }else{
             JLFile.setText("File: "+"No selected file");
           }
        }
        else if(ae.getSource().equals(this.Run)){
            String key;
            boolean sucess;
            if (fc.image != null) {

                if (JCB_AES_DES.getSelectedIndex() == 0) {//AES
                    key = String.valueOf(JPF.getPassword());
                    if (ic.checkKeyAES(key)) {
                         if (JCB_C_D.getSelectedIndex() == 0) { //Encrypt
                            try {
                                sucess=ic.encryptImage(fc.image, key, "AES", JCBMode.getItemAt(JCBMode.getSelectedIndex()));
                                fc.image = null;
                                if(sucess){
                                    JLFile.setText("Sucessfull");
                                    uif.informationMessage("Sucessfull", "Encrypt");
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            try {
                                sucess=ic.decryptImage(fc.image, key, "AES", JCBMode.getItemAt(JCBMode.getSelectedIndex()));
                                fc.image = null;
                                if(sucess){
                                    JLFile.setText("Sucessfull");
                                    uif.informationMessage("Sucessfull", "Decrypt");
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                    } else {
                        uif.warningMessage("Invalid key", "Warning");
                    }

                } else {
                    key = String.valueOf(JPF.getPassword());
                    if (ic.checkKeyDES(key)) {
                        if (JCB_C_D.getSelectedIndex() == 0) { //Encrypt
                            try {
                                sucess=ic.encryptImage(fc.image, key, "DES", JCBMode.getItemAt(JCBMode.getSelectedIndex()));
                                fc.image = null;
                                if(sucess){
                                    JLFile.setText("Sucessfull");
                                    uif.informationMessage("Sucessfull", "Encrypt");
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            try {
                                sucess=ic.decryptImage(fc.image, key, "DES", JCBMode.getItemAt(JCBMode.getSelectedIndex()));
                                fc.image = null;
                                if(sucess){
                                    JLFile.setText("Sucessfull");
                                    uif.informationMessage("Sucessfull", "Decrypt");
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {
                        uif.warningMessage("Invalid key", "Warning");
                    }
                }

            }else{
                uif.warningMessage("no selected file", "Warning");
            }
            
        }
        
    }
     
}
