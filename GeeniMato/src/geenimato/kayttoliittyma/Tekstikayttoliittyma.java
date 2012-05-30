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
                System.exit(0);
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
        kasaaja.append("Kirjoita [lopeta], jos haluat lopettaa ohjelman suorituksen");
        kasaaja.append("\n");
        
        return kasaaja.toString();
    }
    
    private void hoidaSolunLuonti(String komento){
        if (komento.equals("lopeta")){
            System.exit(0);
        }if (komento.equals("arvottu")){
            arvotaan();
        }else if (komento.equals("manuaalinen")){
            manuaalinen();
        }else{
            System.out.println("Et kirjoittanut oikeaa komentoa..");
            System.out.println("Vaihtoehdot: \n[arvottu], luo solun jossa arvotut ominaisuudet"
                    + "\n[manuaalinen], luo solun kysellen ominaisuuksia"
                    +"\n[lopeta], lopettaa ohjelman suorituksen");
            String uusiKomento = lukija.nextLine();
            hoidaSolunLuonti(uusiKomento);
        }
    }
    
    private void arvotaan(){
        System.out.println("Montako ainetta? (kokonaisluku)"); //TODO testaa syötteen oikeellisuus
        try {
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku >= 0){
                this.solu = new Solu(luku);
                System.out.println(solu.toString());
                System.out.println(solu.interaktioTaulukko()); 
            }else{
                System.out.println("Annoit negatiivisen luvun, ei käy semmoinen");
                arvotaan();
            }
            
        }catch (Exception e){
            System.out.println("Kysyttiin kokonaislukua..");
            arvotaan();
        }
        
        
    }
    
    private void manuaalinen(){ 
        this.solu = new Solu(0);
        try {
            while(true){
            Aine aine = kyseleTiedot();
            solu.lisaaAine(aine);
            System.out.println("Haluatko lisätä vielä aineita? (kyllä/ei)");
            
            if (lukija.nextLine().equals("ei")){
                break; 
            }
            }
        } catch (Exception e){
            System.out.println("Vääränlainen syöte " + e);
            manuaalinen(); //TODO nyt vain keskeytetään väärän syötteen kohdalla ja mennään takas alkuun
        }
            kysyInteraktiot();
            System.out.println(solu.toString());
            System.out.println(solu.interaktioTaulukko()); 
        }
    
    private Aine kyseleTiedot(){
        String nimi = kysyNimi();
        boolean geeni = geeniStatus();
        boolean eritys = eritetaanko();     
        double tuotto = tuottoNopeus();
        double hajotus = hajotusNopeus(tuotto);
        double kynnys = kynnysArvo();  
        Interaktio interaktio = omaInteraktio();
            
        Aine aine = new Aine(nimi, geeni, eritys, tuotto, hajotus, kynnys, interaktio);
        return aine;
    }
    
    private String kysyNimi(){ //voisi tarkistaa, onko solussa jo samannimistä..
        System.out.println("Anna nimi: ");
        String komento = lukija.nextLine();
        if (komento.equals("lopeta")){
                System.exit(0);
            }
        for (Aine aine : solu.getAineet()){
            if (komento.equals(aine.getNimi())){
                System.out.println("Solussa on jo saman niminen aine.");
                kysyNimi();
            } 
        }
        return lukija.nextLine(); 
    }
    
    private boolean geeniStatus(){
        System.out.println("Onko geeni päällä? (kyllä/ei): ");
        String komento = lukija.nextLine();
        if (komento.equals("kyllä")){
            return true;
        }
        if (komento.equals("ei")){
            return false;
        }
        if (komento.equals("lopeta")){
                System.exit(0);
        }
            System.out.println("piti olla kyllä tai ei");
            geeniStatus();
            return false;
    }     
    
    
    private boolean eritetaanko(){
        System.out.println("Eritetäänkö ainetta solusta ympäristöön? (kyllä/ei): ");
        String komento = lukija.nextLine();
        if (komento.equals("kyllä")){
            return true;
        }
        if (komento.equals("ei")){
            return false;
        }
        if (komento.equals("lopeta")){
                System.exit(0);
        }
            System.out.println("piti olla kyllä tai ei");
            geeniStatus();
            return false;
    }
    
    private double tuottoNopeus(){ // miksi tää haluaa noi returnit, ja ei tää muutenkaa toimi..
        System.out.println("Tuottonopeus (0.0-10.0): ");
        String komento = lukija.nextLine();
        try {
            if(komento.equals("lopeta")){
                System.exit(0);
            }
            if (Double.valueOf(komento) >= 0.0 && Double.valueOf(komento) <= 10.0){
                return Double.valueOf(komento); 
            }
                System.out.println("Annoit vääränkokoisen arvon");
                tuottoNopeus();
                return 0.0;
        }catch (Exception e){
            System.out.println("Syötteen on oltava numero");
            tuottoNopeus();
            return 0.0;
        }
    }
            
    private double hajotusNopeus(double tuotto){
        double annettuTuotto = tuotto;
        System.out.println("Tuottonopeutta pienempi hajotusnopeus (0.0-10.0): ");
        String komento = lukija.nextLine();
        try {
            if(komento.equals("lopeta")){
                System.exit(0);
            }
            if (Double.valueOf(komento) >= 0.0 && Double.valueOf(komento) <= 10.0 && Double.valueOf(komento) < annettuTuotto){
                return Double.valueOf(komento); 
            }
            System.out.println("Annoit vääränkokoisen arvon");
            hajotusNopeus(annettuTuotto);
            return 0.0;  
        }catch (Exception e){
            System.out.println("Syötteen on oltava numero");
            hajotusNopeus(annettuTuotto);
            return 0.0;
        }
    }
    
    private double kynnysArvo(){
        System.out.println("Kynnysarvo (0.0-10.0): ");
        String komento = lukija.nextLine();
        try {
            if(komento.equals("lopeta")){
                System.exit(0);
            }
            if (Double.valueOf(komento) >= 0.0 && Double.valueOf(komento) <= 10.0){
                return Double.valueOf(komento); 
            }
            System.out.println("Annoit vääränkokoisen arvon");
            tuottoNopeus();
            return 0.0;
            
        }catch (Exception e){
            System.out.println("Syötteen on oltava numero");
            tuottoNopeus();
            return 0.0;
        }
    }
    
    private Interaktio omaInteraktio(){
        System.out.println("Ineraktio itsensä kanssa: ");
        String komento = lukija.nextLine();
        try {
             if(komento.equals("lopeta")){
                System.exit(0);
            }           
            return Interaktio.valueOf(komento);  
        }catch (Exception e){
            System.out.println("Et antanut interaktiota, vaihtoehdot: [AKTIVAATIO], [INHIBITIO], [EI]");
            omaInteraktio();
            return Interaktio.EI;
        }
    }
    
       
    private void kysyInteraktiot(){ //TODO aika paljon ny looppeja.. apumetodi?
        ArrayList<Aine> aineet = this.solu.getAineet();
        for (Aine a : aineet){
            for (Aine b : aineet){
                if (a.equals(b) == false){
                    System.out.println("Miten " + b.getNimi() + "vaikuttaa aineeseen " + a.getNimi() + "?: ");
                    try {
                        Interaktio vaikutus = Interaktio.valueOf(lukija.nextLine());
                        a.setInteraktio(b, vaikutus);
                    }catch (Exception e){
                       Interaktio vaikutus = Interaktio.EI;
                       a.setInteraktio(b, vaikutus);
                    }
                }
            }
        }
    }
    
    public void muokkaus(){
        System.out.println("Haluatko muokata jonkin aineen ominaisuuksia? (kyllä/ei)");
        String komento = lukija.nextLine();
        if (komento.equals("lopeta")){
                System.exit(0);
            }
        while (true){
            if (komento.equals("ei")) {
                break;
            }else if (komento.equals("kyllä")){
                HashMap<String, Aine> map = solu.nimiMap();
                System.out.println("Anna muokattavan aineen nimi: "); 
                String nimi = lukija.nextLine();
                Aine muokattava = map.get(nimi);
                mitaMuokataan(muokattava);
            }else if (komento.equals("lopeta")){
                System.exit(0);
            }else{
                System.out.println("Ei ole validi syöte nyt ");
                muokkaus();
            }
        }
    }
    
    private void mitaMuokataan(Aine aine){ 
        System.out.println("Mitä ominaisuutta haluat muokata?\n"
                + "Geenistatus\n"
                + "Eritettävyys\n"
                + "Tuottonopeus\n"
                + "Hajotusnopeus\n"
                + "Kynnysarvo\n"
                + "Intertaktio\n");
        String komento = lukija.nextLine();
        if (komento.equals("lopeta")){
                System.exit(0);
        }
        if (komento.equals("Geenistatus")){
           aine.setGeeni(geeniStatus()); 
        }
        if (komento.equals("Eritettävyys")){
            aine.setEritettava(eritetaanko());
        }
        if (komento.equals("Tuottonopeus")){
            aine.setTuotto(tuottoNopeus());
        }
        if (komento.equals("Hajotusnopeus")){
            aine.setHajotus(hajotusNopeus(aine.getTuotto()));
        }
        if (komento.equals("Kynnysarvo")){
            aine.setKynnysarvo(kynnysArvo());
        }
        if (komento.equals("Intertaktio")){
           //TODO pitää kysellä, minkä aineen kanssa interaktoidaan 
        }
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
        Plotti plotti = new Plotti("loppuplot", kasittelija);
        plotti.pack();
        RefineryUtilities.centerFrameOnScreen(plotti);
        plotti.setVisible(true);
    }
    
}
