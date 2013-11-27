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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Lentokone;
import lentokone.LentokoneidenLuominen;

/**
 *
 * @author emmisall
 */
public class LentokoneOstosValinnat implements ActionListener, Runnable {
    
    private Pelaaja pelaaja;
    private JFrame frame;
    private Lentokone lentokone1;
    private Lentokone lentokone2;
    private Lentokone lentokone3;
    private Lentokone lentokone4;
    private JComboBox<Lentokone> ostokoneet;
    
    public LentokoneOstosValinnat(Pelaaja pelaaja) {
        this.pelaaja=pelaaja;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    @Override
    public void run(){
        frame = new JFrame("Pelaajan "+pelaaja.getNimi()+"lentokonekauppa.");
        frame.setPreferredSize(new Dimension(1000,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
     
     private void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(10,1);
        container.setLayout(leiska);
        container.add(new JLabel("Valitse alasvetovalikosta se lentokone, jonka haluat ostaa. Lentokoneessa on yksi ase valmiina."));
        LentokoneidenLuominen lentokoneet = new LentokoneidenLuominen(lentokone1, lentokone2, lentokone3, lentokone4);
        container.add(new JLabel("Pelaajalla "+pelaaja.getNimi()+" on rahaa "+pelaaja.getRahat()));
        ostokoneet = new JComboBox<Lentokone>();
             
        ostokoneet.addItem(lentokoneet.getLento1());
        ostokoneet.addItem(lentokoneet.getLento2());
        ostokoneet.addItem(lentokoneet.getLento3());
        ostokoneet.addItem(lentokoneet.getLento4());
        container.add(ostokoneet);
        
        JButton osta = new JButton("Osta lentokone");
        JButton enosta = new JButton("En osta mitään");
        
        container.add(osta);
        container.add(enosta);
     }
}
