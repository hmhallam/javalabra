/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato;

import geenimato.luokat.Solu;



/**
 *
 * @author henriikka
 */
public class GeeniMato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Solu solu = new Solu(7);
        System.out.println(solu);
        System.out.println(solu.interaktioTaulukko());
        
        solu.elaAikaYksikko();
        System.out.println(solu.konsentraatioStringit());
        solu.elaAikaYksikko();
        System.out.println(solu.konsentraatioStringit());
        solu.elaAikaYksikko();
        System.out.println(solu.konsentraatioStringit());
        
        
        // TODO code application logic here
    }
}
