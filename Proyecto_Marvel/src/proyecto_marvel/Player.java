/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

/**
 *
 * @author David
 */
public class Player {
    //Atributos
    private String username;
    private String password;
    private int puntos=0;
    private int contBuenos=0;
    private int contMalos=0;
    
    //Variable Global
    private static Player player[]= new Player[10];
    private static int numUsuarios = -1;
    private static int maxUsuarios = 10;
    
    //Constructor
    public Player(String username,String password,int puntos,int contBuenos,int contMalos){
        this.username = username;
        this.password = password;
        this.puntos = puntos;
        this.contBuenos = contBuenos;
        this.contMalos = contMalos;
    }
    
    //Funciones
    
    //Funcion que agrega jugadores
    public static void add(String user, String pass, int pts,int cB,int cM)
   {
      
      numUsuarios++;
      player[numUsuarios] = new Player(user, pass, pts,cB,cM);
   }
    
    //Funcion que verifica si el usuario existe
    public static Player existe(String user)
   {
      Player p = null;
      for (Player player : player){
         if (player != null)
         {
            if (user.equals(player.getUsername()))
            {
               p = player;
               break;
            }
         }
      }
      return p;
   }
    //Funcion que verifica que losd atos del usuario esten correctos
    public static Player verificar(String user, String pass)
   {
      Player p = null;
      boolean exists = false;

      for (Player player : player)
      {
         if (player != null)
         {
            if (user.equals(player.getUsername()) && pass.equals(player.getPassword()))
            {
               p = player;
               break;
            }
         }
      }
      return p;
   }
    
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public int getPts(){
        return puntos;
    }
    public int getCBuenos(){
        return contBuenos;
    }
    public int getCMalos(){
        return contMalos;
    }
    
}
