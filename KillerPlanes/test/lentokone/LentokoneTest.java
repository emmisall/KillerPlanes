/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lentokone;

import kayttaja.Pelaaja;
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
public class LentokoneTest {
    
    Lentokone lentokone1;
    Ase ase1;
    Pelaaja pelaaja1;
    
    public LentokoneTest() {
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
        ase1 = new Ase();
        lentokone1 = new Lentokone();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void aseenLisaysToimii() {
        Ase ase1 = new Ase();
        lentokone1.lisaaAse(ase1);
        assertTrue(lentokone1.palautaAseet().contains(ase1));
    }
    
    @Test
    public void paivitaEnergiaToimiiKunOsutaan() {
        ase1.setTeho(40);
        ase1.setTarkkuus(1);
        lentokone1.setEnergia(200);
        Taistelu taistelu1 = new Taistelu();
        taistelu1.ammu(lentokone1, ase1, pelaaja1);
        assertEquals(160, lentokone1.getEnergia());
        
    }
  
    @Test
    public void paivitaEnergiaToimiiKunEiOsuta() {
        ase1.setTeho(40);
        ase1.setTarkkuus(0);
        lentokone1.setEnergia(200);
        Taistelu taistelu1 = new Taistelu();
        taistelu1.ammu(lentokone1, ase1, pelaaja1);
        assertEquals(200, lentokone1.getEnergia());
    }
    
    @Test
    public void josEnergiaNollanTaiAllePalauttaaFalsen() {
        ase1.setTeho(200);
        ase1.setTarkkuus(1);
        lentokone1.setEnergia(200);
        Taistelu taistelu1 = new Taistelu();
        taistelu1.ammu(lentokone1, ase1, pelaaja1);
 
    }
    
}