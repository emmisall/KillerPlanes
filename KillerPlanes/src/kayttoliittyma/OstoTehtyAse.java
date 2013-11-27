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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.Lentokone;

/**
 *
 * @author emmisall
 */
public class OstoTehtyAse implements ActionListener, Runnable{
    
    private Pelaaja pelaaja;
    private Lentokone lentokone;
    private Ase ase;
    private JFrame frame;
    
    public OstoTehtyAse(Pelaaja pelaaja, Lentokone lentokone, Ase ase) {
        this.pelaaja=pelaaja;
        this.lentokone=lentokone;
        this.ase=ase;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    @Override
    public void run(){
        frame = new JFrame("Pelaajan "+pelaaja.getNimi()+" aseostokset.");
        frame.setPreferredSize(new Dimension(700,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
     
     private void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        
        if (pelaaja.ostaAse(ase,lentokone)==true) {
            container.add(new JLabel("Osto onnistui."));
        }
        else 
            container.add(new JLabel("Et voinut ostaa, rahaa ei ollut tarpeeksi tai koneen aseet olivat täynnä. "));
        
     }
    
    
}
