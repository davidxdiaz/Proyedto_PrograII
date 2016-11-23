/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import javax.swing.ImageIcon;

/**
 *
 * @author ANDY ESCOBAR 007
 */
public class FichasVillanos extends Ficha {
    private ImageIcon imgocultar;
    public FichasVillanos cardsVillanos[][]= new FichasVillanos[4][10];
    
    public FichasVillanos(int rango) {
        super(TipoFicha.VILLANO, rango," ");

    }
}
