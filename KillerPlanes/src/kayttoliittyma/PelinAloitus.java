/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * Ennen ensimmäistä taistelua kerrotaan pelaajille heidän ensimmäisten lentokoneidensa tiedot
 *
 */

public class PelinAloitus {

    private Kayttoliittyma kayttis;
    private JPanel paneeli;


    
    public PelinAloitus(Kayttoliittyma kayttis) {
        this.kayttis=kayttis;
    }

     public void luoKomponentit(Container container) {
         container.add(luoSisalto());
    }
     
     private JPanel luoSisalto() {
         
        paneeli = new JPanel(new GridLayout(6,1));
        paneeli.setVisible(true);
        paneeli.setSize(500, 500);
        JLabel teksti = new JLabel("Taistelu alkaa, ensimmäiset lentokoneet ovat valmiina pelaajille "+kayttis.getPelaaja1().getNimi()+" ja "+kayttis.getPelaaja2().getNimi()+".");
        JLabel teksti2 = new JLabel("Ensimmäisen lentokoneen tiedot ovat molemmilla samat.");
        JLabel teksti3 = new JLabel("Nimi on "+kayttis.getPelaaja1().palautaLentokoneet().get(0).getNimi()+" ja energia on "+kayttis.getPelaaja1().palautaLentokoneet().get(0).getEnergia()+".");
        JButton aloitus = new JButton("Aloita taistelu.");
        aloitus.addActionListener(this.kayttis);

        paneeli.add(teksti);
        paneeli.add(teksti2);
        paneeli.add(teksti3);
        paneeli.add(aloitus);
         
         return paneeli;       
     }
     
   
    
}

