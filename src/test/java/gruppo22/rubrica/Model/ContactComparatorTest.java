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
 * @author frank
 */
public class ContactComparatorTest {
    private ContactComparator instance;
    private Contact c1;
    private Contact c2;
    
    public ContactComparatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception{
        instance = new ContactComparator();
        c1 = new Contact("John", "Doe", null, null, null);
        c2 = new Contact("John", "Doe", null, null, null);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of compare method, of class ContactComparator.
     */
    @Test
    public void testCompareContactsWithEqualNames() {
        System.out.println("compare");
        assertEquals(0, instance.compare(c1, c2)); //the result will match 0 and pass, if the 2 contacts share the same names
        
    }
    
    @Test
    public void testCompareContactsWithEqualSurnames() {
        System.out.println("compare");
        assertEquals(0, instance.compare(c1, c2)); //the result will match 0 and pass, if the 2 contacts share the same surnames
    }
    
     @Test
    public void testCompareContactsWithtNameBefore(){
        System.out.println("compareContactsWithtNameBefore");
        c1.setName("Abigail");
        c2.setName("Bryan");
        assertTrue(instance.compare(c1 , c2) < 0); //the result will be true and pass, if c1's name will show up on top of c2's one
    }
    
    @Test
    public void testCompareContactsWithSurnameBeforeSameNames(){
        System.out.println("compareContactsWithSurnameBefore");
        c1.setSurname("Gibson");
        c2.setSurname("Smith");
        assertTrue(instance.compare(c1, c2) < 0); //the result will be true and pass, if c1's surname will show up on top of c2's one (equal names case)
    }
    
    @Test
    public void testCompareContactsWithSurnameBeforeDifferentNames(){
        System.out.println("compareContactsWithSurnameBefore");
        c1.setSurname("Gibson");
        c2.setSurname("Smith");
        c1.setName ("Z");
        assertTrue(instance.compare(c1, c2) < 0); //the result will be true and pass, if c1's surname will show up on top of c2's one (different names case)
    }
    
    @Test
    public void testCompareContactsWithNullName() {
        System.out.println("compareContactsWithNullName");
        c1.setName ("");
        assertTrue(instance.compare(c1, c2) < 0); //the result will be true and pass, if c1's name will show up on top of c2's one (equal surnames)
    }
    
}
