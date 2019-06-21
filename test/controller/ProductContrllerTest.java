
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arith Alexis Villalba Bravo
 */
public class ProductContrllerTest {
    
    public ProductContrllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of actionPerformed method, of class ProductController.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent ae = null;
        ProductContrller instance = null;
        instance.actionPerformed(ae);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyTyped method, of class ProductController.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent ke = null;
        ProductContrller instance = null;
        instance.keyTyped(ke);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyPressed method, of class ProductController.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent ke = null;
        ProductContrller instance = null;
        instance.keyPressed(ke);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyReleased method, of class ProductController.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent ke = null;
        ProductContrller instance = null;
        instance.keyReleased(ke);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
