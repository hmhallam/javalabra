/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato;

import geenimato.kayttoliittyma.GUI;
import geenimato.kayttoliittyma.Tekstikayttoliittyma;
import java.util.Scanner;



/**
 *
 * @author henriikka
 */
public class GeeniMato { 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        GUI kayttis = new GUI();
        //Tekstikayttoliittyma kayttis = new Tekstikayttoliittyma();
        
        kayttis.kaynnista();
        

    }
}
