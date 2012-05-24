/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geenimato.kayttoliittyma;

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
        kasaaja.append("\n");ss
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
        System.out.println("Kirjoita soluun lisättävän aineen parametrit pilkuilla eroteltuna"); //TODO ota selvää miten syöte saadaan ängettyä konstruktoriin..
        while(true){
            
        }
    }
    
}
