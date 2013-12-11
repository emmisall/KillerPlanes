/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lentokone;

import java.util.ArrayList;


/**
 * Hallitsee lentokoneen energiaa ja aseita
 * 
 */
public class Lentokone {
    
    private String nimi;
    private int hinta;
    private ArrayList<Ase> aseet;
    private int energia;
    private AseidenLuominen aseistuksenTeko;
    private Ase ase1;
    private Ase ase2;
    private Ase ase3;

    
 /**
  * Konstruktorissa luodaan lentokoneelle lista aseista ja siihen lisätään lentokoneen ensimmäinen ase
  */
    
    public Lentokone () {
        this.aseet=new ArrayList<Ase>();
        aseistuksenTeko = new AseidenLuominen(ase1, ase2, ase3);
        aseet.add(aseistuksenTeko.getAse1()); //lentokoneeseen laitetaan aina eka ase valmiiksi
//        aseet.add(aseistuksenTeko.getAse2()); //tarvittaessa toinen että on helpompi testata peliä
    }
    
    public void setNimi(String nimi) {
        this.nimi=nimi;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    /**
     * Lisää lentokoneelle aseen, jos lentokoneessa ei ole vielä aseet täynnä (max 3)
     * @param ase, se ase joka halutaan lisätä 
     * @return true jos ase mahtui, false jos ei
     */
    
    public boolean lisaaAse(Ase ase) {
        if (aseet.size()==3) {
            return false;
        }
        else aseet.add(ase);
        return true;
    }
    
    public void setEnergia(int energia) {
        this.energia=energia;
    }
    
    public int getEnergia () {
        return energia;
    }
    
    /**
     * Päivittää lentokoneen energian, jos siihen osutaan taistelussa, vähentää energiaa
     * sen verran mitä aseessa on tehoja*3
     * @param ase se ase, jolla ammuttiin
     */
    
    public void paivitaEnergia(Ase ase) {
        this.energia = this.energia-ase.getTeho()*3;
    }
    
    /**
     *Palauttaa vain tämän pelaajan aseet 
     * @return aseet listana
     */
    
    public ArrayList<Ase> palautaAseet() {
        return aseet;
    }
    
    /**
     * Palauttaa kaikki pelin aseet
     * @return kaikki aseet listana
     */
    
    public ArrayList<Ase> palautaKaikkiAseet() {
        return aseistuksenTeko.palautaKaikki();
    }
    
    
    public void setHinta(int hinta) {
        this.hinta=hinta;
    }
    
    public int getHinta() {
        return hinta;
    }
    
    @Override
    public String toString() {
             String aseita=" Aseet: ";
        for (Ase ase4 : aseet) {
            aseita = aseita+ase4+" ";
        }
        return getNimi()+", energia "+getEnergia()+" hinta "+getHinta()+aseita;
    }

    
}
