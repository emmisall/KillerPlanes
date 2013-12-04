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
import lentokone.Ase;
import lentokone.Lentokone;

/**
 *
 * @author emmisall
 */
public class TaisteluValinnat {
    
    private JComboBox<Ase> aseistus1;
    private JComboBox<Ase> aseistus2;
    private JComboBox<Lentokone> lentokoneet1;
    private JComboBox<Lentokone> lentokoneet2;
    private Kayttoliittyma kayttis;
    
    /**
     * Pelaajat valitsevat tässä itselleen taisteluun aseen ja lentokoneen omista lentokoneistaan
     * (tai valitsevat jos tämä toimisi mutta ei toimi nyt oikein..)
     * 
     * @param pelaaja1
     * @param pelaaja2 
     */
    
    public TaisteluValinnat(Kayttoliittyma kayttis) {
        this.kayttis=kayttis;
    }

    public void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(20,1);
        container.setLayout(leiska);
        JLabel teksti = new JLabel("Valitkaa yksi lentokone ja siitä yksi ase.");
        JLabel teksti1 = new JLabel("Pelaajan "+kayttis.getPelaaja1().getNimi()+" lentokoneet ja niiden aseet ovat seuraavat: ");
        JLabel teksti3 = new JLabel("Pelaajan "+kayttis.getPelaaja2().getNimi()+" lentokoneet ja niiden aseet ovat seuraavat: ");
        ArrayList<Lentokone> koneet1 = new ArrayList<Lentokone>();
        ArrayList<Ase> aseet1 = new ArrayList<Ase>();
        koneet1=kayttis.getPelaaja1().palautaLentokoneet();
        container.add(teksti);
        container.add(teksti1);
        
        lentokoneet1 = new JComboBox<Lentokone>();
        
        //tää ei nyt vieläkään rullaa ihan oikein kun tuo eka lentokoneen alasvetovalikko menee väärään kohtaan..
        
        for (Lentokone lentokone : koneet1) {
            lentokoneet1.addItem(lentokone);
            container.add(lentokoneet1);
            aseet1 = lentokone.palautaAseet();
            aseistus1 = new JComboBox<Ase>();
            container.add(new JLabel(lentokone.getNimi()+" aseet: "));
            for (Ase ase : aseet1) {
                aseistus1.addItem(ase);
                container.add(aseistus1);
            }
            
        }

        container.add(teksti3);

        ArrayList<Lentokone> koneet2 = new ArrayList<Lentokone>();
        ArrayList<Ase> aseet2 = new ArrayList<Ase>();
        koneet2=kayttis.getPelaaja2().palautaLentokoneet();
        lentokoneet2 = new JComboBox<Lentokone>();
        
        for (Lentokone lentokone : koneet2) {
            lentokoneet2.addItem(lentokone);
            container.add(lentokoneet2);
            
            aseet2 = lentokone.palautaAseet();
            aseistus2 = new JComboBox<Ase>();
            container.add(new JLabel(lentokone.getNimi()+" aseet: "));
            
            for (Ase ase : aseet2) {
                aseistus2.addItem(ase);
                container.add(aseistus2);
            }
            
        }
//        
//        kayttis.setValittulentokone1((Lentokone) lentokoneet1.getSelectedItem());
//        kayttis.setValittuase1((Ase) aseistus1.getSelectedItem());
//        kayttis.setValittulentokone2((Lentokone) lentokoneet1.getSelectedItem());
//        kayttis.setValittuase2((Ase) aseistus1.getSelectedItem());
   
        JButton taistele = new JButton("Taistele!");
        taistele.addActionListener(this.kayttis);
        container.add(taistele);
   
    }
    
    public Lentokone getValittuL1() {
        return (Lentokone) lentokoneet1.getSelectedItem();
    }
    
    public Lentokone getValittuL2() {
        return (Lentokone) lentokoneet2.getSelectedItem();
    }
    
    public Ase getValittuA1() {
        return (Ase) aseistus1.getSelectedItem();
    }
    
    public Ase getValittuA2() {
        return (Ase) aseistus2.getSelectedItem();
    }
    
    
    
    

  
    
}
