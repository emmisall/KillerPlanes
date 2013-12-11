/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import kayttaja.Pelaaja;
import lentokone.Lentokone;

/**
 * Pelaaja voi ostaa itselleen uuden lentokoneen kaikista pelin lentokoneista, jos pelaajalla on rahaa 
 * 
 */
public class LentokoneOstosValinnat {
    

    private JComboBox<Lentokone> ostokoneet;
    private Kayttoliittyma kayttis;
    private ArrayList<Lentokone> lentokoneet1;
    private Pelaaja pelaaja;
    private JPanel paneeli;
    private JPanel paneeli2;
    
    public LentokoneOstosValinnat(Kayttoliittyma kayttis, Pelaaja pelaaja) {
        this.kayttis= kayttis;
        this.pelaaja=pelaaja;
    }

     public void luoKomponentit(Container container) throws IOException {
         container.add(luoValinnat());
         container.add(luoKuvat(), BorderLayout.SOUTH);
      
     }
     
    private JPanel luoValinnat() {
        paneeli = new JPanel(new GridLayout(10,1));
        paneeli.setVisible(true);
        paneeli.setSize(1000, 1000);
        
        paneeli.add(new JLabel("Valitse alasvetovalikosta se lentokone, jonka haluat ostaa. Lentokoneessa on yksi ase valmiina."));
        paneeli.add(new JLabel("Pelaajalla "+pelaaja.getNimi()+" on rahaa "+pelaaja.getRahat()));
        ostokoneet = new JComboBox<Lentokone>();
        lentokoneet1 = new ArrayList<Lentokone>();
        lentokoneet1 = kayttis.getKaikkiLentokoneet();
        
        for (Lentokone lentokone : lentokoneet1) {
             ostokoneet.addItem(lentokone);
             paneeli.add(ostokoneet);
         }
      
        
        JButton osta = new JButton("Osta lentokone "+pelaaja.getNimi());
        JButton enosta = new JButton(pelaaja.getNimi()+" ei osta lentokonetta");
        osta.addActionListener(this.kayttis);
        paneeli.add(osta);
        enosta.addActionListener(this.kayttis);
        paneeli.add(enosta);
        
        return paneeli;
        
    }
    
    private JPanel luoKuvat() throws IOException {
        
        paneeli2 = new JPanel(new GridLayout(2,4));
        
        BufferedImage raapale = ImageIO.read(getClass().getResource("raapale.jpg"));
        JLabel raapaleKuva = new JLabel(new ImageIcon(raapale));
        paneeli2.add(new JLabel("Rääpäle"));
        paneeli2.add(raapaleKuva);
        BufferedImage turbo = ImageIO.read(new File("/home/verijuotikas/KillerPlanes/KillerPlanes/src/kayttoliittyma/turbo.jpg"));
        JLabel turboKuva = new JLabel(new ImageIcon(turbo));
        paneeli2.add(new JLabel("Turbo"));
        paneeli2.add(turboKuva);
        BufferedImage kingi = ImageIO.read(new File("/home/verijuotikas/KillerPlanes/KillerPlanes/src/kayttoliittyma/kingi.jpg"));
        JLabel kingiKuva = new JLabel(new ImageIcon(kingi));
        paneeli2.add(new JLabel("Kingi"));
        paneeli2.add(kingiKuva);
        BufferedImage killer = ImageIO.read(new File("/home/verijuotikas/KillerPlanes/KillerPlanes/src/kayttoliittyma/killer.jpg"));
        JLabel killerKuva = new JLabel(new ImageIcon(killer));
        paneeli2.add(new JLabel("Killer"));
        paneeli2.add(killerKuva);
        
        return paneeli2;
    }
     
     
    public Lentokone getValittuL1() {
        return (Lentokone) ostokoneet.getSelectedItem();
    }


     
     
}
