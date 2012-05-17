/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.luokat;

/**
 *
 * @author henriikka
 */
public class Proteiini {
    
    private double konsentraatio;
    private double tuotto;
    private double hajotus;
    private double maksimikonsentraatio;
    
    public Proteiini(double tuotto, double hajotus){ //tuoton oltava hajotusta isompi, voisi laittaa tarkistuksen
        this.konsentraatio = 0;
        this.maksimikonsentraatio = 50.0;
        this.tuotto = tuotto;
        this.hajotus = hajotus;
    }
    
    public void muutaKonsentraatio(boolean tuotetaanko){ // jos geeni on päällä, tuotetaan, muuten hajotetaan.
        if (tuotetaanko == true){
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

    public double getHajotus() {
        return hajotus;
    }

    public void setHajotus(double hajotus) {
        this.hajotus = hajotus;
    }

    public double getTuotto() {
        return tuotto;
    }

    public void setTuotto(double tuotto) {
        this.tuotto = tuotto;
    }
    
    public double getKonsentraatio(){
        return this.konsentraatio;
    }
    
    @Override
    public String toString(){
        return "Tuotto: " + String.format("%.2f",this.tuotto) + 
                ". Hajotus: " + String.format("%.2f",this.hajotus) + 
                ". Maksimi: " + String.format("%.2f",this.maksimikonsentraatio) + 
                ". Konsentraatio: " + String.format("%.2f",this.konsentraatio);
    }
    
}
