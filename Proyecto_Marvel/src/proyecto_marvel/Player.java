/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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
    private static RandomAccessFile rplayers;
    private static boolean activo;
    private int puntos;
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
        this.partidasGanadas=0;
        this.WinHeroes=0;
        this.WinVillanos=0;
        this.activo=true;
       
    }

    

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setWinHeroes(int WinHeroes) {
        this.WinHeroes = WinHeroes;
    }

    public void setWinVillanos(int WinVillanos) {
        this.WinVillanos = WinVillanos;
    }
    public static void creandoFolder(){
        try{
            //1- Asegurar que el folder company exista
            File f = new File("Players");
            f.mkdir();
            //2- Instanciar los RAFs dentro de company
            rplayers = new RandomAccessFile("Players/players.pl", "rw");
            
        }
        catch(IOException e){
            System.out.println("No deberia de pasar esto");
        }
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
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
    public static int pActivos()throws IOException{
        rplayers.seek(0);
        int c=0;
        while(rplayers.getFilePointer()<rplayers.length()){
            rplayers.skipBytes(11);
            if(rplayers.readBoolean())
                c++;
            rplayers.skipBytes(8);
            rplayers.readUTF();
        }
        return c;
    }
    //Funciones
    
   /**
    * FUNCION QUE PERMITE REGISTRA UN NUEVO USUARIO
    * 
    * @param user Nombre del Usuario 
    * @param pass Contraseña
    */
    /*public static void add(String user, String pass){
        Player newPlayer = new Player(user,pass);
        setLoggedPlayer(newPlayer);
        players.add(newPlayer);
        
   }*/
     public static void add(String user, String pass)throws IOException
    {   
        Player newPlayer = new Player(user,pass);
        setLoggedPlayer(newPlayer);
        //Me aseguro que el puntero este en al final
        rplayers.seek(rplayers.length());
        //Password
        rplayers.writeUTF(pass);
        //puntos
        rplayers.writeInt(Player.loggedPlayer.getPuntos());
        //Activo
        activo=true;
        rplayers.writeBoolean(activo);
        //win Heroes
        rplayers.writeInt(loggedPlayer.getWinHeroes());
        //Win Villanos
        rplayers.writeInt(loggedPlayer.getWinVillanos());
        
        //Nombre de usuario
        rplayers.writeUTF(user);
       
    }
     
    
/***
 * 
 * @param user Nombre del Usuario a Buscar
 * @return Retorna el Objeto donde se encuentra el Usuario
     * @throws java.io.IOException
 *
 */
   /* public static Player existe(String user) throws IOException{
        
        try{
            existe.existeP(user);
        }catch(IOException e){
            System.out.println("Error"+e.getMessage());
        }
        return existe;
    }
    */
        
    public static Player existe(String user)throws IOException{
        
        if(rplayers.length()>0){
        //Me aseguro de este en la primera posicion
            rplayers.seek(0);
            //Se hace mientras el puntero sea menor que el tamaño del archivo
            while(rplayers.getFilePointer()<rplayers.length()){
                //obtengo la posicion del puntero
                long pos = rplayers.getFilePointer();
                /**
                 * Salto los 20 Bytes segun el formato
                 * pos 0  pass 7 cantidad_caracteres + 2 (5 caracteres + 2)=7
                 * pos 7  pts  4
                 * pos 11 act  1
                 * pos 12 WinH 4
                 * pos 16 WinV 4
                 * pos 20 User Cantidad_caracteres + 2
                 */
                rplayers.skipBytes(20);
                String n = rplayers.readUTF();
                if(n.equals(user)){
                    rplayers.seek(pos);
                    rplayers.skipBytes(11);
                    if(rplayers.readBoolean()){
                        rplayers.seek(pos);
                        Player newPlayer = new Player(user,rplayers.readUTF());
                        setDatos(newPlayer);
                        rplayers.readUTF();
                        return newPlayer;
                    }


                }    

            }
            
        }
        return null;
        /*for (Player player : players){
            if (player != null){
                if (user.equals(player.username)){
                    return player;
                }
            }
        }
        return null;*/
    }
    public static void setDatos(Player newPlayer)throws IOException{
        newPlayer.setPuntos(rplayers.readInt());
        newPlayer.setActivo(rplayers.readBoolean());
        newPlayer.setWinHeroes(rplayers.readInt());
        newPlayer.setWinVillanos(rplayers.readInt());
    }
    
    public static Player getLoggedPlayer(){
      return loggedPlayer;
   }
    public static void setLoggedPlayer(Player player){
      loggedPlayer = player;
   }
    //Funcion que verifica que los datos del usuario esten correctos
    
    public static Player verificar(String user, String pass)throws IOException{
        //Me aseguro que este en la posicion 0
        if(rplayers.length()>0){
            rplayers.seek(0);
            String pas;

            while(rplayers.getFilePointer()<rplayers.length()){
                
                pas=rplayers.readUTF();
                long pos = rplayers.getFilePointer();
                rplayers.skipBytes(13);
               
                Player newPlayer = new Player(rplayers.readUTF(),pas);
                if(user.equals(newPlayer.getUsername()) && pass.equals(newPlayer.getPassword())){
                    rplayers.seek(pos);
                    setDatos(newPlayer);
                    if(newPlayer.isActivo()){
                        return newPlayer;
                    }
                    rplayers.readUTF();

                }
            }
        }    
        return null;
        /*for (Player player : players){
            if (player != null){
                if (user.equals(player.username) && pass.equals(player.password)){
                    return player;
                }
            }
        }*/
        
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
        try{
        players.remove(players.indexOf(verificar(user, pass)));
        }catch (IOException e){
            System.out.println("Error"+e.getMessage());
        }
    }
    
    
    /**
     * FUNCION QUE PERMITE CAMBIAR LA CONTRASEÑA DEL USUARIO
     * @param user  NOMBRE DEL USUARIO
     * @param pass  CONTRASEÑA ACTUAL
     * @param nuevapass NUEVA CONTRASEÑA
     */
    public void cambiarPassword(String user, String nuevapass){
        for(Player p: players){
            if(p.getUsername().equals(user)){
                p.setPassword(nuevapass);
            }
        }
            
        
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
            if (m==TipoFicha.HEROE){
                WinHeroes++;
            }else{
                WinVillanos++;
            }
            
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
     */     
    
}
    
    
