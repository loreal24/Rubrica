/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.View.VisualizeContactView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * FXML Controller class
 *
 * @author loreal
 */
public class ContactListController {
	@FXML 
	private ListView<Contact> contactListView;

	private ContactList contacts;

	private Groups groups;

	private Stage stage;

	public ContactListController(ContactList contacts, Groups groups) {
		this.contacts = contacts;
		this.groups = groups;
	}

	@FXML
	public void initialize() throws InvalidContactException {
		contactListView.setCellFactory(param -> new ListCell<Contact>() {
			@Override
			protected void updateItem(Contact contact, boolean empty) {
				super.updateItem(contact, empty);
				if(empty || contact == null){
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


	private Pane createContactCard(Contact contact) {
		HBox hbox = new HBox();
		hbox.setMaxHeight(Double.NEGATIVE_INFINITY);
		hbox.setMaxWidth(Double.NEGATIVE_INFINITY);
		hbox.setMinHeight(110);
		hbox.setMinWidth(550);
		hbox.setStyle("-fx-background-color: #365b6d;");

		// Creazione del primo VBox (immagine a sinistra)
		VBox leftVBox = new VBox();
		leftVBox.setAlignment(javafx.geometry.Pos.CENTER);
		leftVBox.setPrefHeight(140.0);
		leftVBox.setPrefWidth(100.0);
		ImageView leftImageView = new ImageView(new Image("/images/contact.png"));
		leftImageView.setFitHeight(100.0);
		leftImageView.setFitWidth(100.0);
		leftImageView.setPreserveRatio(true);
		leftVBox.getChildren().add(leftImageView);

		// Creazione del secondo VBox (dettagli del contatto)
		VBox centerVBox = new VBox();
		centerVBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
		centerVBox.setPrefHeight(140.0);
		centerVBox.setPrefWidth(380.0);
		Label nameLabel = new Label();
		nameLabel.setText(contact.getSurname() + " " + contact.getName());
		nameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
		Label numberLabel = new Label("");
		numberLabel.setTextFill(javafx.scene.paint.Color.WHITE);
		centerVBox.getChildren().addAll(nameLabel, numberLabel);

		// Creazione del terzo VBox (immagine a destra)
		VBox rightVBox = new VBox();
		rightVBox.setAlignment(javafx.geometry.Pos.CENTER);
		rightVBox.setPrefHeight(140.0);
		rightVBox.setPrefWidth(100.0);
		ImageView rightImageView = new ImageView();
		rightImageView.setFitHeight(100.0);
		rightImageView.setFitWidth(100.0);
		rightImageView.setPreserveRatio(true);
		rightVBox.getChildren().add(rightImageView);

		// Aggiunta dei VBox all'HBox
		hbox.getChildren().addAll(leftVBox, centerVBox, rightVBox);

		hbox.setOnMouseClicked((MouseEvent event) -> {
			System.out.println("Vista Dettagliata");


			VisualizeContactView.showModal("Visualize", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), contact, contacts, groups);
		});
		
		return hbox;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void filterList(String query) {
        contactListView.setItems(contacts.contactFilter(query, contacts.getContacts()).getContacts());
	}
}
