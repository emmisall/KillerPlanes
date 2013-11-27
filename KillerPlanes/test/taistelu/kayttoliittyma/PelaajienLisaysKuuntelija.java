/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

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


/**
 *
 * @author verijuotikas
 */
public class PelinAloitus implements ActionListener, Runnable {
    
    private JTextField pelaajan1Nimi;
    private JTextField pelaajan2Nimi;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Kayttoliittyma kayttis;
    private JFrame frame;

    public PelinAloitus(Pelaaja pelaaja1, Pelaaja pelaaja2, JTextField pelaajan1Nimi, JTextField pelaajan2Nimi) {
        this.pelaaja1=pelaaja1;
        this.pelaaja2=pelaaja2;
        this.pelaajan1Nimi=pelaajan1Nimi;
        this.pelaajan2Nimi=pelaajan2Nimi;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        pelaaja1 = new Pelaaja(pelaajan1Nimi.getText());
        pelaaja2 = new Pelaaja(pelaajan2Nimi.getText());
        
        //tiedän että edellinen frame ei sulkeudu kun tämä seuraava avataan, mutta en osannut tehdä sitä sulkeutumista.. 
        //ja en tiedä saako näin edes tehdä muutenkaan, että tehdään aina uusi kuuntelija joka avaa uuden framen ja se edellinenn suljetaan sitten jotenkin... :))
        run();
    }
    
     
    @Override
    public void run() {
        frame = new JFrame("Pelin aloitus");
        frame.setPreferredSize(new Dimension(700,200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
       
    }
    
     private void luoKomponentit(Container container) {

        GridLayout leiska = new GridLayout(6,1);
        container.setLayout(leiska);
        JLabel teksti = new JLabel("Taistelu alkaa, ensimmäiset lentokoneet ovat valmiina pelaajille "+pelaaja1.getNimi()+" ja "+pelaaja2.getNimi()+".");
        JLabel teksti2 = new JLabel("Ensimmäisen lentokoneen tiedot ovat molemmilla samat.");
        JLabel teksti3 = new JLabel("Nimi on "+pelaaja1.palautaLentokoneet().get(0).getNimi()+" ja energia on "+pelaaja1.palautaLentokoneet().get(0).getEnergia()+".");
        JButton ohjeet = new JButton("Pelin ohjeet."); //ei tee vielä mitään
        JLabel teksti4 = new JLabel("Ensimmäisellä kierroksella on sama kone ja sama ase molemmilla, joten niitä ei valita.");
        JButton ekataistelu = new JButton("Aloita taistelu.");
        PelinTulos ekapeli = new PelinTulos(pelaaja1.palautaLentokoneet().get(0), pelaaja2.palautaLentokoneet().get(0), pelaaja1.palautaLentokoneet().get(0).palautaAseet().get(0), pelaaja2.palautaLentokoneet().get(0).palautaAseet().get(0), pelaaja1, pelaaja2);
        ekataistelu.addActionListener(ekapeli);
        
        container.add(teksti);
        container.add(teksti2);
        container.add(teksti3);
        container.add(teksti4);
        container.add(ohjeet); 
        container.add(ekataistelu);
    }
     
      public JFrame getFrame() {
        return frame;
    }
    
}
