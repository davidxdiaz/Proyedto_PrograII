/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_marvel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDY ESCOBAR 007
 */
public class CasillasMarvel extends JButton implements ActionListener{
    
    public int x,y;
    Ficha ficha;
    byte clic=0;
    int primerClick=0;
    int primerPosicionx=0;
    int primerPosiciony=0;

    public CasillasMarvel(int x, int y, Ficha ficha) {
        this.x = x;
        this.y = y;
        this.ficha = ficha;
        this.primerClick=primerClick;
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(primerClick==1){
            System.out.print("SEGUNDO CLICK");
            int newPosicionx=x;
            int newPosiciony=y;
            System.out.println(" "+newPosicionx+"  "+newPosiciony);
            if (primerPosicionx==newPosicionx && primerPosiciony==newPosiciony){
                System.out.println("No puede elegir la mismas cordenada");
            }
            else{
                primerClick=0;
            }
            
        }
        else{
            System.out.println("Primer Click");
            primerClick=1;
            System.out.println(" "+x+" "+y+" "+  (ficha==null? "No hay niguna ficha" :"ficha"));
            primerPosicionx=x;
            primerPosiciony=y;
        }
    }
    

   
}
