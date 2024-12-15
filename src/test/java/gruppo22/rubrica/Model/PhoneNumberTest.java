/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Model;

import java.util.List;
import java.util.ArrayList;
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
        instance = null;
    }

    /**
     * Test of getPhoneNumbers method, of class PhoneNumber.
     */
    @Test
    public void testGetPhoneNumbers() throws InvalidPhoneNumberException {
        System.out.println("getPhoneNumbers");
        String phoneNumber = "3349135107";
        instance.addPhoneNumber(phoneNumber); // added phonenumber
        List<String> expResult = new ArrayList<>();
        expResult.add("3349135107");
        assertEquals(expResult, instance.getPhoneNumbers()); //the test will check if the expected number will match with the one previously added
    }

    /**
     * Test of addPhoneNumber method, of class PhoneNumber.
     */
    @Test
    public void testAddPhoneNumber() throws InvalidPhoneNumberException{
        System.out.println("addPhoneNumber");
        String phoneNumber = "3349135107";
        instance.addPhoneNumber(phoneNumber); // adds a phonenumber
        assertTrue(instance.getPhoneNumbers().contains(phoneNumber)); //the result will be true and the test pass if the phoneNumbers contains the phone number we chose
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
    assertEquals(3, instance.getPhoneNumbers().size()); //the test will pass if the number of phonenumbers is equal to 3
        }
    

    /**
     * Test of removePhoneNumber method, of class PhoneNumber.
     */
    @Test
    public void testRemovePhoneNumber() throws InvalidPhoneNumberException {
        System.out.println("removePhoneNumber");
        String phoneNumber = "3349135107";
        instance.addPhoneNumber(phoneNumber); // number added
        String expResult = phoneNumber;
        String result = instance.removePhoneNumber(phoneNumber);
        assertEquals(expResult, result); //the test will pass if the phone number is successfully removed
    }

    /**
     * Test of modifyPhoneNumber method, of class PhoneNumber.
     */
    @Test
    public void testModifyPhoneNumber() throws InvalidPhoneNumberException{
        System.out.println("modifyPhoneNumber");
        String oldPhoneNumber = "3349135107";
        String newPhoneNumber = "78990";
        instance.addPhoneNumber(oldPhoneNumber); // add old number
        instance.modifyPhoneNumber(oldPhoneNumber, newPhoneNumber); // modify that number
        assertFalse(instance.getPhoneNumbers().contains(oldPhoneNumber)); // it'll result false if the number didn't change and the test will fail
        assertTrue(instance.getPhoneNumbers().contains(newPhoneNumber)); // it'll result true if the number changed and the test will pass
    }
    
}
