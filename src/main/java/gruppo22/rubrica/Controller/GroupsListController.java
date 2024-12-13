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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
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
		GroupListController.groupsListView = groupsListView;
		groupsListView.setCellFactory(param -> new ListCell<Group>() {
			@Override
			protected void updateItem(Group group, boolean empty) {
				super.updateItem(group, empty);
				if(empty || group == null){
					setGraphic(null);
					setText(null);
				} else {
					Label nameLabel = new Label(group.getName());
					nameLabel.setTextFill(Paint.valueOf("#ffffff"));
					Label descriptionLabel = new Label(group.getDescription());
					descriptionLabel.setTextFill(Paint.valueOf("#ffffff"));
					Pane pane = new VBox(nameLabel, descriptionLabel);
					pane.setStyle("-fx-background-color: #365b6d;");
					pane.setOnMouseClicked((MouseEvent event) ->{
						System.out.println();
						GroupListView.showModal("Vista Dettagliata gruppo", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), rubrica, group, groups);
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
