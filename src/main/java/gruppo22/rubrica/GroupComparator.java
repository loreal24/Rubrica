/**
 * @file ContactComparator.java
 * @brief The file contains the implementation of the comparator for the 
 * Contacts 
 * @author simon 
 */
package gruppo22.rubrica;

import java.util.Comparator;

public class GroupComparator implements Comparator<Group>{
	/**
	 * @param g1 The first contact to compare
	 * @param g2 The second contact to compare
	 * @return The result is negative if g1 comes before g2, positive if g2 
	 * comes before g1, zero if g1 and g2 are equal
	 */
    @Override
    public int compare(Group g1, Group g2) {
        return g1.getName().compareTo(g2.getName());
    }
    
}
