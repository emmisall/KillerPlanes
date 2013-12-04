/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lentokone;

/**
 *
 * @author verijuotikas
 */
public class Ase {
    
    private int teho;
    private double tarkkuus;
    private String nimi;
    private int hinta;
    
    /**
     * Asetetaan aseen tiedot ja voidaan saada ne gettereillä taistelua ja ostamista varten
     */
    
    public Ase () {
        
    }
    
    //tässä ei puututa virheellisiin (esim. < 0) syöttöarvoihin vielä, tiedetään
    //mutta aseet lisää ylläpitäjä joka nyt saa toistaiseksi luvan tietää että mitä on tekemässä, 
    //pelaajat vain ottavat käyttöön ylläpitäjän lisäämiä aseita
    
    public void setNimi(String nimi) {
        this.nimi=nimi;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void setTeho(int teho) {
        this.teho=teho;
    }
    
    public void setTarkkuus(double tarkkuus) {
        this.tarkkuus=tarkkuus;
    }
    
    public int getTeho() {
        return this.teho;
    }
    
    public double getTarkkuus() {
        return this.tarkkuus;
    }
    
    public void setHinta(int hinta) {
        this.hinta=hinta;
    }
    
    public int getHinta() {
        return hinta;
    }
    
    @Override
    public String toString() {
        return getNimi()+", tarkkuus "+getTarkkuus()+", teho "+getTeho()+", hinta "+getHinta();
    }
   

}
