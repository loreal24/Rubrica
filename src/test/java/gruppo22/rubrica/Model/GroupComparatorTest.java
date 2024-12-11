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
 *
 * @author lpane
 */
public class GroupComparatorTest {
    private GroupComparator instance;
    private Group group1 = new Group();
    private Group group2 = new Group();
    
    public GroupComparatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Starting GroupComparatorTest");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("Finished GroupComparatorTest");
    }
    
    @BeforeEach
    public void setUp() {
        instance = new GroupComparator();
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }
    
    /**
     *
     */
    @Test
    public void testCompareGroupsWithEqualNames() {
        System.out.println("compareGroupsWithEqualNames");
        group1.setName("Aaaaa");
        group2.setName("Aaaaa");
       
        assertEquals(0, instance.compare(group1, group2)); //deve essere uguale a 0 se i nomi coincidono
    }
    
    @Test
    public void testCompareGroupsWithFirstNameBefore(){
        System.out.println("compareGroupsWithFirstNameBefore");
        group1.setName("Aaaa");
        group2.setName("Bbbb");
        
        assertTrue(instance.compare(group1 , group2) < 0); //se il valore è negativo allora "Aaaa" viene prima di "Bbbb"
    }
    
    /**
     *
     */
    @Test
    public void testCompareGroupsWithSecondNameBefore(){
        System.out.println("compareGroupsWithSecondNameBefore");
        group1.setName("Last");
        group2.setName("First");
        
        assertTrue(instance.compare(group1, group2) > 0); //se il risultato è positivo, significa che "first" viene inserito prima di "last"s
    }
    
    /**
     *
     */
    @Test
    public void testCompareGroupsWithNullName() {
        System.out.println("compareGroupsWithNullName");
        group1.setName(null);
        group2.setName("Group2");
        
        assertTrue(instance.compare(group1, group2) < 0);
    }
    

}
