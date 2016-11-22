/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author ANDY ESCOBAR 007
 */
public final class GameStratego extends javax.swing.JFrame implements ActionListener{
        
    CasillasMarvel celda[][]=new CasillasMarvel[10][10];
    Ficha heroes[][]=new FichasHeroes[4][10];
    Ficha villanos[][]=new FichasVillanos[4][10];
    CasillasMarvel primerCasilla=null,segundaCasilla=null;
    boolean turnoPlayerHeroes=true, primerclic=false;
    TipoFicha fichaContraria= turnoPlayerHeroes?TipoFicha.VILLANO:TipoFicha.HEROE;
    TipoFicha miTipoFicha = turnoPlayerHeroes? TipoFicha.HEROE:TipoFicha.VILLANO;
    int turno=1; 
    String turnoplayer=(turno==1?"HEROES":"VILANOS");
    private String playertwo;
    
    /**
     * vARIABLE QUE ME CUENTA LOS VILLANOS QUE SE HAN COMID
     */
    int cVillanosR1=0,cVillanosR2=0,cVillanosR3=0,cVillanosR4=0,cVillanosR5=0;
    int cVillanosR6=0,cVillanosR7=0,cVillanosR8=0,cVillanosR9=0,cVillanosR10=0;
    
    /**
     * VARIABLE QUE CUENTA LA CANTIDA DE HEROE QUE ME HA COMIDO
     */
    int cHeroesR1=0,cHeroesR2=0,cHeroesR3=0,cHeroesR4=0,
       cHeroesR5=0,cHeroesR6=0,cHeroesR7=0,cHeroesR8=0,cHeroesR9=0,cHeroesR10=0;
    
    
    
    String turn=turnoPlayerHeroes?"HEROES":"VILLANOS";
       
   
    /**
     * Creates new form GameStratego
     */
    public GameStratego() {
      
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        panelTablero.setSize(500, 700);
        obtenerHeroes();
        obtenerVillanos();
        tablero(); //IMPLEMENTA EL TABLERO EN PANTALLA\
        pintarZonaSegura();
        lblTurno.setText("TURNO: "+turnoplayer);
        
        
  
    }
    
  /**
   * FUNCION QUE IMPLEMENTA LAS CASILLAS DE TABLERO
   */  
    public void tablero(){
        do
        {
         playertwo = JOptionPane.showInputDialog(null, "Ingrese jugador 2");

         if (playertwo == null)
         {
            return;
         }

         if ("".equals(playertwo))
         {
            JOptionPane.showMessageDialog(null, "El jugador no puede estar vacio");
            continue;
         }

         if ((Player.existe(playertwo) != null) && !playertwo.equals(Player.getLoggedPlayer().getUsername()))
         {
            break;
         } else
         {
            JOptionPane.showMessageDialog(null, "El jugador no existe o ingreselo correctamente");
            continue;
         }

       } while (true);
        lblPlayerOne.setText(Player.getLoggedPlayer().getUsername());
        lblPlayerTwo.setText(playertwo);
        
 
        panelTablero.setLayout(new GridLayout(10,10));
        for (int i=0;i<celda.length;i++ ){
            for (int e=0;e<celda[i].length;e++){
                if(i<heroes.length &&e<heroes[i].length){ 
                    celda[i][e]=new CasillasMarvel(i, e, heroes[i][e]);
                    celda[i][e].setText("HR"+i+" "+e);
                }else if(i>5){
                    celda[i][e]=new CasillasMarvel(i, e, villanos[i-6][e]);
                    celda[i][e].setText("VILLAINS"+i+e);
                }
                else{ 
                    celda[i][e]=new CasillasMarvel(i, e, null);
                    
                }
                celda[i][e].setName(i+""+e);
                celda[i][e].addActionListener(this);
                
                panelTablero.add(celda[i][e]);
        
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
        lblPlayerOne = new javax.swing.JLabel();
        lblPlayerTwo = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
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

        lblPlayerOne.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPlayerOne.setText("Player 1");

        lblPlayerTwo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPlayerTwo.setText("Player 2");

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurno.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblTurnoPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Player 1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setText("Player 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(lblPlayerTwo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPlayerOne)))
                        .addGap(83, 83, 83)))
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayerOne)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayerTwo)
                    .addComponent(jLabel2))
                .addGap(213, 213, 213))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblTurnoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblTurnoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTurnoPropertyChange

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
            java.util.logging.Logger.getLogger(GameStratego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPlayerOne;
    private javax.swing.JLabel lblPlayerTwo;
    public javax.swing.JLabel lblTurno;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables

    private static ImageIcon getImage(String path)
   {
      try
      {
         
         Image image = ImageIO.read(GameStratego.class.getResource(path));
         Image image_resize = image.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
         return new ImageIcon(image_resize);
      } catch (IOException e){
          e.getMessage();
      }
      return null;
   }

    @Override
    public void actionPerformed(ActionEvent e) {
 
            if(primerclic){
                if(e.getSource() instanceof CasillasMarvel){
                    for (CasillasMarvel[] celda1 : celda) {
                        for (CasillasMarvel objeto : celda1) {
                            if (e.getSource().equals(objeto)) {
                                segundaCasilla=objeto;
                                validarSegundoClic(primerCasilla,segundaCasilla);
                                cambiarTurno();
                                
                            }
                        }
                    }
                }  
            }
            else{
                
                if(e.getSource() instanceof CasillasMarvel){
                    for (CasillasMarvel[] celda1 : celda) {
                        for (CasillasMarvel objeto : celda1) {
                            if (e.getSource().equals(objeto)){
                                primerCasilla= objeto;
                                validarPrimerClic(primerCasilla);                                     
                            }
                        }
                    }
                }
            }
    }

    private void validarMovimiento(CasillasMarvel primerCasilla, CasillasMarvel segundaCasilla) {
        if(segundaCasilla.ficha == null|| segundaCasilla.ficha.ficha!=miTipoFicha){
            moverPieza(primerCasilla,segundaCasilla);
        }

            
        
    }

    private void moverPieza(CasillasMarvel primerCasilla, CasillasMarvel segundaCasilla) {
        
        int scx=segundaCasilla.x,scy=segundaCasilla.y; //COORDENADAS DE LA SEGUNDO BOTON O CASILA
        if(scx==4 ||scx==5){
            if(scy==2||scy==3||scy==6||scy==7){
                JOptionPane.showMessageDialog(null, "!NO PUEDE MOVER ESTA PIEZA A LA ZONA PROHIBIDA");
                return;
            }
        }
        if (primerCasilla.x==segundaCasilla.x){
            int pos=primerCasilla.y;
            int s=segundaCasilla.y;
            if ((s+1)>=pos &&(s-1)<=pos){
                segundaCasilla.ficha=primerCasilla.ficha;
                segundaCasilla.setText(primerCasilla.getText());
                primerCasilla.setText(null);
                primerCasilla.ficha=null;
            }
            else{
                JOptionPane.showMessageDialog(null, "Movimiento no valido, esta Ficha no se puede mover mas 2 posciones");
            }
        }
        else if(primerCasilla.y==segundaCasilla.y){
            int h=primerCasilla.x;
            int s=segundaCasilla.x;
            if ((s+1)>=h &&(s-1)<=h){
                segundaCasilla.ficha=primerCasilla.ficha;
                segundaCasilla.setText(primerCasilla.getText());
                primerCasilla.setText(null);
                primerCasilla.ficha=null;
            }
            else{
                JOptionPane.showMessageDialog(null, "Movimiento no valido, esta Ficha no se puede mover mas 2 posciones");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Movimiento no valido, porfavor intenete de nuevo");
        }
    }
        
    private void pintarZonaSegura() {
        for(int y=4;y<=5;y++){
            for (int x=2;x<=3;x++){
                celda[y][x].setBackground(Color.YELLOW);     
            }
            for(int z=6;z<=7;z++){
                celda[y][z].setBackground(Color.magenta);
            }
        }
    }

    private void validarPrimerClic(CasillasMarvel primerCasilla) {
         String tipo=null;
        if(primerCasilla.ficha!=null &&primerCasilla.ficha.ficha==miTipoFicha){
            
            primerclic=true;
            System.out.println("Primer Clic");
            if(primerCasilla.ficha instanceof FichasHeroes){
                tipo="HEROE";  
            }
            else if(primerCasilla.ficha instanceof FichasVillanos){
                tipo="VILLANO";
            }
            System.out.println(primerCasilla.x+""+primerCasilla.y+" "+tipo);
                                    
            }
        else {
            System.out.println(primerCasilla.x+""+primerCasilla.y+" "+tipo);
            JOptionPane.showMessageDialog(null, "Selecione una ficha porfavor tuya porfavor");
        }
    }

    private void validarSegundoClic(CasillasMarvel primerCasilla, CasillasMarvel segundaCasilla) {
        CasillasMarvel objeto=segundaCasilla;
        String tipo=null;
        if(objeto.ficha instanceof FichasHeroes){
            tipo="HEROE";
        }else if(objeto.ficha instanceof FichasVillanos)
            tipo="VILLANOS";
        if(primerCasilla.equals(objeto)){
            JOptionPane.showMessageDialog(null,"Usted a hecho clic en la misma cordenada");
        }
        else{
            System.out.println("Segundo Clic\n"+objeto.x+""+objeto.y+" "+tipo);
            primerclic=false;
            
            validarMovimiento(primerCasilla,segundaCasilla);
            
        }
    }

    private void obtenerVillanos() {
        for (int cont1=0;cont1<villanos.length;cont1++){
            for(int cont2=0; cont2<villanos[cont1].length;cont2++){
                if (cont1<2) {
                   villanos[cont1][cont2] = new FichasVillanos(2);
                }else if(cont1<4){
                    villanos[cont1][cont2]=new FichasVillanos(4);
                }
                if (villanos[cont1][cont2] == null) {
                    villanos[cont1][cont2] = new FichasVillanos(1);
                }
                
            }
        }
    }

    private void cambiarTurno() {
        turno++;
        if (turno>2){
           turno=1;
        }
        turnoplayer= turno==1?"HEROES":"VILLANOS";
        lblTurno.setText("TURNO "+turnoplayer);
        fichaContraria= turno==1?TipoFicha.VILLANO:TipoFicha.HEROE;
        miTipoFicha = turno==1? TipoFicha.HEROE:TipoFicha.VILLANO;
    }

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        @Override
        public void run() {
            new GameStratego().setVisible(true);
        }
    }
    
    
    public void obtenerHeroes(){
        for (Ficha[] heroe : heroes) {
            for (int cont2 = 0; cont2 < heroe.length; cont2++) {
                if (cont2>2 || 2 < heroe.length - 2) {
                    heroe[cont2] = new FichasHeroes(2);
                }
                if (heroe[cont2] == null) {
                    heroe[cont2] = new FichasHeroes(1);
                }
            }
        }
    }
    
}



        



