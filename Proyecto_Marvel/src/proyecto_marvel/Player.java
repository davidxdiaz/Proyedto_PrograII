/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Player implements Serializable{

    
    //Atributos
    private String username;
    private String password;
    private static RandomAccessFile rplayers;
    private boolean activo;
    private int puntos;
    public static ArrayList<Player>players=new ArrayList<>();
    public ArrayList<String>partidas;
    int partidasGanadas=0,WinHeroes=0,WinVillanos=0;
    
    //Variables Global
   
    private static Player loggedPlayer;
   
    //Constructor
    public Player(String username,String password){
        this.username = username;
        this.password = password;
        this.puntos = 0;
        this.partidasGanadas=0;
        this.WinHeroes=0;
        this.WinVillanos=0;
        this.activo=true;
        partidas=new ArrayList<>();
       
    }

    public static void add(String user, String pass)throws IOException{   
        players.add(new Player(user, pass));
        FileOutputStream fo = new FileOutputStream("player.pl");
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        oo.writeObject(players);
  
    }

    public int getWinHeroes() {
        return WinHeroes;
    }

    public int getWinVillanos() {
        return WinVillanos;
    }
    public static int pHistoricos()throws IOException{
        rplayers.seek(0);
        int c=0;
        while(rplayers.getFilePointer()<rplayers.length()){
            rplayers.skipBytes(20);
            rplayers.readUTF();
            c++;
        }
        return c;
    }
    
    public static Player verificar(String text, String passw) throws IOException, ClassNotFoundException {
       // FileOutputStream fo = new FileOutputStream("player.pl");
       // ObjectOutputStream oo = new ObjectOutputStream(fo);
        //oo.writeObject(players);
        try{
            FileInputStream fi = new FileInputStream("player.pl");
            ObjectInputStream oi = new ObjectInputStream(fi);
            players=(ArrayList<Player>)oi.readObject();
            for(Player player:players){
                if (text.equals(player.username)){
                    if(passw.equals(player.password)){
                        return player;
                    }
                }
            }return null;     
        }catch(FileNotFoundException e){
            FileOutputStream fo = new FileOutputStream("player.pl");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(players);
            return null;
        }
        
    }
    
    public static int pActivos()throws IOException, ClassNotFoundException{
        int playerA=0;
        FileInputStream fi = new FileInputStream("player.pl");
        ObjectInputStream oi = new ObjectInputStream(fi);
        players = (ArrayList<Player>)oi.readObject();
        for(Player p:players){
            if(p.activo){
                playerA++;
            }
        }
        return playerA;
    }
    //Funciones
    
   /**
    * FUNCION QUE PERMITE REGISTRA UN NUEVO USUARIO
    * 
    * @param user Nombre del Usuario 
    * @param pass Contraseña
     * @throws java.io.IOException
    */
    /*public static void add(String user, String pass){
        Player newPlayer = new Player(user,pass);
        setLoggedPlayer(newPlayer);
        players.add(newPlayer);
        
   }*/
    
    
/***
 * 
 * @param user Nombre del Usuario a Buscar
 * @return Retorna el Objeto donde se encuentra el Usuario
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
 *
 */
    public static Player existe(String user)throws IOException, ClassNotFoundException{
        for (Player player : players){
            if (player != null){
                if (player.activo && user.equals(player.username)){
                    return player;
                }
            }
        }
        return null;
    }
    
    
    /**
     * FUNCION QUE ADICIONA 3 PUNTOS AL PLAYER GANADOR
     * @throws java.io.FileNotFoundException
     */
    public void addPuntos() throws FileNotFoundException, IOException{
        this.puntos+=3;
        FileOutputStream fo = new FileOutputStream("player.pl",false);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        oo.writeObject(players);
    }
        
    
    
    /**
     * FUNCION QUE ELIMINA LA CUENTA DEL USUARIO
     * @param user NOMBRE DEL USUARIO
     * @param pass CONTRASEÑA 
     * @throws java.io.IOException 
     */
    public void elimiarCuenta(String user, String pass)throws IOException, ClassNotFoundException{   
            FileInputStream fi = new FileInputStream("player.pl");
            ObjectInputStream oi = new ObjectInputStream(fi);
            players= (ArrayList<Player>)oi.readObject();
            for(Player p:players){
                if(p.username.equals(user)&&p.password.equals(pass)){
                    p.activo=false;
                }
            }
            FileOutputStream fo = new FileOutputStream("player.pl",false);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(players);
        }
      
    /**
     * FUNCION QUE PERMITE CAMBIAR LA CONTRASEÑA DEL USUARIO
     * @param user  NOMBRE DEL USUARIO
     * @param nuevapass NUEVA CONTRASEÑA
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * }
     */
    public void cambiarPassword(String user, String nuevapass)throws IOException, ClassNotFoundException{
        FileInputStream fi = new FileInputStream("player.pl");
        ObjectInputStream oi = new ObjectInputStream(fi);
        players= (ArrayList<Player>)oi.readObject();
        for(Player player:players){
            if(player.activo && player.username.equals(user)){
                player.password=nuevapass;
            }
        }
        FileOutputStream fo = new FileOutputStream("player.pl",false);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        oo.writeObject(players);
        
        /*for(Player p: players){
            if(p.getUsername().equals(user)){
                p.setPassword(nuevapass);
            }
        }*/
            
        
    }
   
    
    /**
     * Funcion que adiciona un juego a mi arreglo de partidas
     * @param m TIPO DE FICHA CON QUE JUGUE
     * @param n Obtine el resultado del juego true=Gane,false=perdi
     * @param rival Nombre del rival con quien me enfrente
     * 
     * Obtiene la fecha actual 
     */
    public void ultimasPartidas(TipoFicha m,boolean n, String rival)throws IOException{
        Calendar actual=Calendar.getInstance();
        SimpleDateFormat formato =new SimpleDateFormat("dd-mm-yyyy hh:mm:ss a");
        String resultado="DERROTA";  
        if (n){
            resultado="VICTORIA";
            if (m.equals(TipoFicha.HEROE)){
            WinHeroes++;
            }else{
                WinVillanos++;
            }    
        }
        
        partidas.add(0,actual.getTime()+"  Rival: "+rival.toUpperCase()+" Resultado: "+resultado+" Tipo de Ficha Utilizada: "+m.name()+"S");
        
        FileOutputStream fo = new FileOutputStream("player.pl",false);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        oo.writeObject(players);
        
       
    }
            
        
        
       
    
   
    
      
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public static void setLoggedPlayer(Player loggedPlayer) {
        Player.loggedPlayer = loggedPlayer;
    }

    public static Player getLoggedPlayer() {
        return loggedPlayer;
    }
    
    
    
    
    
    

    
    /**
     * ESTA ES UN FUNCION ORDENAR EL RAKING DE LOS JUGADORES 
     * @param args 
     */
    /*
    public static void main(String[] args) {
        players.add(new Player("andy", "password"));
        players.get(0).addPuntos();
        players.get(0).addPuntos();
        
        players.add(new Player("hola", "password"));
        players.get(1).addPuntos();
        players.get(1).addPuntos();
        players.get(1).addPuntos();
        players.get(1).addPuntos();
        players.add(new Player("hey", "password"));
        players.get(2).addPuntos();
        players.get(2).addPuntos();
        players.get(2).addPuntos();
        players.add(new Player("player", "password"));
        players.get(3).addPuntos();
        players.get(3).addPuntos();
        players.get(3).addPuntos();
        players.get(3).addPuntos();
        
        System.out.println(players.size());
        for(Player play:players){
            System.out.println(play.username);
        }
        
        Player.rankingPlayers();
        int pos=0;
        for(Player play:players){
            pos+=1;
            System.out.println(pos+". "+play.username+" "+play.puntos);
        }
        
    }*/
    
    public static void rankingPlayers(){
        Player aux;
        for(int i=0;i<players.size()-1;i++){
            for(int j=0;j<players.size()-i-1;j++){
                if(players.get(j+1).puntos>players.get(j).puntos){
                    aux=players.get(j+1);
                    players.set(j+1,players.get(j));
                    players.set(j,aux);
                }
            }
        }
    }
    
  

    public ArrayList<String> getPartidas() {
        return partidas;
    }
        
    
}
    
    
