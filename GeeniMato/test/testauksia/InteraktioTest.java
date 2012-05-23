/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testauksia;

import geenimato.luokat.Interaktio;
import org.junit.*;
import static org.junit.Assert.*;



/**
 *
 * @author henriikka
 */
public class InteraktioTest {
    
    public InteraktioTest() {
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
    public void toimiikoToString(){
        assertTrue(Interaktio.INHIBITIO.toString().equals("X"));
        assertTrue(Interaktio.AKTIVAATIO.toString().equals("A"));
        assertTrue(Interaktio.EI.toString().equals(" "));
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
