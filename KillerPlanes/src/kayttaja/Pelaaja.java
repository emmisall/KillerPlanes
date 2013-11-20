/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttaja;

import lentokone.Lentokone;
import java.util.ArrayList;
import lentokone.Ase;
import lentokone.LentokoneidenLuominen;


/**
 *
 * @author verijuotikas
 */
public class Pelaaja {
    //testi
    private String nimi;
    private ArrayList<Lentokone> lentokoneet; 
    private Lentokone lentokone;
    private int rahat;
    private int summa;
    private Ase ase;
    private LentokoneidenLuominen lentsikat;
    private Lentokone lentokone1;
    private Lentokone lentokone2;
    private Lentokone lentokone3;
    private Lentokone lentokone4;

    
    public Pelaaja(String nimi) {
       this.nimi=nimi;
       this.lentokoneet=new ArrayList<Lentokone>();
       this.rahat=1000; //alkupääoma pelaajalle
       this.lentsikat = new LentokoneidenLuominen(lentokone1, lentokone2, lentokone3, lentokone4);
       lentokoneet.add(lentsikat.getLento1()); //lisätään ensimmäinen lentokone pelaajalle 
       lentokoneet.add(lentsikat.getLento2()); //toinen testimielessä
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void lisaaLentokone(Lentokone lentokone) {
        lentokoneet.add(lentokone);
    }
    
    public ArrayList<Lentokone> palautaLentokoneet() {
        return lentokoneet;
    }
    
    public boolean tarkistaSailyykoKoneIlmassa(Lentokone lentokone) { //tässä siis poistetaan lentokone pelaajan listasta jos tippuu taistelussa
        if (lentokone.getEnergia() <= 0) {
            lentokoneet.remove(lentokone);
            return false;
        }
        else return true;
    }
    
    public void setRahaa(int summa) {
        this.rahat=rahat+summa;
        //jos raha ylittää voittosumman, pelaaja voittaa. tarkistus?
    }
    
    public int getRahat() {
        return rahat;
        
    }
    
    public boolean ostaLentokone(Lentokone lentokone) {
        if (getRahat()-lentokone.getHinta()>=0) {
            setRahaa(0-lentokone.getHinta());
            lisaaLentokone(lentokone);
            return true;
        }
        return false;
    }
    
     public boolean ostaAse(Ase ase, Lentokone lentokone) {
         if (getRahat()-ase.getHinta() >= 0) {
             setRahaa(0-ase.getHinta());
             lentokone.lisaaAse(ase);
             return true;
         }
         return false;
     }
   
    
    
}
