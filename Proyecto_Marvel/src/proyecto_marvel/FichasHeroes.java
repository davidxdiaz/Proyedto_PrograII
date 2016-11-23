/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import javax.swing.ImageIcon;

/**
 *
 * @author Miguel Paz
 */
public class FichasHeroes extends Ficha {
    
    public FichasHeroes arrayheroes[][]= new FichasHeroes[4][10];
    public ImageIcon imagenHeroe; 
    String nombre;
    
    public FichasHeroes(int rango,String nom) {
        super(TipoFicha.HEROE, rango,nom);
        this.nombre=nom;
    }

    public ImageIcon getImagenHeroe() {
        return imagenHeroe;
    }
    
}
/*
CREAR UN FUNCION RANDOW QUE GENERE POSICIONES ALEATORIAS

CREAR UN FUNCION QUE AÑADA OBJETOS TIPO HEROES AL ARRAYHERORES
*/