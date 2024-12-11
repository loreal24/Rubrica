/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author loreal
 */
public class ModifyContactController implements Initializable {

	private Contact contact;
	private ContactList rubrica;
	private Stage stage;
	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}	

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setContactList(ContactList rubrica) {
		this.rubrica = rubrica;
	}

	public void setStage(Stage modalStage) {
		this.stage = stage;
	}
	
}
