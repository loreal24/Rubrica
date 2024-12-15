/**
 * @file GroupsListController.java
 * @author loreal
 * @brief Controller class for managing the display and interaction of the
 * groups list in the application.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.View.GroupListView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class for managing the list of groups.
 *
 * This class handles the initialization of the groups list view, the display of
 * group details, and the filtering of groups based on user input.
 */
public class GroupsListController {

	private Groups groups; ///< The model containing the list of groups.
	private ContactList rubrica; ///< The contact list model.

	@FXML
	private ListView<Group> groupsListView; ///< The ListView component for displaying groups.

	/**
	 * Constructor for GroupsListController.
	 *
	 * @param rubrica The contact list to be used in the controller.
	 * @param groups The groups model to be used in the controller.
	 */
	public GroupsListController(ContactList rubrica, Groups groups) {
		this.rubrica = rubrica;
		this.groups = groups;
	}

	/**
	 * Initializes the controller class. This method sets up the ListView cell
	 * factory and populates the ListView with groups.
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

					// Create the first VBox (image on the left)
					VBox leftVBox = new VBox();
					leftVBox.setAlignment(javafx.geometry.Pos.CENTER);
					leftVBox.setPrefHeight(60.0);
					leftVBox.setPrefWidth(100.0);
					ImageView leftImageView = new ImageView(new Image("/images/groupIcon.png"));
					leftImageView.setFitHeight(40.0);
					leftImageView.setFitWidth(40.0);
					leftImageView.setPreserveRatio(true);
					leftVBox.getChildren().add(leftImageView);

					// Create the second VBox (contact details)
					VBox centerVBox = new VBox();
					centerVBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
					centerVBox.setPrefHeight(50.0);
					centerVBox.setPrefWidth(380.0);
					Label nameLabel = new Label();
					nameLabel.setText(group.getName().replace("\u200d", ""));
					Label descriptionLabel = new Label("");
					if (group.getDescription() != null && !group.getDescription().isEmpty()) {
						descriptionLabel.setText(group.getDescription());
					}
					centerVBox.getChildren().addAll(nameLabel, descriptionLabel);

					// Create the third VBox (image on the right)
					VBox rightVBox = new VBox();
					rightVBox.setAlignment(javafx.geometry.Pos.CENTER);
					rightVBox.setPrefHeight(50.0);
					rightVBox.setPrefWidth(100.0);
					ImageView rightImageView = new ImageView();
					rightImageView.setFitHeight(100.0);
					rightImageView.setFitWidth(100.0);
					rightImageView.setPreserveRatio(true);
					rightVBox.getChildren().add(rightImageView);

					// Add the VBoxes to the HBox
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

	/**
	 * Filters the list of groups based on the provided query.
	 *
	 * This method updates the ListView to display only the groups that match
	 * the query.
	 *
	 * @param query The search query used to filter the groups.
	 */
	public void filterList(String query) {
		System.out.println(query);
		groupsListView.setItems(groups.groupFilter(query, groups.getGroups()).getGroups());
	}
}
