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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;


/**
 *
 * @author verijuotikas
 */
public class PelinAloitus implements ActionListener, Runnable {

    private JFrame frame;
    private Kayttoliittyma kayttis;

    /**
     * Pelaajaoliot on luotu, kerrotaan ensimmäisten lentokoneiden tiedot
     * 
     * @param pelaaja1 
     * @param pelaaja2
     * @param pelaajan1Nimi
     * @param pelaajan2Nimi 
     */
    
    public PelinAloitus(Kayttoliittyma kayttis) {
        this.kayttis=kayttis;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //tiedän että edellinen frame ei sulkeudu kun tämä seuraava avataan, mutta en osannut tehdä sitä sulkeutumista.. 
        //ja en tiedä saako näin edes tehdä muutenkaan, että tehdään aina uusi kuuntelija joka avaa uuden framen ja se edellinenn suljetaan sitten jotenkin... :))
//        pelaaja1 = new Pelaaja(pelaajan1Nimi.getText());
//        pelaaja2 = new Pelaaja(pelaajan2Nimi.getText());

   
    }
    
     
    @Override
    public void run() {
        frame = new JFrame("Pelin aloitus");
        frame.setPreferredSize(new Dimension(700,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
       
    }
    
     public void luoKomponentit(Container container) {

        GridLayout leiska = new GridLayout(6,1);
        container.setLayout(leiska);
        JLabel teksti = new JLabel("Taistelu alkaa, ensimmäiset lentokoneet ovat valmiina pelaajille "+kayttis.getPelaaja1().getNimi()+" ja "+kayttis.getPelaaja2().getNimi()+".");
        JLabel teksti2 = new JLabel("Ensimmäisen lentokoneen tiedot ovat molemmilla samat.");
        JLabel teksti3 = new JLabel("Nimi on "+kayttis.getPelaaja1().palautaLentokoneet().get(0).getNimi()+" ja energia on "+kayttis.getPelaaja1().palautaLentokoneet().get(0).getEnergia()+".");
        JButton ohjeet = new JButton("Pelin ohjeet."); //ei tee vielä mitään
        JButton aloitus = new JButton("Aloita taistelu.");

//        TaisteluValinnat valinnat = new TaisteluValinnat(pelaaja1, pelaaja2);
//        aloitus.addActionListener(valinnat);
        
        container.add(teksti);
        container.add(teksti2);
        container.add(teksti3);
        container.add(ohjeet); 
        container.add(aloitus);

    }
     
      public JFrame getFrame() {
        return frame;
    }
    
}
