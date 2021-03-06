/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taistelu;

import java.util.Random;
import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.Lentokone;

/**
 *Luokka taistelua varten, sisältää ampumisen
 * 
 */
public class Taistelu {
    
    Random rand = new Random();
    
    public Taistelu () {
        
    }
    
    
    /**
     * Metodi, jonka avulla ammutaan taistelussa toista pelaajaa. 
     * Jos osutaan, huolehtii siitä että lentokoneesta otetaan energiaa, tarkistetaan tippuuko se antaa rahaa pelaajalle joka osui.
     * 
     * @param lentokone se lentokone, jota kohti ammutaan
     * @param ase se ase, jolla ammutaan
     * @param kohde se pelaaja, jota ammutaan (eli lentokone on tämän pelaajan)
     * @param ampuja se joka ampuu ( eli ase on tämän pelaajan)
     * @return true jos osuttiin, false jos ei osuttu
     */
    
    public boolean ammu(Lentokone lentokone, Ase ase, Pelaaja kohde, Pelaaja ampuja) {
        if (rand.nextDouble() < ase.getTarkkuus()) {
            lentokone.paivitaEnergia(ase);
            kohde.tarkistaSailyykoKoneIlmassa(lentokone);
            ampuja.setRahaa(ase.getTeho()*4); 
            return true; //osuu
        }
        return false; //ei osu
    }
    
    
    
}
