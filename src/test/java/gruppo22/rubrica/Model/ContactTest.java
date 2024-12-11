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
import java.util.List;
import java.util.LinkedList;
import gruppo22.rubrica.Exceptions.InvalidContactException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author frank
 */
public class ContactTest {
    private Contact instance;
    
    public ContactTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws InvalidContactException{
        try{
        Email email = new Email();
        email.addEmail("example@example.com"); // Inizializza con una mail valida
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.addPhoneNumber("3349135107"); // Inizializza con un numero valido
        instance = new Contact("John", "Doe", email , phoneNumber, "Sono io John Doe"); //Crea un nuovo contatto prima di ogni test
         } catch (Exception e) {
            fail("Setup fallito a causa di un'eccezione: " + e.getMessage());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Contact.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "John";
        assertEquals(expResult, instance.getName());
    }

    /**
     * Test of setName method, of class Contact.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newName = "Jane";
        instance.setName(newName);
        assertTrue(instance.getName().contains(newName));
    }

    /**
     * Test of getSurname method, of class Contact.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        String expResult = "Doe";
        assertEquals(expResult, instance.getSurname());
    }

    /**
     * Test of setSurname method, of class Contact.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String newSurname = "Smith";
        instance.setSurname(newSurname);
        assertTrue(instance.getSurname().contains(newSurname));
    }

    /**
     * Test of getEmail method, of class Contact.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        assertNotNull(instance.getEmail()); //Verifica che lo spazio email non sia nullo
        assertTrue(instance.getEmail().getEmailList().contains("example@example.com")); //Veirfica che la email corrisponda
    }

    /**
     * Test of getPhoneNumber method, of class Contact.
     */
    @Test
    public void testGetPhoneNumber() {
        assertNotNull(instance.getPhoneNumber()); //Verifica che lo spazio phoneNumber non sia nullo
        assertTrue(instance.getPhoneNumber().getPhoneNumbers().contains("3349135107")); //Verifica che la mail corrisponda
    }

    /**
     * Test of getDescription method, of class Contact.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        assertEquals ("Sono io John Doe", instance.getDescription()); //Verifica che la descriziona corrisponda
    }

    /**
     * Test of setDescription method, of class Contact.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String newDescription = "Ho 20 anni";
        instance.setDescription(newDescription);
        assertTrue(instance.getDescription().contains(newDescription));
    }
    
}
