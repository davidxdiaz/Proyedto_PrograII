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
public enum TipoFicha {
    HEREO,VILLANO;
    public int r1,r2,r3,r4,r5;
    public static int rango;
    TipoFicha(){
        r1=1;
        r2=2;
        r3=3;
        r4=4;
        r5=5;
    }

    public int getR1() {
        return r1;
    }

    public int getR2() {
        return r2;
    }

    public int getR3() {
        return r3;
    }

    public int getR4() {
        return r4;
    }

    public int getR5() {
        return r5;
    }

    public static int getRango() {
        return rango;
    }
    
   
    
}
