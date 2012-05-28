/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testauksia;

import geenimato.luokat.Aine;
import geenimato.luokat.Interaktio;
import geenimato.luokat.Solu;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author henriikka
 */
public class SoluTest {
    private Solu solu;
    private ArrayList<Aine> aineet;
    
    public SoluTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        this.solu = new Solu(10);
        this.aineet = solu.getAineet();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void aikaAlussaNolla(){
        assertTrue(solu.getAika() == 0);
    }
    
    @Test
    public void nimetOikein(){
        assertTrue(aineet.get(0).getNimi().equals("Aine1"));
        assertTrue(aineet.get(1).getNimi().equals("Aine2"));
        assertTrue(aineet.get(2).getNimi().equals("Aine3"));
        assertTrue(aineet.get(3).getNimi().equals("Aine4"));
    }
    
    @Test 
    public void oikeaMaaraAineita(){
        assertTrue(aineet.size() == 10);
    }
    
    @Test
    public void kaikillaInteraktiot(){
        boolean loytyykoNull = false;
        for (Aine a : aineet){
            for (Aine b : aineet){
                if (a.getInteraktio(b) == null){
                    loytyykoNull = true;
                }
            }
        }
        assertFalse(loytyykoNull);
    }
    
    @Test
    public void kaikkiaInteraktioitaOn(){
        int inhibitiot = 0;
        int aktivaatiot = 0;
        int eit = 0;
        for (Aine a : aineet){
            for (Aine b : aineet){
                if (a.getInteraktio(b) == Interaktio.EI){
                    eit++;
                }else if(a.getInteraktio(b) == Interaktio.AKTIVAATIO){
                    aktivaatiot++;
                }else if(a.getInteraktio(b) == Interaktio.INHIBITIO){
                    inhibitiot++;
                }
            }
        }
        assertTrue(inhibitiot != 0 && aktivaatiot != 0 && eit != 0);
    }
    
    @Test
    public void OmatInteraktiotVaihtelevat(){
        int inhibitiot = 0;
        int aktivaatiot = 0;
        for (Aine a : aineet){
            if(a.getInteraktio(a) == Interaktio.AKTIVAATIO){
                aktivaatiot++;
            }else if(a.getInteraktio(a) == Interaktio.INHIBITIO){
                inhibitiot++;
            }
        }
        assertTrue(inhibitiot != 0 && aktivaatiot != 0);
    }
    
    @Test
    public void InteraktioidenSuhteet(){
        //en tee tätä vielä, sillä haluan vaihdella suhteita
    }
    
    @Test
    public void kopioiUudetInstanssit(){ //TODO tän ei kuuluisi vielä toimia
        Solu solu2 = new Solu(0);
        Aine aine = new Aine("nimi", false, true, 4.0, 3.0, 0.3, Interaktio.EI);
        solu.lisaaAine(aine);
        ArrayList<Aine> kopiot = solu.kopioiEritettavat();
        assertTrue(kopiot.size() == 1);
        assertFalse(solu2.getAineet().get(0).equals(kopiot.get(0)));
        
    }
    
    @Test
    public void kaikkiMapissa(){
        HashMap<String, Aine> map = solu.nimiMap();
        assertTrue(map.size() == 10);
    }
    
    @Test
    public void aineLisattyOikein(){ 
        Aine aine = new Aine("lisatty");
        solu.lisaaAine(aine);
        boolean loytyykoNull = false;
        for (Aine a : solu.getAineet()){
            for (Aine b : solu.getAineet()){
                if (a.getInteraktio(b) == null){
                    loytyykoNull = true;
                }
            }
        }
        assertFalse(loytyykoNull);
        assertTrue(solu.getAineet().size() == 11);
    }
    
    @Test
    public void yhdenGeeninStatusPalautusarvo(){ //testataan siis apumetodia
        
    }
    
    @Test
    public void geenistatusMuuttuuOikein(){ //tähän paljon eri vaihtoehtoja..
        
    }
    
    @Test
    public void proteiininTuotto(){
        int paalla = 0;
        for (Aine a : aineet){
            if (a.getGeeni()){
                paalla++;
            }
        }
        solu.elaAikaYksikko();
        int muuttuneet = 0;
        for (Aine a : solu.getAineet()){
            if (a.getKonsentraatio() != 0.0){
                muuttuneet++;
            }
        }
        assertTrue(paalla-muuttuneet == 0);
        
    }
//    @Test
//    public void InteraktiotaulukonKoko(){ //mitenhän tätä testais
//        
//    }
    
    
    // add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
