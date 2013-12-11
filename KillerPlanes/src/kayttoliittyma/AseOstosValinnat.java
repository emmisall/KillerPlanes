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
import javax.swing.JPanel;
import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.Lentokone;

/**
 * Pelaaja voi valitsemaansa omaan lentokoneeseensa aseen kaikista pelissä tarjolla olevista aseista, jos pelaajalla on rahaa 
 * ja ase mahtuu valittuun lentokoneeseen
 * 
 */

public class AseOstosValinnat {

    private JComboBox<Lentokone> lentokoneet1;
    private JComboBox<Ase> ostoaseet;
    private Kayttoliittyma kayttis;
    private Pelaaja pelaaja;
    private JPanel paneeli;
 
    
    public AseOstosValinnat(Kayttoliittyma kayttis, Pelaaja pelaaja) {
        this.kayttis=kayttis;
        this.pelaaja=pelaaja;
    }
 
    /**
     * Listataan pelaajan lentokoneet ja sitten kaikki aseet, jotka ovat ostettavissa
     * @param paneeli 
     */
    
    public void luoKomponentit(Container container) {
       container.add(luoValinnat());
     }
    
    private JPanel luoValinnat() {
        paneeli = new JPanel(new GridLayout(10,1));
        paneeli.setVisible(true);
        paneeli.setSize(500, 500);
        
            paneeli.add(new JLabel("Valitse alasvetovalikosta se lentokone, johon haluat ostaa aseen."));
        paneeli.add(new JLabel("Pelaajan "+pelaaja.getNimi()+" (rahaa "+pelaaja.getRahat()+") lentokoneet ja niiden aseet ovat: "));
        ArrayList<Lentokone> koneet1 = new ArrayList<Lentokone>();
        koneet1=pelaaja.palautaLentokoneet();
        lentokoneet1 = new JComboBox<Lentokone>();
         
        for (Lentokone lentokone : koneet1) {
             lentokoneet1.addItem(lentokone);
             paneeli.add(lentokoneet1); 
         }
    
        paneeli.add(new JLabel("Ostettavia aseita ovat: "));
        ostoaseet = new JComboBox<Ase>();
        ArrayList<Ase> aseet = new ArrayList<Ase>();
        aseet=kayttis.getKaikkiAseet();
        
        for (Ase ase : aseet) {
            ostoaseet.addItem(ase);
            paneeli.add(ostoaseet);
        }
 
        JButton osta = new JButton("Osta ase "+pelaaja.getNimi());
        JButton enosta = new JButton(pelaaja.getNimi()+" ei osta asetta");
        osta.addActionListener(this.kayttis);
        paneeli.add(osta);
        enosta.addActionListener(this.kayttis);
        paneeli.add(enosta);
        
        return paneeli;
    }
    
    public Lentokone getValittuL1() {
        return (Lentokone) lentokoneet1.getSelectedItem();
    }
    
    
    public Ase getValittuA1() {
        return (Ase) ostoaseet.getSelectedItem();
    }
    
  
}
