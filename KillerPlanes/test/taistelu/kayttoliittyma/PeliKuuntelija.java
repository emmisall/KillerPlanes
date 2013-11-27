/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import taistelu.Taistelu;

/**
 *
 * @author verijuotikas
 */
public class PelinTulos implements ActionListener, Runnable {
    //ekalla kierroksella lentsikat ja aseet on molemmilla samoja, mutta joka tapauksessa jatkossa aina kun kierros alkaa, 
    //pitää olla tiedossa että millä lentsikalla ja millä aseella pelaajat ovat taistelemassa
    private Lentokone lentokone1;
    private Lentokone lentokone2;
    private Ase ase1;
    private Ase ase2;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private JFrame frame;
    private Taistelu taistelu1;
    
    public PelinTulos(Lentokone lentokone1, Lentokone lentokone2, Ase ase1, Ase ase2, Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.lentokone1=lentokone1;
        this.lentokone2=lentokone2;
        this.ase1=ase1;
        this.ase2=ase2;
        this.pelaaja1=pelaaja1;
        this.pelaaja2=pelaaja2;
        this.taistelu1=new Taistelu();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    @Override
    public void run(){
        frame = new JFrame("Ensimmäinen peli.");
        frame.setPreferredSize(new Dimension(700,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(6,1);
        container.setLayout(leiska);
        JLabel teksti2;
        JLabel teksti3;
        JLabel teksti1 = new JLabel("Ensimmäisen taistelun tulos:");
        if (taistelu1.ammu(lentokone1, ase1, pelaaja1, pelaaja2)==true) { //pelaajat kääntyvät tässä siis toisin päin tämän ja seuraavan iffin välillä eli kohde ja ampuja, katso ammu-metodin paramterit luokassa taistelu
            teksti2 = new JLabel("Pelaajaan "+pelaaja1.getNimi()+" osui. Lentokoneen energia on nyt "+lentokone1.getEnergia()+".");
        }
        else 
            teksti2 = new JLabel("Pelaajaan "+pelaaja1.getNimi()+" ei osunut.");
        
        if (taistelu1.ammu(lentokone2, ase2, pelaaja2, pelaaja1)==true) {
            teksti3= new JLabel("Pelaajaan "+pelaaja2.getNimi()+" osui. Lentokoneen energia on nyt "+lentokone2.getEnergia()+".");
        }
        else
            teksti3 = new JLabel("Pelaajaan "+pelaaja2.getNimi()+" ei osunut.");
        
        JLabel rahat = new JLabel("Pelaajien omaisuus ensimmäisen taistelun jälkeen: ");
        JLabel rahat1 = new JLabel(pelaaja1.getNimi()+": "+pelaaja1.getRahat());
        JLabel rahat2 = new JLabel(pelaaja2.getNimi()+": "+pelaaja2.getRahat());
        
        container.add(teksti1);
        container.add(teksti2);
        container.add(teksti3);
        container.add(rahat);
        container.add(rahat1);
        container.add(rahat2);
    }
    
     public JFrame getFrame() {
        return frame;
    }
    
    
}
