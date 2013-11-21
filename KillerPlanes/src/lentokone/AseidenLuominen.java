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
public class AseidenLuominen {
    
    private Ase ase1;
    private Ase ase2;
    private Ase ase3;
    
    //asiden ominaisuudet ei välttämättä ole optimaaliset pelin läpiviennin kannalta vielä mutta ovat kuitenkin olemassa
    //että peliä voi pelata
    
    /**
     * Luodaan aseet lentokoneelle, "ylläpidon" määrittelemä, pelaaja ei voi hallita näitä
     * @param ase1
     * @param ase2
     * @param ase3 
     */
    
    public AseidenLuominen(Ase ase1, Ase ase2, Ase ase3) {
        this.ase1=new Ase();
        this.ase2=new Ase();
        this.ase3=new Ase();
        this.ase1.setNimi("Ampuja");
        this.ase2.setNimi("Ohjus");
        this.ase3.setNimi("Sinko");
        this.ase1.setTeho(50);
        this.ase2.setTeho(100);
        this.ase3.setTeho(300);
        this.ase1.setTarkkuus(0.7);
        this.ase2.setTarkkuus(0.5);
        this.ase3.setTarkkuus(0.4);
        this.ase1.setHinta(50);
        this.ase2.setHinta(100);
        this.ase3.setHinta(300);
    }
    
    public Ase getAse1() {
        return ase1;
    }
    
    public Ase getAse2() {
        return ase2;
    }
    
    //muille ei vielä gettereitä
    
}
