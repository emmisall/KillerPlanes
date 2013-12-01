/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.Lentokone;

/**
 *
 * @author emmi
 */
public class Kayttoliittyma implements ActionListener, Runnable{
    
    private JFrame frame;
    private Aloitus aloitus;
    PelinAloitus pelaajaKuuntelija;
    
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Lentokone valittulentokone1;
    private Lentokone valittulentokone2;
    private Ase valittuase1;
    private Ase valittuase2;

    
    public Kayttoliittyma() {
 

    }
    
        
    @Override
    public void run() {
        frame = new JFrame("KillerPlanes");
        frame.setPreferredSize(new Dimension(1000,500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        
        frame.pack();
        frame.setVisible(true);

   

        aloitus = new Aloitus(this);
        aloitus.luoKomponentit(this.frame.getContentPane());

        this.pelaajaKuuntelija = new PelinAloitus(this);        
        

        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if ( ae.getActionCommand().equals("Aloita peli!") ) {
            this.tyhjennys();
            System.out.println("1");
            this.pelaaja1 = new Pelaaja(aloitus.pelaajanimi1());
            this.pelaaja2 = new Pelaaja(aloitus.pelaajanimi2());  
            System.out.println("2");
            this.pelaajaKuuntelija.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
            System.out.println("3");
        }
        
        
        
        
    }
    
    private void tyhjennys() {
        this.frame.getContentPane().removeAll();
        this.frame.repaint();
    }

    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    public void setPelaaja1(Pelaaja pelaaja1) {
        this.pelaaja1 = pelaaja1;
    }

    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }

    public void setPelaaja2(Pelaaja pelaaja2) {
        this.pelaaja2 = pelaaja2;
    }

    public Lentokone getValittulentokone1() {
        return valittulentokone1;
    }

    public void setValittulentokone1(Lentokone valittulentokone1) {
        this.valittulentokone1 = valittulentokone1;
    }

    public Lentokone getValittulentokone2() {
        return valittulentokone2;
    }

    public void setValittulentokone2(Lentokone valittulentokone2) {
        this.valittulentokone2 = valittulentokone2;
    }

    public Ase getValittuase1() {
        return valittuase1;
    }

    public void setValittuase1(Ase valittuase1) {
        this.valittuase1 = valittuase1;
    }

    public Ase getValittuase2() {
        return valittuase2;
    }

    public void setValittuase2(Ase valittuase2) {
        this.valittuase2 = valittuase2;
    }
    
    
    
    
}
