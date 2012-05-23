/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.luokat;

import java.util.HashMap;
import java.util.Random;

/**Luokka, joka pitää huolta omasta konsentraatiostaan
 *
 * @author henriikka
 */


public class Aine {
    
    private String nimi;
    private boolean geeni;
    private boolean eritettava;
    private double konsentraatio;
    private double tuotto;
    private double hajotus;
    private double maksimikonsentraatio;
    private double kynnysarvo;
    private HashMap<Aine, Interaktio> interaktiot; //kaikkien aineiden vaikutukset
    
    /** Konstruktori, joka ottaa kaikki sisäiset muuttujansa parametreina
     * 
     * @param nimi jotta voidaan erottaa muista
     * @param geeni jos päällä, ainetta tuotetaan, jos poissa päältä, ainetta ei tuoteta
     * @param eritettava tarvitaan, jotta erotetaan aineet, joita saadaan solun ulkopuolle
     * @param tuotto paljonko tuotetaan ainetta (/aikayksikkö)
     * @param hajotus paljonko ainetta hajoaa (/aikayksikkö)
     * @param kynnysarvo paljonko muita aineita on oltava, jotta geenistatus muuttuu
     * @param interaktio millä tavalla geenistatus muuttuu
     */
    
    public Aine(String nimi, boolean geeni, boolean eritettava, 
            double tuotto, double hajotus, double kynnysarvo, Interaktio interaktio){
        this.nimi = nimi;
        this.geeni = geeni;
        this.eritettava = eritettava;
        this.konsentraatio = 0;
        this.maksimikonsentraatio = 5.0;
        this.tuotto = tuotto;
        this.hajotus = hajotus;
        this.kynnysarvo = kynnysarvo;
        this.interaktiot = new HashMap<Aine, Interaktio>();
        omaInteraktio(interaktio);  
    }
    
    /** Konstruktori tekee olion, joka ei tee mitään.
     * 
     * @param nimi 
     */
    
    public Aine(String nimi){
        this(nimi, false, false, 0.0, 0.0, 0.0, Interaktio.EI);
    }
    
    /** Arvontakonstruktori. Arpoo useat parametrit järkevähköille väleille.
     * nimeä ei arvota, eikä maksimikonsentraatiota. Oma interaktio arvotaan toistaiseksi.
     * 
     * @param nimi 
     * @param random konstruktori käyttää metodeita, joille se antaa Random-olion.
     */
    
    public Aine(String nimi, Random random){
        this.nimi = nimi;
        this.interaktiot = new HashMap<Aine, Interaktio>();
        this.geeni = random.nextBoolean();
        this.eritettava = eritetaanko(random);
        this.konsentraatio = 0;
        this.maksimikonsentraatio = 10.0;
        this.tuotto = isompi(random);
        this.hajotus = pienempi(this.tuotto, random);
        this.kynnysarvo = random.nextDouble();
        omaInteraktio(Interaktio.EI);
    }
    
    /** Aineen tyypin arpominen, eritettäviä vähemmän joten 20% tn saada eritettävä aine
     * 
     * @param random tarvitaan arpomiseen, annettu jo konstruktorille parametrina
     * @return boolean, joka kertoo onko aine eritettävä
     */
    private boolean eritetaanko(Random random){ //randomgenerointi tekee luokasta aika sotkuisen..
        if (random.nextDouble() < 0.2){
            return true;
        }else{
            return false;
        }
    }
    /** Tuottoarvon arpominen, alaraja, jotta tuotto todennäköisesti ei kauhean hidasta
     * 
     * @param random tarvitaan arpomiseen
     * @return luku, joka on isompi kuin 0.3 ja alle 1
     */
    private double isompi(Random random){
        double luku = 0.0;
        while (luku < 0.3){
            luku = random.nextDouble();
        }
        return luku;
    }
    
    /**Hajotusarvon arpominen, luvulla yläraja, jotta tuotto todennäköisesti
     * ei kauhean hidasta.
     * 
     * @param tuotto hajotuksen oltava tuottoa pienempi
     * @param random tarvitaan arpomiseen
     * @return luku, joka on pienempi kuin 0.7 ja tuotto.
     */
    private double pienempi(double tuotto, Random random){
        double  luku = 1.0;
        while (luku > tuotto || luku > 0.7){
            luku = random.nextDouble();
        }
        return luku;
    }
    
    /** Konstrukrorin käyttämä metodi, aineen vaikutus itseensä.
     * 
     * @param interaktio konstruktorilla EI, mutta solu voi vaihtaa tämän 
     * arpoessaan uudet interaktiot luomilleen aineille
     */
    private void omaInteraktio(Interaktio interaktio){
        this.setInteraktio(this, interaktio);
    }

//****************Konstruktorileikkiminen loppui********************************

    /**
     * Metodi muuttaa aineen konsentraatiota.
     * Jos geeni on päällä, muutos on tuotto - hajotus, muuten vain -hajotus.
     * konsentraatio ei mene yli maksimikonsentraation, eikä alle nollan.
     */
    public void muutaKonsentraatio(){ // jos geeni on päällä, tuotetaan, muuten hajotetaan.
        if (this.geeni == true){
            if (this.konsentraatio + (this.tuotto - this.hajotus) > this.maksimikonsentraatio){
                this.konsentraatio = this.maksimikonsentraatio;
            }else{
                this.konsentraatio += this.tuotto - this.hajotus;
            }
        }else if ((this.konsentraatio - this.hajotus) > 0){
            this.konsentraatio -= this.hajotus;
        }else{
            this.konsentraatio = 0;
        }
    }
    
    /** Lyhyt merkkojonoesitys.
     * 
     * @return Aineen nimi ja konsentraatio
     */
    
    public String konsentraatioString(){
        return this.nimi +": " + String.format( "%.2f", konsentraatio);
    }
    
    /** Kattavahko merkkijonoesitys
     * 
     * @return Kahdella rivillä geenin päällä/poissaolo, aineen tyyppi, sekä 
     * konsentraatio, tuotto ja hajotus
     */
    
    @Override
    public String toString(){
        String status;
        if (this.geeni == true){
            status = "Geeni päällä";
        }else{
            status = "Geeni ei päällä";
        }
        String eritys;
        if (this.eritettava == true){
            eritys = "Eritetään";
        }else{
            eritys = "Solunsisäinen aine";
        }
        return this.nimi + ": " + status + ". " + eritys + ". \n" +
                "Konsentraatio: " + String.format( "%.2f", konsentraatio) +
                ". Tuotto: " + String.format( "%.2f", tuotto )+
                ". Hajotus: " +String.format( "%.2f",  hajotus);
    }
    
//****************Seuraavaksi miljoonittain gettereitä/settereitä***************

    public boolean getGeeni() {
        return geeni;
    }

    public void setGeeni(boolean geeni) {
        this.geeni = geeni;
    }

    public String getNimi() {
        return nimi;
    }

    public boolean isEritettava() {
        return eritettava;
    }

    public void setEritettava(boolean eritettava) {
        this.eritettava = eritettava;
    }

    public double getKonsentraatio() {
        return konsentraatio;
    }

    public void setKonsentraatio(double konsentraatio) {
        this.konsentraatio = konsentraatio;
    }
    
    public void setInteraktio(Aine aine, Interaktio interaktio){ //jonkun muun aineen vaikutus
        interaktiot.put(aine,interaktio);
    }
    
    public HashMap<Aine, Interaktio> getInteraktiot() {
        return interaktiot;
    }
    
    public Interaktio getInteraktio(Aine aine){
        return this.interaktiot.get(aine);
    }

    public double getKynnysarvo() {
        return kynnysarvo;
    }

    public void setKynnysarvo(double kynnysarvo) {
        this.kynnysarvo = kynnysarvo;
    }
    
}
