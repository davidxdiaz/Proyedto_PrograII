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

/**
 *
 * @author ANDY ESCOBAR 007
 */
public final class GameStratego extends javax.swing.JFrame implements ActionListener{
    
    /**
     * Variables Globales
     */    
    String cap="Capitán América";
    ImageIcon icono=new ImageIcon("src/Imagenes/cardsVillain.png");
    ImageIcon iconoH=new ImageIcon("src/Imagenes/Heroes/"+cap+".png");
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
    
    
    
    
    String nomHeroes[]={"Nightcrowler","Elektra","Dr. Strange","Phoenix","Storm","Ice Man","SpiderGirl",
        "Gambit","Colossus","Beast","Giant Man","She Hulk","Emma Frost",
        "Thing","Blade","Punisher","Ghost Rider",
        "Invisible Woman","Cyclops","Human Torch","Thor",
        "Iron Man","Hulk","Silver Surfers","Daredevil",
        "Namor","Wolverine","SpiderMan",
        "Nick Fury","Profesor X",
        "Capitán América","Mr. Fantastic","Black Widow"};
    
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
       
    public GameStratego() { 
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        
        
        panelTablero.setSize(500, 700);
        formularioInicial();
        obtenerHeroes();
        obtenerVillanos();
        tablero(); //IMPLEMENTA EL TABLERO EN PANTALLA\
        pintarZonaSegura();
        lblTurno.setText("TURNO "+turnoplayer);
    }
    
  /**
   * FUNCION QUE IMPLEMENTA LAS CASILLAS DE TABLERO
   */  
    public void tablero(){
        panelTablero.setLayout(new GridLayout(10,10));
        for (int i=0;i<celda.length;i++ ){
            for (int e=0;e<celda[i].length;e++){
                if(i<heroes.length &&e<heroes[i].length){ 
                    celda[i][e]=new CasillasMarvel(i, e, heroes[i][e]);
                    celda[i][e].setText("HR"+i+" "+e);
                    celda[i][e].setIcon(obtenerImagen(heroes[i][e]));
                }else if(i>5){
                    celda[i][e]=new CasillasMarvel(i, e, villanos[i-6][e]);
                    celda[i][e].setText("VILLAINS"+i+e);
                    celda[i][e].setIcon(icono);
                }else{ 
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        lblTurno.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblTurno.setForeground(java.awt.Color.red);
        lblTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurno.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblTurnoPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Héroes:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setText("Villanos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPlayerTwo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayerOne))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 119, Short.MAX_VALUE)
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
                .addGap(120, 120, 120)
                .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                            }
                        }
                    }
                }  
            }else{
                if(e.getSource() instanceof CasillasMarvel){
                    for (CasillasMarvel[] celda1 : celda) {
                        for (CasillasMarvel objeto : celda1) {
                            if (e.getSource().equals(objeto)){
                                primerCasilla= objeto;
                                System.out.println(objeto.getWidth()+"  "+objeto.getHeight());
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
               JOptionPane.showMessageDialog(null,"Movimiento no válido", "Zona Prohibida", JOptionPane.ERROR_MESSAGE);
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
                //Quita la imagen de la casilla anterior
                segundaCasilla.setIcon(primerCasilla.getIcon());
                primerCasilla.setIcon(null);
                
                primerCasilla.ficha=null;
                
                cambiarTurno();
            }
            else{
                JOptionPane.showMessageDialog(null, "Movimiento no válido, esta Ficha no se puede mover más 2 posiciones");
            }
        }
        else if(primerCasilla.y==segundaCasilla.y){
            int h=primerCasilla.x;
            int s=segundaCasilla.x;
            if ((s+1)>=h &&(s-1)<=h){
                segundaCasilla.ficha=primerCasilla.ficha;
                segundaCasilla.setText(primerCasilla.getText());
                
                segundaCasilla.setIcon(primerCasilla.getIcon());
                primerCasilla.setIcon(null);
                cambiarTurno();
                primerCasilla.setText(null);
                primerCasilla.ficha=null;
            }
            else{
                JOptionPane.showMessageDialog(null, "Movimiento no válido, esta Ficha no se puede mover más 2 posiciones");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Movimiento no válido, por favor intente de nuevo");
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
/**
 * 
 * @param primerCasilla  Obtiene el primer clic y valida que este cumpla con las condiciones requeridas
 */
    private void validarPrimerClic(CasillasMarvel primerCasilla) {
        if(primerCasilla.ficha!=null && primerCasilla.ficha.ficha==miTipoFicha){
            primerclic=true;
            System.out.println("Primer Clic");
            System.out.println(primerCasilla.x+""+primerCasilla.y+" "+infoTipoFicha(primerCasilla));
                                    
            }
        else {
            System.out.println(primerCasilla.x+""+primerCasilla.y+" "+infoTipoFicha(primerCasilla));
            JOptionPane.showMessageDialog(null, "Selecione una ficha tuya por favor");
        }
    }

    private void validarSegundoClic(CasillasMarvel primerCasilla, CasillasMarvel segundaCasilla) {
        CasillasMarvel objeto=segundaCasilla;
        if(primerCasilla.equals(objeto)){
            JOptionPane.showMessageDialog(null,"Usted a hecho clic en la misma cordenada");
        }
        else{
            System.out.println("Segundo Clic\n"+objeto.x+""+objeto.y+" "+infoTipoFicha(objeto)); //infotipoFicha retorna String segun el tipo del Objeto
            validarMovimiento(primerCasilla,segundaCasilla);
            primerclic=false;     
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

    private void formularioInicial() {
        
        
        
        
        do{
            playertwo = JOptionPane.showInputDialog(null, "Ingrese jugador 2");
        
            if (playertwo.equals(JOptionPane.CANCEL_OPTION)){
             this.dispose();
             new MenuIncial().setVisible(true);
             break;
            }
            if (playertwo == null){
                return;
            }            
            if ("".equals(playertwo)){
                JOptionPane.showMessageDialog(null, "El jugador no puede estar vacio");
                continue;
            }
            if ((Player.existe(playertwo) != null) && !playertwo.equals(Player.getLoggedPlayer().getUsername())){
                break;
            } else{
                JOptionPane.showMessageDialog(null, "El jugador no existe o ingreselo correctamente");
            }
        } while (true);
        if(Opciones.op==true){
            lblPlayerOne.setText(Player.getLoggedPlayer().getUsername().toUpperCase());
            lblPlayerTwo.setText(playertwo.toUpperCase());
        }
        else{
            lblPlayerOne.setText(playertwo.toUpperCase());
            lblPlayerTwo.setText(Player.getLoggedPlayer().getUsername().toUpperCase());
        }
    }

    private String infoTipoFicha(CasillasMarvel objeto) {
        String tipo=null;
        if(objeto.ficha instanceof FichasHeroes){
            tipo="HEROE";
        }else if(objeto.ficha instanceof FichasVillanos){
            tipo="VILLANOS";
        }return tipo;
    }

    private int posicionAleatoria(int min,int max) {
        int numero=(int)(Math.random()*max)+min;
        return numero;
    }


    private ImageIcon obtenerImagen(Ficha img) {
        String dir=(String)(img.nombreficha);
        ImageIcon icoimg= new ImageIcon("src/Imagenes/Heroes/"+dir+".png");
        return icoimg;
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
                    heroe[cont2] = new FichasHeroes(2,"Capitán América");
                }
                if (heroe[cont2] == null) {
                    heroe[cont2] = new FichasHeroes(1,"Capitán América");
                }
            }
        }  
        
      
        
        int f=0,pos=0;
        int c=posicionAleatoria(1,8);
        heroes[f][c]=new FichasHeroes(0,"Planet Earth");
        heroes[f][c+1]=new FichasHeroes(0,"Nova Blast");
        heroes[f][c-1]=new FichasHeroes(0,"Nova Blast");
        heroes[f+1][c]=new FichasHeroes(0,"Nova Blast");
       // f=1;
        ////////////////////
        //if(f==1){
         //   int f1,c2;
           // f1=posicionAleatoria(0,1);
           // c2=posicionAleatoria(0,9);
           // while(heroes[f1][c2]!=null){
             //   f1=posicionAleatoria(0,1);
             //   c2=posicionAleatoria(0,9);  
           // }
         //   heroes[f1][c2]=new FichasHeroes(0,"Nova Blast");
            
        //    while(heroes[f1][c2]!=null){
              //  f1=posicionAleatoria(0,1);
            //    c2=posicionAleatoria(0,9);  
           // }
            //heroes[f1][c2]=new FichasHeroes(0,"Nova Blast");
           // f=2;
     //   }
       
        /*if (f==2){
            int f2,c2;
            f2=posicionAleatoria(0,3);
            c2=posicionAleatoria(0,9);
            while(pos<8){
                while(heroes[f2][c2]!=null){
                    f2=posicionAleatoria(0,1);
                    c2=posicionAleatoria(0,9);  
                }
                heroes[f2][c2]=new FichasHeroes(2,nomHeroes[pos]);
                pos+=1;
            }
            while(pos<13){
                f2=3;
                c2=posicionAleatoria(0,9);
                while(heroes[f2][c2]!=null){
                    c2=posicionAleatoria(0,9);  
                }
                heroes[f2][c2]=new FichasHeroes(3,nomHeroes[pos]);
                pos+=1;   
            }
            while(pos<17){
                while(heroes[f2][c2]!=null){
                    f2=posicionAleatoria(0,3);
                    c2=posicionAleatoria(0,9);  
                }
                heroes[f2][c2]=new FichasHeroes(4,nomHeroes[pos]);
                pos+=1;   
            }
            while(pos<21){
                while(heroes[f2][c2]!=null){
                    f2=posicionAleatoria(0,3);
                    c2=posicionAleatoria(0,9);  
                }
                heroes[f2][c2]=new FichasHeroes(5,nomHeroes[pos]);
                pos+=1;   
            }
            while(pos<25){
                while(heroes[f2][c2]!=null){
                    f2=posicionAleatoria(0,3);
                    c2=posicionAleatoria(0,9);  
                }
                heroes[f2][c2]=new FichasHeroes(6,nomHeroes[pos]);
                pos++;   
            }
            while(pos<28){
                while(heroes[f2][c2]!=null){
                    f2=posicionAleatoria(0,3);
                    c2=posicionAleatoria(0,9);  
                }
                heroes[f2][c2]=new FichasHeroes(7,nomHeroes[pos]);
                pos++;   
            }
            while(pos<30){
                while(heroes[f2][c2]!=null){
                    f2=posicionAleatoria(0,3);
                    c2=posicionAleatoria(0,9);  
                }
                heroes[f2][c2]=new FichasHeroes(8,nomHeroes[pos]);
                pos++;   
            }
            while(pos<31){
                while(heroes[f2][c2]!=null){
                    f2=posicionAleatoria(0,3);
                    c2=posicionAleatoria(0,9);  
                }
                heroes[f2][c2]=new FichasHeroes(9,nomHeroes[pos]);
                pos++;   
            }
            while(pos<32){
                while(heroes[f2][c2]!=null){
                    f2=posicionAleatoria(0,3);
                    c2=posicionAleatoria(0,9);  
                }
                heroes[f2][c2]=new FichasHeroes(10,nomHeroes[pos]);
                pos++;   
            }
            while(pos<nomHeroes.length){
                while(heroes[f2][c2]!=null){
                    f2=posicionAleatoria(0,3);
                    c2=posicionAleatoria(0,9);  
                }
                heroes[f2][c2]=new FichasHeroes(1,nomHeroes[pos]);
                pos++;   
            }
            
            
        }
        */
        
            
            
        
            
        
        
        //////////////////
        
        
        
         
                }

}



        



