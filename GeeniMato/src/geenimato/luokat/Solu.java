/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.luokat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**luokka, joka sisältää aineita
 *
 * @author henriikka
 */


public class Solu { //TODO interaktioiden suhteet talteen muuttujaan, helpottaa testaamista
    
    private ArrayList<Aine> aineet;
    private int aika;
    
    /** Solu sisältää aineita, jotka se voi luoda itse tai voi luoda tyhjän solun ja asettaa sinne aineita
     * 
     * @param aineidenMaara montako ainetta solu luo konstruktorissaan
     */
    public Solu(int aineidenMaara){
        this.aineet = luoAineet(aineidenMaara);
        this.aika = 0;
    }
    
    /** Luo listan soluista ja täyttää sen aineilla, jotka luodaan käyttäen aineen random-konstruktoria
     * apumetodina interaktioidenluomismetodi
     * 
     * @param maara montako ainetta luodaan
     * @return lista aineista
     */
    private ArrayList<Aine> luoAineet(int maara){
        Random random = new Random();
        ArrayList<Aine> lista = new ArrayList<Aine>();
        int i = 1;
        while (i <= maara){ 
            lista.add(new Aine("Aine" + i, random));
            i++;
        }
        lista = luoInteraktiot(lista);
        return lista;
    } 
    
    /** käy läpi ainelistan, asettaa sinne kaikki interaktiot (myös aineen interaktion itsensä kanssa, joka alunperin oli EI
     * 
     * @param lista ilman interaktioita
     * @return lista ineraktioilla
     */
    private ArrayList<Aine> luoInteraktiot(ArrayList<Aine> lista){
        for (Aine tama : lista){
            for (Aine muu : lista){
                tama.setInteraktio(muu, randomInteraktio());
            }
        }
        return lista;
    }
    
    
    
    /** interaktioarpoja, 20% ettei ineraktiota ole. Aktivaatiolla ja inhibitiolla yhtä suuret todennäköisyydet
     * 
     * 
     * @return Interaktio tietyillä todennäköisyyksillä
     */
    private Interaktio randomInteraktio(){
        Random random = new Random();
        double luku = random.nextDouble();
        if (luku <= 0.4){
            return Interaktio.INHIBITIO;
        }else if (luku <= 0.8){
            return Interaktio.AKTIVAATIO;
        }else{
           return Interaktio.EI; 
        }
        
    }
    
//*************konstruktorin käyttämät alkusäätömetodit oli siinä***************

    public ArrayList<Aine> getAineet() {
        return aineet;
    }
    
    /**mappaa aineiden nimet ja itse aineet
     * 
     * @return HashMap<String, Aine>
     */
    public HashMap<String, Aine> nimiMap(){
        HashMap<String, Aine> map = new HashMap<String, Aine>();
        for (Aine aine : aineet){
            map.put(aine.getNimi(), aine);
        }
        return map;
    }
    
    /**Antaa listan aineista, joita solu erittää
     * 
     * @return ArrayList<Aine>
     */
    public ArrayList<Aine> kopioiEritettavat(){ //TODO täytyy antaa eri instanssit
        ArrayList<Aine> eritettavat = new ArrayList<Aine>();
        for (Aine aine : aineet){
            if (aine.isEritettava()){
                Aine aine2 = new Aine(aine.getNimi(),
                        false, true, aine.getTuotto(), 
                        aine.getHajotus(), aine.getKynnysarvo(),
                        aine.getInteraktio(aine));
                eritettavat.add(aine2);
            }
        }
        return eritettavat;
    }
    
    /** Soluun voidaan lisätä aineita, metodi huolehtii lisäämisestä ja interaktioiden lisäämisestä
     * 
     * @param aine lisättävä aine
     */
    public void lisaaAine(Aine aine){ 
        for (Aine a : aineet){
            aine.setInteraktio(a, randomInteraktio());
            for (Aine b : aineet){
                b.setInteraktio(aine, randomInteraktio());
            }
        }
        aineet.add(aine);
    }
   
    /** solun aineiden sisäinen tila muttuu
     * Geenit päälle/pois, aineiden pitoisuudet muuttuvat.
     */
    public void elaAikaYksikko(){
        geeniStatukset(); //geenit päälle/pois
        proteiininTuotto(); //päivitetään proteiinikonsentraatiot
        this.aika += 1;
    }
    
    public int getAika(){
        return this.aika;
    }
    
    /**muutetaan aineiden geenien statukset riippuen niihin vaikuttavien aineiden konsentraatioista
     * käyttää apumetodia joka summaa yksittäisille aineille interaktioiden vaikutukset
     */
    private void geeniStatukset(){ 
        for (Aine aine : aineet){
            int yhteisvaikutus = yhdenAineenStatus(aine);
            if (yhteisvaikutus > 0){
                 aine.setGeeni(true);
            }else if (yhteisvaikutus < 0){
                aine.setGeeni(false);
           } //else{
//                aine.setGeeni(true);
//            }
        }
    }
    
    /** yksi aine tarkistaa, ylittävätkö muiden aineiden konsentraatiot kynnysarvon.
     * jos sellainen aine löytyy, katsotaan sen inerakton tyyppi. Aktivaatiot ja
     * inhibitiot summataan ja luku palautetaan
     * 
     * @param tama aine, jonka geenistatusta ollaan muuttamassa
     * @return luku, negatiivinen tarkoittaa, että inhibitiot voittivat, positiivisella aktivaatiot
     */ 
    private int yhdenAineenStatus(Aine tama){
        int muisti = 0;
        for (Aine a : aineet){
            if (a.getKonsentraatio() >= tama.getKynnysarvo()){
                Interaktio vaikutus = tama.getInteraktio(a);
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
    
    /** muutetaan kaikkien aineiden konsentraatioita
     * 
     */
    private void proteiininTuotto(){
        for (Aine a : aineet){
            a.muutaKonsentraatio();
        }
    }
    
    
    /**Printtaamista varten tehty tekstitaulukko.
     * ylärivillä vaikuttavat aineet
     * 
     * @return taulukko, jossa näkyy aineiden väliset interaktiot
     */
    
    public String interaktioTaulukko(){ //TODO lyhennä metodia apumetodeilla
        StringBuilder kasaaja = new StringBuilder();
        kasaaja.append("     ");
        for (Aine a : aineet){
            kasaaja.append(a.getNimi());
        }
        kasaaja.append(" <- nuo vaikuttavat alariveillä oleviin");
        kasaaja.append("\n");
        for (Aine a : aineet){
            kasaaja.append(a.getNimi());
            kasaaja.append("  ");
            HashMap<Aine, Interaktio> lista = a.getInteraktiot();
            for (Aine b : aineet){
                kasaaja.append(lista.get(b));
                kasaaja.append("    ");
            }
            kasaaja.append("\n");
        }
        return kasaaja.toString();
    }
    
    /**Merkkijonoesitys, jossa solun kaikkien aineiden lyhyemmät merkkijonoesitykset
     * 
     * @return teksti, jossa omalla rvillään yhden aineen nimi ja konsentraatio
     */
    public String konsentraatioStringit(){
        StringBuilder kasaaja = new StringBuilder();
        for (Aine a : aineet){
            kasaaja.append(a.konsentraatioString());
            kasaaja.append("\n");
        }
        return kasaaja.toString();
    }
    
    /** merkkijonoesitys, jossa aineiden pidemmät merkkijonoesitykset omana blokkinaan
     * 
     * @return String
     */
    
    @Override
    public String toString(){
        StringBuilder kasaaja = new StringBuilder();
        for (Aine a : aineet){
            kasaaja.append(a);
            kasaaja.append("\n");
        }
        return kasaaja.toString();
    }
    
}
