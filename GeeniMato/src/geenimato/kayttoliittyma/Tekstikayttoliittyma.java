/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.kayttoliittyma;

import geenimato.luokat.Aine;
import geenimato.luokat.Interaktio;
import geenimato.luokat.Solu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author hmhallam
 */
public class Tekstikayttoliittyma {
    
    private Scanner lukija;
    private Solu solu;
    private Datankasittelija kasittelija;
    
    public Tekstikayttoliittyma(Scanner lukija){
        this.lukija = lukija;
    }
    
    public void kaynnista(){
        System.out.println(alkunakyma());
        while(true){
            String komento = lukija.nextLine();
            if (komento.equals("lopeta")) {
                break;
            }
            
            hoidaSolunLuonti(komento);
            this.kasittelija = new Datankasittelija(this.solu);
            muokkaus();
            aikaaEteenPain();
            plottaa();
        }
    }
    
    private String alkunakyma(){
        StringBuilder kasaaja = new StringBuilder();
        kasaaja.append("Valitse, millaisen solun haluat luoda:");
        kasaaja.append("\n");
        kasaaja.append("\n");
        kasaaja.append("Kirjoita [arvottu], jos et halua määritellä ominaisuuksia manuaalisesti.");
        kasaaja.append("\n");
        kasaaja.append("Kirjoita [manuaalinen], jos haluat lisätä aineita yksi kerrallaan");
        kasaaja.append("\n");
        
        return kasaaja.toString();
    }
    
    private void hoidaSolunLuonti(String komento){
        if (komento.equals("arvottu")){
            arvotaan();
        }else if (komento.equals("manuaalinen")){
            manuaalinen();
        }else{
            System.out.println("Et kirjoittanut oikeaa komentoa..");
            System.out.println("Vaihtoehdot: \n[arvottu], luo solun jossa arvotut ominaisuudet"
                    + "\n[manuaalinen], luo solun kysellen ominaisuuksia");
            String uusiKomento = lukija.nextLine();
            hoidaSolunLuonti(uusiKomento);
        }
    }
    
    private void arvotaan(){
        System.out.println("Montako ainetta? (kokonaisluku)"); //TODO testaa syötteen oikeellisuus
        int luku = Integer.parseInt(lukija.nextLine());
        this.solu = new Solu(luku);
        System.out.println(solu.toString());
        System.out.println(solu.interaktioTaulukko());
        
    }
    
    private void manuaalinen(){ //testaa kaikkien syötteiden oikeellisuus
        this.solu = new Solu(0);
    
        while(true){
            System.out.println("Anna nimi: ");
            String nimi = lukija.nextLine();
            System.out.println("Onko geeni päällä? (true/false): ");
            boolean geeni = Boolean.valueOf(lukija.nextLine());
            System.out.println("Eritetäänkö ainetta solusta ympäristöön? (true/false): ");
            boolean eritys = Boolean.valueOf(lukija.nextLine());
            System.out.println("Tuottonopeus (0.0-10.0): ");
            double tuotto = Double.valueOf(lukija.nextLine());
            System.out.println("Hajotusnopeus (0.0-10.0): ");
            double hajotus = Double.valueOf(lukija.nextLine());
            System.out.println("Kynnysarvo (0.0-10.0): ");
            double kynnys = Double.valueOf(lukija.nextLine());
            System.out.println("Ineraktio itsensä kanssa: ");
            Interaktio interaktio = Interaktio.valueOf(lukija.nextLine());
            
            solu.lisaaAine(new Aine(nimi, geeni, eritys, tuotto, hajotus, kynnys, interaktio));
            
            System.out.println("Haluatko lisätä vielä aineita? (kyllä/ei)");
            if (lukija.nextLine().equals("ei")){
                break;
            }
        }
            kysyInteraktiot();
            System.out.println(solu.toString());
            System.out.println(solu.interaktioTaulukko()); 
        }
       
    private void kysyInteraktiot(){
        ArrayList<Aine> aineet = this.solu.getAineet();
        for (Aine a : aineet){
            for (Aine b : aineet){
                if (a.equals(b) == false){
                    System.out.println("Miten " + b.getNimi() + "vaikuttaa aineeseen " + a.getNimi() + "?: ");
                    Interaktio vaikutus = Interaktio.valueOf(lukija.nextLine());
                    a.setInteraktio(b, vaikutus);
                }
            }
        }
    }
    
    public void muokkaus(){
        System.out.println("Haluatko muokata jonkin aineen ominaisuuksia? (kyllä/ei)");
        String komento = lukija.nextLine();
        while (true){
            if (komento.equals("ei")) {
                break;
            }else{
                HashMap<String, Aine> map = solu.nimiMap();
                System.out.println("Anna muokattavan aineen nimi: "); 
                String nimi = lukija.nextLine();
                Aine muokattava = map.get(nimi);
                mitaMuokataan(muokattava);
            }
        }
    }
    
    private void mitaMuokataan(Aine aine){
        System.out.println("Mitä ominaisuutta haluat muokata?\n"
                + "");
    }

    public void aikaaEteenPain(){
        System.out.println("Montako aika-askelta?: ");
        int luku = Integer.parseInt(lukija.nextLine());
        System.out.println("kuinka usein printataan konsentraatiot (2 = joka toinen jne): ");
        int valiaikatieto = Integer.parseInt(lukija.nextLine());
        int i = 0;
        while(i < luku){
            this.solu.elaAikaYksikko();
            this.kasittelija.paivita();
            if (i%valiaikatieto == 0){
                System.out.println(this.solu.konsentraatioStringit());
            }
            i++;
        }
        System.out.println(solu.toString());
    }
    
    public void plottaa(){
        Plotti plotti = new Plotti("kokeillaan", kasittelija);
        plotti.pack();
        RefineryUtilities.centerFrameOnScreen(plotti);
        plotti.setVisible(true);
    }
    
}
