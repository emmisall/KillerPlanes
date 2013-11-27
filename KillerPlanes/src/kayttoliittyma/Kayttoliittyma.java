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


public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    
    /**
     * Pelin alku, annetaan pelaajille nimet.
     */
    
    public Kayttoliittyma() {
        
    }
    
//    public Kayttoliittyma(Pelaaja pelaaja1, Pelaaja pelaaja2) {
//        this.pelaaja1=pelaaja1;
//        this.pelaaja2=pelaaja2;
//    }
    
    @Override
    public void run() {
        frame = new JFrame("Pelaajien nimet");
        frame.setPreferredSize(new Dimension(500,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
       
    }
    
    private void luoKomponentit(Container container) {

        GridLayout leiska = new GridLayout(3,2);
        container.setLayout(leiska);
        JLabel pelaajan1nimi = new JLabel("Pelaajan1 nimi: ");
        JTextField nimiKentta1 = new JTextField();
        JLabel pelaajan2nimi = new JLabel("Pelaajan2 nimi: ");
        JTextField nimiKentta2 = new JTextField();
        
        JButton lisaaNappula = new JButton("Aloita peli!");
        PelinAloitus pelaajaKuuntelija = new PelinAloitus(pelaaja1, pelaaja2, nimiKentta1, nimiKentta2);
        lisaaNappula.addActionListener(pelaajaKuuntelija);
        
        container.add(pelaajan1nimi);
        container.add(nimiKentta1);
        container.add(pelaajan2nimi);
        container.add(nimiKentta2);
        container.add(lisaaNappula);
        
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
   
}