/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testauksia;

import geenimato.luokat.Aine;
import geenimato.luokat.Interaktio;
import geenimato.luokat.Solu;
import java.util.Random;
import static org.junit.Assert.assertTrue;
import org.junit.*;

/**
 *
 * @author henriikka
 */
public class AineTest { //TODO magic numberit pois täältäki
    private Solu solu;
    private Random random;
    
    public AineTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        this.solu = new Solu(0);
        this.random = new Random();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void parametrillinenKonstruktori(){
        Aine aine = new Aine("nimi", true, false, 3.0, 0.1, 0.3, Interaktio.AKTIVAATIO); //testaa et nää on olemassa.. tjs tee vimmeiseksi valmiiks
        
    }
    
    @Test
    public void randomGeeni(){
        int i = 0;
        double paalla = 0;
        double poissa = 0;
        while (i < 10000){
            Aine aine2 = new Aine("nimi", random);
            if (aine2.getGeeni() == true){
                paalla++;
            }else if (aine2.getGeeni() == false){
                poissa++;
            }
            i++;
        }
        double luku = paalla/poissa;
        assertTrue(luku < 1.1 && luku > 0.9); 
    }  
        
     @Test
     public void randomEritys(){
        int j = 0;
        double sisaiset = 0;
        double ulkoiset = 0;
        while (j < 10000){
            Aine aine3 = new Aine("nimi", random);
            if (aine3.isEritettava() == true){
                ulkoiset++;
            }else{
                sisaiset++;
            }
            j++;
        }
        double suhde = sisaiset/ulkoiset;
        assertTrue(suhde < 4.5 && suhde > 3.5);
     }
     
    @Test
    public void yksittainenInteraktio(){ //TODO eri konstruktoreille eri testit
        Aine aine1 = new Aine("nimi1");
        assertTrue(aine1.getInteraktio(aine1).equals(Interaktio.EI));
        Aine aine2 = new Aine("nimi2", random);
        assertTrue(aine1.getInteraktio(aine1).equals(Interaktio.EI));
        aine1.setInteraktio(aine1, Interaktio.INHIBITIO);
        aine2.setInteraktio(aine2, Interaktio.AKTIVAATIO);
        assertTrue(aine1.getInteraktio(aine1).equals(Interaktio.INHIBITIO));
        assertTrue(aine2.getInteraktio(aine2).equals(Interaktio.AKTIVAATIO));
        Aine aine3 = new Aine("nimi", true, false, 3.0, 0.1, 0.3, Interaktio.AKTIVAATIO);
        assertTrue(aine3.getInteraktio(aine3).equals(Interaktio.AKTIVAATIO));
    }
     
    @Test
    public void randomTuottoVali(){
        int i = 0;
        while (i < 1000){
            Aine aine = new Aine("nimi", random);
            assertTrue(aine.getTuotto() >= 0.3 && aine.getTuotto() < 1.0);
            i++;
        }
    }
    
    @Test
    public void randomHajotusVali(){
        int i = 0;
        while (i < 1000){
            Aine aine = new Aine("nimi", random);
            assertTrue(aine.getHajotus() <= 0.7 &&
                    aine.getHajotus() >= 0.0 &&
                    (aine.getTuotto()-aine.getHajotus() >= 0.2));
            i++;
        }
    }
    
//    @Test
//    public void randomKynnys(){ //TODO ei toimi..
//        int i = 0;
//        double yliPuolen = 0;
//        double allePuolen = 0;
//        while (i < 10000){
//            Aine aine = new Aine("nimi", random);
//            if (aine.getKynnysarvo() > 0.5){
//                yliPuolen++;
//            }else if (aine.getKynnysarvo() < 0.5){
//                allePuolen++;
//            }
//            i++;
//        }
//        double luku = yliPuolen/allePuolen;
//        assertTrue(luku < 1.5 && luku > 0.5);
//    }
    
    @Test
    public void parametritonKonstruktori(){ 
        Aine aine = new Aine("nimi");
        assertTrue(aine.getNimi().equals("nimi"));
        assertTrue(aine.getGeeni() == false);
        assertTrue(aine.isEritettava() == false);
        assertTrue(aine.getKonsentraatio() == 0.0);
        assertTrue(aine.getKynnysarvo() <= 10.0 && aine.getKynnysarvo() >= 0.0);
    }
    
    @Test
    public void konsentraatioEiYliMaksimin(){ //konsentraatiotestejä ehkä lisää
        Aine aine = new Aine("nimi", true, false, 3.0, 0.1, 0.3, Interaktio.EI);
        solu.lisaaAine(aine);
        assertTrue(aine.getKonsentraatio() == 0.0);
        solu.elaAikaYksikko();
        assertTrue(aine.getKonsentraatio() == 2.9);
        solu.elaAikaYksikko();
        solu.elaAikaYksikko();
        solu.elaAikaYksikko();
        solu.elaAikaYksikko();
        assertTrue(aine.getKonsentraatio() == 10.0);
    }
    
    @Test
    public void konsentraatioPieneneeKunGeeniPois(){
        Aine aine = new Aine("nimi", false, false, 4.0, 3.0, 0.3, Interaktio.EI);
        aine.setKonsentraatio(5.0);
        solu.lisaaAine(aine);
        assertTrue(aine.getKonsentraatio() == 5.0);
        solu.elaAikaYksikko();
        solu.elaAikaYksikko();
        assertTrue(aine.getKonsentraatio() == 0.0);  
    }
    
    @Test
    public void lyhytMerkkijonoesitys(){
        Aine aine = new Aine("nimi", false, false, 4.0, 3.0, 0.3, Interaktio.EI);
        assertTrue(aine.konsentraatioString().equals("nimi: 0.00"));
    }
    
    // add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
