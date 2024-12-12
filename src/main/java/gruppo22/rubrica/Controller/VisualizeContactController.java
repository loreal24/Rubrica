/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.View.AddToGroupModalView;
import gruppo22.rubrica.View.DeleteModalView;
import gruppo22.rubrica.View.ModifyContactView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author loreal
 */
public class VisualizeContactController {
	@FXML
	Button deleteButton;
	@FXML
	Label nameLabel;
	@FXML
	Label numberLabel;
	@FXML
	Label emailLabel;
	@FXML
	Label numberLabel2;
	@FXML
	Label emailLabel2;
	@FXML
	Label numberLabel3;
	@FXML
	Label emailLabel3;

	private Contact contact;
	private ContactList rubrica;
	private Stage stage;

	/**
	 * Initializes the controller class.
	 */
	@FXML
	public void initialize() {
		/*
		numberLabel2.setText(contact.getPhoneNumber().getPhoneNumbers().get(1));
		emailLabel2.setText(contact.getEmail().getEmailList().get(1));
		numberLabel3.setText(contact.getPhoneNumber().getPhoneNumbers().get(2));
		emailLabel3.setText(contact.getEmail().getEmailList().get(2));
*/
	}	

	@FXML
	public void handleDelete(MouseEvent event) throws InvalidContactException, IOException {
			DeleteModalView.showModal("Delete", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), contact, rubrica);
			stage.close();
	}

	@FXML
	public void handleModify(MouseEvent event) throws InvalidContactException, IOException {
           ModifyContactController.contact = contact;
            ModifyContactController.rubrica = rubrica;
			ModifyContactView.showModal("Modify", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
                        
			stage.close();
	}

	@FXML
	public void handleAddToGroup(MouseEvent event) throws InvalidContactException, IOException {
			AddToGroupModalView.showModal("Add To Group", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), contact, rubrica);
			stage.close();
	}

	public void setContact(Contact contact) {
		this.contact = contact;
		nameLabel.setText(contact.getSurname() + " " + contact.getName());
		numberLabel.setText(contact.getPhoneNumber().getPhoneNumbers().get(0));
		emailLabel.setText(contact.getEmail().getEmailList().get(0));
	}

	public void setContactList(ContactList rubrica){
		this.rubrica = rubrica;
	}

	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}

