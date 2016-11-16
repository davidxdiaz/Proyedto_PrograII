/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public abstract class Ficha {
    protected int rango;
    protected TipoFicha ficha;
    protected ImageIcon imagen;
    protected ImageIcon imgocultar;
    protected String nombreficha;
    
    
    public Ficha(TipoFicha ficha, int rango, ImageIcon imagen){
        this.ficha= ficha;
        this.rango= rango;
        this.imagen= imagen;
        
    }
    
    public boolean comer(){
        if(GameStratego.turno==true){
            //if()
            GameStratego.turno=false;
            
        }else{
            GameStratego.turno=true;
        }
        return true;
    }

    public int getRango() {
        return rango;
    }

    public TipoFicha getFicha() {
        return ficha;
    }
    
}
