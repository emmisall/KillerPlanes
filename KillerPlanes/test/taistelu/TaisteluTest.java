/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taistelu;

import kayttaja.Pelaaja;
import lentokone.Ase;
import lentokone.Lentokone;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emmisall
 */
public class TaisteluTest {
    
    Taistelu taistelu1;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    Lentokone lentokone1;

    
    public TaisteluTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        taistelu1 = new Taistelu();
        pelaaja1 = new Pelaaja("Emmi");
        pelaaja2 = new Pelaaja("Anni");
        lentokone1 = new Lentokone();
    }
    
    @After
    public void tearDown() {
    }
 
    @Test
    public void ampuminenPalauttaaOikeinKunOsutaan() {
        Ase ase1 = new Ase();
        lentokone1.setEnergia(300);
        ase1.setTeho(40);
        ase1.setTarkkuus(1);
        assertTrue(taistelu1.ammu(lentokone1, ase1, pelaaja1, pelaaja2));
        
    }
    
    @Test
    public void ampuminenPalauttaaOikeinKunEiOsuta() {
        Ase ase1 = new Ase();
        lentokone1.setEnergia(300);
        ase1.setTeho(40);
        ase1.setTarkkuus(0);
        assertFalse(taistelu1.ammu(lentokone1, ase1, pelaaja1, pelaaja2));
    }
    
    @Test
    public void antaaRahaaKunOsutaan() {
        Ase ase1 = new Ase();
        ase1.setTeho(40);
        ase1.setTarkkuus(1);
        taistelu1.ammu(lentokone1, ase1, pelaaja1, pelaaja2);
        assertEquals(pelaaja2.getRahat(),1160);
    }
    
    @Test 
    public void eiAnnaRahaaKunEiOsuta() {
        Ase ase1 = new Ase();
        ase1.setTeho(40);
        ase1.setTarkkuus(0);
        taistelu1.ammu(lentokone1, ase1, pelaaja1, pelaaja2);
        assertEquals(pelaaja2.getRahat(),1000);
    }
        
    
    
    
    
}