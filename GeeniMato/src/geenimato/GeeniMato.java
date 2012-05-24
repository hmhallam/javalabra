/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato;

import geenimato.luokat.Aine;
import geenimato.luokat.Interaktio;
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
        
        Solu solu = new Solu(0);
        Aine aine = new Aine("nimi", false, false, 4.0, 3.0, 0.3, Interaktio.EI);
        aine.setKonsentraatio(5.0);
        System.out.println(solu.konsentraatioStringit());
        solu.lisaaAine(aine);
        System.out.println(solu.konsentraatioStringit());
        solu.elaAikaYksikko();
        solu.elaAikaYksikko();
        
        
        System.out.println(solu.konsentraatioStringit());
        // TODO code application logic here
    }
}
