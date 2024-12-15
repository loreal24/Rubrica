/**
 * @file ContactComparator.java
 * @brief The file contains the implementation of the comparator for the
 * Contacts
 * @author simon
 */
package gruppo22.rubrica.Model;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {

	/**
	 * @brief If the surnames are different, compare by surname, otherwise by
	 * name
	 *
	 * @param c1 The first contact to compare
	 * @param c2 The second contact to compare
	 * @return The result is negative if c1 comes before c2, positive if c2
	 * comes before c1, zero if c1 and c2 are equal
	 */
	@Override
	public int compare(Contact c1, Contact c2) {
		if (!c1.getSurname().equals(c2.getSurname())) {
			return c1.getSurname().toLowerCase().compareToIgnoreCase(c2.getSurname());
		}
		return c1.getName().compareToIgnoreCase(c2.getName());

	}

}
