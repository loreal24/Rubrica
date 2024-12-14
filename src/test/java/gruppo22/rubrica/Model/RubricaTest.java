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
public class RubricaTest {
    private Rubrica instance;
    private String filename = "test.vcf";
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Starting RubricaTest");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("Finished RubricaTest");
    }
    
    @BeforeEach
    public void setUp() throws InvalidContactException, InvalidEmailException, InvalidPhoneNumberException {
        instance = new Rubrica();
        // Aggiungo un contatto
        Email email = new Email();
        email.addEmail("mario.rossi@example.com");
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.addPhoneNumber("123456789");
        Contact contact = new Contact("Mario", "Rossi", email , phoneNumber , "Cugino");
        
        instance.addContact(contact);
    }
    
    @AfterEach
    public void tearDown() {
        new File(filename).delete();
    }

    /**
     * Test of saveVCF method, of class Rubrica.
     */
    @Test
    public void testSaveVCF() throws Exception {
        System.out.println("saveVCF");
        
        instance.saveVCF(filename);
        File file = new File(filename);
        assertTrue(file.exists(), "Il file non esiste");

        // Leggo il file e verifico il contenuto
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean foundContact = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("FN:")) {
                    foundContact = true;
                    assertTrue(line.contains("Rossi Mario"));
                }
            }
            assertTrue(foundContact);
        }
    }

    /**
     * Test of readVCF method, of class Rubrica.
     */
    @Test
    public void testReadVCF() throws IOException, InvalidEmailException, InvalidPhoneNumberException, InvalidContactException {
        System.out.println("readVCF");
        
        // Scrivo un file VCF di test
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("BEGIN:VCARD\n");
            writer.write("VERSION:3.0\n");
            writer.write("FN:Rossi Mario\n");
            writer.write("N:Rossi;Mario;;;\n");
            writer.write("EMAIL:mario.rossi@example.com\n");
            writer.write("TEL:123456789\n");
            writer.write("NOTE:cugino\n");
            writer.write("END:VCARD\n");
        }

        // Leggi i contatti dal file VCF
        ContactList contactList = Rubrica.readVCF(filename);

        List<Contact> contacts = contactList.getContacts(); 
        assertEquals(1, contacts.size()); //verifico che ci sia un solo contatto

        Contact contact = contacts.get(0); //prendo il primo e unico contatto della lista
        assertEquals("Mario", contact.getName(), "Il nome del contatto non è corretto");
        assertEquals("Rossi", contact.getSurname(), "Il cognome del contatto non è corretto");
        assertEquals("mario.rossi@example.com", contact.getEmail().getEmailList().get(0), "L'email del contatto non è corretta");
        assertEquals("123456789", contact.getPhoneNumber().getPhoneNumbers().get(0), "Il numero di telefono del contatto non è corretto");
        assertEquals("cugino", contact.getDescription(), "La descrizione del contatto non è corretta");
    }
    
    @Test
    public void testReadVCFWithNoNameOrSurname() throws IOException, InvalidEmailException, InvalidPhoneNumberException, InvalidContactException {
        System.out.println("readVCFWithNoNameOrSurname");
        
        // Scrivo un file VCF con solo il nome
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("BEGIN:VCARD\n");
            writer.write("VERSION:3.0\n");
            writer.write("FN:Mario\n");
            writer.write("N:;Mario;;;\n");
            writer.write("EMAIL:mario@example.com\n");
            writer.write("TEL:987654321\n");
            writer.write("NOTE:Amico\n");
            writer.write("END:VCARD\n");
        }

        // Leggo i contatti dal file VCF
        ContactList contactList = Rubrica.readVCF(filename);

        List<Contact> contacts = contactList.getContacts();
        assertEquals(1, contacts.size(), "Il numero di contatti letti non è corretto"); //verifico che ci sia un solo contatto

        Contact contact = contacts.get(0);
        assertEquals("Mario", contact.getName(), "Il nome del contatto non è corretto");
        assertEquals("" , contact.getSurname(), "Il cognome del contatto dovrebbe essere null"); //verifico che il cognome non sia presente
        assertEquals("mario@example.com", contact.getEmail().getEmailList().get(0), "L'email del contatto non è corretta");
        assertEquals("987654321", contact.getPhoneNumber().getPhoneNumbers().get(0), "Il numero di telefono del contatto non è corretto");
        assertEquals("Amico", contact.getDescription(), "La descrizione del contatto non è corretta");
    }



}
