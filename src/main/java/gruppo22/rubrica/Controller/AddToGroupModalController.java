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
import gruppo22.rubrica.View.ErrorModalView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author loreal
 */
public class AddToGroupModalController {

	private Contact contact;
	private ContactList rubrica;
	private Stage stage;

	@FXML
	private ListView<Group> listView;
	
	private Groups groups;

	public AddToGroupModalController(Stage stage, Contact contact, Groups groups){
		this.groups = groups;
		this.stage = stage;
		this.contact = contact;
	}

	/**
	 * Initializes the controller class.
	 */
	@FXML
	public void initialize() {
		listView.setCellFactory(param -> new ListCell<Group>() {
			@Override
			protected void updateItem(Group group, boolean empty) {
				super.updateItem(group, empty);
				if(empty || contact == null){
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

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setContactList(ContactList rubrica) {
		this.rubrica = rubrica;
	}

	public void setGroups(Groups groups){
		this.groups = groups;
	}

	public void setStage(Stage modalStage) {
		this.stage = modalStage;
	}

	@FXML
	public void handleConfirm() throws InvalidContactException {
		Group selected = listView.getSelectionModel().getSelectedItem();
		System.out.println(selected.getName());

		System.out.println(groups.getGroups());

		if(!groups.getGroups().get(groups.getGroups().indexOf(selected)).getContacts().contains(contact))
			groups.getGroups().get(groups.getGroups().indexOf(selected)).addContact(contact);
		else
		{
			ErrorModalView errorModal = new ErrorModalView();
			errorModal.showModal("Errore",(Stage) listView.getScene().getWindow(), "Il Contatto è già presente nel gruppo e non può essere aggiunto");
		}

		groups.getGroups().forEach((Group group) -> {
			System.out.println(group.getContacts());
		});
		//System.out.println(groups.getGroups().get(groups.getGroups().indexOf(selected)));
		stage.close();
		
	}

	@FXML
	public void handleUndo() {
		stage.close();
	}

}
