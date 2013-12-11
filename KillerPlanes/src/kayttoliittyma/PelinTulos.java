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
 * Kertoo taistelun tuloksen ja pelaajien rahatilanteen taistelun jälkeen
 * 
 */
public class PelinTulos {
    
    private Kayttoliittyma kayttis;
    private JPanel paneeli;
    
    
    public PelinTulos(Kayttoliittyma kayttis) {
        
      this.kayttis=kayttis;
    }

    /**
     * Ampumpinen tapahtuu tässä luokassa pelaajien valitsemien lentokoneiden ja aseiden perusteella, tulos ilmoitetetaan heti
     * @param container 
     */
    
    public void luoKomponentit(Container container) {
        container.add(luoSisalto());
        
    }
    
    private JPanel luoSisalto() {
        paneeli = new JPanel(new GridLayout(10,1));
         JLabel teksti2;
        JLabel teksti3;
        JLabel teksti1 = new JLabel("Taistelun tulos:");
        
        if (kayttis.getTaistelu().ammu(kayttis.getValittulentokone1(), kayttis.getValittuase1(), kayttis.getPelaaja1(), kayttis.getPelaaja2())==true) { 
            teksti2 = new JLabel("Pelaajaan "+kayttis.getPelaaja1().getNimi()+" osui. Lentokoneen "+kayttis.getValittulentokone1().getNimi()+" energia on nyt "+kayttis.getValittulentokone1().getEnergia()+".");
        }
        else 
            teksti2 = new JLabel("Pelaajaan "+kayttis.getPelaaja1().getNimi()+" ei osunut.");
        
        if (kayttis.getTaistelu().ammu(kayttis.getValittulentokone2(), kayttis.getValittuase2(), kayttis.getPelaaja2(), kayttis.getPelaaja1())==true) {
            teksti3= new JLabel("Pelaajaan "+kayttis.getPelaaja2().getNimi()+" osui. Lentokoneen "+kayttis.getValittulentokone2().getNimi()+" energia on nyt "+kayttis.getValittulentokone2().getEnergia()+".");
        }
        else
            teksti3 = new JLabel("Pelaajaan "+kayttis.getPelaaja2().getNimi()+" ei osunut.");
        
        JLabel rahat = new JLabel("Pelaajien omaisuus taistelun jälkeen: ");
        JLabel rahat1 = new JLabel(kayttis.getPelaaja1().getNimi()+": "+kayttis.getPelaaja1().getRahat());
        JLabel rahat2 = new JLabel(kayttis.getPelaaja2().getNimi()+": "+kayttis.getPelaaja2().getRahat());
        
        paneeli.add(teksti1);
        paneeli.add(teksti2);
        paneeli.add(teksti3);
        paneeli.add(rahat);
        paneeli.add(rahat1);
        paneeli.add(rahat2);

        paneeli.add(new JLabel("Kauppa suoritetaan ostamalla ensin aseet ja sitten lentokoneet"));
        JButton kauppa = new JButton("Asekauppaan "+kayttis.getPelaaja1().getNimi());
        kauppa.addActionListener(this.kayttis);
        paneeli.add(kauppa);
        
        return paneeli;
        
    }

    
    
}
