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

/**
 *
 * @author David
 */
public class MiPerfil extends javax.swing.JFrame {

    /**
     * Creates new form MiPerfil
     */
    public MiPerfil() throws IOException, ClassNotFoundException {
        initComponents();
        lblNompERFIL.setText(Player.getLoggedPlayer().getUsername().toUpperCase());
        int puntos=Player.existe(Player.getLoggedPlayer().getUsername()).getPuntos();
        txtPuntos.setText(""+puntos);
        int ganoV=Player.existe(Player.getLoggedPlayer().getUsername()).WinVillanos;
        int ganoH=Player.existe(Player.getLoggedPlayer().getUsername()).WinHeroes;
        lblWinHeroes.setText(""+ganoH);
        lblWinVillanos.setText(""+ganoV);
        ImageIcon imagen= new ImageIcon("src\\Imagenes\\Para Frames\\Perfil.jpg");
        //OBTENER TAMAÑO DEL FRAME
        Toolkit tk= Toolkit.getDefaultToolkit();
        Dimension tamaño= tk.getScreenSize();
        //Se le asigna el tamaño del frame al label
        jLabel4.setSize(tamaño);
     
        ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(),Image.SCALE_DEFAULT));
        jLabel4.setIcon(icono);
       
     
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocation(0,0);
        this.setLocationRelativeTo(null);
      
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblNompERFIL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JLabel();
        lblwinH = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblWinHeroes = new javax.swing.JLabel();
        lblWinVillanos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setText("LOG DE MIS ULTIMOS JUEGOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 130, 310, 40);

        jButton2.setText("CAMBIAR MI PASSWORD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 180, 310, 40);

        jButton3.setText("CONECTAR A TWITTER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(40, 230, 310, 40);

        jButton4.setText("ELIMINAR MI CUENTA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(40, 280, 310, 40);

        lblNompERFIL.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNompERFIL.setForeground(new java.awt.Color(255, 255, 255));
        lblNompERFIL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNompERFIL.setText("User");
        getContentPane().add(lblNompERFIL);
        lblNompERFIL.setBounds(30, 400, 170, 29);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Puntos:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 400, 70, 22);

        txtPuntos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPuntos.setForeground(new java.awt.Color(255, 255, 255));
        txtPuntos.setText("...");
        getContentPane().add(txtPuntos);
        txtPuntos.setBounds(390, 400, 70, 22);

        lblwinH.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblwinH.setForeground(new java.awt.Color(255, 255, 255));
        lblwinH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblwinH.setText("Partidas Ganadas con Héroes");
        getContentPane().add(lblwinH);
        lblwinH.setBounds(30, 490, 270, 22);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Partidas Ganadas con Villanos");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 550, 270, 22);

        lblWinHeroes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblWinHeroes.setForeground(new java.awt.Color(255, 255, 255));
        lblWinHeroes.setText("jLabel3");
        getContentPane().add(lblWinHeroes);
        lblWinHeroes.setBounds(350, 490, 70, 22);

        lblWinVillanos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblWinVillanos.setForeground(new java.awt.Color(255, 255, 255));
        lblWinVillanos.setText("jLabel3");
        getContentPane().add(lblWinVillanos);
        lblWinVillanos.setBounds(350, 550, 80, 17);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("VER INFORMACIÓN");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 80, 190, 22);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MIS DATOS");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 370, 140, 22);

        jLabel4.setText("jLabel3");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jLabel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel4ComponentHidden(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 910, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
        new EliminarCuenta().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       new Ultimosjuegos().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Cambiarpass().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       new ConectarTwitter().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel4ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel4ComponentHidden
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel4ComponentHidden

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel4MouseExited

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MiPerfil().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MiPerfil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MiPerfil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblNompERFIL;
    private javax.swing.JLabel lblWinHeroes;
    private javax.swing.JLabel lblWinVillanos;
    private javax.swing.JLabel lblwinH;
    private javax.swing.JLabel txtPuntos;
    // End of variables declaration//GEN-END:variables
}
