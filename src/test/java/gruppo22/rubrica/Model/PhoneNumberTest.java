/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Model;

import java.util.List;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
/**
 *
 * @author frank
 */
public class PhoneNumberTest {
    private PhoneNumber instance;
    public PhoneNumberTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new PhoneNumber();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPhoneNumbers method, of class PhoneNumber.
     */
    @Test
    public void testGetPhoneNumbers() throws InvalidPhoneNumberException {
        System.out.println("getPhoneNumbers");
        instance.addPhoneNumber("3349135107");
        List<String> expResult = new LinkedList<>();
        expResult.add("3349135107");
        assertEquals(expResult, instance.getPhoneNumbers());
    }

    /**
     * Test of addPhoneNumber method, of class PhoneNumber.
     */
    @Test
    public void testAddPhoneNumber() throws InvalidPhoneNumberException{
        System.out.println("addPhoneNumber");
        String phoneNumber = "3349135107";
        PhoneNumber instance = new PhoneNumber();
        instance.addPhoneNumber(phoneNumber);
        assertTrue(instance.getPhoneNumbers().contains(phoneNumber)); 
    }
    
    /**
     * Test of addPhoneNumber in case is Invalid
     */
    
     @Test
    public void testAddPhoneNumber_InvalidPhoneNumber(){
        System.out.println("addPhoneNumber - invalid");
        String invalid = "invalid-PhoneNumber";
        assertThrows(InvalidPhoneNumberException.class, () -> instance.addPhoneNumber(invalid)); 
    }
    
    /**
     * Test in case number of PhoneNumbers exceeds the limit
     */

    @Test
    public void testMaxPhoneNumbers() throws InvalidPhoneNumberException{
        System.out.println("addPhoneNumber - maxsize");
        for (int i = 0; i < 4; i++) {
        instance.addPhoneNumber("334913510" + i);
    }
    assertEquals(3, instance.getPhoneNumbers().size());
        }
    

    /**
     * Test of removePhoneNumber method, of class PhoneNumber.
     */
    @Test
    public void testRemovePhoneNumber() throws Exception {
        System.out.println("removePhoneNumber");
        String phoneNumber = "3349135107";
        PhoneNumber instance = new PhoneNumber();
        instance.addPhoneNumber(phoneNumber); // Aggiungi prima il numero
        String expResult = phoneNumber;
        String result = instance.removePhoneNumber(phoneNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of modifyPhoneNumber method, of class PhoneNumber.
     */
    @Test
    public void testModifyPhoneNumber() throws Exception {
        System.out.println("modifyPhoneNumber");
        String oldPhoneNumber = "3349135107";
        String newPhoneNumber = "3892129007";
        PhoneNumber instance = new PhoneNumber();
        instance.addPhoneNumber(oldPhoneNumber); // Aggiunta vecchio numero
        instance.modifyPhoneNumber(oldPhoneNumber, newPhoneNumber); // Modifica numero
        assertFalse(instance.getPhoneNumbers().contains(oldPhoneNumber)); // Rimozione vecchio numero
        assertTrue(instance.getPhoneNumbers().contains(newPhoneNumber)); // creazione nuovo numero
    }
    
}
