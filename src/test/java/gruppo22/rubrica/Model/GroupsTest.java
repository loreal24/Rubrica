/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Model;

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
public class GroupsTest {
    private Groups instance;
    private Group group1 = new Group();
    private Group group2 = new Group();

    
    public GroupsTest() {
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
        instance = new Groups();
        group1.setName("Agroup1");
        group2.setName("Bgroup2");
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
        group1 = null;
        group2 = null;
    }

    /**
     * Test of addGroup method, of class Groups.
     */
    @Test
    public void testAddGroup() {
        System.out.println("addGroup");
        instance.addGroup(group1);
        assertEquals(1 , instance.getGroups().size()); //verifica che ci sia 1 solo gruppo
        assertTrue(instance.getGroups().contains(group1)); //verifica che la lista contenga il gruppo giusto
    }
   
    @Test
    void testAddGroupSortedOrder() {
        System.out.println("addGroupSortedOrder");
        instance.addGroup(group2); //Bgroup2
        instance.addGroup(group1); // Agroup1

        assertEquals(2, instance.getGroups().size());
        assertEquals(group1, instance.getGroups().get(0)); //verifica che Agroup1 sia il primo della lista
        assertEquals(group2, instance.getGroups().get(1)); //verifica che Bgroup2 sia il secondo della lista
    }

    
    /**
     * Test of removeGroup method, of class Groups.
     */
    @Test
    public void testRemoveGroup() {
        System.out.println("removeGroup");
        instance.addGroup(group1);
        instance.addGroup(group2);
        
        instance.removeGroup(group1);
        assertEquals(1 , instance.getGroups().size()); //controlla che ci sia un solo gruppo nella lista dopo la rimozione
        assertFalse(instance.getGroups().contains(group1)); //controlla che "group1" non sia più presente nella lista
    }
    
    /**
     *
     */
    @Test
    public void testRemoveGroupFromEmptyList(){
        System.out.println("removeGroupFromEmptyList");
        instance.removeGroup(group1);
        assertTrue(instance.getGroups().isEmpty()); //controlla che se si tenta di rimuovere un gruppo dalla lista, la lista resta vuota
    }
    
    @Test
    void testGetGroups() {
        System.out.println("getGroups");
        
        instance.addGroup(group1);
        assertEquals(group1, instance.getGroups().get(0)); //verifico che il metodo getGroups restituisca correttamente il gruppo inserito
    }

    @Test
    void testContactFilter() {
        System.out.println("ContactFilter");
        
        Group group3 = new Group();
        group3.setName("Agroup1");
        
        instance.addGroup(group1);
        instance.addGroup(group2);
        instance.addGroup(group3);

        Groups filteredGroups = instance.contactFilter("Agroup1", instance.getGroups());

        ObservableList<Group> filteredList = filteredGroups.getGroups();
        assertEquals(2, filteredList.size()); //verifico che il metodo ritorni entrambi i gruppi contenenti la stringa passata
        assertTrue(filteredList.contains(group1)); //verifico che la lista contenga il gruppo1 
        assertTrue(filteredList.contains(group3)); //verifico che la lista contenga il gruppo3
        assertFalse(filteredList.contains(group2)); //verifico che la stringa NON contenga il gruppo2
  
    }

    @Test
    void testContactFilterEmptyQuery() {
        System.out.println("ContactFilterEmptyQuery");

        instance.addGroup(group1);
        instance.addGroup(group2);

        Groups filteredGroups = instance.contactFilter("", instance.getGroups());

        ObservableList<Group> filteredList = filteredGroups.getGroups();
        assertEquals(2, filteredList.size()); //verifico che in caso di stringa vuota la lista filtri tutti i gruppi presenti
    }

    @Test
    void testContactFilterNoMatch() {
        System.out.println("ContactFilterNoMatch");

        instance.addGroup(group1);
        instance.addGroup(group2);

        Groups filteredGroups = instance.contactFilter("Nonexistent", instance.getGroups());

        ObservableList<Group> filteredList = filteredGroups.getGroups();
        assertTrue(filteredList.isEmpty()); //verifico che la lista sia vuota quando manca una corrispondenza
    }
}
