/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;

/**
 *
 * @author emmisall
 */
public class OstosValinnat implements Runnable {
    
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private JFrame frame;
    
    public OstosValinnat(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1=pelaaja1;
        this.pelaaja2=pelaaja2;
    }
      
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    @Override
    public void run(){
        frame = new JFrame("Kauppa.");
        frame.setPreferredSize(new Dimension(700,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
     
     private void luoKomponentit(Container container) {
         
     }
    
}
