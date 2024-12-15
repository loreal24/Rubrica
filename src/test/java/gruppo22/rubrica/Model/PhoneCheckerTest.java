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
    private PhoneChecker instance;
    
    public PhoneCheckerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        instance = new PhoneChecker();
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of isValid method, of class PhoneChecker.
     */
    @Test
    public void testNotValidPhoneNumber1() {
        System.out.println("isNotValid");
        String phoneNumber = "abcdefghijklm";
        assertEquals(false, instance.isValid(phoneNumber)); //the result will be false and pass, if the phoneNumber is not valid
    }
    
     @Test
    public void testNotValidPhoneNumber2() {
        System.out.println("isNotValid");
        String phoneNumber = "#&%";
        assertEquals(false, instance.isValid(phoneNumber)); //the result will be false and pass, if the phoneNumber is not valid
    }
    
    @Test
    public void testValidPhoneNumber() {
        System.out.println("isValid");
        String phoneNumber = "3349135107";
        assertEquals(true, instance.isValid(phoneNumber)); //the result will be true and pass, if the phoneNumber is  valid
    }
}
