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
        container.add(new JLabel("Pelaajalla "+kayttis.getPelaaja1().getNimi()+" on rahaa "+kayttis.getPelaaja1().getRahat()));
        ostokoneet = new JComboBox<Lentokone>();
        lentokoneet1 = new ArrayList<Lentokone>();
        lentokoneet1 = kayttis.getKaikkiLentokoneet();
        
         for (Lentokone lentokone : lentokoneet1) {
             ostokoneet.addItem(lentokone);
             container.add(ostokoneet);
         }

        JButton osta = new JButton("Osta lentokone "+kayttis.getPelaaja1().getNimi());
        JButton enosta = new JButton(kayttis.getPelaaja1().getNimi()+" ei osta lentokonetta");
        osta.addActionListener(this.kayttis);
        container.add(osta);
        enosta.addActionListener(this.kayttis);
        container.add(enosta);
     }
     
    public Lentokone getValittuL1() {
        return (Lentokone) ostokoneet.getSelectedItem();
    }
     
     
}
