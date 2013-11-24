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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.Lentokone;

/**
 *
 * @author emmisall
 */
public class TaisteluValinnat implements ActionListener, Runnable{
    
    
    
    private JFrame frame;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private JComboBox<Ase> aseistus1;
    private JComboBox<Ase> aseistus2;
    private JComboBox<Lentokone> lentokoneet1;
    private JComboBox<Lentokone> lentokoneet2;
    
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
        koneet1=pelaaja1.palautaLentokoneet();
        container.add(teksti);
        container.add(teksti1);
        
        lentokoneet1 = new JComboBox<Lentokone>();
        

        
        for (Lentokone lentokone : koneet1) {
            lentokoneet1.addItem(lentokone);
            container.add(lentokoneet1);
            aseet1 = lentokone.palautaAseet();
            aseistus1 = new JComboBox<Ase>();
            for (Ase ase : aseet1) {
                aseistus1.addItem(ase);
                container.add(aseistus1);
            }
            
        }       
       
        
        container.add(teksti3);

        ArrayList<Lentokone> koneet2 = new ArrayList<Lentokone>();
        ArrayList<Ase> aseet2 = new ArrayList<Ase>();
        koneet2=pelaaja2.palautaLentokoneet();
        lentokoneet2 = new JComboBox<Lentokone>();
        
        for (Lentokone lentokone : koneet2) {
            lentokoneet2.addItem(lentokone);
            container.add(lentokoneet2);
            aseet2 = lentokone.palautaAseet();
            aseistus2 = new JComboBox<Ase>();
            for (Ase ase : aseet2) {
                aseistus2.addItem(ase);
                container.add(aseistus2);
            }
            
        }
          
        Lentokone valittulento1 = (Lentokone) lentokoneet1.getSelectedItem();
        Ase valittuase1 = (Ase) aseistus1.getSelectedItem();
        Lentokone valittulento2 = (Lentokone) lentokoneet1.getSelectedItem();
        Ase valittuase2 = (Ase) aseistus1.getSelectedItem();
       
        
        PeliKuuntelija pelikuuntelija = new PeliKuuntelija(valittulento1, valittulento2, valittuase1, valittuase2, pelaaja1, pelaaja2);
        JButton taistele = new JButton("Taistele!");
        taistele.addActionListener(pelikuuntelija);
        container.add(taistele);
   
    }
    
  
    
     public JFrame getFrame() {
        return frame;
    }
  
    
}
