/**
 * @file AddToGroupModalController.java
 * @author loreal
 * @brief Controller for managing the Add to Group modal in the application.
 *
 * This file contains the implementation of the AddToGroupModalController class,
 * which handles the user interface for adding a contact to a selected group.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.View.ErrorModalView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class for managing the Add to Group modal. This class handles
 * the user input for adding a contact to a selected group, including validation
 * and interaction with the Groups model.
 */
public class AddToGroupModalController {

	/**
	 * The contact to be added to a group.
	 */
	private Contact contact;

	/**
	 * The contact list (rubrica) containing all contacts.
	 */
	private ContactList rubrica;

	/**
	 * The stage for the modal dialog.
	 */
	private Stage stage;

	/**
	 * ListView for displaying the groups.
	 */
	@FXML
	private ListView<Group> listView;

	/**
	 * The Groups model that holds all the groups.
	 */
	private Groups groups;

	/**
	 * Constructor for the AddToGroupModalController.
	 *
	 * @param stage The owner stage of the modal.
	 * @param contact The contact to be added to a group.
	 * @param groups The Groups model to manage group data.
	 */
	public AddToGroupModalController(Stage stage, Contact contact, Groups groups) {
		this.groups = groups;
		this.stage = stage;
		this.contact = contact;
	}

	/**
	 * Initializes the controller class. This method is called after the FXML
	 * file has been loaded.
	 */
	@FXML
	public void initialize() {
		listView.setCellFactory(param -> new ListCell<Group>() {
			@Override
			protected void updateItem(Group group, boolean empty) {
				super.updateItem(group, empty);
				if (empty || contact == null) {
					setGraphic(null);
					setText(null);
				} else {
					Pane pane = new Pane(new Label(group.getName()));
					setGraphic(pane);
				}
			}
		});

		listView.setItems(groups.getGroups());
	}

	/**
	 * Sets the contact to be added to a group.
	 *
	 * @param contact The contact to set.
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
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
	 * Sets the stage for the modal dialog.
	 *
	 * @param modalStage The stage to set.
	 */
	public void setStage(Stage modalStage) {
		this.stage = modalStage;
	}

	/**
	 * Handles the confirm action when the user selects a group to add the
	 * contact. Validates if the contact is already in the group and adds it if
	 * not. Displays an error modal if the contact is already present in the
	 * group.
	 *
	 * @throws InvalidContactException If the contact is invalid.
	 */
	@FXML
	public void handleConfirm() throws InvalidContactException {
		Group selected = listView.getSelectionModel().getSelectedItem();
		
		if(selected == null){
			ErrorModalView errorModal = new ErrorModalView();
			errorModal.showModal("Errore", (Stage) listView.getScene().getWindow(), "Nessun gruppo selezionato");
		}
		else if (!groups.getGroups().get(groups.getGroups().indexOf(selected)).getContacts().contains(contact)) {
			groups.getGroups().get(groups.getGroups().indexOf(selected)).addContact(contact);
		} else {
			ErrorModalView errorModal = new ErrorModalView();
			errorModal.showModal("Errore", (Stage) listView.getScene().getWindow(), "Il Contatto è già presente nel gruppo e non può essere aggiunto");
		}

		groups.getGroups().forEach((Group group) -> {
			System.out.println(group.getContacts());
		});
		stage.close();
	}

	/**
	 * Handles the undo action, closing the modal without making changes.
	 */
	@FXML
	public void handleUndo() {
		stage.close();
	}
}
