/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testauksia;

import geenimato.luokat.Geeni;
import geenimato.luokat.Interaktio;
import geenimato.luokat.Proteiini;
import geenimato.luokat.Solu;
import java.util.ArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;

/**
 *
 * @author henriikka
 */
public class NewJavaUnitTest {
    private Geeni geeni;
    private Solu solu;
    
    public NewJavaUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        this.geeni = new Geeni();
        this.geeni.setKynnysarvo(10.0);
        this.geeni.setProteiini(new Proteiini(6.0, 2.0));
        this.solu = new Solu(0);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alussaNolla(){
        this.geeni.setStatus(true);
        this.solu.lisaaGeeni(this.geeni);
        assertTrue(this.geeni.getKonsentraatio() == 0.0);
    }
    
    @Test
    public void eiMeneYliMaksimin(){  
        this.geeni.setStatus(true);
        this.solu.lisaaGeeni(this.geeni);
        int i = 20;
        while (i > 0){
            this.solu.elaAikaYksikko();
            i--;
        }
        assertTrue(this.geeni.getKonsentraatio() == 50.0);
    }
    
    @Test
    public void pysyyNollassaJosGeeniEiPaalla(){
        this.geeni.setStatus(false);
        this.solu.lisaaGeeni(this.geeni);
        int i = 20;
        while (i > 0){
            this.solu.elaAikaYksikko();
            i--;
        }
        assertTrue(this.geeni.getKonsentraatio() == 0.0);
    }
    
    
    @Test
    public void InhibitioToimiiItselle(){
        this.geeni.setStatus(true);
        this.geeni.setInteraktio(geeni, Interaktio.INHIBITIO);
        this.solu.lisaaGeeni(this.geeni);
        assertTrue(this.geeni.getKonsentraatio() == 0.0);
        this.solu.elaAikaYksikko();
        assertTrue(this.geeni.getKonsentraatio() == 4.0);
        this.solu.elaAikaYksikko();
        assertTrue(this.geeni.getKonsentraatio() == 8.0);
        assertTrue(this.geeni.getStatus());
        this.solu.elaAikaYksikko();
        assertTrue(this.geeni.getKonsentraatio() == 12.0);
        assertTrue(this.geeni.getStatus());
        this.solu.elaAikaYksikko();
        assertTrue(this.geeni.getKonsentraatio() == 10.0);
        assertFalse(this.geeni.getStatus());
        this.solu.elaAikaYksikko();
        assertTrue(this.geeni.getKonsentraatio() == 8.0);
        this.solu.elaAikaYksikko();
        assertTrue(this.geeni.getKonsentraatio() == 6.0);
        this.solu.elaAikaYksikko();
        assertTrue(this.geeni.getKonsentraatio() == 4.0);
        this.solu.elaAikaYksikko();
        assertTrue(this.geeni.getKonsentraatio() == 2.0);
        this.solu.elaAikaYksikko();
        assertTrue(this.geeni.getKonsentraatio() == 0.0);
        this.solu.elaAikaYksikko();
        assertTrue(this.geeni.getKonsentraatio() == 0.0);
    }
    
    @Test
    public void onnistuukoUseanGeeninSolu(){
        Solu solu2 = new Solu(5);
        ArrayList<Geeni> geenit = solu2.getGenomi();
        assertTrue(geenit.size() == 5); 
    }
    
    @Test
    public void tyhjaGeeni(){
        Solu solu2 = new Solu(1);
        Geeni geeni3 = solu2.getGenomi().get(0);
        assertTrue(geeni3.toString().equals("Geeni on poissa päältä. Kynnysarvo on 0.00"));
    }
    
    @Test
    public void interaktioToimii(){
        Geeni geeni2 = new Geeni();
        Geeni geeni3 = new Geeni();
        
        this.geeni.setInteraktio(this.geeni, Interaktio.INHIBITIO);
        this.geeni.setInteraktio(geeni2, Interaktio.EI);
        this.geeni.setInteraktio(geeni3, Interaktio.AKTIVAATIO);
        
        assertTrue(geeni.getInteraktio(geeni) == Interaktio.INHIBITIO
                && geeni.getInteraktio(geeni2) == Interaktio.EI
                && geeni.getInteraktio(geeni3) == Interaktio.AKTIVAATIO);
        
       
        
    }
    
    @Test
    public void kaksiDesimaalia(){
       assertTrue(geeni.toString().equals("Geeni on poissa päältä. Kynnysarvo on 10.00")); 
    }
    
    @Test
    public void toStringToimii(){
        Proteiini proteiini = geeni.getProteiini();
        assertTrue(proteiini.toString().equals("Tuotto: 6.00. Hajotus: 2.00. Maksimi: 50.00. Konsentraatio: 0.00"));
        
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
