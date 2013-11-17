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
public class LentokoneidenLuominen {
    
    //tässä luokassa luodaan lentokoneet, joita käyttäjät voivat ostaa, hintoja ja energiaa yms. ei ole mietitty vielä pelin toimimisen kannalta
    //pääasia että peliä voi pelata, en tiedä voiko kukaan voittaa näillä hinnoilla ja energioilla
    //aseille pitää tehdä samanlainen
    private Lentokone lentokone1;
    private Lentokone lentokone2;
    private Lentokone lentokone3;
    private Lentokone lentokone4;
    
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
    
    //ei vielä gettereitä muille lentsikoille olemassa
    
}
