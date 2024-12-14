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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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

	public GroupsListController(ContactList rubrica, Groups groups) {
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
				if (empty || group == null) {
					setGraphic(null);
					setText(null);
				} else {
					HBox hbox = new HBox();
					hbox.setMaxWidth(Double.NEGATIVE_INFINITY);
					hbox.setMinHeight(50);
					hbox.setMaxHeight(50);
					hbox.setMinWidth(550);

					// Creazione del primo VBox (immagine a sinistra)
					VBox leftVBox = new VBox();
					leftVBox.setAlignment(javafx.geometry.Pos.CENTER);
					leftVBox.setPrefHeight(60.0);
					leftVBox.setPrefWidth(100.0);
					ImageView leftImageView = new ImageView(new Image("/images/groupIcon.png"));
					leftImageView.setFitHeight(40.0);
					leftImageView.setFitWidth(40.0);
					leftImageView.setPreserveRatio(true);
					leftVBox.getChildren().add(leftImageView);

					// Creazione del secondo VBox (dettagli del contatto)
					VBox centerVBox = new VBox();
					centerVBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
					centerVBox.setPrefHeight(50.0);
					centerVBox.setPrefWidth(380.0);
					Label nameLabel = new Label();
					nameLabel.setText(group.getName());
					Label descriptionLabel = new Label("");
					if (group.getDescription() != null && !group.getDescription().isEmpty()) {
						descriptionLabel.setText(group.getDescription());
					}
					centerVBox.getChildren().addAll(nameLabel, descriptionLabel);

					// Creazione del terzo VBox (immagine a destra)
					VBox rightVBox = new VBox();
					rightVBox.setAlignment(javafx.geometry.Pos.CENTER);
					rightVBox.setPrefHeight(50.0);
					rightVBox.setPrefWidth(100.0);
					ImageView rightImageView = new ImageView();
					rightImageView.setFitHeight(100.0);
					rightImageView.setFitWidth(100.0);
					rightImageView.setPreserveRatio(true);
					rightVBox.getChildren().add(rightImageView);

					// Aggiunta dei VBox all'HBox
					hbox.getChildren().addAll(leftVBox, centerVBox, rightVBox);
					hbox.setOnMouseClicked((MouseEvent event) -> {
						GroupListView.showModal("Vista Dettagliata gruppo", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), rubrica, group, groups);
					});
					setGraphic(hbox);
				}
			}
		});

		groupsListView.setItems(groups.getGroups());
	}

	public void filterList(String query) {
		System.out.println(query);
		groupsListView.setItems(groups.contactFilter(query, groups.getGroups()).getGroups());
	}
}
