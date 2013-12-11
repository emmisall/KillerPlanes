/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;


import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ensimmäisen framen sisältö, jossa annetaan pelaajille nimet
 *
 */

public class Aloitus {

    private Kayttoliittyma kayttis;
    private JTextField nimiKentta1;
    private JTextField nimiKentta2;
    private JPanel paneeli;
    
    /**
    * Pelin alku, annetaan pelaajille nimet.
    * @param kayttis
    */
    
    public Aloitus(Kayttoliittyma kayttis) {
        this.kayttis = kayttis;
    }

    public void luoKomponentit(Container container) {
        
        container.add(teeNappulat());
        
    }
    
    private JPanel teeNappulat() {
        
        paneeli = new JPanel(new GridLayout(3,2));
        paneeli.setVisible(true);
        paneeli.setSize(500, 500);
        JLabel pelaajan1nimi = new JLabel("Pelaajan1 nimi: ");
        nimiKentta1 = new JTextField();
        JLabel pelaajan2nimi = new JLabel("Pelaajan2 nimi: ");
        nimiKentta2 = new JTextField();
        
        JButton lisaaNappula = new JButton("Aloita peli!");
        lisaaNappula.addActionListener(this.kayttis);
        
        paneeli.add(pelaajan1nimi);
        paneeli.add(nimiKentta1);
        paneeli.add(pelaajan2nimi);
        paneeli.add(nimiKentta2);
        paneeli.add(lisaaNappula);
        return paneeli;
        
    }
    
    public String pelaajanimi1() {
        return nimiKentta1.getText();
    }
    
    public String pelaajanimi2() {
        return nimiKentta2.getText();
    }
    
   
    
   
}