/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ANDY ESCOBAR 007
 */
public class CasillasMarvel extends JButton implements ActionListener{
    
    public int x,y;
    Ficha ficha;
    byte clic=0;

    public CasillasMarvel(int x, int y, Ficha ficha) {
        this.x = x;
        this.y = y;
        this.ficha = ficha;
        this.addActionListener(this);
    }

    private void actionListener(ActionEvent e) {
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(""+x+" "+y);
    }

   
}
