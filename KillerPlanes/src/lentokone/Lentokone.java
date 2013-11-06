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
    private int kestavyys;
 
    
    public Lentokone () {
        aseet=new ArrayList<Ase>();
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
        this.kestavyys=kestavyys;
    }
    
    public int getEnergia () {
        return kestavyys;
    }
    
    public void paivitaEnergia(Ase ase) {
        this.kestavyys = this.kestavyys-ase.getTeho();
    }
    
    

    
}
