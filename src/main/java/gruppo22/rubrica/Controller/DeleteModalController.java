/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * FXML Controller class
 *
 * @author loreal
 */
public class DeleteModalController {
	private Contact contact;
	private ContactList rubrica;
	private Groups groups;
	private Stage stage;

	public static TextField contactTextField;

	/**
	 * Initializes the controller class.
	 */
	@FXML
	public void initialize() {
		// TODO
	}	

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setStage(Stage modalStage) {
		this.stage = modalStage;
	}

	public void setContactList(ContactList rubrica) {
		this.rubrica = rubrica;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	@FXML
	public void confirmDelete() throws InvalidContactException {
		groups.getGroups().forEach((Group group) -> {
			if(group.getContacts().contains(contact))
				try {
					group.removeContact(contact);
			} catch (InvalidContactException ex) {
				Logger.getLogger(DeleteModalController.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		rubrica.removeContact(contact);
		contactTextField.setText("a");
		contactTextField.setText("");
		
		stage.close();
	}

	@FXML
	public void undoDelete() {
		stage.close();
	}
	
}
