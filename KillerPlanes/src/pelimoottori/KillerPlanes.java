/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pelimoottori;

import java.util.ArrayList;
import kayttaja.Pelaaja;
import java.util.Scanner;
import lentokone.Ase;
import lentokone.Lentokone;
import taistelu.Taistelu;


/**
 *
 * @author emmisall
 */
public class KillerPlanes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //tämä on vain testailua varten..
                
        Scanner lukija = new Scanner(System.in);
        String nimi1;
        String nimi2;
        ArrayList<Lentokone> lentokoneet1 = new ArrayList<Lentokone>();
        ArrayList<Lentokone> lentokoneet2 = new ArrayList<Lentokone>();
  
        System.out.println("Anna pelaajanimesi pelaaja1: ");
        nimi1=lukija.nextLine();
        Pelaaja pelaaja1 = new Pelaaja(nimi1);
        System.out.println("Valitsit nimeksesi "+pelaaja1.getNimi());
        Lentokone lentokone1 = new Lentokone();
        pelaaja1.lisaaLentokone(lentokone1);
        lentokone1.setNimi("lol");
        System.out.println(lentokone1.getNimi());
        
         
        System.out.println("Anna pelaajanimesi pelaaja2: ");
        nimi2=lukija.nextLine();
        Pelaaja pelaaja2 = new Pelaaja(nimi2);
        System.out.println("Valitsit nimeksesi "+pelaaja2.getNimi());
        Lentokone lentokone2 = new Lentokone();
        pelaaja2.lisaaLentokone(lentokone1);
        lentokone2.setNimi("lol2");
        System.out.println(lentokone2.getNimi());
        
        Ase ase1 = new Ase();
        ase1.setNimi("Sinko");
        ase1.setTarkkuus(0.7);
        ase1.setTeho(20);
        ase1.setHinta(50);
//        lentokone1.lisaaAse(ase1);
//        System.out.println("Aseen1 nimi on: "+ase1.getNimi()+" ja tarkkuus on "+ase1.getTarkkuus()+" ja voima on "+ase1.getTeho());
        
//        lentokone1.setEnergia(150);
//        System.out.println("Lentokoneen1 kestävyys on: "+lentokone1.getEnergia());
//        
//        Taistelu taistelu1 = new Taistelu();
//        taistelu1.ammu(lentokone1, ase1, pelaaja1);
//        System.out.println(lentokone1.getEnergia());
        
        lentokone2.setHinta(400);
        pelaaja1.ostaLentokone(lentokone2);
        if(pelaaja1.palautaLentokoneet().contains(lentokone2)) {
            System.out.println("jee");
        }
  
        
        pelaaja1.ostaAse(ase1, lentokone2);
        if (lentokone2.palautaAseet().contains(ase1)) {
            System.out.println("ase on");
        }

        System.out.println(pelaaja1.getRahat());
        
        

    }
    
  
}
