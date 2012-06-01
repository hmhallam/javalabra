/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.kayttoliittyma;

import geenimato.kayttoliittyma.ikkunat.Alkunakyma;
import geenimato.kayttoliittyma.ikkunat.Manuaalinen;
import geenimato.kayttoliittyma.ikkunat.KysyVaikutukset;
import geenimato.kayttoliittyma.ikkunat.NaytaSolu;
import geenimato.kayttoliittyma.ikkunat.AjoTiedot;
import geenimato.luokat.Aine;
import geenimato.luokat.Interaktio;
import geenimato.luokat.Solu;
import java.util.ArrayList;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author henriikka
 */
public class GUI implements Kayttoliittyma{
    
    private Solu solu;
    private Datankasittelija kasittelija;
    
    private Alkunakyma alku;
    private Manuaalinen manuaalinen;
    private KysyVaikutukset vaikutukset;
    private NaytaSolu tiedot;
    private AjoTiedot ajo;
    
    public GUI(){
        this.alku = new Alkunakyma();
        this.manuaalinen = new Manuaalinen();
        this.vaikutukset = new KysyVaikutukset();
        this.tiedot = new NaytaSolu();
        this.ajo = new AjoTiedot();
    }

    @Override
    public void kaynnista() {
       aloitus();
       naytaSolu();
       this.kasittelija = new Datankasittelija(this.solu);
       int luku = kauankoAjetaan();
       tiedot.setVisible(false);
       aikaaEteenPain(luku);
       
       plottaa();
    }
    
    private void aloitus(){
       alku.setVisible(true);
       while (alku.onkoNappiaPainettu() == false){
           
       }
       if(alku.valittiinManuaalinen()){
           alku.setVisible(false);
           manuaalinen();
       }else{
          arvotaan(alku.ainemaara());
          alku.setVisible(false);
       }
    }
    
    private void manuaalinen(){
        manuaalinen.setVisible(true);
        while (manuaalinen.onkoValmis() == false){   
        }
        this.solu = manuaalinen.getSolu();
        System.out.println(solu);
        System.out.println(solu.interaktioTaulukko());
        manuaalinen.setVisible(false);
        KysyVaikutukset();
        System.out.println(solu);
        System.out.println(solu.interaktioTaulukko());
    }
    
    private void KysyVaikutukset(){ //TODO nyt taulukossa on ennen kyselyä arvottuja interaktioita.
        this.vaikutukset.setVisible(true);
        ArrayList<Aine> aineet = this.solu.getAineet();
        for (Aine a : aineet){
            for (Aine b : aineet){
                if (a.equals(b) == false){
                    vaikutukset.setKysymys("Miten " + b.getNimi() + " vaikuttaa aineeseen " + a.getNimi() + "?: ");
                    while(vaikutukset.nappiaPainettu()==false){
                        
                    }
                    Interaktio vaikutus = vaikutukset.mikaInteraktio();
                    a.setInteraktio(b, vaikutus);
                    vaikutukset.NappiAlas();
                }
            }
        }
        this.vaikutukset.setVisible(false);
    }
    
    private void arvotaan(int ainemaara){
        this.solu = new Solu(ainemaara);
        System.out.println(solu);
        System.out.println(solu.interaktioTaulukko());
    }
    
    private void naytaSolu(){
        tiedot.setTiedot(solu);
        while(tiedot.onkoNappiaPainettu() == false){
        }
        tiedot.setVisible(false);
    }
    
    private int kauankoAjetaan(){
        this.ajo.setVisible(true);
        while(tiedot.onkoNappiaPainettu() == false){
        }
        return ajo.aikaa();  
    }
    
    public void aikaaEteenPain(int luku){
        int i = 0;
        while(i < luku){
            this.solu.elaAikaYksikko();
            this.kasittelija.paivita();
            i++;
        }
    }
    
    public void plottaa(){
        Plotti plotti = new Plotti("Kaikkien solun aineiden konsentraatiot", kasittelija);
        plotti.pack();
        RefineryUtilities.centerFrameOnScreen(plotti);
        plotti.setVisible(true);
    }
    
}
