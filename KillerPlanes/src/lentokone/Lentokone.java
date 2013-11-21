/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lentokone;

import java.util.ArrayList;
import kayttaja.Pelaaja;


/**
 *
 * @author verijuotikas
 */
public class Lentokone {
    
    private Ase ase;
    private String nimi;
    private int hinta;
    private ArrayList<Ase> aseet;
    private int energia;
    private Pelaaja pelaaja;
    private AseidenLuominen aseistuksenTeko;
    private Ase ase1;
    private Ase ase2;
    private Ase ase3;

    //tässä ei puututa virheellisiin (esim. < 0) syöttöarvoihin vielä, tiedetään
    //mutta lentokoneet lisää ylläpitäjä joka nyt saa toistaiseksi luvan tietää että mitä on tekemässä, 
    //pelaajat vain ottavat käyttöön ylläpitäjän lisäämiä lentokoneita
 
    
    public Lentokone () {
        this.aseet=new ArrayList<Ase>();
        aseistuksenTeko = new AseidenLuominen(ase1, ase2, ase3);
        aseet.add(aseistuksenTeko.getAse1()); //lentokoneeseen laitetaan aina eka ase valmiiksi
        aseet.add(aseistuksenTeko.getAse2());
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
    
    public void setHinta(int hinta) {
        this.hinta=hinta;
    }
    
    public int getHinta() {
        return hinta;
    }
  
   
    

    
    

    
}
