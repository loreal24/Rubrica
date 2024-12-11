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


	/**
	 * Initializes the controller class.
	 */
	@FXML
	public void initialize() {
		groups = new Groups();
		groups.addGroup(new Group("NOMONE", "DESCRIZIONONE"));
		groups.addGroup(new Group("NOMONE", "DESCRIZIONONE"));
		groups.addGroup(new Group("NOMONE", "DESCRIZIONONE"));
		groups.addGroup(new Group("NOMONE", "DESCRIZIONONE"));
		groups.addGroup(new Group("NOMONE", "DESCRIZIONONE"));
		groups.addGroup(new Group("NOMONE", "DESCRIZIONONE"));
		groups.addGroup(new Group("NOMONE", "DESCRIZIONONE"));
		groups.addGroup(new Group("NOMONE", "DESCRIZIONONE"));
		groups.addGroup(new Group("NOMONE", "DESCRIZIONONE"));

		setGroups(groups);

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
	}	

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setContactList(ContactList rubrica) {
		this.rubrica = rubrica;
	}

	public void setGroups(Groups groups){
		this.groups = groups;
		loadGroupsAsync();
	}

	public void setStage(Stage modalStage) {
		this.stage = modalStage;
	}

	@FXML
	public void handleConfirm() throws InvalidContactException {
		Group selected = listView.getSelectionModel().getSelectedItem();

		selected.addContact(contact);
		System.out.println(selected.getContacts().toString());
		stage.close();
		
	}

	@FXML
	public void handleUndo() {
		stage.close();
	}


	private void loadGroupsAsync() {
		Task<ObservableList<Group>> task = new Task<ObservableList<Group>>() {
			@Override
			protected ObservableList<Group> call() throws Exception {
				Thread.sleep(1000);

				return groups.getGroups();
			}
		};


		task.setOnSucceeded(event -> {
			listView.setItems(task.getValue());
		});

		task.setOnFailed(event -> {
			Throwable exception = task.getException();
			exception.printStackTrace();
		});

		new Thread(task).start();
	}

	
}
