/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taistelu;

import java.util.Random;
import lentokone.Ase;
import lentokone.Lentokone;

/**
 *
 * @author verijuotikas
 */
public class Taistelu {
    
    Random rand = new Random();
    
    public Taistelu () {
        
    }
    
    
    public boolean ammu(Lentokone lentokone, Ase ase) {
        double randomi = rand.nextDouble(); //talletetaan muuttujaan että saan testitulostuksia tehtyä, tulostusta ei jätetä tänne
        if (randomi < ase.getTarkkuus()) {
            System.out.println("Osui, random oli:"+randomi);
            lentokone.paivitaKestavyys(ase);
            return true; //osuu
        }
        System.out.println("Ei osunut, randomi oli: "+randomi);
        return false; //ei osu
    }
    
    
    
}
