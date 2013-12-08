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
import lentokone.Ase;
import lentokone.AseidenLuominen;
import lentokone.Lentokone;

/**
 *
 * @author emmisall
 */
public class AseOstosValinnat {

    private JComboBox<Lentokone> lentokoneet1;
    private JComboBox<Ase> ostoaseet;
    private Kayttoliittyma kayttis;
    private Pelaaja pelaaja;
    
    /**
     * Pelaaja voi ostaa aseen tässä, vain 1 pelaaja kerrallaan voi ostaa. 2:n vuoro tulee kun toinen on ostanut halutessaan lentokoneenkin
     * 
     * 
     * @param pelaaja1
     * @param pelaaja2 
     */
    
    public AseOstosValinnat(Kayttoliittyma kayttis, Pelaaja pelaaja) {
        this.kayttis=kayttis;
        this.pelaaja=pelaaja;
    }
 
    /**
     * Listataan pelaajan lentokoneet ja sitten kaikki aseet, jotka ovat ostettavissa
     * @param container 
     */
    
    public void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        container.add(new JLabel("Valitse alasvetovalikosta se lentokone, johon haluat ostaa aseen."));
        container.add(new JLabel("Pelaajan "+pelaaja.getNimi()+" (rahaa "+pelaaja.getRahat()+") lentokoneet ja niiden aseet ovat: "));
        ArrayList<Lentokone> koneet1 = new ArrayList<Lentokone>();
        koneet1=pelaaja.palautaLentokoneet();
        lentokoneet1 = new JComboBox<Lentokone>();
         
        for (Lentokone lentokone : koneet1) {
             lentokoneet1.addItem(lentokone);
             container.add(lentokoneet1); 
         }
    
        container.add(new JLabel("Ostettavia aseita ovat: "));
        ostoaseet = new JComboBox<Ase>();
        ArrayList<Ase> aseet = new ArrayList<Ase>();
        aseet=kayttis.getKaikkiAseet();
        
        for (Ase ase : aseet) {
            ostoaseet.addItem(ase);
            container.add(ostoaseet);
        }
 
        JButton osta = new JButton("Osta ase "+pelaaja.getNimi());
        JButton enosta = new JButton(pelaaja.getNimi()+" ei osta asetta");
        osta.addActionListener(this.kayttis);
        container.add(osta);
        enosta.addActionListener(this.kayttis);
        container.add(enosta);
         
     }
    
    public Lentokone getValittuL1() {
        return (Lentokone) lentokoneet1.getSelectedItem();
    }
    
    
    public Ase getValittuA1() {
        return (Ase) ostoaseet.getSelectedItem();
    }
    
  
}
