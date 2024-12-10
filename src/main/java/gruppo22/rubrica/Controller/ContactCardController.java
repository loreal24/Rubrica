package gruppo22.rubrica.Controller;

import gruppo22.rubrica.App.App;
import gruppo22.rubrica.Model.Contact;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ContactCardController {
	@FXML
	private Label nameLabel;

	@FXML
	private Label numberLabel;

	private Contact contact;

	public void setContact(Contact contact) {
		this.contact = contact;
		nameLabel.setText(contact.getSurname() + " " + contact.getName());
		numberLabel.setText(contact.getPhoneNumber().getPhoneNumbers().get(0));
	}	
	
}
