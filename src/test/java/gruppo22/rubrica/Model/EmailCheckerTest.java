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
public class EmailCheckerTest {
    private EmailChecker instance;
    private EmailChecker emailChecker = new EmailChecker();
    
    @BeforeAll
    public static void setUpClass() throws Exception {
    }
    @AfterAll
    public static void tearDownClass() throws Exception {
    }
    @BeforeEach
    public void setUp() throws Exception {
        instance = new EmailChecker();
    }
    @AfterEach
    public void tearDown() throws Exception {
        instance = null;
    }
    

    /**
     * Test of isValid method, of class EmailChecker.
     */
    
    @Test
    public void testValidEmail1(){
        System.out.println("Test email is valid");
        assertTrue(emailChecker.isValid("example@example.com")); //the result will be true and pass, if the email is valid
    }
    
    @Test
    public void testValidEmail2(){
        System.out.println("Test email is valid");
        assertTrue(emailChecker.isValid("exa.mple@example.conf.com")); //the result will be true and pass, if the email is valid
    }
    
    @Test
    public void testNotValidEmail1(){
        System.out.println("Test email not valid");
        assertFalse(emailChecker.isValid("nome&cognome")); //the result will be true and pass, if the email is not valid
    }
    
    @Test
    public void testNotValidEmail2(){
        System.out.println("Test email not valid");
        assertFalse(emailChecker.isValid("exàmple@example.com")); //the result will be true and pass, if the email is not valid
    }
    
    @Test
    public void testNotValidEmail3(){
        System.out.println("Test email not valid");
        assertFalse(emailChecker.isValid("exa[++]@example.com")); //the result will be true and pass, if the email is not valid
    }
}
