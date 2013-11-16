/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttaja;

/**
 *
 * @author verijuotikas
 */
public class Raha {
    
    private int rahat;
    private int vahennys;
    
    public Raha() {
        this.rahat=1000; //aloitussuma on 1000 rahaa, asetetaan kun pelaajalle annetaan aloitusrahat eli tehdään rahaolio pelaajan konstruktorissa
    }
    
    public void setRahat(int summa) {
        this.rahat=rahat+summa;
    }
    
    public int getRahat() {
        return rahat;
    }
    
    public boolean vahennaRahaa(int vahennys) {
        if (getRahat()-this.vahennys<0) {
            return false;
        }
        return true;
    }
    
}
