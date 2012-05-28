/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato;

import geenimato.kayttoliittyma.Tekstikayttoliittyma;
import geenimato.luokat.Aine;
import geenimato.luokat.Interaktio;
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
        
        Aine aine = new Aine("nimi", false, false, 4.0, 3.0, 0.3, Interaktio.EI);
        System.out.println(aine.toString());
        
//        Scanner lukija = new Scanner(System.in);
//        
//        Tekstikayttoliittyma liittyma = new Tekstikayttoliittyma(lukija);
//        liittyma.kaynnista();
    }
}
