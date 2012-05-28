/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.luokat;

import java.util.ArrayList;
import java.util.HashMap;

/**Luokka sisältää soluja tietyissä paikoissa, pitää myös kirjaa tietyistä aineista
 *
 * @author henriikka
 */
public class Ymparisto {

    
    private ArrayList<Aine> aineet;
    private Solu solu;
    
    public Ymparisto(Solu solu){
        this.solu = solu;
        this.aineet = solu.kopioiEritettavat();
    }
    
    /** tarkoituksena on ottaa solulta talteen tieto uusista konsentraatioista,
     * ja mahdollisesti asettaa solun konsentraatiot nolliksi.
     * @param uudetKonsentraatiot 
     */
    public void paivita(HashMap<Aine, Double> uudetKonsentraatiot){
        
    }
    
    public ArrayList<Aine> getAineet() {
        return aineet;
    }

    public void setAineet(ArrayList<Aine> aineet) {
        this.aineet = aineet;
    }
    
}
