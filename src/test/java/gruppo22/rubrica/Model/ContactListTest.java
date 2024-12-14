/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Model;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Exceptions.InvalidEmailException;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import java.util.List;
import javafx.collections.ObservableList;
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
public class ContactListTest {
    private ContactList instance;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    private Contact contact4;
    
    public ContactListTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Starting ContactListTest...");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("Finished ContactListTest...");
    }
    
    @BeforeEach
    public void setUp() throws InvalidEmailException, InvalidPhoneNumberException, InvalidContactException {
        instance = new Rubrica();
        
        Email email_1 = new Email();
        email_1.addEmail("mario@gmail.com");
        PhoneNumber phoneNumber_1 = new PhoneNumber();
        phoneNumber_1.addPhoneNumber("123456789");
        contact1 = new Contact("mario" , "rossi" , email_1 , phoneNumber_1 , "amico");
        
        Email email_2 = new Email();
        email_2.addEmail("nome@gmail.com");
        PhoneNumber phoneNumber_2 = new PhoneNumber();
        phoneNumber_2.addPhoneNumber("987654321");
        contact2 = new Contact("nome" , "cognome" , email_1 , phoneNumber_1 , "cugino");
        
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    
    /**
     * Test of getContacts method, of class ContactList.
     */
    @Test
    public void testGetContacts() throws InvalidContactException {
        System.out.println("getContacts");
        
        instance.addContact(contact1);
        instance.addContact(contact2);
        
        assertEquals(2, instance.getContacts().size(), "Il numero di contatti presenti è diverso da 2");
        assertEquals(contact1 , instance.getContacts().get(1) , "Il primo contatto non corrisponde");
        assertEquals(contact2 , instance.getContacts().get(0) , "Il secondo contatto non corrisponde");
    }

    /**
     * Test of addContact method, of class ContactList.
     */
    @Test
    public void testAddContactValid() throws Exception {
        System.out.println("addContactValid");
        
        instance.addContact(contact1);
        
        assertEquals(1 , instance.getContacts().size() , "Il contatto non è stato aggiunto correttamente");
        assertEquals(contact1 , instance.getContacts().get(0) , "Il contatto aggiunto non corrisponde "); 
    }
    
    /**
     *
     * @throws InvalidContactException
     */
    @Test
    public void testAddContactSortedBySurname() throws InvalidContactException{
        System.out.println("AddContactSortedOrderBySurname");
    
        instance.addContact(contact1);
        instance.addContact(contact2);
        
        assertEquals(contact2 , instance.getContacts().get(0) , "Il primo contatto della lista non è 'cognome'");
        assertEquals(contact1 , instance.getContacts().get(1) , "Il secondo contatto della lista non è 'rossi'");
    }
    
    /**
     *
     * @throws InvalidEmailException
     * @throws InvalidPhoneNumberException
     * @throws InvalidContactException
     */
    @Test
    public void testAddContactSortedWithoutSurname() throws InvalidEmailException, InvalidPhoneNumberException, InvalidContactException{
        System.out.println("AddContactSortedWithoutSurname");
        
        Email email_3 = new Email();
        email_3.addEmail("example@gmail.com");
        PhoneNumber phoneNumber_3 = new PhoneNumber();
        phoneNumber_3.addPhoneNumber("000000000");
        contact3 = new Contact("luigi" , "" , email_3 , phoneNumber_3 , "amico");
        
        Email email_4 = new Email();
        email_4.addEmail("example@gmail.com");
        PhoneNumber phoneNumber_4 = new PhoneNumber();
        phoneNumber_4.addPhoneNumber("11111111");
        contact4 = new Contact("alberto" , "" , email_4 , phoneNumber_4 , "cugino");
        
        instance.addContact(contact3);
        instance.addContact(contact4);
        
        assertEquals(contact4 , instance.getContacts().get(0) , "Il ptimo contatto della lista non è 'alberto'");
        assertEquals(contact3 , instance.getContacts().get(1) , "Il secondo contatto della lista non è 'luigi'");
        
    }
    
    /**
     *
     */
    @Test
    public void testAddContactNull() {
        System.out.println("AddContactNull");
        assertThrows(InvalidContactException.class, () -> instance.addContact(null), "L'aggiunta di un contatto nullo non ha generato un'eccezione");
    }

    /**
     * Test of removeContact method, of class ContactList.
     */
    @Test
    public void testRemoveContactValid() throws Exception {
        System.out.println("removeContactValid");
        instance.addContact(contact1);
        instance.addContact(contact2);
        
        instance.removeContact(contact1);
        
        assertEquals(1 , instance.getContacts().size() , "Non è presente solo un contatto nella lista");
        assertEquals(contact2 , instance.getContacts().get(0), "Il contatto che non è stato rimosso non corrisponde");
    }
    
    /**
     *
     */
    @Test
    public void testRemoveContactNull() {
        System.out.println("RemoveContactNull");
        assertThrows(InvalidContactException.class, () -> instance.removeContact(null), "La rimozione di un contatto nullo non ha generato un'eccezione");
    }

    /**
     * Test of getIndex method, of class ContactList.
     */
    @Test
    public void testGetIndex() throws InvalidContactException {
        System.out.println("getIndex");
        
        instance.addContact(contact1);
        instance.addContact(contact2);
        
        assertEquals(0, instance.getIndex(contact2) , "L'indice non corrisponde a quello del contatto");
        
    }

    /**
     * Test of contactFilter method, of class ContactList.
     */
    @Test
    public void testContactFilterByName() throws InvalidContactException {
        System.out.println("contactFilterByName");
        instance.addContact(contact1);
        instance.addContact(contact2);

        ContactList filteredList = instance.contactFilter("Mario", instance.getContacts());
        assertEquals(1, filteredList.getContacts().size(), "Il filtro per nome non ha restituito il numero corretto di contatti");
        assertEquals(contact1, filteredList.getContacts().get(0), "Il filtro per nome non ha restituito il contatto corretto");
    }
    
    /**
     *
     * @throws InvalidContactException
     */
    @Test
    public void testContactFilterBySurname() throws InvalidContactException {
        System.out.println("contactFilterBySurname");
        instance.addContact(contact1);
        instance.addContact(contact2);

        ContactList filteredList = instance.contactFilter("Cognome", instance.getContacts());
        assertEquals(1, filteredList.getContacts().size(), "Il filtro per cognome non ha restituito il numero corretto di contatti");
        assertEquals(contact2, filteredList.getContacts().get(0), "Il filtro per cognome non ha restituito il contatto corretto");
    }
    
    /**
     *
     * @throws InvalidContactException
     */
    @Test
    public void testContactFilterEmptyQuery() throws InvalidContactException {
        System.out.println("contactFilterEmptyQuery");
        instance.addContact(contact1);
        instance.addContact(contact2);

        ContactList filteredList = instance.contactFilter("", instance.getContacts());
        assertEquals(2, filteredList.getContacts().size(), "Il filtro con query vuota non ha restituito tutti i contatti");
    }
    
    /**
     *
     * @throws InvalidContactException
     */
    @Test
    public void testContactFilterNoMatch() throws InvalidContactException {
        System.out.println("contactFilterNoMatch");
        instance.addContact(contact1);
        instance.addContact(contact2);

        ContactList filteredList = instance.contactFilter("NonEsiste", instance.getContacts());
        assertEquals(0, filteredList.getContacts().size(), "Il filtro con query senza corrispondenze ha restituito risultati");
    }

}
