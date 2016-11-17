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
public class CasillasMarvel extends JButton{
    
    boolean turnplayerHeroe;
    public int x,y;
    Ficha ficha;
   
    public CasillasMarvel(int x, int y, Ficha ficha) {
        this.x = x;
        this.y = y;
        this.ficha = ficha;
       // this.addActionListener(this);
  
    }
    
    
/*
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(getName());
       
    }

    public void setName(int x, int y){
        setText(x+""+y);
    }
    
    @Override
    public String getName(){
     return String.valueOf(x)+String.valueOf(y);   
    }



    

*/
   
}
    

   

