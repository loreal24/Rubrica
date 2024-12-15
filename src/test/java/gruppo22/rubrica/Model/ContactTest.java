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
import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Exceptions.InvalidEmailException;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;

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
    public void setUp() throws Exception {
        Email email = new Email();
        email.addEmail("example@example.com"); // insert valid mail
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.addPhoneNumber("3349135107"); // insert valid number
        instance = new Contact("John", "Doe", email , phoneNumber, "Sono io John Doe"); // create a new contact
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getName method, of class Contact.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "John";
        assertEquals("John", instance.getName()); //the test will pass if the expected result, will match the name in the contact created (beforeeach)
    }

    /**
     * Test of setName method, of class Contact.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newName = "Jane"; 
        instance.setName(newName); // will set a different name
        assertTrue(instance.getName().contains(newName)); //the result will be true and the test pass, if the new name "Jane" is contained in the contact
    }

    /**
     * Test of getSurname method, of class Contact.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        String expResult = "Doe";
        assertEquals(expResult, instance.getSurname()); //the test will pass if the expected result, will match the surname in the contact created (beforeeach)
    }

    /**
     * Test of setSurname method, of class Contact.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String newSurname = "Smith"; 
        instance.setSurname(newSurname); // will set a different surname
        assertTrue(instance.getSurname().contains(newSurname)); //the result will be true and the test pass, if the new surname "Jane" is contained in the contact
    }

    /**
     * Test of getEmail method, of class Contact.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        assertNotNull(instance.getEmail()); // check that the email's space isn't null
        assertTrue(instance.getEmail().getEmailList().contains("example@example.com")); // the result will be true and the test pass if the mail contained in the contact
    }

    /**
     * Test of getPhoneNumber method, of class Contact.
     */
    @Test
    public void testGetPhoneNumber() {
        assertNotNull(instance.getPhoneNumber()); // verifies that the phonenumber's spot isn't null
        assertTrue(instance.getPhoneNumber().getPhoneNumbers().contains("3349135107")); //the result will be true and the test pass if the phonenumber contained in the contact
    }

    /**
     * Test of getDescription method, of class Contact.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        assertEquals ("Sono io John Doe", instance.getDescription()); //check that the description matches with the one in the contact
    }

    /**
     * Test of setDescription method, of class Contact.
     */
    @Test
    public void testSetDescription() { 
        System.out.println("setDescription");
        String newDescription = "Ho 20 anni";
        instance.setDescription(newDescription); // will set a new description 
        assertTrue(instance.getDescription().contains(newDescription)); //the result will be true and the test pass, if the new description is contained in the contact
    }
    
}
