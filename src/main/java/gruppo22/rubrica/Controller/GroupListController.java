/**
 * @file GroupListController.java
 * @author loreal
 * @brief Controller for managing the group list in the application.
 *
 * This file contains the implementation of the GroupListController class, which
 * handles the user interface for displaying and managing contacts within a
 * group.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.View.ModifyGroupView;
import gruppo22.rubrica.View.VisualizeContactView;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class for managing the group list. This class handles the
 * user interface for displaying contacts in a group, including creating contact
 * cards, removing contacts, and modifying groups.
 */
public class GroupListController {

	/**
	 * Static ListView for displaying groups.
	 */
	public static ListView<Group> groupsListView;

	/**
	 * ListView for displaying contacts in the group.
	 */
	@FXML
	private ListView<Contact> groupListView;

	/**
	 * Button for removing a group.
	 */
	@FXML
	private Button removeGroupButton;

	/**
	 * The current group being managed.
	 */
	private Group group;

	/**
	 * The contact list containing all contacts.
	 */
	private ContactList contacts;

	/**
	 * The Groups model that holds all the groups.
	 */
	private Groups groups;

	/**
	 * The stage for the current window.
	 */
	private Stage stage;

	/**
	 * Constructor for the GroupListController.
	 *
	 * @param contacts The ContactList containing all contacts.
	 * @param group The current group being managed.
	 * @param groups The Groups model to manage group data.
	 * @param stage The stage for the current window.
	 */
	public GroupListController(ContactList contacts, Group group, Groups groups, Stage stage) {
		this.contacts = contacts;
		this.group = group;
		this.groups = groups;
		this.stage = stage;
	}

	/**
	 * Initializes the controller class. This method is called after the FXML
	 * file has been loaded.
	 *
	 * @throws InvalidContactException If there is an issue with the contact
	 * data.
	 */
	@FXML
	public void initialize() throws InvalidContactException {
		groupListView.setCellFactory(param -> new ListCell<Contact>() {
			@Override
			protected void updateItem(Contact contact, boolean empty) {
				super.updateItem(contact, empty);
				if (empty || contact == null) {
					setGraphic(null);
					setText(null);
				} else {
					Pane pane = createContactCard(contact, group);
					setGraphic(pane);
				}
			}
		});

		groupListView.setItems(group.getContacts());
	}

	/**
	 * Creates a visual representation of a contact as a card.
	 *
	 * @param contact The contact to create a card for.
	 * @param group The group to which the contact belongs.
	 * @return A Pane containing the contact card.
	 */
	private Pane createContactCard(Contact contact, Group group) {
		HBox hbox = new HBox();
		hbox.setMaxHeight(Double.NEGATIVE_INFINITY);
		hbox.setMaxWidth(520);
		hbox.setMinHeight(110);
		hbox.setMinWidth(520);

		// Create the first VBox (image on the left)
		VBox leftVBox = new VBox();
		leftVBox.setAlignment(javafx.geometry.Pos.CENTER);
		leftVBox.setPrefHeight(140.0);
		leftVBox.setPrefWidth(100.0);
		ImageView leftImageView = new ImageView(new Image("/images/contact.png"));
		leftImageView.setFitHeight(100.0);
		leftImageView.setFitWidth(100.0);
		leftImageView.setPreserveRatio(true);
		leftVBox.getChildren().add(leftImageView);

		// Create the second VBox (contact details)
		VBox centerVBox = new VBox();
		centerVBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
		centerVBox.setPrefHeight(140.0);
		centerVBox.setPrefWidth(380.0);
		Label nameLabel = new Label();
		nameLabel.setText(contact.getSurname() + " " + contact.getName());
		Label numberLabel = new Label("");
		if (contact.getPhoneNumber().getPhoneNumbers().size() > 0) {
			if (!contact.getPhoneNumber().getPhoneNumbers().get(0).isEmpty()) {
				numberLabel.setText(contact.getPhoneNumber().getPhoneNumbers().get(0));
			}
		}
		centerVBox.getChildren().addAll(nameLabel, numberLabel);

		// Create the third VBox (remove button)
		VBox rightVBox = new VBox();
		rightVBox.setAlignment(javafx.geometry.Pos.CENTER);
		rightVBox.setPrefHeight(140.0);
		rightVBox.setPrefWidth(100.0);
		Button button = new Button("Rimuovi");
		button.minHeight(100.0);
		button.minWidth(100.0);
		rightVBox.getChildren().add(button);

		// Add the VBox elements to the HBox
		hbox.getChildren().addAll(leftVBox, centerVBox, rightVBox);

		// Set up mouse click event to visualize contact details
		hbox.setOnMouseClicked((MouseEvent event) -> {
			System.out.println("Vista Dettagliata");
			VisualizeContactView.showModal("Visualize", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), contact, contacts, groups);
		});

		// Set up button click event to remove the contact from the group
		button.setOnMouseClicked((MouseEvent event) -> {
			try {
				group.removeContact(contact);
				groupListView.setItems(group.getContacts());
			} catch (InvalidContactException ex) {
				Logger.getLogger(GroupListController.class.getName()).log(Level.SEVERE, null, ex);
			}
		});

		return hbox;
	}

	/**
	 * Sets the stage for the current window.
	 *
	 * @param stage The stage to set.
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Opens the Modify Group modal for editing the current group.
	 *
	 * @param event The mouse event that triggered the action.
	 */
	public void modifyGroup(MouseEvent event) {
		try {
			ModifyGroupView.showModal("Modifica Gruppo", stage, group, groups);
		} catch (IOException ex) {
			Logger.getLogger(GroupListController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Removes the current group and its contacts from the Groups model. Deletes
	 * the associated file if it exists.
	 *
	 * @param event The mouse event that triggered the action.
	 */
	public void removeGroup(MouseEvent event) {
		if (group.getContacts() != null) {
			List<Contact> list = new LinkedList<>();
			group.getContacts().forEach((Contact c) -> {
				list.add(c);
			});
			group.getContacts().removeAll(list);
		}
		System.out.println(group.getName());
		groups.removeGroup(group);
		groupsListView.setItems(groups.getGroups());

		Path filePath = Paths.get(group.getName() + ".vcf");

		try {
			// Check if the file exists
			if (Files.exists(filePath)) {
				// Delete the file
				Files.delete(filePath);
				System.out.println("File cancellato: " + filePath);
			} else {
				System.out.println("Il file non esiste: " + filePath);
			}
		} catch (IOException e) {
			System.err.println("Errore durante la cancellazione del file: " + e.getMessage());
		}

		stage.close();
	}
}
