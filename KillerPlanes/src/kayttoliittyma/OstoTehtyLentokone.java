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
    
    private Pelaaja pelaaja;
    private Lentokone lentokone;
    private JFrame frame;
    
    public OstoTehtyLentokone(Pelaaja pelaaja, Lentokone lentokone) {
        this.pelaaja=pelaaja;
        this.lentokone=lentokone;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    @Override
    public void run(){
        frame = new JFrame("Pelaajan "+pelaaja.getNimi()+"lentokonekauppa.");
        frame.setPreferredSize(new Dimension(1000,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
     
     private void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        
        if (pelaaja.ostaLentokone(lentokone)==true) {
            container.add(new JLabel("Lentokoneen osto onnistui."));
            container.add(new JLabel("Rahaa on nyt "+pelaaja.getRahat()));
        }
        else 
            container.add(new JLabel("Osto ei onnistunut. Rahaa ei ollut tarpeeksi."));
        
        JButton lentsikoita = new JButton("Lentokonekauppaan "+pelaaja.getNimi());
        LentokoneOstosValinnat lentokoneosto = new LentokoneOstosValinnat(pelaaja);
        lentsikoita.addActionListener(lentokoneosto);
        container.add(lentsikoita);
     
     }   
}
