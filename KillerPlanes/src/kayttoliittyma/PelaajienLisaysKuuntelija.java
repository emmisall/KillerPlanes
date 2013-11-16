/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import kayttaja.Pelaaja;

/**
 *
 * @author verijuotikas
 */
public class PelaajienLisaysKuuntelija implements ActionListener {
    
    private JTextField pelaajan1Nimi;
    private JTextField pelaajan2Nimi;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    
    public PelaajienLisaysKuuntelija(Pelaaja pelaaja1, Pelaaja pelaaja2, JTextField pelaajan1Nimi, JTextField pelaajan2Nimi) {
        this.pelaaja1=pelaaja1;
        this.pelaaja2=pelaaja2;
        this.pelaajan1Nimi=pelaajan1Nimi;
        this.pelaajan2Nimi=pelaajan2Nimi;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        pelaaja1 = new Pelaaja(pelaajan1Nimi.getText());
        pelaaja2 = new Pelaaja(pelaajan2Nimi.getText());
//        System.out.println(pelaaja1.getNimi());
//        System.out.println(pelaaja2.getNimi());
//        System.out.println(pelaaja1.getRahat());
    }
    
}
