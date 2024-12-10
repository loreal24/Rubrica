/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author frank
 */
public class PhoneCheckerTest {
    
    public PhoneCheckerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isValid method, of class PhoneChecker.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        String phoneNumber = "abcdefghijklm";
        PhoneChecker instance = new PhoneChecker();
        boolean expResult = false;
        boolean result = instance.isValid(phoneNumber);
        assertEquals(expResult, result);
    }
     @Test
    public void testIsValid2() {
        System.out.println("isValid");
        String phoneNumber = "#&%";
        PhoneChecker instance = new PhoneChecker();
        boolean expResult = false;
        boolean result = instance.isValid(phoneNumber);
        assertEquals(expResult, result);
    }
    
}
