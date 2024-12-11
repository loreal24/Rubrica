/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author loreal
 */
public class DeleteModalController {
	private Contact contact;
	private ContactList rubrica;
	private Stage stage;

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

	@FXML
	public void confirmDelete() throws InvalidContactException {
		rubrica.removeContact(contact);
		stage.close();
	}

	@FXML
	public void undoDelete() {
		stage.close();
	}
	
}
