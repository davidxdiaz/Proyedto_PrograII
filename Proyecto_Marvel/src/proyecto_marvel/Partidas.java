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
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Partidas {
    private RandomAccessFile rpartidas;
    GameStratego nuevaPartida;
    
    public Partidas(){
        
    }
    public GameStratego nuevaPartida(){
        return nuevaPartida = new GameStratego();
    }
    private String folderPlayer(String name) {
        return "Players/"+name;
    }
    
    public void crearFolderPlayer(String name)throws IOException{
        //Creando Folder del Player Logged
        File player = new File( folderPlayer(name) );
        player.mkdir();
    }
    
    public void savePartidaForPlayer(String name,String invitado)throws IOException{
        //Obtengo la direccion del FolderPlayer logged
        String dirPadre = folderPlayer(name);
        //Obtengo la fecha justo en el momento que se crea el archivo
        Date fecha = Calendar.getInstance().getTime();
        //Creo la direccion para el RAF
        String path = dirPadre+"/"+name+"_vs_"+invitado+"_"+fecha+".ps";
        rpartidas= new RandomAccessFile(path, "rw");
    }
    private void partidaSalvada(String path){
        try {
            //seriealizar
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(nuevaPartida);
            
            
            
        
        } catch (IOException ex) {
            System.out.println("Error: "+ex.getMessage());
        } 
        
    }
    private void cargarPartida(String path)throws IOException{
        try{
            FileInputStream fi = new FileInputStream(path);
        
            ObjectInputStream oi = new ObjectInputStream(fi);
            GameStratego otro = (GameStratego)oi.readObject();
            otro.setVisible(true);
        }catch (ClassNotFoundException ex) {
            //Logger.getLogger(Serializacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
