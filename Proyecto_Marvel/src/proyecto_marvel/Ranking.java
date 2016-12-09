/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel Paz
 */
public class Ranking extends javax.swing.JFrame {

    /**
     * Creates new form Ranking
     */
    public Ranking() {
        initComponents();
         ImageIcon imagen= new ImageIcon("src\\Imagenes\\Para Frames\\Ranking.jpg");
        //OBTENER TAMAÑO DEL FRAME
        Toolkit tk= Toolkit.getDefaultToolkit();
        Dimension tamaño= tk.getScreenSize();
        //Se le asigna el tamaño del frame al label
        jLabel2.setSize(tamaño);
     
        ImageIcon icono= new ImageIcon(imagen.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(),Image.SCALE_DEFAULT));
        jLabel2.setIcon(icono);
       
     
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocation(0,0);
        this.setLocationRelativeTo(null);
        
        FileInputStream fi;
        ObjectInputStream oi;
        try {
            fi = new FileInputStream("player.pl");
            oi = new ObjectInputStream(fi);
            Player.players = (ArrayList<Player>)oi.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }
        rankingPlayer();
         
        int pos=0;
        for(Player play:Player.players){
            pos+=1;
            System.out.println(pos+". "+play.getUsername().toUpperCase()+" "+play.getPuntos()+" PUNTOS");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableRanking = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(null);

        tableRanking.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tableRanking.setForeground(new java.awt.Color(0, 153, 153));
        tableRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableRanking);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(650, 130, 452, 402);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1210, 500);

        pack();
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
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ranking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRanking;
    // End of variables declaration//GEN-END:variables
    
    private void rankingPlayer(){
        Player.rankingPlayers();
        String columnas[]={"POS.","PLAYERS", "PUNTOS"};
        String topPlayer[][]=new String[Player.rankingPlayers.size()][3];
        if(Player.rankingPlayers.size()<20){
            for(int cont=0;cont<topPlayer.length;cont++){
                topPlayer[cont][0]=String.valueOf((cont+1));
                topPlayer[cont][1]=Player.rankingPlayers.get(cont).getUsername().toUpperCase();
                topPlayer[cont][2]= String.valueOf(Player.rankingPlayers.get(cont).getPuntos());   
            }
        }else{
            for(int cont=0;cont<20;cont++){
                topPlayer[cont][0]=String.valueOf((cont+1));
                topPlayer[cont][1]=Player.rankingPlayers.get(cont).getUsername().toUpperCase();
                topPlayer[cont][2]= String.valueOf(Player.rankingPlayers.get(cont).getPuntos());
            }
                    
        }
        DefaultTableModel model=new DefaultTableModel(topPlayer,columnas);
        tableRanking.setModel(model);
        this.setLayout(new BorderLayout());  
    }
}
