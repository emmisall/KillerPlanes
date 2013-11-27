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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Lentokone;

/**
 *
 * @author emmisall
 */
public class OstoTehtyLentokone implements ActionListener, Runnable {
    
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Lentokone lentokone;
    private JFrame frame;
    
    /**
     * Pelaaja on ostanut lentokoneen, tämän jälkeen on taas toisen pelaajan vuoro. Ostoksia tehdään vuorotellen, 1 ase ja 1 lentokone kerrallaan.
     * Ostaminen loppuu, kun pelaajat haluavat siirtyä taisteluun (ei nappulaa vielä).
     * 
     * @param pelaaja1
     * @param pelaaja2
     * @param lentokone 
     */
    
    public OstoTehtyLentokone(Pelaaja pelaaja1, Pelaaja pelaaja2, Lentokone lentokone) {
        this.pelaaja1=pelaaja1;
        this.pelaaja2=pelaaja2;
        this.lentokone=lentokone;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    @Override
    public void run(){
        frame = new JFrame("Pelaajan "+pelaaja1.getNimi()+" lentokoneostos.");
        frame.setPreferredSize(new Dimension(1000,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
     
     private void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        
        if (pelaaja1.ostaLentokone(lentokone)==true) {
            container.add(new JLabel("Lentokoneen osto onnistui."));
            container.add(new JLabel("Rahaa on nyt "+pelaaja1.getRahat()));
        }
        else 
            container.add(new JLabel("Osto ei onnistunut. Rahaa ei ollut tarpeeksi."));
        
        JButton lentsikoita = new JButton("Asekauppaan "+pelaaja2.getNimi());
        AseOstosValinnat ostoksille = new AseOstosValinnat(pelaaja2, pelaaja1);
        lentsikoita.addActionListener(ostoksille);
        container.add(lentsikoita);
     
     }   
}
