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
    
    public Ase () {
        
    }
    
    public void setNimi(String nimi) {
        this.nimi=nimi;
    }
    
    public String getNimi() {
        return this.nimi;
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
    


}
