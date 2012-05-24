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
    
    public Ymparisto(){
        this.aineet = new ArrayList<Aine>();
    }
    
    public void ainelista(ArrayList<Aine> lista){
        for (Aine a : lista){
            if (a.isEritettava()){
                this.aineet.add(a);
            }
        }
    }
    
    public void paivita(HashMap<Aine, Double> uudetKonsentraatiot){
        //TODO onko eritettävillä solunsisäistä konsentraatiota. Ympäristön pitää
        //varmaankin luoda uudet instanssit aineista, jotta ne eivät vaikuta solujen sisällä.
        //silloin ongelmaksi tulee listan päivitys kun vissiin sekä oliot että viitteet ovat eri
        
    }
    
    public ArrayList<Aine> getAineet() {
        return aineet;
    }

    public void setAineet(ArrayList<Aine> aineet) {
        this.aineet = aineet;
    }
    
}
