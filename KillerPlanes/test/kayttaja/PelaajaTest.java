/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttaja;

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
public class PelaajaTest {
    
    Pelaaja pelaaja1;
    
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
         Pelaaja pelaaja1 = new Pelaaja("Emmi");
    }
    
    @After
    public void tearDown() {
    }
    
   @Test
    public void lentokoneLisataanOikein() {
       Lentokone lentokone1 = new Lentokone();
       pelaaja1.lisaaLentokone(lentokone1);
       
   }
    
}