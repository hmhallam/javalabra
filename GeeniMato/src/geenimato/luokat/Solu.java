/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.luokat;

import java.util.ArrayList;

/**
 *
 * @author henriikka
 */
public class Solu {
    
    private ArrayList<Geeni> genomi;
    
    public Solu(int geenienMaara){
        this.genomi = luoGeenit(geenienMaara);
        
    }
    
    private ArrayList<Geeni> luoGeenit(int maara){
        ArrayList<Geeni> lista = new ArrayList<Geeni>();
        int i = 0;
        while (i < maara){
            lista.add(new Geeni());
            i++;
        }
        return lista;
    }

    public ArrayList<Geeni> getGenomi() {
        return genomi;
    }
    
    public void lisaaGeeni(Geeni geeni){
        for (Geeni g : genomi){
            geeni.setInteraktio(g, Interaktio.EI);
        }
        genomi.add(geeni);
    }
    
    public void elaAikaYksikko(){
        geeniStatukset(); //geenit päälle/pois
        proteiininTuotto(); //päivitetään proteiinikonsentraatiot
    }
    
    private void geeniStatukset(){ //kaikki geenit tarkkailevat muiden 
        for (Geeni geeni : genomi){
            int yhteisvaikutus = yhdenGeeninStatus(geeni);
            if (yhteisvaikutus > 0){
                 geeni.setStatus(true);
            }else if (yhteisvaikutus < 0){
                geeni.setStatus(false);
            }
        }
    }
    
    private int yhdenGeeninStatus(Geeni tama){ // yksi geeni tarkistaa, vaikuttavatko muiden proteiinien konsentraatiot sen päälläoloon
        int muisti = 0;
        for (Geeni g : genomi){
            if (g.getKonsentraatio() >= tama.getKynnysarvo()){
                Interaktio vaikutus = tama.getInteraktio(g);
                switch(vaikutus){
                   case EI:
                       break; 
                   case INHIBITIO:
                       muisti--;
                       break;
                   case AKTIVAATIO:
                       muisti++;
                       break;
                }
            }
        }
        return muisti;
    }
    
    private void proteiininTuotto(){
        for (Geeni geeni : genomi){
            geeni.tuotaProteiinia();
        }
    }
    
    public void printtaaGeenit(){
        for (Geeni g : genomi){
            System.out.println(g);
        }
    }
    
    public void printtaaProteiinit(){
        for (Geeni g : genomi){
            System.out.println(g.getProteiini());
        }
    }
}
