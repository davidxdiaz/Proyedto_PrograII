/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author David  Miguel
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
         ImageIcon imagen= new ImageIcon("src\\Imagenes\\Para Frames\\RaBatallas.jpg");
        //OBTENER TAMAÑO DEL FRAME
        Toolkit tk= Toolkit.getDefaultToolkit();
        Dimension tamaño= tk.getScreenSize();
        //Se le asigna el tamaño del frame al label
        jLabel3.setSize(tamaño);
     
        ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_DEFAULT));
        jLabel3.setIcon(icono);
       
     
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocation(0,0);
        
        jLabel1.setText(Player.getLoggedPlayer().getUsername().toUpperCase());   
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStratego = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnUniverso = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(100, 100));
        getContentPane().setLayout(null);

        btnStratego.setText("STRATEGO – MARVEL HEROES!");
        btnStratego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStrategoActionPerformed(evt);
            }
        });
        getContentPane().add(btnStratego);
        btnStratego.setBounds(100, 220, 310, 40);

        btnConfig.setText("CONFIGURACIÓN");
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfig);
        btnConfig.setBounds(100, 280, 310, 40);

        btnPerfil.setText("MI PERFIL");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(btnPerfil);
        btnPerfil.setBounds(100, 340, 310, 40);

        btnUniverso.setText("UNIVERSO MARVEL");
        btnUniverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUniversoActionPerformed(evt);
            }
        });
        getContentPane().add(btnUniverso);
        btnUniverso.setBounds(100, 400, 310, 40);

        btnCerrar.setText("CERRAR SESIÓN");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(100, 460, 310, 40);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 170, 80, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BIENVENIDO:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 130, 310, 20);

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 860, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        //Pregunta si desea cerrar sesión
        
        int n= JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Información", JOptionPane.YES_NO_OPTION);
        
        if (n==JOptionPane.YES_OPTION){
            Player.setLoggedPlayer(null);
            dispose();
            new MenuIncial().setVisible(true);
        }else{
           
        }
      
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        new Configuracion().setVisible(true);
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        try {
            new MiPerfil().setVisible(true);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnUniversoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUniversoActionPerformed
        new UniversoMarvel().setVisible(true);
    }//GEN-LAST:event_btnUniversoActionPerformed

    private void btnStrategoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStrategoActionPerformed
        new StrategoMarvelHeroes().setVisible(true);
    }//GEN-LAST:event_btnStrategoActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnStratego;
    private javax.swing.JButton btnUniverso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
