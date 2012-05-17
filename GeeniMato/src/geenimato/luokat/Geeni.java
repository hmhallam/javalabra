/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.luokat;

import java.util.HashMap;

/**
 *
 * @author henriikka
 */
public class Geeni {
    
    private boolean status; //onko geeni päällä vai pois
    private HashMap<Geeni, Interaktio> interaktiot; //kaikkien geenien vaikutukset tähän geeniin.
    private double kynnysarvo; //milloin ineraktiot toteutuvat
    private Proteiini proteiini; //geenin tuote
   
    public Geeni(){
        this.status = false;
        this.interaktiot = new HashMap<Geeni, Interaktio>();
        omaInteraktio();
        this.kynnysarvo = 0.0;
        this.proteiini = new Proteiini(0.0, 0.0);
        
    }
    
    public void setStatus(boolean b){
        this.status = b;
    }
    
    public boolean getStatus(){
        return this.status;
    }
    private void omaInteraktio(){
        this.setInteraktio(this, Interaktio.EI);
    }
    
    public void setInteraktio(Geeni geeni, Interaktio interaktio){ //jonkun muun geenin vaikutus tähän
        interaktiot.put(geeni,interaktio);
    }
    
    public Interaktio getInteraktio(Geeni geeni){//miten joku muu geeni vaikuttaa tähän geeniin
        return interaktiot.get(geeni);
    }
    
    public HashMap<Geeni, Interaktio> getInteraktiot(){
        return this.interaktiot;
    }
    
    public Proteiini getProteiini(){
        return this.proteiini;
    }
    
    public void setProteiini(Proteiini proteiini){
        this.proteiini = proteiini;
    }

    public void setKynnysarvo(double kynnysarvo) {
        this.kynnysarvo = kynnysarvo;
    }
    
    public double getKynnysarvo(){
        return this.kynnysarvo;
    }
    
    public double getKonsentraatio(){
        return this.proteiini.getKonsentraatio();
    }
    
    public void tuotaProteiinia(){
        this.proteiini.muutaKonsentraatio(this.status);
    }
    
    @Override
    public String toString(){
        String tila = "poissa päältä. ";
        if (this.status == true){
           tila = "päällä. ";
        }
        return "Geeni on " + tila + "Kynnysarvo on " + String.format("%.2f", this.kynnysarvo);
    }
}
