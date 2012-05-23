/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.luokat;

import java.util.ArrayList;
import java.util.HashMap;

/**
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
        //ei ole valmis, täytyy miettiä uusiksi pari juttua..
        
    }
}
