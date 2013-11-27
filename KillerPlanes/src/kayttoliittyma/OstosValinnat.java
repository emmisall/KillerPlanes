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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.AseidenLuominen;
import lentokone.Lentokone;

/**
 *
 * @author emmisall
 */
public class OstosValinnat implements ActionListener, Runnable {
    
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private JFrame frame;
    private JComboBox<Lentokone> lentokoneet1;
    private JComboBox<Lentokone> lentokoneet2;
    private JComboBox<Ase> ostoaseet;
    private Ase ase1;
    private Ase ase2;
    private Ase ase3;
    
    public OstosValinnat(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1=pelaaja1;
        this.pelaaja2=pelaaja2;
    }
      
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    @Override
    public void run(){
        frame = new JFrame("Kauppa.");
        frame.setPreferredSize(new Dimension(700,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
     
     private void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        container.add(new JLabel("Valitse alasvetovalikosta se lentokone, johon haluat ostaa aseen."));
        container.add(new JLabel("Pelaajan "+pelaaja1.getNimi()+" lentokoneet ja niiden aseet ovat: "));
        ArrayList<Lentokone> koneet1 = new ArrayList<Lentokone>();
        koneet1=pelaaja1.palautaLentokoneet();
        
         for (Lentokone lentokone : koneet1) {
             lentokoneet1 = new JComboBox<Lentokone>();
             lentokoneet1.addItem(lentokone);
             container.add(lentokoneet1); 
         }
         
         ArrayList<Lentokone> koneet2 = new ArrayList<Lentokone>();
         koneet2=pelaaja2.palautaLentokoneet();
         
         container.add(new JLabel("Pelaajan "+pelaaja2.getNimi()+" lentokoneet ja niiden aseet ovat: "));
         for (Lentokone lentokone : koneet2) {
             lentokoneet2 = new JComboBox<Lentokone>();
             lentokoneet2.addItem(lentokone);
             container.add(lentokoneet2);
         }
         
         container.add(new JLabel("Ostettavia aseita ovat: "));
         ostoaseet = new JComboBox<Ase>();
         AseidenLuominen aseet = new AseidenLuominen(ase1, ase2, ase3);
         ostoaseet.addItem(aseet.getAse1());
         container.add(ostoaseet);
         
     }
    
}
