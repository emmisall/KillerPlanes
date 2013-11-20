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
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.Lentokone;

/**
 *
 * @author emmisall
 */
public class TaisteluValinnat implements ActionListener, Runnable{
    
    //huom huom huom ei puutu vielä virheellisiin valintoihin, ne on mahdollisia
    
    
    private JFrame frame;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;

    
    public TaisteluValinnat(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1=pelaaja1;
        this.pelaaja2=pelaaja2;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        run();
    }
    
    
    @Override
    public void run() {
        frame = new JFrame("Lentokoneen ja aseen valinta");
        frame.setPreferredSize(new Dimension(1000,1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        GridLayout leiska = new GridLayout(20,1);
        container.setLayout(leiska);
        JLabel teksti = new JLabel("Valitkaa yksi lentokone ja siitä yksi ase.");
        JLabel teksti1 = new JLabel("Pelaajan "+pelaaja1.getNimi()+" lentokoneet ja niiden aseet ovat seuraavat: ");
        JLabel teksti3 = new JLabel("Pelaajan "+pelaaja2.getNimi()+" lentokoneet ja niiden aseet ovat seuraavat: ");
        ArrayList<Lentokone> koneet1 = new ArrayList<Lentokone>();
        ArrayList<Ase> aseet1 = new ArrayList<Ase>();
        ButtonGroup lentokoneNappulat1= new ButtonGroup();
        koneet1=pelaaja1.palautaLentokoneet();
        container.add(teksti);
        container.add(teksti1);
        for (Lentokone lentokone : koneet1) {
            JRadioButton koneNappula = new JRadioButton("Lentokone "+lentokone.getNimi()+", energia "+lentokone.getEnergia()+".");
            lentokoneNappulat1.add(koneNappula);
            container.add(koneNappula);
            aseet1 = lentokone.palautaAseet();
            ButtonGroup aseNappulat1 = new ButtonGroup();
            for (Ase ase : aseet1) {
                JRadioButton aseNappula = new JRadioButton("Ase "+ase.getNimi()+ ", tarkkuus "+ase.getTarkkuus()+" ja teho "+ase.getTeho()+".");
                aseNappulat1.add(aseNappula);
                container.add(aseNappula);
            }
        }
        container.add(teksti3);
        ArrayList<Lentokone> koneet2 = new ArrayList<Lentokone>();
        ArrayList<Ase> aseet2 = new ArrayList<Ase>();
        koneet2 = pelaaja2.palautaLentokoneet();
        ButtonGroup lentokoneNappulat2= new ButtonGroup();
        
          for (Lentokone lentokone : koneet2) {
            JRadioButton koneNappula = new JRadioButton("Lentokone "+lentokone.getNimi()+", energia "+lentokone.getEnergia()+".");
            lentokoneNappulat2.add(koneNappula);
            container.add(koneNappula);
            aseet2 = lentokone.palautaAseet();
            ButtonGroup aseNappulat2 = new ButtonGroup();
            for (Ase ase : aseet2) {
                JRadioButton aseNappula = new JRadioButton("Ase "+ase.getNimi()+ ", tarkkuus "+ase.getTarkkuus()+" ja teho "+ase.getTeho()+".");
                aseNappulat2.add(aseNappula);
                container.add(aseNappula);
            }
        }
        
        
       
   
    }
    
     public JFrame getFrame() {
        return frame;
    }
  
    
}
