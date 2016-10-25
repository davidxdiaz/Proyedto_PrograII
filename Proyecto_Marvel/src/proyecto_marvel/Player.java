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
    public static void add(String user, String pass, int pts,int cB,int cM)
   {
      if (pass.equals(""))
      {
         pass = "password";
      }
      numUsuarios++;
      player[numUsuarios] = new Player(user, pass, pts,cB,cM);
   }
}
