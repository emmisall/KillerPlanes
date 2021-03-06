/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.Lentokone;
import lentokone.LentokoneidenLuominen;
import taistelu.Taistelu;

/**
 * Hallitsee käyttöliittymää kokonaisuudessaan, luo framen johon tuodaan sisältöä muista käyttöliittymän luokista
 * Tallentaa tietoa valituista lentokoneista ja aseista taistelun eri vaiheissa ja kaupassa
 * 
 */

public class Kayttoliittyma implements ActionListener, Runnable{
    
    private JFrame frame;
    private Aloitus aloitus;
    private PelinAloitus pelaajaKuuntelija;
    private TaisteluValinnat valinnat;
    private PelinTulos tulos;
    private AseOstosValinnat aseosto;
    private LentokoneOstosValinnat lentokoneosto;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Pelaaja valittuPelaaja;
    private Lentokone valittulentokone1;
    private Lentokone valittulentokone2;
    private Lentokone lentokone;
    private Ase valittuase1;
    private Ase valittuase2;
    private Taistelu taistelu;
    private Voitto voitto;
    private Tasapeli tasapeli;
    private Lentokone lentokone1;
    private Lentokone lentokone2;
    private Lentokone lentokone3;
    private Lentokone lentokone4;
    
    public Kayttoliittyma() {
        
        this.taistelu=new Taistelu();

    }
    
    /**
     * Ensimmäisen näkymä luokasta PelinAloitus
     */
        
    @Override
    public void run() {
        frame = new JFrame("KillerPlanes");
        JPanel paneeli = new JPanel();
        frame.setPreferredSize(new Dimension(1000,500));
        frame.setContentPane(paneeli);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);

        aloitus = new Aloitus(this);
        aloitus.luoKomponentit(this.frame.getContentPane());
        this.pelaajaKuuntelija = new PelinAloitus(this);
        
        
    }
    
    /**
     * Kuuntelee, mitä nappia painetaan ja sisältö tuodaan sen perusteella frameen
     * Huolehtii framen tyhjentämisestä sopivassa kohdassa, kun edellisestä framesta on saatu kaikki tieto, esim. mitkä aseet ja lentokoneet on valittu taisteluun
     * @param ae 
     */
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if ( ae.getActionCommand().equals("Aloita peli!") ) {
            this.tyhjennys();
            this.pelaaja1 = new Pelaaja(aloitus.pelaajanimi1());
            this.pelaaja2 = new Pelaaja(aloitus.pelaajanimi2());
            setPelaaja1(pelaaja1);
            setPelaaja2(pelaaja2);
            if (pelaaja1.getNimi().equals(pelaaja2.getNimi())) {
                pelaaja2.setNimi("2");
            }
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
            
            if (pelaaja1.tarkistaVoittaako()==true && pelaaja2.tarkistaVoittaako()==true) {
                this.tyhjennys();
                this.tasapeli = new Tasapeli(this);
                this.tasapeli.luoKomponentit(this.frame.getContentPane());
                this.frame.pack();
            }
            
            else if (pelaaja1.tarkistaVoittaako()==true) {
                this.tyhjennys();
                this.voitto = new Voitto(this, pelaaja1, pelaaja2);
                this.voitto.luoKomponentit(this.frame.getContentPane());
                this.frame.pack();
            }
            
            else if (pelaaja2.tarkistaVoittaako()==true) {
                this.tyhjennys();
                this.voitto = new Voitto(this, pelaaja2, pelaaja1);
                this.voitto.luoKomponentit(this.frame.getContentPane());
                this.frame.pack();
            }
            
            else if (pelaaja1.tarkistaKuoleeko()==true && pelaaja2.tarkistaKuoleeko()==true) {
                this.tyhjennys();
                this.tasapeli = new Tasapeli(this);
                this.tasapeli.luoKomponentit(this.frame.getContentPane());
                this.frame.pack();
            }
            
            else if (pelaaja1.tarkistaKuoleeko()==true) {
                this.tyhjennys();
                this.voitto=new Voitto(this, pelaaja2, pelaaja1);
                this.voitto.luoKomponentit(this.frame.getContentPane());
                this.frame.pack();
            }
            else if (pelaaja2.tarkistaKuoleeko()==true) {
                this.tyhjennys();
                this.voitto=new Voitto(this, pelaaja1, pelaaja2);
                this.voitto.luoKomponentit(this.frame.getContentPane());
                this.frame.pack();
            }
            else {
                setValittuPelaaja(pelaaja1);
                this.tyhjennys();
                this.aseosto = new AseOstosValinnat(this, getValittuPelaaja());
                this.aseosto.luoKomponentit(this.frame.getContentPane());
                this.frame.pack();
            }  
        }
        
        if (ae.getActionCommand().equals("Osta ase "+pelaaja1.getNimi()) || ae.getActionCommand().equals("Osta ase "+pelaaja2.getNimi())) {
            setValittulentokone1(aseosto.getValittuL1());
            setValittuase1(aseosto.getValittuA1());
            pelaaja1.ostaAse(getValittuase1(), getValittulentokone1());
            this.tyhjennys();
            frame.setPreferredSize(new Dimension(1500,800));
            if (getValittuPelaaja().equals(pelaaja1)) {
                this.lentokoneosto = new LentokoneOstosValinnat(this, pelaaja1);
            }
            else this.lentokoneosto = new LentokoneOstosValinnat(this, pelaaja2);
            try {
                this.lentokoneosto.luoKomponentit(this.frame.getContentPane());
            } catch (IOException ex) {
                System.out.println("Kuvaa ei löynyt, "+ex.getMessage());
            }
            this.frame.pack();
            
        }
        
        if (ae.getActionCommand().equals((pelaaja1.getNimi()+" ei osta asetta")) || ae.getActionCommand().equals(pelaaja2.getNimi()+" ei osta asetta")) {
            this.tyhjennys();
            frame.setPreferredSize(new Dimension(1500,800));
            if (getValittuPelaaja().equals(pelaaja1)) {
                this.lentokoneosto = new LentokoneOstosValinnat(this, pelaaja1);
            }
            else this.lentokoneosto = new LentokoneOstosValinnat(this, pelaaja2);
            try {
                this.lentokoneosto.luoKomponentit(this.frame.getContentPane());
            } catch (IOException ex) {
                Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.frame.pack();
        }
        
        if (ae.getActionCommand().equals("Osta lentokone "+pelaaja1.getNimi())) {
            setValittulentokone1(lentokoneosto.getValittuL1());
            pelaaja1.ostaLentokone(getValittulentokone1());
            this.tyhjennys();
            setValittuPelaaja(pelaaja2);
            this.aseosto = new AseOstosValinnat(this, getValittuPelaaja());
            this.aseosto.luoKomponentit(this.frame.getContentPane());          
            this.frame.pack();
        }
        
        if (ae.getActionCommand().equals(pelaaja1.getNimi()+" ei osta lentokonetta")) {
            this.tyhjennys();
            setValittuPelaaja(pelaaja2);
            this.aseosto = new AseOstosValinnat(this, getValittuPelaaja());
            this.aseosto.luoKomponentit(this.frame.getContentPane());           
            this.frame.pack();
        }

        if (ae.getActionCommand().equals("Osta lentokone "+pelaaja2.getNimi())) {
            setValittulentokone1(lentokoneosto.getValittuL1());
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
    
    /**
     * Tyhjentää framen
     */
    
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
    
    /**
     * Lentokoneet pitää luoda uudestaan, koska ostaessa jää viittaus ostettuun lentokoneeseen ja ostettavien lista
     * perustuu kaikkiin lentokoneisiin. Jos niitä ei luoda uudestaan, myydään jo käytettyjä lentokoneita (energia pienempi,
     * jos lentokoneeseen on osuttu).
     * @return kaikki lentokoneet, jotka voi ostaa
     */
    
    public ArrayList<Lentokone> getKaikkiLentokoneet() {
        LentokoneidenLuominen lentokoneet = new LentokoneidenLuominen(lentokone1, lentokone2, lentokone3, lentokone4);
        return lentokoneet.getKaikkiLentokoneet();
    }
    
    public ArrayList<Ase> getKaikkiAseet() {
        lentokone = new Lentokone();
        return lentokone.palautaKaikkiAseet();
    }
    
    public void setValittuPelaaja(Pelaaja valittuPelaaja) {
        this.valittuPelaaja=valittuPelaaja;
    }
    
    public Pelaaja getValittuPelaaja() {
        return valittuPelaaja;
    }
    
    
    
    
}