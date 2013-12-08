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
    Pelaaja pelaaja2;
    Lentokone lentokone1;
    Lentokone lentokone2;
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
       pelaaja2 = new Pelaaja("Anni");
       lentokone1 = new Lentokone();
       lentokone2 = new Lentokone();
       taistelu1 = new Taistelu();
       ase1 = new Ase();
       pelaaja1.lisaaLentokone(lentokone1);
       lentokone1.setEnergia(200);
       ase1.setTarkkuus(1);
       ase1.setHinta(50);
       lentokone2.setHinta(400);
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
       taistelu1.ammu(lentokone1, ase1, pelaaja1, pelaaja2);
       assertFalse(pelaaja1.tarkistaSailyykoKoneIlmassa(lentokone1));
       
   }
   
   @Test
   public void palauttaaFalseJosLentokoneTippuuEnergiaAlleNolla() {
       ase1.setTeho(500);
       taistelu1.ammu(lentokone1, ase1, pelaaja1, pelaaja2);
       assertFalse(pelaaja1.tarkistaSailyykoKoneIlmassa(lentokone1));
    }   
   
   @Test 
   public void palauttaaTrueJosLentokoneEiTipuEnergiaYliNolla() {
       ase1.setTeho(100);
       taistelu1.ammu(lentokone1, ase1, pelaaja1, pelaaja2);
       assertTrue(pelaaja1.tarkistaSailyykoKoneIlmassa(lentokone1));
   }
   
   @Test
   public void poistaaLentokoneenListastaJosSeTippuu() {
       ase1.setTeho(500);
       taistelu1.ammu(lentokone1, ase1, pelaaja1, pelaaja2);
       assertFalse(pelaaja1.palautaLentokoneet().contains(lentokone1));
   }
   
   @Test
   public void eiPoistaLentokonettaListastaJosSeEiTipu() {
       ase1.setTeho(100);
       taistelu1.ammu(lentokone1, ase1, pelaaja1, pelaaja2);
       assertTrue(pelaaja1.palautaLentokoneet().contains(lentokone1));
   }
   
   @Test
   public void lisaaLentokoneenJosOnRahaaOstaa() {
       pelaaja1.ostaLentokone(lentokone2);
       assertTrue(pelaaja1.palautaLentokoneet().contains(lentokone2));
   }
   
   @Test
   public void vahentaaRahaaJosOnRahaaOstaaLentokone() {
       pelaaja1.ostaLentokone(lentokone2);
       assertEquals(pelaaja1.getRahat(), 600);
   }
   
   @Test
   public void lisaaAseenJosOnRahaaOstaa() {
       pelaaja1.ostaLentokone(lentokone2);
       pelaaja1.ostaAse(ase1, lentokone2);
       assertTrue(lentokone2.palautaAseet().contains(ase1));
   }
   
   @Test
   public void vahentaaRahaaJosOnRahaaOstaaAse() {
       pelaaja1.ostaLentokone(lentokone2);
       pelaaja1.ostaAse(ase1, lentokone2);
       assertEquals(pelaaja1.getRahat(), 550);
   }
   
   @Test
   public void eiLisaaLentokonettaJosEiOleRahaaOstaaLentokonetta() {
       pelaaja1.setRahaa(-900);
       pelaaja1.ostaLentokone(lentokone2);
       assertFalse(pelaaja1.palautaLentokoneet().contains(lentokone2));
   }
   
   @Test
   public void eiOtaRahaaPoisJosEiOleRahaaOstaaLentokonetta() {
       pelaaja1.setRahaa(-900);
       pelaaja1.ostaLentokone(lentokone2);
       assertEquals(pelaaja1.getRahat(), 100);
   }
   
   @Test
   public void palauttaaTrueJosEiOleLentokoneitaEliKuolee() {
       pelaaja1.palautaLentokoneet().clear();
       assertTrue(pelaaja1.tarkistaKuoleeko());
   }
   
   @Test 
   public void palauttaaFalseJosEiKuole() {
       pelaaja1.lisaaLentokone(lentokone1);
       assertFalse(pelaaja1.tarkistaKuoleeko());
   }
   
   @Test
   public void palauttaaTrueJosVoittaa() {
       pelaaja1.setRahaa(5000);
       assertTrue(pelaaja1.tarkistaVoittaako());
   }
   
   @Test
   public void palauttaaFalseJosEiVoita() {
       assertFalse(pelaaja1.tarkistaVoittaako());
   }
   

    
}