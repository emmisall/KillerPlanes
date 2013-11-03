/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pelimoottori;

import java.util.ArrayList;
import kayttaja.Pelaaja;
import java.util.Scanner;
import lentokone.Lentokone;

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
        
        //taulukko täällä, 2 pelaajaa lisätään
        
        Scanner lukija = new Scanner(System.in);
        String nimi1;
        String nimi2;
        ArrayList<Lentokone> lentokoneet1 = new ArrayList<Lentokone>();
        ArrayList<Lentokone> lentokoneet2 = new ArrayList<Lentokone>();
        
        System.out.println("Anna pelaajanimesi pelaaja2: ");
        nimi1=lukija.nextLine();
        Pelaaja pelaaja1 = new Pelaaja(nimi1,lentokoneet1);
        System.out.println("Valitsit nimeksesi "+pelaaja1.getNimi());
        Lentokone lentokone1 = new Lentokone(pelaaja1);
        pelaaja1.lisaaLentokone(lentokone1);
        lentokone1.setNimi("lol");
        System.out.println(lentokone1.getNimi(lentokone1));
        
         
        System.out.println("Anna pelaajanimesi pelaaja1: ");
        nimi1=lukija.nextLine();
        Pelaaja pelaaja2 = new Pelaaja(nimi1,lentokoneet2);
        System.out.println("Valitsit nimeksesi "+pelaaja2.getNimi());
        Lentokone lentokone2 = new Lentokone(pelaaja2);
        pelaaja2.lisaaLentokone(lentokone1);
        lentokone2.setNimi("lol2");
        System.out.println(lentokone2.getNimi(lentokone2));
        
    }
    
  
}
