/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Model;

import gruppo22.rubrica.Exceptions.InvalidEmailException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lpane
 */
public class EmailTest {
    private Email instance;
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Starting EmailTest...");
    }
    
    @AfterAll
    public static void tearDownClass() {
         System.out.println("Finished EmailTest...");
    }
    
    @BeforeEach
    public void setUp() {
        instance = new Email();
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getEmailList method, of class Email.
     * @throws gruppo22.rubrica.Exceptions.InvalidEmailException
     */
    @Test
    public void testGetEmailList() throws InvalidEmailException {
        System.out.println("getEmailList");
        instance.addEmail("example@gmail.com");
        List<String> expResult = new ArrayList<>();
        expResult.add("example@gmail.com");
        assertEquals(expResult, instance.getEmailList());
        
    }

    /**
     * Test of addEmail method, of class Email.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddEmail_Success() throws Exception {
        System.out.println("addEmail - success");
        String email = "emailexample@gmail.com";
        instance.addEmail(email);
        assertTrue(instance.getEmailList().contains(email) , "the e-mail has been added successfully");
       
    }
    
    @Test
    public void testAddEmail_InvalidEmail(){
        System.out.println("addEmail - invalid");
        String invalid = "invalid-e-mail";
        assertThrows(InvalidEmailException.class, () -> instance.addEmail(invalid)); 
    }

    
    @Test
    public void testAddEmail_MaxSizeExceeded()throws InvalidEmailException{
        System.out.println("addEmail - maxsize");
        for(int i = 0 ; i < 4 ; i++){
        instance.addEmail( i+"@gmail.com");
        }
        assertEquals(3 , instance.getEmailList().size());
        
    }
    
    /**
     * Test of removeEmail method, of class Email.
     * @throws java.lang.Exception
     */
    @org.junit.jupiter.api.Test
    public void testRemoveEmail_Success() throws Exception {
        System.out.println("removeEmail");
        String email = "example@gmail.com";
        instance.addEmail(email);
        String expResult = "example@gmail.com";
        assertEquals(expResult, instance.removeEmail(email) , "the e-mail has been removed correctly");
        assertFalse(instance.getEmailList().contains(email)); //controlla se l'e-mail è stata rimossa correttamente
    }
    

    /**
     * Test of modifyEmail method, of class Email.
     * @throws java.lang.Exception
     */
    @org.junit.jupiter.api.Test
    public void testModifyEmail() throws Exception {
        System.out.println("modifyEmail");
        String oldEmail = "old@gmail.com";
        String newEmail = "new@gmail.com";
        instance.addEmail(oldEmail);
        instance.modifyEmail(oldEmail, newEmail);

        assertTrue(instance.getEmailList().contains(newEmail) , "the e-mail has been modified correctly"); //verifica che l'e-mail contenga la nuova e sia stata modificata
        assertFalse(instance.getEmailList().contains(oldEmail));//verifica che non sia più presente la vecchia e-mail
    }
    
}
