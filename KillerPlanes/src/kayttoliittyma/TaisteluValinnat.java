/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.Lentokone;

/**
 *
 * @author emmisall
 */
public class TaisteluValinnat implements ActionListener, Runnable{
    
    //ei toimi vielä ollenkaan niinkun pitäs, koska ei pysty siirtämään parametrina eteen päin valittuja lentokoneita ja aseita PeliKuuntelijaan, peliKuuntelija kylläkin toimii jos vaan saisi siirrettyä asiat sinne
    //lisäksi nuo alasvetovalikot on omituisessa järjestyksessä vielä mutta se varmaan onnistuu korjata jotenkin.
    
    
    private JFrame frame;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private JComboBox aseistus1;
    private JComboBox aseistus2;
    
    public TaisteluValinnat(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1=pelaaja1;
        this.pelaaja2=pelaaja2;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    
    @Override
    public void run() {
        frame = new JFrame("Lentokoneen ja aseen valinta");
        frame.setPreferredSize(new Dimension(1000,1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    
    private void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(20,1);
        container.setLayout(leiska);
        JLabel teksti = new JLabel("Valitkaa yksi lentokone ja siitä yksi ase.");
        JLabel teksti1 = new JLabel("Pelaajan "+pelaaja1.getNimi()+" lentokoneet ja niiden aseet ovat seuraavat: ");
        JLabel teksti3 = new JLabel("Pelaajan "+pelaaja2.getNimi()+" lentokoneet ja niiden aseet ovat seuraavat: ");
        ArrayList<Lentokone> koneet1 = new ArrayList<Lentokone>();
        ArrayList<Ase> aseet1 = new ArrayList<Ase>();
        koneet1=pelaaja1.palautaLentokoneet();
        container.add(teksti);
        container.add(teksti1);
        
        JComboBox lentokoneet1 = new JComboBox();
        
        //nämä on kirjoitettu nyt vain niin että näkyy mitä on, eli ei toimi vielä oikein (laitetaan lentokoneita alasvetovalikkoihin)
        //en saanut sitä toimimaan vielä oikein niin tein niin että näkyy edes mitä siellä on
        
        for (Lentokone lentokone : koneet1) {
            lentokoneet1.addItem(lentokone.getNimi()+", energia "+lentokone.getEnergia());
            container.add(lentokoneet1);
            aseet1 = lentokone.palautaAseet();
            aseistus1 = new JComboBox();
            for (Ase ase : aseet1) {
                aseistus1.addItem(lentokone.getNimi()+": "+ase.getNimi()+", tarkkuus "+ase.getTarkkuus()+", teho "+ase.getTeho());
                container.add(aseistus1);
            }
            
        }
        
        container.add(teksti3);

        ArrayList<Lentokone> koneet2 = new ArrayList<Lentokone>();
        ArrayList<Ase> aseet2 = new ArrayList<Ase>();
        koneet2=pelaaja2.palautaLentokoneet();
        JComboBox lentokoneet2 = new JComboBox();
        
        for (Lentokone lentokone : koneet2) {
            lentokoneet2.addItem(lentokone.getNimi()+", energia "+lentokone.getEnergia());
            container.add(lentokoneet2);
            aseet2 = lentokone.palautaAseet();
            aseistus2 = new JComboBox();
            for (Ase ase : aseet2) {
                aseistus2.addItem(lentokone.getNimi()+": "+ase.getNimi()+", tarkkuus "+ase.getTarkkuus()+", teho "+ase.getTeho());
                container.add(aseistus2);
            }
            
        }
          
       
        
//          PeliKuuntelija pelikuuntelija = new PeliKuuntelija(lentokoneet1.getSelectedItem(), lentokoneet2.getSelectedItem(), aseistus1.getSelectedItem(), aseistus2.getSelectedItem(), pelaaja1, pelaaja2);
//          JButton taistele = new JButton("Taistele!");
//          taistele.addActionListener(pelikuuntelija);
//          container.add(taistele);
   
    }
    
  
    
     public JFrame getFrame() {
        return frame;
    }
  
    
}
