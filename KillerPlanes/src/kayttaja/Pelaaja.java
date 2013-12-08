


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

    
    /**
     * 
     * Pelaaja-luokka hallitsee pelaajan lentokoneita ja rahoja
     * 
     * @param nimi pelaajan antama pelaajanimi
     */
    
    public Pelaaja(String nimi) {
       this.nimi=nimi;
       this.lentokoneet=new ArrayList<Lentokone>();
       this.rahat=1000; //alkupääoma pelaajalle
       this.lentsikat = new LentokoneidenLuominen(lentokone1, lentokone2, lentokone3, lentokone4);
       lentokoneet.add(lentsikat.getLento1()); //lisätään ensimmäinen lentokone pelaajalle 
//       lentokoneet.add(lentsikat.getLento2()); //toinen testimielessä
    }
    
    public String getNimi() {
        return nimi;
    }
    
    
    /**
     * Metodi lisää lentokoneen käyttäjän lentokone-arrayListiin
     * 
     * @param lentokone Se lentokone, joka halutaan lisätä, esim. ostettu lentokone
     */
    public void lisaaLentokone(Lentokone lentokone) {
        lentokoneet.add(lentokone);
    }
    
    
    /**
     * Tämä metodi palauttaa siis vain tämän pelaajan lentokoneet
     * @return lista lentokoneista
     */
    
    public ArrayList<Lentokone> palautaLentokoneet() {
        return lentokoneet;
    }
    
    public ArrayList<Lentokone> palautaKaikki() {
        return lentsikat.getKaikkiLentokoneet();
    }
    
    /**
     * Metodin avulla tarkistetaan, säilyykö pelaajan lentokone ilmassa osuman jälkeen, poistaa pelaajan arrayLististä koneen jos se tippuu
     * 
     * @param lentokone eli se pelaajan lentokone, johon osuttiin
     * @return false jos tippuu, true jos ei tipu 
     */
    
    public boolean tarkistaSailyykoKoneIlmassa(Lentokone lentokone) { //tässä siis poistetaan lentokone pelaajan listasta jos tippuu taistelussa
        if (lentokone.getEnergia() <= 0) {
            lentokoneet.remove(lentokone);
            return false;
        }
        else return true;
    }
    
    public void setRahaa(int summa) {
        this.rahat=rahat+summa;
    }
    
    public int getRahat() {
        return rahat;
        
    }
    
    public boolean tarkistaKuoleeko() {
        if (palautaLentokoneet().isEmpty()) {
            return true;
        }
        else return false;
    }
    
    public boolean tarkistaVoittaako() {
        if (getRahat() >= 2000) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodilla ostetaan lentokone, jos on rahaa tarpeeksi. Lentokone lisätään arrayListiin ja pelaajalta otetaan rahaa pois.
     * 
     * @param lentokone
     * @return true jos oli rahaa ostaa, false jos ei ollut
     */
    
    public boolean ostaLentokone(Lentokone lentokone) {
        if (getRahat()-lentokone.getHinta()>=0) {
            setRahaa(0-lentokone.getHinta());
            lisaaLentokone(lentokone);
            return true;
        }
        return false;
    }
    
    /**
     * Metodilla ostetaan ase, jos on rahaa tarpeeksi. Ase lisätään sen lentokoneen ArrayListiin jolle se ostetaan
     * Ei sisällä vielä tarkistusta sille että onko koneessa jo 3 asetta, jos on niin ei voi ostaa.
     * @param ase se ase joka halutaan ostaa
     * @param lentokone se lentokone, johon asetta ollaan ostamassa
     * @return true jos oli rahaa ostaa, false jos ei
     */
    
     public boolean ostaAse(Ase ase, Lentokone lentokone) {
         if (getRahat()-ase.getHinta() >= 0) {
             setRahaa(0-ase.getHinta());
             lentokone.lisaaAse(ase);
             return true;
         }
         return false;
     }
   
    
    
}
