/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Miguel Paz
 */
public class FichasHeroes extends Ficha {
    private ImageIcon imgocultar,imagen;
    public FichasHeroes arrayheroes[][]= new FichasHeroes[4][10];
    
    public FichasHeroes(int rango) {
        super(TipoFicha.HEROE, rango);
        imagen=new ImageIcon(".png");
    }
    
}
/*
CREAR UN FUNCION RANDOW QUE GENERE POSICIONES ALEATORIAS

CREAR UN FUNCION QUE AÑADA OBJETOS TIPO HEROES AL ARRAYHERORES
*/