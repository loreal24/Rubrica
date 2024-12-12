/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.View.ContactListView;
import gruppo22.rubrica.View.GroupListView;
import java.net.URL;
import java.util.ResourceBundle;
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


public class GroupsListController {
	private Groups groups;
	private ContactList rubrica;

	@FXML
	private ListView<Group> groupsListView;

	public GroupsListController(ContactList rubrica, Groups groups){
		this.rubrica = rubrica;
		this.groups = groups;
	}
	/**
	 * Initializes the controller class.
	 */
	@FXML
	public void initialize() {
		groupsListView.setCellFactory(param -> new ListCell<Group>() {
			@Override
			protected void updateItem(Group group, boolean empty) {
				super.updateItem(group, empty);
				if(empty || group == null){
					setGraphic(null);
					setText(null);
				} else {
					Pane pane = new Pane(new Label(group.getName()));
					pane.setOnMouseClicked((MouseEvent event) ->{
						System.out.println();
						GroupListView.showModal("Vista Dettagliata gruppo", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), group, groups);
					});
					setGraphic(pane);
				}
			}
		});

		groupsListView.setItems(groups.getGroups());
	}	
	
	public void filterList(String query) {
        groupsListView.setItems(groups.contactFilter(query, groups.getGroups()).getGroups());
	}
}
