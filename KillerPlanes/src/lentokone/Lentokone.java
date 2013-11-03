/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lentokone;

import kayttaja.Pelaaja;

/**
 *
 * @author verijuotikas
 */
public class Lentokone {
    
//    private Ase ase;
    private String nimi;
    private Lentokone lentokone;
    
    public Lentokone (Pelaaja pelaaja) {
//        pelaaja.lisaaLentokone(this.lentokone);
    }
    
    public void setNimi(String nimi) {
        this.nimi=nimi;
    }
    
    public String getNimi(Lentokone lentokone) {
        return nimi;
    }
    
    
}
