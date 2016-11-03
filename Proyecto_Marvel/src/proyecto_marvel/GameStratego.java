/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

/**
 *
 * @author ANDY ESCOBAR 007
 */
public class GameStratego extends javax.swing.JFrame {
    JButton square[][]=new JButton[10][10];
    private static ImageIcon villano;
    
    /**
     * Creates new form GameStratego
     */
    public GameStratego() {
        /* 
        this.setUndecorated(true); Remueve la barra "Hace que no podas cerrar la
                                   ventana con la x o que la podas mover.
        
        */
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        initComponents();
        
        JButton square[][]=new JButton[10][10];
        
        //Full Screen
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        int xSize = (int) tk.getScreenSize().getWidth();
        int ySize = (int) tk.getScreenSize().getHeight();
        
        this.setSize(xSize,ySize);
        //Cierre de full Screen
        
        this.setLocationRelativeTo(null);
        panelTablero.setSize(500, 700);
        this.add(panelTablero,BorderLayout.CENTER);
        this.setResizable(false);
        tablero();
        OcultarVillanos();
        
    }
    
    
    
    
    
    private void tablero(){
        
        
        panelTablero.setLayout(new GridLayout(10,10));
        for (int x=0;x<square.length;x++ ){
            for (int y=0;y<square[x].length;y++){
                JButton btn=new JButton();
                btn.setName(x+"");
                
                btn.setText(x+" , "+y);
               
                square[x][y]=btn;
                
                panelTablero.add(square[x][y]);
            }
            
        }
        villano = getImage("src/Imagenes/cardsVillain.png");
        OcultarVillanos();// Probando  
    }
    
    
    //Agreado Funcion ocultar cartas villano
    public void OcultarVillanos(){
        //ImageIcon ovillain=new ImageIcon("src/Imagenes/cardsVillain.png");
        
        for (int x=0;x<4;x++ ){
            for (int y=0;y<10;y++){
                //Icon icono=new ImageIcon(ovillain.getImage().getScaledInstance(square[x][y].getWidth(),square[x][y].getHeight(),Image.SCALE_DEFAULT));
                //square[x][y].setIcon(icono);
                square[x][y].setIcon(villano);
          
            }
        }
    }
    
   
   
    
    
    
            

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTablero = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 680));

        panelTablero.setName("panelTablero"); // NOI18N
        panelTablero.setPreferredSize(new java.awt.Dimension(530, 530));

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Player 1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Player 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(325, 325, 325)
                        .addComponent(jLabel2)
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GameStratego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameStratego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameStratego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameStratego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameStratego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables

    private static ImageIcon getImage(String path) {
         try
      {
         Image image = ImageIO.read(GameStratego.class.getResource(path));
         Image image_resize = image.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
         return new ImageIcon(image_resize);
      } catch (IOException e)
      {
      }
      return null;
    }
}
