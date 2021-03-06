/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JLabel;
import kayttaja.Pelaaja;

/**
 * Peli voi päättyä voitoon jos toinen pelaaja saa ensin 2000 tai enemmän rahaa täyteen tai toisen pelaajan kaikki lentokoneen tippuvat
 * 
 */
public class Voitto {
    
    private Kayttoliittyma kayttis;
    private Pelaaja voittaja;
    private Pelaaja haviaja;
    
    /**
     * 
     * @param kayttis 
     * @param voittaja se pelaaja, joka voittaa pelin
     * @param haviaja  se pelaaja, joka häviää pelin
     */
    
    public Voitto (Kayttoliittyma kayttis, Pelaaja voittaja, Pelaaja haviaja) {
        this.voittaja=voittaja;
        this.kayttis=kayttis;
        this.haviaja=haviaja;
    }
    
    /**
     * Tarkistaa voiton syyn ja ilmoittaa sitten tuloksen sen perusteella
     * @param container 
     */
    
    public void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        
        if (haviaja.palautaLentokoneet().isEmpty()) {
            container.add(new JLabel("Pelaajan "+haviaja.getNimi()+" kaikki lentokoneet tippuivat, "+voittaja.getNimi()+" voitti pelin."));
        }
        else
            container.add(new JLabel(voittaja.getNimi()+" voitti pelin summalla "+voittaja.getRahat()));
    }
}
