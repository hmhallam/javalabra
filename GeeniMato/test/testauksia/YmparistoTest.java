/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testauksia;

import geenimato.luokat.Solu;
import geenimato.luokat.Ymparisto;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author henriikka
 */
public class YmparistoTest {
    private Ymparisto ymparisto;
    
    public YmparistoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void eiAineitaAlussa(){
        //assertTrue(ymparisto.getAineet().isEmpty());
    }
    
    @Test
    public void AineitaOnKunAnnetaan(){ //testi kuuluu solun testeihin
        //Solu solu = new Solu(9);
        //ymparisto.setAineet(solu.getAineet());
        //assertTrue(ymparisto.getAineet().size() == 9);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
