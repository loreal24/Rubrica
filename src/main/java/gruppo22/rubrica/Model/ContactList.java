/*
 * @file ContactList.java
 * @brief The file contains the abstract implementation of a List of Contacts 
 * @author loreal
 */
package gruppo22.rubrica.Model;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import java.util.LinkedList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class ContactList {
	protected final ObservableList<Contact> contacts; 

	/*
	 * @brief Default Constructor 
	*/
	public ContactList() {
		contacts = FXCollections.observableArrayList();	
	}

	/**
	 * @brief Allows to add a contact to the list 
	 * @param[in] c, specifies the contact to add to the list
	*/

	public void addContact(Contact c) throws InvalidContactException {
		if(c != null){
			contacts.add(c);
                        contacts.sort(new ContactComparator());
                }
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

	 public ObservableList<Contact> getContacts() {
        return contacts;
    }
}
