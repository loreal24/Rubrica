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
    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    /**
     * Test of isValid method, of class EmailChecker.
     */
    @org.junit.jupiter.api.Test
    
    
    public void testValidEmails(){
    System.out.println("Test email valide");
    EmailChecker emailChecker = new EmailChecker();
    assertTrue(emailChecker.isValid("example@example.com"));
    }
    @Test
    public void testNotValidEmails(){
    System.out.println("Test email non valide");
    EmailChecker emailChecker = new EmailChecker();
    assertFalse(emailChecker.isValid("nome&cognome"));
    }
}
