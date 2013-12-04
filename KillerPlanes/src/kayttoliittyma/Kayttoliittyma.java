/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

/**
 *
 * @author emmisall
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.AseidenLuominen;
import lentokone.Lentokone;
import taistelu.Taistelu;


public class Kayttoliittyma implements ActionListener, Runnable{
    
    private JFrame frame;
    private Aloitus aloitus;
    private PelinAloitus pelaajaKuuntelija;
    private TaisteluValinnat valinnat;
    private PelinTulos tulos;
    private AseOstosValinnat aseosto;
    private LentokoneOstosValinnat lentokoneosto;
    private AseOstosValinnat2 aseosto2;
    private LentokoneOstosValinnat2 lentokoneosto2;
    
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Lentokone valittulentokone1;
    private Lentokone valittulentokone2;
    private Lentokone lentokone;
    private Ase valittuase1;
    private Ase valittuase2;
    private Taistelu taistelu;

    public Kayttoliittyma() {
        
        this.taistelu=new Taistelu();

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
            this.pelaaja1 = new Pelaaja(aloitus.pelaajanimi1());
            this.pelaaja2 = new Pelaaja(aloitus.pelaajanimi2());
            setPelaaja1(pelaaja1);
            setPelaaja2(pelaaja2);
            this.pelaajaKuuntelija.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
        }
        
        if (ae.getActionCommand().equals("Aloita taistelu.")) {
            this.tyhjennys();
            this.valinnat=new TaisteluValinnat(this);
            this.valinnat.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
        }
        
        if (ae.getActionCommand().equals("Taistele!")) {
              
            setValittulentokone1(valinnat.getValittuL1());
            setValittuase1(valinnat.getValittuA1());
            setValittulentokone2(valinnat.getValittuL2());
            setValittuase2(valinnat.getValittuA2());
            this.tyhjennys();
            this.tulos = new PelinTulos(this);
            this.tulos.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
        }
        
        if (ae.getActionCommand().equals("Asekauppaan "+pelaaja1.getNimi())) {
            this.tyhjennys();
            this.aseosto = new AseOstosValinnat(this);
            this.aseosto.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
            
        }
        
        if (ae.getActionCommand().equals("Osta ase "+pelaaja1.getNimi())) {
            setValittulentokone1(aseosto.getValittuL1());
            setValittuase1(aseosto.getValittuA1());
            pelaaja1.ostaAse(getValittuase1(), getValittulentokone1());
            this.tyhjennys();
            this.lentokoneosto = new LentokoneOstosValinnat(this);
            this.lentokoneosto.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
            
        }
        
        if (ae.getActionCommand().equals((pelaaja1.getNimi()+" ei osta asetta"))) {
            this.tyhjennys();
            this.lentokoneosto = new LentokoneOstosValinnat(this);
            this.lentokoneosto.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
        }
        
        if (ae.getActionCommand().equals("Osta lentokone "+pelaaja1.getNimi())) {
            setValittulentokone1(lentokoneosto.getValittuL1());
            pelaaja1.ostaLentokone(getValittulentokone1());
            this.tyhjennys();
            this.aseosto2 = new AseOstosValinnat2(this);
            this.aseosto2.luoKomponentit(this.frame.getContentPane());           
            this.frame.pack();
        }
        
        if (ae.getActionCommand().equals(pelaaja1.getNimi()+" ei osta lentokonetta")) {
            this.tyhjennys();
            this.aseosto2 = new AseOstosValinnat2(this);
            this.aseosto2.luoKomponentit(this.frame.getContentPane());           
            this.frame.pack();
        }
        
         if (ae.getActionCommand().equals("Osta ase "+pelaaja2.getNimi())) {
            setValittulentokone1(aseosto2.getValittuL1());
            setValittuase1(aseosto2.getValittuA1());
            pelaaja2.ostaAse(getValittuase1(), getValittulentokone1());
            this.tyhjennys();
            this.lentokoneosto2 = new LentokoneOstosValinnat2(this);
            this.lentokoneosto2.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
            
        }
        
        if (ae.getActionCommand().equals((pelaaja2.getNimi()+" ei osta asetta"))) {
            this.tyhjennys();
            this.lentokoneosto2 = new LentokoneOstosValinnat2(this);
            this.lentokoneosto2.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
        }
        
        if (ae.getActionCommand().equals("Osta lentokone "+pelaaja2.getNimi())) {
            setValittulentokone1(lentokoneosto2.getValittuL1());
            pelaaja2.ostaLentokone(getValittulentokone1());
            this.tyhjennys();
            this.valinnat=new TaisteluValinnat(this);
            this.valinnat.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
        }
        
        if (ae.getActionCommand().equals(pelaaja2.getNimi()+" ei osta lentokonetta")) {
            this.tyhjennys();
            this.valinnat=new TaisteluValinnat(this);
            this.valinnat.luoKomponentit(this.frame.getContentPane());
            this.frame.pack();
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
    
    public Taistelu getTaistelu() {
        return this.taistelu;
    }
    
    public ArrayList<Lentokone> getKaikkiLentokoneet() {
        return pelaaja1.palautaKaikki();
    }
    
    public ArrayList<Ase> getKaikkiAseet() {
        lentokone = new Lentokone();
        return lentokone.palautaKaikkiAseet();
    }
    
    
    
    
}