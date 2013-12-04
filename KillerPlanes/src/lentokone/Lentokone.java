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
    
    /**
     * Lentokone-luokka hallitsee lentokoneen energiaa ja aseita
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
     * sen verran mitä aseessa on tehoja
     * @param ase se ase, jolla ammuttiin
     */
    
    public void paivitaEnergia(Ase ase) {
        this.energia = this.energia-ase.getTeho();
    }
    
    /**
     *Palauttaa vain tämän pelaajan aseet 
     * @return aseet listana
     */
    
    public ArrayList<Ase> palautaAseet() {
        return aseet;
    }
    
    public ArrayList<Ase> palautaKaikkiAseet() {
        return aseistuksenTeko.palautaKaikki();
    }
    
    
    public void setHinta(int hinta) {
        this.hinta=hinta;
    }
    
    public int getHinta() {
        return hinta;
    }
    
    public String toString() {
             String aseita=" Aseet: ";
        for (Ase ase4 : aseet) {
            aseita = aseita+ase4+" ";
        }
        return getNimi()+", energia "+getEnergia()+" hinta "+getHinta()+aseita;
    }

    
}
