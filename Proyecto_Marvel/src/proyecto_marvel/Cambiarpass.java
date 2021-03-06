/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;


import java.io.IOException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Paz
 */
public class Cambiarpass extends javax.swing.JFrame {

    /**
     * Creates new form Cambiarpass
     */
    public Cambiarpass() {
        initComponents();
        lblUser.setText(Player.getLoggedPlayer().getUsername().toUpperCase());
        ImageIcon imagen= new ImageIcon("src\\Imagenes\\Para Frames\\Thanos.jpg");
        //OBTENER TAMAÑO DEL FRAME
        Toolkit tk= Toolkit.getDefaultToolkit();
        Dimension tamaño= tk.getScreenSize();
        //Se le asigna el tamaño del frame al label
        jLabel1.setSize(tamaño);
     
        ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),Image.SCALE_DEFAULT));
        jLabel1.setIcon(icono);
       
     
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocation(0,0);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCPass = new javax.swing.JButton();
        txtPassA = new javax.swing.JPasswordField();
        txtPassNew = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        lblUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUser.setText("user");
        getContentPane().add(lblUser);
        lblUser.setBounds(60, 60, 150, 22);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese la contraseña actual");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 110, 200, 17);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingrese la nueva contraseña");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 200, 260, 17);

        btnCPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCPass.setText("Cambiar password");
        btnCPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPassActionPerformed(evt);
            }
        });
        getContentPane().add(btnCPass);
        btnCPass.setBounds(60, 300, 260, 50);

        txtPassA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtPassA);
        txtPassA.setBounds(60, 130, 260, 40);

        txtPassNew.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtPassNew);
        txtPassNew.setBounds(60, 220, 260, 40);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 790, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPassActionPerformed
        //Evaluo si el pass ingresado es igual al pass del usuario logged
        if(txtPassA.getText().equals(Player.getLoggedPlayer().getPassword())){
            //Verifico si el pass new es de 5 caracteres
            if(txtPassNew.getText().length()==5){
                try{
                    //cambio el pass
                    Player.getLoggedPlayer().setPassword(txtPassNew.getText());
                    Player.getLoggedPlayer().cambiarPassword(Player.getLoggedPlayer().getUsername(), Player.getLoggedPlayer().getPassword());
                    JOptionPane.showMessageDialog(null,"Cambiado exitosamente", "Gracias", JOptionPane.CLOSED_OPTION); 
                    dispose();
                }catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error "+e.getMessage());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Cambiarpass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
               JOptionPane.showMessageDialog(null,"Password nuevo no válido", "ERROR", JOptionPane.ERROR_MESSAGE); 
            
        }
        else
            JOptionPane.showMessageDialog(null,"Password actual no válido", "ERROR", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnCPassActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Cambiarpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cambiarpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cambiarpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cambiarpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cambiarpass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPassA;
    private javax.swing.JPasswordField txtPassNew;
    // End of variables declaration//GEN-END:variables
}
