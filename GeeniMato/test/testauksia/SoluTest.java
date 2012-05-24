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
    public void oikeaMaaraAineita(){
        assertTrue(solu.getAineet().size() == 7);
    }
    
    @Test
    public void kaikillaInteraktiot(){
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
