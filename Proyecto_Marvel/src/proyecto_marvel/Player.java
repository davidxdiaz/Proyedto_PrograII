/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author David
 */
public class Player {
    //Atributos
    private String username;
    private String password;
    private int puntos;
    int playersActivos=0,playersHistoricos=0;
    int partidasGanadas=0,WinHeroes=0,WinVillanos=0;
    static ArrayList<Player> players=new ArrayList<>();
    static ArrayList<String>partidas;
    
    //Variables Global
   
    private static Player loggedPlayer;
    
    //Constructor
    public Player(String username,String password){
        this.username = username;
        this.password = password;
        this.puntos = 0;
        
        playersActivos+=1;
        playersHistoricos+=1;
 
        partidas=new ArrayList<>();        
    }
    
    //Funciones
    
   /**
    * FUNCION QUE PERMITE REGISTRA UN NUEVO USUARIO
    * 
    * @param user Nnombre del Usuario 
    * @param pass Contraseña
    */
    public static void add(String user, String pass){
        players.add(new Player(user, pass));
        
   }
    
/***
 * 
 * @param user Nombre del Usuario a Buscar
 * @return Retorna el Objeto donde se encuentra el Usuario
 */
    public static Player existe(String user){
        for (Player player : players){
            if (player != null){
                if (user.equals(player.username)){
                    return player;
                }
            }
        }
        return null;
    }
    
    public static Player getLoggedPlayer(){
      return loggedPlayer;
   }
    public static void setLoggedPlayer(Player player){
      loggedPlayer = player;
   }
    //Funcion que verifica que los datos del usuario esten correctos
    
    public static Player verificar(String user, String pass){
        for (Player player : players){
            if (player != null){
                if (user.equals(player.username) && pass.equals(player.password)){
                    return player;
                }
            }
        }
        return null;
    }
    
    
    /**
     * FUNCION QUE ADICIONA 3 PUNTOS AL PLAYER GANADOR
     */
    public void addPuntos(){
        this.puntos+=3;
    }
    
    
    /**
     * FUNCION QUE ELIMINA LA CUENTA DEL USUARIO
     * @param user NOMBRE DEL USUARIO
     * @param pass CONTRASEÑA 
     */
    public void elimiarCuenta(String user, String pass){
        players.remove(players.indexOf(verificar(user, pass)));
        playersActivos-=1;
    }
    
    
    /**
     * FUNCION QUE PERMITE CAMBIAR LA CONTRASEÑA DEL USUARIO
     * @param user  NOMBRE DEL USUARIO
     * @param pass  CONTRASEÑA ACTUAL
     * @param nuevapass NUEVA CONTRASEÑA
     */
    public void cambiarPassword(String user, String pass,String nuevapass){
        verificar(user, pass).setPassword(nuevapass);
        
    }
    
    /**
     * Funcion que adiciona un juego a mi arreglo de partidas
     * @param m TIPO DE FICHA CON QUE JUGUE
     * @param n Obtine el resultado del juego true=Gane,false=perdi
     * @param rival Nombre del rival con quien me enfrente
     * 
     * Obtiene la fecha actual 
     */
    public void ultimasPartidas(TipoFicha m,boolean n, String rival){
        Calendar actual=Calendar.getInstance();
        SimpleDateFormat formato =new SimpleDateFormat("dd-mm-yyyy hh:mm:ss a");
        String resultado="DERROTA";  
        if (n){
            resultado="VICTORIA";
        }
        String fecha=actual.toString();
        partidas.add(fecha+" Rival: "+rival+" Resultado: "+resultado+" Fichas"+m.name());
       
    }
    /**
     * 
     * @param nomb NOMBRE DEL USUARIO
     * @param pass CONTRASEÑA
     * @return RETORNA TRUE SI EL USUARIO Y CONTRASEÑA ES CORRECTA,SINO  RETURNA FALSE
     */
    
    public boolean verificarCuenta(String nomb, String pass){
        for(Player player:players){
            if (nomb.equals(player.username)){
                if(pass.equals(player.password)){
                    return true;
                }
            }
        }
        return false;
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

    
    /**
     * ESTA ES UN FUNCION ORDENAR EL RAKING DE LOS JUGADORES 
     * @param args 
     */
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
        
    }
    
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
             
    
}
    
    
