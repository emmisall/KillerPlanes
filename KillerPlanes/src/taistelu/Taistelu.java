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
 *
 * @author verijuotikas
 */
public class Taistelu {
    
    Random rand = new Random();
    
    /**
     * Luokka taistelua varten, sisältää toistaiseksi vain ampumista
     */
    
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
        double randomi = rand.nextDouble(); //talletetaan muuttujaan että saan testitulostuksia tehtyä, tulostusta ei jätetä tänne
        if (randomi < ase.getTarkkuus()) {
            System.out.println("Osui, random oli:"+randomi);
            lentokone.paivitaEnergia(ase);
            kohde.tarkistaSailyykoKoneIlmassa(lentokone);
            ampuja.setRahaa(ase.getTeho()); //ampuja saa osumasta rahaa sen verran kuin aseessa oli tehoja tai kenties kertaa 3 tms. jos tuntuu että peli ei etene
            return true; //osuu
        }
        System.out.println("Ei osunut, randomi oli: "+randomi);
        return false; //ei osu
    }
    
    
    
}
