/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pelimoottori;

import javax.swing.SwingUtilities;
import kayttoliittyma.Kayttoliittyma;



/**
 * 
 * Peli ajetaan täältä kutsumalla käyttöliittymää
 * 
 */
public class KillerPlanes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        Kayttoliittyma kayttis = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttis);
        
 

    }
    
  
}
