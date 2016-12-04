/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author David
 */
public class Partidas {
    private RandomAccessFile rpartidas;
    public Partidas(){
        
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
        String path = dirPadre+"/"+name+"_vs_"+invitado+"_"+fecha+".emp";
        rpartidas= new RandomAccessFile(path, "rw");
    }
    private void partidaSalvada(){
        //En proceso
    }

    
}
