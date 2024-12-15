/**
 * @file ContactListController.java
 * @author loreal
 * @brief Controller for managing the contact list in the application.
 *
 * This file contains the implementation of the ContactListController class,
 * which handles the user interface for displaying and interacting with a list
 * of contacts.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.View.VisualizeContactView;
import javafx.fxml.FXML;
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
 * FXML Controller class for managing the contact list. This class handles the
 * user interface for displaying contacts, including creating contact cards and
 * handling user interactions.
 */
public class ContactListController {

	/**
	 * ListView for displaying the contacts.
	 */
	@FXML
	private ListView<Contact> contactListView;

	/**
	 * The list of contacts.
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
	 * Constructor for the ContactListController.
	 *
	 * @param contacts The ContactList containing all contacts.
	 * @param groups The Groups model to manage group data.
	 */
	public ContactListController(ContactList contacts, Groups groups) {
		this.contacts = contacts;
		this.groups = groups;
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
		contactListView.setCellFactory(param -> new ListCell<Contact>() {
			@Override
			protected void updateItem(Contact contact, boolean empty) {
				super.updateItem(contact, empty);
				if (empty || contact == null) {
					setGraphic(null);
					setText(null);
				} else {
					Pane pane = createContactCard(contact);
					setGraphic(pane);
				}
			}
		});

		contactListView.setItems(contacts.getContacts());
	}

	/**
	 * Creates a visual representation of a contact as a card.
	 *
	 * @param contact The contact to create a card for.
	 * @return A Pane containing the contact card.
	 */
	private Pane createContactCard(Contact contact) {
		HBox hbox = new HBox();
		hbox.setMaxHeight(Double.NEGATIVE_INFINITY);
		hbox.setMaxWidth(Double.NEGATIVE_INFINITY);
		hbox.setMinHeight(110);
		hbox.setMinWidth(550);

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

		// Create the third VBox (image on the right)
		VBox rightVBox = new VBox();
		rightVBox.setAlignment(javafx.geometry.Pos.CENTER);
		rightVBox.setPrefHeight(140.0);
		rightVBox.setPrefWidth(100.0);
		ImageView rightImageView = new ImageView();
		rightImageView.setFitHeight(100.0);
		rightImageView.setFitWidth(100.0);
		rightImageView.setPreserveRatio(true);
		rightVBox.getChildren().add(rightImageView);

		// Add the VBox elements to the HBox
		hbox.getChildren().addAll(leftVBox, centerVBox, rightVBox);

		// Set up mouse click event to visualize contact details
		hbox.setOnMouseClicked((MouseEvent event) -> {
			System.out.println("Vista Dettagliata");
			VisualizeContactView.showModal("Visualize", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), contact, contacts, groups);
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
	 * Filters the contact list based on the provided query.
	 *
	 * @param query The search query to filter contacts.
	 */
	public void filterList(String query) {
		contactListView.setItems(contacts.contactFilter(query, contacts.getContacts()).getContacts());
	}
}
