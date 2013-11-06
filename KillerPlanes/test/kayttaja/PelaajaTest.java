/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttaja;

import lentokone.Ase;
import lentokone.Lentokone;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taistelu.Taistelu;

/**
 *
 * @author emmisall
 */
public class PelaajaTest {
    
    Pelaaja pelaaja1;
    Lentokone lentokone1;
    Taistelu taistelu1;
    Ase ase1;
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       pelaaja1 = new Pelaaja("Emmi");
       lentokone1 = new Lentokone();
       taistelu1 = new Taistelu();
       ase1 = new Ase();
       pelaaja1.lisaaLentokone(lentokone1);
       lentokone1.setEnergia(200);
       ase1.setTarkkuus(1);
    }
    
    @After
    public void tearDown() {
    }
    
   @Test
    public void lentokoneLisataanOikein() {
       assertTrue(pelaaja1.palautaLentokoneet().contains(lentokone1));
       
   }
   
   @Test
   public void palauttaaFalseJosLentokoneTippuuEnergiaTasanNolla() {
       ase1.setTeho(200);
       taistelu1.ammu(lentokone1, ase1, pelaaja1);
       assertFalse(pelaaja1.tarkistaSailyykoKoneIlmassa(lentokone1));
       
   }
   
   @Test
   public void palauttaaFalseJosLentokoneTippuuEnergiaAlleNolla() {
       ase1.setTeho(500);
       taistelu1.ammu(lentokone1, ase1, pelaaja1);
       assertFalse(pelaaja1.tarkistaSailyykoKoneIlmassa(lentokone1));
    }   
   
   @Test 
   public void palauttaaTrueJosLentokoneEiTipuEnergiaYliNolla() {
       ase1.setTeho(100);
       taistelu1.ammu(lentokone1, ase1, pelaaja1);
       assertTrue(pelaaja1.tarkistaSailyykoKoneIlmassa(lentokone1));
   }
   
   @Test
   public void poistaaLentokoneenListastaJosSeTippuu() {
       ase1.setTeho(500);
       taistelu1.ammu(lentokone1, ase1, pelaaja1);
       assertFalse(pelaaja1.palautaLentokoneet().contains(lentokone1));
   }
   
   @Test
   public void eiPoistaLentokonettaListastaJosSeEiTipu() {
       ase1.setTeho(100);
       taistelu1.ammu(lentokone1, ase1, pelaaja1);
       assertTrue(pelaaja1.palautaLentokoneet().contains(lentokone1));
   }

    
}