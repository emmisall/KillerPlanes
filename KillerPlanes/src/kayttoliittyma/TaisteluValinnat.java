/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Lentokone;

/**
 *
 * @author emmisall
 */
public class TaisteluValinnat implements ActionListener, Runnable{
    
    private JFrame frame;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    
    public TaisteluValinnat(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1=pelaaja1;
        this.pelaaja2=pelaaja2;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    
    @Override
    public void run() {
        frame = new JFrame("Lentokoneen ja aseen valinta");
        frame.setPreferredSize(new Dimension(700,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(6,1);
        container.setLayout(leiska);
        JLabel teksti1 = new JLabel ("Pelaajan "+pelaaja1.getNimi()+" lentokoneet ja niiden aseet ovat seuraavat: ");
        ArrayList<Lentokone> koneet1 = new ArrayList<Lentokone>();
        koneet1=pelaaja1.palautaLentokoneet();
        JLabel kone1=new JLabel();
        for (Lentokone lentokone : koneet1) {
            kone1=new JLabel(lentokone.getNimi()+" ja sen energia on "+lentokone.getEnergia());
        }
        container.add(teksti1);
        container.add(kone1);
       
        
        
        
    }
    
     public JFrame getFrame() {
        return frame;
    }
  
    
}
