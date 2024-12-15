/*
 * @file VisualizeContactController.java
 * @brief Controller class for visualizing and managing contact details in the application.
 * @author loreal
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.View.AddToGroupModalView;
import gruppo22.rubrica.View.DeleteModalView;
import gruppo22.rubrica.View.ModifyContactView;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class handles the display of contact information, including the
 * contact's name, phone numbers, email addresses, and description. It also
 * provides functionality for modifying, deleting, and adding the contact to
 * groups.
 */
public class VisualizeContactController {

	@FXML
	Button deleteButton; ///< Button for deleting the contact.

	@FXML
	Label nameLabel; ///< Label for displaying the contact's name.

	@FXML
	Label numberLabel; ///< Label for displaying the primary phone number.

	@FXML
	Label emailLabel; ///< Label for displaying the primary email address.

	@FXML
	Label numberLabel2; ///< Label for displaying the second phone number.

	@FXML
	Label emailLabel2; ///< Label for displaying the second email address.

	@FXML
	Label numberLabel3; ///< Label for displaying the third phone number.

	@FXML
	Label emailLabel3; ///< Label for displaying the third email address.

	@FXML
	Text descriptionText; ///< Text area for displaying the contact's description.

	private Contact contact; ///< The contact being visualized.
	private ContactList rubrica; ///< The contact list model.
	private Stage stage; ///< The stage for the current modal.
	private Groups groups; ///< The groups model.

	/**
	 * Initializes the controller class. This method is called after the FXML
	 * file has been loaded.
	 */
	@FXML
	public void initialize() {
		// Initialization logic can be added here if needed
	}

	/**
	 * Handles the delete action for the contact. Opens a modal to confirm
	 * deletion of the contact.
	 *
	 * @param event The mouse event that triggered this action.
	 * @throws InvalidContactException If the contact is invalid.
	 * @throws IOException If an I/O error occurs during deletion.
	 */
	@FXML
	public void handleDelete(MouseEvent event) throws InvalidContactException, IOException {
		DeleteModalView.showModal("Delete", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), contact, rubrica, groups);
		stage.close();
	}

	/**
	 * Handles the modify action for the contact. Opens a modal to modify the
	 * contact's details.
	 *
	 * @param event The mouse event that triggered this action.
	 * @throws InvalidContactException If the contact is invalid.
	 * @throws IOException If an I/O error occurs during modification.
	 */
	@FXML
	public void handleModify(MouseEvent event) throws InvalidContactException, IOException {
		ModifyContactController.contact = contact;
		ModifyContactController.rubrica = rubrica;
		ModifyContactView.showModal("Modify", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
		stage.close();
	}

	/**
	 * Handles the action to add the contact to a group. Opens a modal to select
	 * a group to add the contact to.
	 *
	 * @param event The mouse event that triggered this action.
	 * @throws InvalidContactException If the contact is invalid.
	 * @throws IOException If an I/O error occurs during the operation.
	 */
	@FXML
	public void handleAddToGroup(MouseEvent event) throws InvalidContactException, IOException {
		AddToGroupModalView.showModal("Add To Group", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), contact, groups);
		stage.close();
	}

	/**
	 * Sets the contact to be visualized and updates the UI labels accordingly.
	 *
	 * @param contact The contact to be visualized.
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
		nameLabel.setText(contact.getSurname() + " " + contact.getName());

		// Update phone number labels
		if (!contact.getPhoneNumber().getPhoneNumbers().isEmpty()) {
			numberLabel.setText(contact.getPhoneNumber().getPhoneNumbers().get(0));
			if (contact.getPhoneNumber().getPhoneNumbers().size() >= 2) {
				numberLabel2.setText(contact.getPhoneNumber().getPhoneNumbers().get(1));
			} else {
				numberLabel2.setText("");
			}
			if (contact.getPhoneNumber().getPhoneNumbers().size() == 3) {
				numberLabel3.setText(contact.getPhoneNumber().getPhoneNumbers().get(2));
			} else {
				numberLabel3.setText("");
			}
		} else {
			numberLabel.setText("");
			numberLabel2.setText("");
			numberLabel3.setText("");
		}

		// Update email labels
		if (!contact.getEmail().getEmailList().isEmpty()) {
			emailLabel.setText(contact.getEmail().getEmailList().get(0));
			if (contact.getEmail().getEmailList().size() >= 2) {
				emailLabel2.setText(contact.getEmail().getEmailList().get(1));
			} else {
				emailLabel2.setText("");
			}
			if (contact.getEmail().getEmailList().size() == 3) {
				emailLabel3.setText(contact.getEmail().getEmailList().get(2));
			} else {
				emailLabel3.setText("");
			}
		} else {
			emailLabel.setText("");
			emailLabel2.setText("");
			emailLabel3.setText("");
		}

		// Update description text
		if (!contact.getDescription().isEmpty()) {
			descriptionText.setText(contact.getDescription());
		} else {
			descriptionText.setText("");
		}
	}

	/**
	 * Sets the contact list for the controller.
	 *
	 * @param rubrica The contact list to be set.
	 */
	public void setContactList(ContactList rubrica) {
		this.rubrica = rubrica;
	}

	/**
	 * Sets the stage for the modal.
	 *
	 * @param stage The stage to be set.
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Sets the groups model for the controller.
	 *
	 * @param groups The groups model to be set.
	 */
	public void setGroups(Groups groups) {
		this.groups = groups;
	}
}
