/**
 * @file DeleteModalController.java
 * @author loreal
 * @brief Controller for managing the delete contact modal in the application.
 *
 * This file contains the implementation of the DeleteModalController class,
 * which handles the user interface for confirming the deletion of a contact.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class for managing the delete contact modal. This class
 * handles the user input for confirming the deletion of a contact from both the
 * contact list and any associated groups.
 */
public class DeleteModalController {

	/**
	 * The contact to be deleted.
	 */
	private Contact contact;

	/**
	 * The contact list (rubrica) containing all contacts.
	 */
	private ContactList rubrica;

	/**
	 * The Groups model that holds all the groups.
	 */
	private Groups groups;

	/**
	 * The stage for the modal dialog.
	 */
	private Stage stage;

	/**
	 * Static TextField for displaying contact information.
	 */
	public static TextField contactTextField;

	/**
	 * Sets the contact to be deleted.
	 *
	 * @param contact The contact to set.
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * Sets the stage for the modal dialog.
	 *
	 * @param modalStage The stage to set.
	 */
	public void setStage(Stage modalStage) {
		this.stage = modalStage;
	}

	/**
	 * Sets the contact list (rubrica).
	 *
	 * @param rubrica The contact list to set.
	 */
	public void setContactList(ContactList rubrica) {
		this.rubrica = rubrica;
	}

	/**
	 * Sets the Groups model.
	 *
	 * @param groups The Groups model to set.
	 */
	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	/**
	 * Confirms the deletion of the contact. This method removes the contact
	 * from all groups and the contact list.
	 *
	 * @throws InvalidContactException If the contact is invalid during
	 * deletion.
	 */
	@FXML
	public void confirmDelete() throws InvalidContactException {
		groups.getGroups().forEach((Group group) -> {
			if (group.getContacts().contains(contact)) {
				try {
					group.removeContact(contact);
				} catch (InvalidContactException ex) {
					Logger.getLogger(DeleteModalController.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		rubrica.removeContact(contact);
		contactTextField.setText("a");
		contactTextField.setText("");

		stage.close();
	}

	/**
	 * Handles the undo action, closing the modal without making changes.
	 */
	@FXML
	public void undoDelete() {
		stage.close();
	}
}
