/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testauksia;

import geenimato.luokat.Ymparisto;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author henriikka
 */
public class YmparistoTest { //TODO mieti, mitä ympäristö oikeasti tekee
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
    
    
    //  add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
