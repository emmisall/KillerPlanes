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
public class LentokoneidenLuominen {
    
    
    private Lentokone lentokone1;
    private Lentokone lentokone2;
    private Lentokone lentokone3;
    private Lentokone lentokone4;

    /**
     * Luodaan lentokoneet, joita voi ostaa. "Ylläpidon" määrittelemiä, pelaaja ei voi hallita näitä
     * 
     * @param lentokone1
     * @param lentokone2
     * @param lentokone3
     * @param lentokone4 
     */
    
    public LentokoneidenLuominen(Lentokone lentokone1, Lentokone lentokone2, Lentokone lentokone3, Lentokone lentokone4) {
        this.lentokone1 = new Lentokone();
        this.lentokone2 = new Lentokone();
        this.lentokone3 = new Lentokone();
        this.lentokone4 = new Lentokone();
        this.lentokone1.setNimi("Rääpäle");
        this.lentokone2.setNimi("Turbo");
        this.lentokone3.setNimi("Kingi");
        this.lentokone4.setNimi("TheKiller");
        this.lentokone1.setEnergia(200);
        this.lentokone2.setEnergia(300);
        this.lentokone3.setEnergia(400);
        this.lentokone4.setEnergia(600);
        this.lentokone1.setHinta(200);
        this.lentokone2.setHinta(300);
        this.lentokone3.setHinta(400);
        this.lentokone4.setHinta(600);
    }
    
    public Lentokone getLento1() {
        return lentokone1;
    }
    
    public Lentokone getLento2(){
        return lentokone2;
    }    
    
    public Lentokone getLento3() {
        return lentokone3;
    }
    
    public Lentokone getLento4() {
        return lentokone4;
    }
    

}
