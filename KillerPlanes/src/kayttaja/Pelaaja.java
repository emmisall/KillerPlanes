/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttaja;

import lentokone.Lentokone;
import java.util.ArrayList;


/**
 *
 * @author verijuotikas
 */
public class Pelaaja {
    //testi
    private String nimi;
    private ArrayList<Lentokone> lentokoneet; 
    private Lentokone lentokone;
    private Raha rahat;
    
    public Pelaaja(String nimi) {
       this.nimi=nimi;
       this.lentokoneet=new ArrayList<Lentokone>();
       this.rahat = new Raha();
       // tässä pitää lisätä myös ensimmäinen lentokone kun uusi pelaaja tehdään -> pitää testata
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void lisaaLentokone(Lentokone lentokone) {
        lentokoneet.add(lentokone);
    }
    
    public ArrayList<Lentokone> palautaLentokoneet() {
        return lentokoneet;
    }
    
    public boolean tarkistaSailyykoKoneIlmassa(Lentokone lentokone) { //tässä siis poistetaan lentokone pelaajan listasta jos tippuu taistelussa
        if (lentokone.getEnergia() <= 0) {
            lentokoneet.remove(lentokone);
            return false;
        }
        else return true;
    }
    
    public boolean ostaLentokone(Lentokone lentokone) {
        if (rahat.vahennaRahaa(lentokone.getHinta())==true) {
            lisaaLentokone(lentokone);
            return true;
        }
        return false;
        
    }
    
    
}
