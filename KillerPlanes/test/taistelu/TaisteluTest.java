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
        lentokone1 = new Lentokone();
    }
    
    @After
    public void tearDown() {
    }
 
    @Test
    public void ampuminenPalauttaaOikeinKunOsutaan() {
        lentokone1.setEnergia(300);
        Ase ase1 = new Ase();
        ase1.setTeho(40);
        ase1.setTarkkuus(1);
        assertTrue(taistelu1.ammu(lentokone1, ase1, pelaaja1));
        
    }
    
    @Test
    public void ampuminenPalauttaaOikeinKunEiOsuta() {
        lentokone1.setEnergia(300);
        Ase ase1 = new Ase();
        ase1.setTeho(40);
        ase1.setTarkkuus(0);
        assertFalse(taistelu1.ammu(lentokone1, ase1, pelaaja1));
    }
    
    
    
}