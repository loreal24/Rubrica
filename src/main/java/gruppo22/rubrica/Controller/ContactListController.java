/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Email;
import gruppo22.rubrica.Model.PhoneNumber;
import gruppo22.rubrica.Model.Rubrica;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author loreal
 */
public class ContactListController {
	@FXML 
	private ListView<Contact> contactListView;

	private ContactList contacts;

	@FXML
	public void initialize() throws InvalidContactException {
		List numbers = new LinkedList();
		numbers.add("089825713");
		contacts = new Rubrica();
		contacts.addContact(new Contact("Marco", "B", new Email(), new PhoneNumber(numbers), "Porterai Minecraft, vabè Maincraiff uhm no"));

		setContactList(contacts);
		
	
		System.out.println(contactListView.getItems().toString());
		contactListView.setCellFactory(param -> new ListCell<Contact>() {
			protected void print(Contact contact, boolean empty) {
			}
			@Override
			protected void updateItem(Contact contact, boolean empty) {
				super.updateItem(contact, empty);
				if(empty || contact == null){
					setGraphic(null);
					setText(null);
				} else {
					setGraphic(createContactCard(contact));
				}
			}
		});
	}


	private Pane createContactCard(Contact contact) {
		/*
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/contactCard.fxml"));
			Pane card = loader.load();
			ContactCardController controller = loader.getController();
			controller.setContact(contact);
			return card;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		*/

		Pane card = new Pane();
		Label nome = new Label();
		nome.setText(contact.getName() + contact.getSurname());

		card.getChildren().addAll(nome);

		return card;


	}

	 public void setContactList(ContactList contactList) {
        this.contacts = contactList;
		loadContactsAsync();	
	}

	private void loadContactsAsync() {
		Task<ObservableList<Contact>> task = new Task<ObservableList<Contact>>() {
			@Override
			protected ObservableList<Contact> call() throws Exception {
				Thread.sleep(2000);

				return contacts.getContacts();
			}
		};


		task.setOnSucceeded(event -> {
			contactListView.setItems(task.getValue());
			contactListView.setCellFactory(param -> new ListCell<Contact>() {
			protected void print(Contact contact, boolean empty) {
			}
			@Override
			protected void updateItem(Contact contact, boolean empty) {
				super.updateItem(contact, empty);
				if(empty || contact == null){
					setGraphic(null);
					setText(null);
				} else {
					setGraphic(createContactCard(contact));
				}
			}
		});
		});

		task.setOnFailed(event -> {
			Throwable exception = task.getException();
			exception.printStackTrace();
		});

		new Thread(task).start();
	}


}
