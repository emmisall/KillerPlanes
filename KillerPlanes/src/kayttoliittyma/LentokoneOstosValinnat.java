/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import kayttaja.Pelaaja;
import lentokone.Lentokone;
import lentokone.LentokoneidenLuominen;

/**
 *
 * @author emmisall
 */
public class LentokoneOstosValinnat {
    
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Lentokone lentokone1;
    private Lentokone lentokone2;
    private Lentokone lentokone3;
    private Lentokone lentokone4;
    private JComboBox<Lentokone> ostokoneet;
    private Kayttoliittyma kayttis;
    private ArrayList<Lentokone> lentokoneet1;
    
    /**
     * Pelaaja voi ostaa lentokoneen
     * 
     * @param pelaaja1
     * @param pelaaja2 
     */
    
    public LentokoneOstosValinnat(Kayttoliittyma kayttis) {
        this.kayttis = kayttis;
    }

     public void luoKomponentit(Container container) {
         
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        container.add(new JLabel("Valitse alasvetovalikosta se lentokone, jonka haluat ostaa. Lentokoneessa on yksi ase valmiina."));
        container.add(new JLabel("Pelaajalla "+pelaaja1.getNimi()+" on rahaa "+pelaaja1.getRahat()));
        ostokoneet = new JComboBox<Lentokone>();
        lentokoneet1 = new ArrayList<Lentokone>();
        lentokoneet1 = kayttis.getKaikkiLentokoneet();
        
         for (Lentokone lentokone : lentokoneet1) {
             ostokoneet.addItem(lentokone);
             container.add(ostokoneet);
         }

        
        JButton osta = new JButton("Osta lentokone "+kayttis.getPelaaja1());
        JButton enosta = new JButton("En osta mitään");
        osta.addActionListener(this.kayttis);
        container.add(osta);
        container.add(enosta);
     }
     
    public Lentokone getValittuL1() {
        
        return (Lentokone) lentokoneet1.getSelectedItem();
    }
     
     
}
