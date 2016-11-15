/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

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
    private int puntos,playersActivos=0,playersHistoricos=0;
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
    
    //Funcion que agrega jugadores
    public static void add(String user, String pass){
        players.add(new Player(user, pass));
 
   }
    
    //Funcion que verifica si el usuario existe
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
    
    public void addPuntos(){
        puntos+=3;
        
    }
    
    public void elimiarCuenta(String user, String pass){
        players.remove(players.indexOf(verificar(user, pass)));
        playersActivos-=1;
    }
    
    public void cambiarPassword(String user, String pass,String nuevapass){
        verificar(user, pass).setPassword(nuevapass);
        
    }
    public void ultimasPartidas(TipoFicha m,boolean n, String rival){
        Calendar actual=Calendar.getInstance();
        String resultado="DERROTA";  
        if (n){
            resultado="VICTORIA";
        }
        partidas.add(actual.toString()+" Rival: "+rival+" Resultado: "+resultado+" Fichas"+m.name());
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
    
    
    
        
        
    
}
    
    
