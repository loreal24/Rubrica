/*
 * @file ContactList.java
 * @brief The file contains the abstract implementation of a List of Contacts 
 * @author loreal
 */
package gruppo22.rubrica;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import java.util.LinkedList;
import java.util.List;

public abstract class ContactList {
	protected final List<Contact> contacts; 

	/*
	 * @brief Default Constructor 
	*/
	public ContactList() {
		contacts = new LinkedList<>();	
	}

	/**
	 * @brief Allows to add a contact to the list 
	 * @param[in] c, specifies the contact to add to the list
	*/

	public void addContact(Contact c) throws InvalidContactException {
		if(c != null)
			contacts.add(c);
		else 
			throw new InvalidContactException("Contatto non valido oppure null");
	}

	/**
	 * @brief Allows to remove a contact from the list 
	 * @param[in] c, specifies the contact to remove from the list
	*/
	public void removeContact(Contact c) throws InvalidContactException {
		if(c != null)
			contacts.remove(c);
		else
			throw new InvalidContactException("Contatto non valido oppure null");
	}

	/**
	 * @brief Allows to get the index of a specific contact
	 * @param[in] c specifies the specific contact you want to know the index of
	 * @return The index of a specific contact 
	 */
	public int getIndex(Contact c) {
		return contacts.indexOf(c);
	}
}
