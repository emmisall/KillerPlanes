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
import lentokone.Ase;
import lentokone.Lentokone;

/**
 *
 * @author emmisall
 */
public class OstoTehtyAse implements ActionListener, Runnable{
    
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Lentokone lentokone;
    private Ase ase;
    private JFrame frame;
    
    /**
     * Kun aseiden osto on tehty, pelaaja siirtyy lentokoneiden ostoon
     * @param pelaaja1
     * @param pelaaja2
     * @param lentokone
     * @param ase 
     */
    
    public OstoTehtyAse(Pelaaja pelaaja1, Pelaaja pelaaja2, Lentokone lentokone, Ase ase) {
        this.pelaaja1=pelaaja1;
        this.pelaaja2=pelaaja2;
        this.lentokone=lentokone;
        this.ase=ase;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    @Override
    public void run(){
        frame = new JFrame("Pelaajan "+pelaaja1.getNimi()+" aseostos.");
        frame.setPreferredSize(new Dimension(700,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
     
     private void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        
        if (pelaaja1.ostaAse(ase,lentokone)==true) {
            container.add(new JLabel("Osto onnistui."));
            container.add(new JLabel("Rahaa on nyt "+pelaaja1.getRahat()));
        }
        else 
            container.add(new JLabel("Et voinut ostaa, rahaa ei ollut tarpeeksi tai koneen aseet olivat täynnä."));
       
        JButton lentsikoita = new JButton("Lentokonekauppaan "+pelaaja1.getNimi());
        LentokoneOstosValinnat lentokoneosto = new LentokoneOstosValinnat(pelaaja1, pelaaja2);
        lentsikoita.addActionListener(lentokoneosto);
        container.add(lentsikoita);
        
     
     }
    
    
}
