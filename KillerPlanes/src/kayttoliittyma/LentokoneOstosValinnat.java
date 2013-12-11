/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import kayttaja.Pelaaja;
import lentokone.Lentokone;

/**
 * Pelaaja voi ostaa itselleen uuden lentokoneen kaikista pelin lentokoneista, jos pelaajalla on rahaa
 * Lentokoneen luodaan tässä uudestaan, koska muuten käy niin että tässä myydään lentokoneita joita on jo käytetty
 * (ostaessa viitataan lentokoneidenLuomisessa tehtäviin lentokoneisiin ja se viittaus säilyy koko ajan, joten lentokoneet
 * pitää luoda uudestaan ennen ostoa jotta ne ovat uusia)
 * 
 */
public class LentokoneOstosValinnat {
    

    private JComboBox<Lentokone> ostokoneet;
    private Kayttoliittyma kayttis;
    private ArrayList<Lentokone> lentokoneet1;
    private Pelaaja pelaaja;
    
    public LentokoneOstosValinnat(Kayttoliittyma kayttis, Pelaaja pelaaja) {
        this.kayttis= kayttis;
        this.pelaaja=pelaaja;
    }

     public void luoKomponentit(Container container) {
         
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        container.add(new JLabel("Valitse alasvetovalikosta se lentokone, jonka haluat ostaa. Lentokoneessa on yksi ase valmiina."));
        container.add(new JLabel("Pelaajalla "+pelaaja.getNimi()+" on rahaa "+pelaaja.getRahat()));
        ostokoneet = new JComboBox<Lentokone>();
        lentokoneet1 = new ArrayList<Lentokone>();
        lentokoneet1 = kayttis.getKaikkiLentokoneet();
        
         for (Lentokone lentokone : lentokoneet1) {
             ostokoneet.addItem(lentokone);
             container.add(ostokoneet);
         }

        JButton osta = new JButton("Osta lentokone "+pelaaja.getNimi());
        JButton enosta = new JButton(pelaaja.getNimi()+" ei osta lentokonetta");
        osta.addActionListener(this.kayttis);
        container.add(osta);
        enosta.addActionListener(this.kayttis);
        container.add(enosta);
     }
     
    public Lentokone getValittuL1() {
        return (Lentokone) ostokoneet.getSelectedItem();
    }
     
     
}
