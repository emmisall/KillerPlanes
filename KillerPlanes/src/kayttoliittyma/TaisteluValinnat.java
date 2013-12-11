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
import lentokone.Ase;
import lentokone.Lentokone;

/**
 * Pelaajat valitsevat taisteluun lentokoneen ja aseen omista lentokoneistaan ja niiden aseista 
 * Lentokoneet ja aseet ovat alasvetovalikoissa
 * 
 */
public class TaisteluValinnat {
    
    private JComboBox<Ase> aseistus1;
    private JComboBox<Ase> aseistus2;
    private JComboBox<Lentokone> lentokoneet1;
    private JComboBox<Lentokone> lentokoneet2;
    private Kayttoliittyma kayttis;
    private JPanel paneeli;
    
    
    public TaisteluValinnat(Kayttoliittyma kayttis) {
        this.kayttis=kayttis;
    }

    public void luoKomponentit(Container container) {
        container.add(luoValinnat());
  
    }
    
    
    private JPanel luoValinnat() {
        
        paneeli = new JPanel(new GridLayout(20,1));
        paneeli.setSize(1000,2000);
        paneeli.setVisible(true);
        JLabel teksti = new JLabel("Valitkaa yksi lentokone ja siitä yksi ase.");
        JLabel teksti1 = new JLabel("Pelaajan "+kayttis.getPelaaja1().getNimi()+" lentokoneet ja niiden aseet ovat seuraavat: ");
        JLabel teksti3 = new JLabel("Pelaajan "+kayttis.getPelaaja2().getNimi()+" lentokoneet ja niiden aseet ovat seuraavat: ");
        ArrayList<Lentokone> koneet1 = new ArrayList<Lentokone>();
        ArrayList<Ase> aseet1 = new ArrayList<Ase>();
        koneet1=kayttis.getPelaaja1().palautaLentokoneet();
        paneeli.add(teksti);
        paneeli.add(teksti1);
        
        lentokoneet1 = new JComboBox<Lentokone>();
        
        for (Lentokone lentokone : koneet1) {
            lentokoneet1.addItem(lentokone);
            paneeli.add(lentokoneet1);
            aseet1 = lentokone.palautaAseet();
            aseistus1 = new JComboBox<Ase>();
            paneeli.add(new JLabel(lentokone.getNimi()+" aseet: "));
            for (Ase ase : aseet1) {
                aseistus1.addItem(ase);
                paneeli.add(aseistus1);
            }
            
        }

        paneeli.add(teksti3);

        ArrayList<Lentokone> koneet2 = new ArrayList<Lentokone>();
        ArrayList<Ase> aseet2 = new ArrayList<Ase>();
        koneet2=kayttis.getPelaaja2().palautaLentokoneet();
        lentokoneet2 = new JComboBox<Lentokone>();
        
        for (Lentokone lentokone : koneet2) {
            lentokoneet2.addItem(lentokone);
            paneeli.add(lentokoneet2);
            
            aseet2 = lentokone.palautaAseet();
            aseistus2 = new JComboBox<Ase>();
            paneeli.add(new JLabel(lentokone.getNimi()+" aseet: "));
            
            for (Ase ase : aseet2) {
                aseistus2.addItem(ase);
                paneeli.add(aseistus2);
            }
            
        }
        
        JButton taistele = new JButton("Taistele!");
        taistele.addActionListener(this.kayttis);
        paneeli.add(taistele);
        
        return paneeli;
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
