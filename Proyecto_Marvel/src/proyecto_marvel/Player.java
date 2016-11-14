/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Player {
    //Atributos
    private String username;
    private String password;
    private int puntos;
    static ArrayList<Player> players=new ArrayList<>();
    
    //Variables Global
   
    private static Player loggedPlayer;
    
    //Constructor
    public Player(String username,String password){
        this.username = username;
        this.password = password;
        this.puntos = 0;
       
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
    //Funcion que verifica que losd atos del usuario esten correctos
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
        
    }
        
        
    
}
    
    
