/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.kayttoliittyma;

import geenimato.luokat.Aine;
import geenimato.luokat.Interaktio;
import geenimato.luokat.Solu;
import java.util.Scanner;

/**
 *
 * @author hmhallam
 */
public class Tekstikayttoliittyma {
    
    private Scanner lukija;
    
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
            
            hoidaKomento(komento);
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
    
    private void hoidaKomento(String komento){
        if (komento.equals("arvottu")){
            arvotaan();
        }else if (komento.equals("manuaalinen")){
            manuaalinen();
        }
    }
    
    private void arvotaan(){
        System.out.println("Montako ainetta? (kokonaisluku)");
        int luku = Integer.parseInt(lukija.nextLine());
        Solu solu = new Solu(luku);
        System.out.println(solu.toString());
        System.out.println(solu.interaktioTaulukko());
        
    }
    
    private void manuaalinen(){
        Solu solu = new Solu(0);
    
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
        System.out.println(solu.toString());
        System.out.println(solu.interaktioTaulukko()); //TODO myöhemmin lisättävien vaikutukset aiemmin lisättyihin null
    }
    
}
