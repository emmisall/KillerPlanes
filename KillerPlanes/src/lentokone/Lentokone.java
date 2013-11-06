/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lentokone;

import java.util.ArrayList;

/**
 *
 * @author verijuotikas
 */
public class Lentokone {
    
//    private Ase ase;
    private String nimi;
    private ArrayList<Ase> aseet;
    private int energia;
 
    
    public Lentokone () {
        this.aseet=new ArrayList<Ase>();
    }
    
    public void setNimi(String nimi) {
        this.nimi=nimi;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void lisaaAse(Ase ase) {
        aseet.add(ase);
    }
    
    public void setEnergia(int kestavyys) {
        this.energia=kestavyys;
    }
    
    public int getEnergia () {
        return energia;
    }
    
    public void paivitaEnergia(Ase ase) {
        this.energia = this.energia-ase.getTeho();
        // pitää lisätä että jos energia menee 0 tai alle 0 niin lentokone tippuu -> poistetaa arrayLististä
    }
    
    public ArrayList<Ase> palautaAseet() {
        return aseet;
    }
    
    

    
}
