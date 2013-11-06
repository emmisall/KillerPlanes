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
    
    private Ase ase;
    private String nimi;
    private ArrayList<Ase> aseet;
    private int energia;
    //tässä ei puututa virheellisiin (esim. < 0) syöttöarvoihin vielä, tiedetään
    //mutta lentokoneet lisää ylläpitäjä joka nyt saa toistaiseksi luvan tietää että mitä on tekemässä, 
    //pelaajat vain ottavat käyttöön ylläpitäjän lisäämiä lentokoneita
 
    
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
    
    public void setEnergia(int energia) {
        this.energia=energia;
    }
    
    public int getEnergia () {
        return energia;
    }
    
    public void paivitaEnergia(Ase ase) {
        this.energia = this.energia-ase.getTeho();
    }
    
    public ArrayList<Ase> palautaAseet() {
        return aseet;
    }
    
    

    
}
