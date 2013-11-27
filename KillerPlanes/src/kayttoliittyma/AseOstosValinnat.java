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
import javax.swing.JButton;
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
public class AseOstosValinnat implements ActionListener, Runnable {
    
    private Pelaaja pelaaja;
    private JFrame frame;
    private JComboBox<Lentokone> lentokoneet1;
    private JComboBox<Ase> ostoaseet;
    private Ase ase1;
    private Ase ase2;
    private Ase ase3;
    
    public AseOstosValinnat(Pelaaja pelaaja1) {
        this.pelaaja=pelaaja1;
    }
      
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    @Override
    public void run(){
        frame = new JFrame("Pelaajan "+pelaaja.getNimi()+"asekauppa.");
        frame.setPreferredSize(new Dimension(1000,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
     
     private void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        container.add(new JLabel("Valitse alasvetovalikosta se lentokone, johon haluat ostaa aseen."));
        container.add(new JLabel("Pelaajan "+pelaaja.getNimi()+" (rahaa "+pelaaja.getRahat()+") lentokoneet ja niiden aseet ovat: "));
        ArrayList<Lentokone> koneet1 = new ArrayList<Lentokone>();
        koneet1=pelaaja.palautaLentokoneet();
        
         for (Lentokone lentokone : koneet1) {
             lentokoneet1 = new JComboBox<Lentokone>();
             lentokoneet1.addItem(lentokone);
             container.add(lentokoneet1); 
         }
    
         container.add(new JLabel("Ostettavia aseita ovat: "));
         ostoaseet = new JComboBox<Ase>();
         AseidenLuominen aseet = new AseidenLuominen(ase1, ase2, ase3);
         ostoaseet.addItem(aseet.getAse1());
         ostoaseet.addItem(aseet.getAse2());
         ostoaseet.addItem(aseet.getAse3());
         container.add(ostoaseet);
         
        Lentokone valittulentokone = (Lentokone) lentokoneet1.getSelectedItem();
        Ase ostoase = (Ase) ostoaseet.getSelectedItem();
         
         JButton osta = new JButton("Osta ase");
         JButton enosta = new JButton("En osta mitään");
         OstoTehtyAse osto = new OstoTehtyAse(pelaaja, valittulentokone, ostoase);
         osta.addActionListener(osto);
         container.add(osta);
         container.add(enosta);
         
     }
    
}
