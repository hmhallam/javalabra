/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testauksia;

import geenimato.luokat.Solu;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author henriikka
 */
public class SoluTest {
    private Solu solu;
    
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
        this.solu = new Solu(7);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void aikaAlussaNolla(){
        
    }
    
    @Test
    public void nimetOikein(){
        
    }
    
    @Test 
    public void oikeaMaaraAineita(){
        assertTrue(solu.getAineet().size() == 7);
    }
    
    @Test
    public void kaikillaInteraktiot(){
        
    }
    
    @Test
    public void kaikkiaInteraktioitaOn(){
        
    }
    
    @Test
    public void OmatInteraktiotVaihtelevat(){
        
    }
    
    @Test
    public void InteraktioidenSuhteet(){
        
    }
    
    @Test
    public void kopioiUudetInstanssit(){
        
    }
    
    @Test
    public void kaikkiMapissa(){
        
    }
    
    @Test
    public void aineLisattyOikein(){
        
    }
    
    @Test
    public void yhdenGeeninStatusPalautusarvo(){
        
    }
    
    @Test
    public void geenistatusMuuttuuOikein(){ //tähän paljon eri vaihtoehtoja..
        
    }
    
    @Test
    public void proteiininTuotto(){ 
        
    }
    @Test
    public void InteraktiotaulukonKoko(){ 
        
    }
    
    @Test
    public void lyhytMerkkijonoesitys(){ 
        
    }
    
    @Test
    public void pitkaMerkkijonoesitys(){ 
        
    }
    // add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
