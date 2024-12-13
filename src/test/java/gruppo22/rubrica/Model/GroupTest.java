/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Model;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Exceptions.InvalidEmailException;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
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
public class GroupTest {
    private Group instance;
    
    public GroupTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Starting GroupTest...");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("Finished GroupTest...");
    }
    
    @BeforeEach
    public void setUp() {
        instance = new Group();
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getName method, of class Group.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "newgroup";
        instance.setName("newgroup");
        assertEquals(expResult, instance.getName());
     
    }

    /**
     * Test of setName method, of class Group.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "newGroup";
        instance.setName(name);
        assertTrue(instance.getName().contains(name));
    }

    /**
     * Test of getDescription method, of class Group.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "testdescription";
        instance.setDescription("testdescription");
        assertEquals(expResult, instance.getDescription());
    
    }

    /**
     * Test of setDescription method, of class Group.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "testdescription";
        instance.setDescription(description);
        assertTrue(instance.getDescription().contains(description));
    }

    /**
     * Test of saveVCF method, of class Group.
     * @throws java.lang.Exception
     */
    @Test
    void testSaveVCF() throws IOException, InvalidContactException {
        // Creo dei contatti
        Contact contact1 = new Contact("nome", "cognome", new Email(Arrays.asList("example@gmail.com")), 
                new PhoneNumber(Arrays.asList("123456789")), "cugino");
        Contact contact2 = new Contact("name", "surname", new Email(Arrays.asList("name.surname@gmail.com")), 
                new PhoneNumber(Arrays.asList("987654321")), "zio");

        instance.addContact(contact1);
        instance.addContact(contact2);

        String filename = "saveTest";

        // Salvo nel file
        instance.saveVCF(filename);

        File file = new File(filename);
        assertTrue(file.exists()); //verifico che il file esista

        file.delete();//cancello il file
    }

    /**
     * Test of readVCF method, of class Group.
     * @throws java.lang.Exception
     */
    @Test
    void testReadVCF() throws IOException, InvalidEmailException, InvalidPhoneNumberException, InvalidContactException {
        System.out.println("readVFC");
        String filename = "readTest";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("NOME:Mario\n");
            writer.write("DESCRIZIONE:gruppo\n");
            writer.write("BEGIN:VCARD\n");
            writer.write("VERSION:3.0\n");
            writer.write("FN:Rossi Mario\n");
            writer.write("N:Mario;Rossi;;;\n");
            writer.write("EMAIL:mario.rossi@example.com\n");
            writer.write("TEL:123456789\n");
            writer.write("NOTE:cugino\n");
            writer.write("END:VCARD\n");
        }
        // Stampa del file per verifica
        System.out.println("Contenuto del file creato:");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        //Leggo dal file
        instance = Group.readVCF(filename);

        //Verifico i dettagli del contatto
        assertEquals("Mario", instance.getName() , "Il nome del gruppo è errato");
        assertEquals("gruppo", instance.getDescription());

    
        List<Contact> readContacts = instance.getContacts(); //passo il contatto contenuto in instance
        assertEquals(1, readContacts.size()); //verifico che ci sia un solo contatto
        Contact readContact = readContacts.get(0); //accedo al primo contatto della lista
        
        //verifico le informazioni salvate in readContact
        assertEquals("Mario", readContact.getName() , "Il nome del contatto è errato");
        assertEquals("Rossi", readContact.getSurname());
        assertEquals("mario.rossi@example.com", readContact.getEmail().getEmailList().get(0));
        assertEquals("123456789", readContact.getPhoneNumber().getPhoneNumbers().get(0));
        assertEquals("cugino", readContact.getDescription());


        new File(filename).delete(); //cancello il file
    }
   
    
    
}
