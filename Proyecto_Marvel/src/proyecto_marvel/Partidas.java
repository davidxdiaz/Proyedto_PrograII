/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Partidas implements Serializable{
    private static Calendar fecha;
    private static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy hh'H'mm'M'ss's' a");
    private RandomAccessFile rpartidas;
    static ArrayList<Partidas>GamePartidas=new ArrayList<>();
    GameStratego nuevaPartida;
    CasillasMarvel [][]piezas;
    private int turno;
    private static int cont=0;
    String playerOne,PlayerTwo;

    public Partidas(String playerOne,int turno, String PlayerTwo,CasillasMarvel[][] cas) {
        this.turno = turno;
        this.playerOne = playerOne;
        this.PlayerTwo = PlayerTwo;
        this.piezas=cas;
        this.fecha=Calendar.getInstance();
    }

    public Partidas() {
    }
    
    
    public GameStratego nuevaPartida(){
        return nuevaPartida = new GameStratego();
    }
    private static String folderPlayer(String name) {
        return "Players//"+name;
    }
    
    public static void crearFolderPlayer(String name)throws IOException{
        //Creando Folder del Player Logged
        File player = new File(folderPlayer(name) );
        player.mkdirs();
    }
    
    public static void savePartidaForPlayer(String name,int turn,String invitado,CasillasMarvel[][] c)throws IOException{
        Calendar fecha= Calendar.getInstance();
        int day=fecha.get(Calendar.DAY_OF_MONTH);
        int month=fecha.get(Calendar.MONTH);
        int year=fecha.get(Calendar.YEAR);
        int hour=fecha.get(Calendar.HOUR);
        int minute=fecha.get(Calendar.MINUTE);
        int second=fecha.get(Calendar.SECOND);
        String date=day+"-"+month+"-"+year+" HH "+hour+".mm "+minute+".ss "+second;
        if(Player.getLoggedPlayer().getUsername().equals(name)){
            //Obtengo la direccion del FolderPlayer logged
            Partidas.crearFolderPlayer(name);
            String dirPadre = folderPlayer(name);
            //Obtengo la fecha justo en el momento que se crea el archivo
            
            
           // GamePartidas.add(0,new Partidas( name,turn-1, invitado));
            //Creo la direccion para el RAF
            cont++;
            String path = dirPadre+"/"+name+"_vs_"+invitado+" "+date+".ps";
            //rpartidas= new RandomAccessFile(path, "rw");
            partidaSalvada(path,name,turn,invitado,c);

        }else{
            Partidas.crearFolderPlayer(name);
            String dirPadre = folderPlayer(invitado);
            //Obtengo la fecha justo en el momento que se crea el archivo
            //Creo la direccion para el RAF
            cont++;
            String path = dirPadre+"/"+name+" vs "+invitado+" "+date+".ps";
            
            //rpartidas= new RandomAccessFile(path, "rw");
         //   GamePartidas.add(0,new Partidas(invitado,turn-1,name));
            partidaSalvada(path,invitado,turn,name,c);
        }
        
    }
    private static void partidaSalvada(String path,String p,int n,String s,CasillasMarvel [][]c){
        try {
            FileOutputStream fo = new FileOutputStream(path);
            GamePartidas.add(new Partidas(p, n, s,c));
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(GamePartidas);
        } catch (IOException ex) {
            
            System.out.println("Error: "+ex.getMessage());
            Logger.getLogger(Partidas.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            
        }
    }
    private void cargarPartida(String path)throws IOException{
        try{
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream oi = new ObjectInputStream(fi);
            GamePartidas= (ArrayList<Partidas>)oi.readObject();
        }catch (ClassNotFoundException ex) {
            //Logger.getLogger(Serializacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
