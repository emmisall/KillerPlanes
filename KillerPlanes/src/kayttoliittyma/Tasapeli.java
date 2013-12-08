/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 *
 * @author verijuotikas
 */
public class Tasapeli {
    
    private Kayttoliittyma kayttis;
    
    public Tasapeli(Kayttoliittyma kayttis) {
        this.kayttis=kayttis;
        
    }
    
    public void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        
        if (kayttis.getPelaaja1().getRahat() >= 2000 && kayttis.getPelaaja2().getRahat() >= 2000) {
            container.add(new JLabel("Tasapeli! Pelaajalla "+kayttis.getPelaaja1().getNimi()+" on rahaa "+kayttis.getPelaaja1().getRahat()+" ja pelaajalla "+kayttis.getPelaaja2().getNimi()+" on rahaa "+kayttis.getPelaaja2().getRahat()));
        }
        else
            container.add(new JLabel("Molempien kaikki lentokoneet tippuivat."));
    }
    
}
