/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

/**
 *
 * @author verijuotikas
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;


public class Aloitus implements Runnable {

    private JFrame frame;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Kayttoliittyma kayttis;
    private JTextField nimiKentta1;
    private JTextField nimiKentta2;
    
    /**
* Pelin alku, annetaan pelaajille nimet.
* @param kayttis
*/
    
    public Aloitus(Kayttoliittyma kayttis) {
        this.kayttis = kayttis;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Pelaajien nimet");
        frame.setPreferredSize(new Dimension(500,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);

       
    }
    
    public void luoKomponentit(Container container) {

        GridLayout leiska = new GridLayout(3,2);
        container.setLayout(leiska);
        JLabel pelaajan1nimi = new JLabel("Pelaajan1 nimi: ");
        nimiKentta1 = new JTextField();
        JLabel pelaajan2nimi = new JLabel("Pelaajan2 nimi: ");
        nimiKentta2 = new JTextField();
        
        JButton lisaaNappula = new JButton("Aloita peli!");
        //PelinAloitus pelaajaKuuntelija = new PelinAloitus(pelaaja1, pelaaja2, nimiKentta1, nimiKentta2);
        lisaaNappula.addActionListener(this.kayttis);
        
        container.add(pelaajan1nimi);
        container.add(nimiKentta1);
        container.add(pelaajan2nimi);
        container.add(nimiKentta2);
        container.add(lisaaNappula);
    }
    public String pelaajanimi1() {
        return nimiKentta1.getText();
    }
    public String pelaajanimi2() {
        return nimiKentta2.getText();
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
   
}