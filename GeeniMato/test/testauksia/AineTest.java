/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testauksia;

import geenimato.luokat.Aine;
import geenimato.luokat.Interaktio;
import geenimato.luokat.Solu;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author henriikka
 */
public class AineTest {
    private Solu solu;
    
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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konsentraatioEiYliMaksimin(){
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
    public void konsentraatioEiNegatiivinen(){
        Aine aine = new Aine("nimi", true, false, 1.0, 2.0, 0.3, Interaktio.EI);
        solu.lisaaAine(aine);
        assertTrue(aine.getKonsentraatio() == 0.0);
        solu.elaAikaYksikko();
        assertTrue(aine.getKonsentraatio() == 0.0);
    }
    
    @Test
    public void konsentraatioPieneneeKunGeeniPois(){
        Aine aine = new Aine("nimi", false, false, 1.0, 4.0, 0.3, Interaktio.EI);
        aine.setKonsentraatio(5.0);
        solu.lisaaAine(aine);
        assertTrue(aine.getKonsentraatio() == 5.0);
        solu.elaAikaYksikko();
        solu.elaAikaYksikko();
        assertTrue(aine.getKonsentraatio() == 0.0);  
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
