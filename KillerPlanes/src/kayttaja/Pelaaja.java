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
    
    private String nimi;
    private ArrayList<Lentokone> lentokoneet; 
    
    public Pelaaja(String nimi) {
       this.nimi = nimi;

        
    }
    
    public String palautaNimi() {
        return nimi;
    }
}
