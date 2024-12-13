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
import gruppo22.rubrica.View.VisualizeContactView;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
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
 * FXML Controller class
 *
 * @author loreal
 */
public class GroupListController {

	public static ListView<Group> groupsListView;

	@FXML 
	private ListView<Contact> groupListView;

	@FXML
	private Button removeGroupButton;

	private Group group;

	private ContactList contacts;

	private Groups groups;

	private Stage stage;

	public GroupListController(ContactList contacts, Group group, Groups groups, Stage stage) {
		this.contacts = contacts;
		this.group = group;
		this.groups = groups;
		this.stage = stage;
	}


	@FXML
	public void initialize() throws InvalidContactException {
		groupListView.setCellFactory(param -> new ListCell<Contact>() {
			@Override
			protected void updateItem(Contact contact, boolean empty) {
				super.updateItem(contact, empty);
				if(empty || contact == null){
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


	private Pane createContactCard(Contact contact, Group group) {
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
		Button button = new Button("Rimuovi");
		button.minHeight(100.0);
		button.minWidth(100.0);
		rightVBox.getChildren().add(button);

		// Aggiunta dei VBox all'HBox
		hbox.getChildren().addAll(leftVBox, centerVBox, rightVBox);

		hbox.setOnMouseClicked((MouseEvent event) -> {
			System.out.println("Vista Dettagliata");


			VisualizeContactView.showModal("Visualize", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), contact, contacts, groups);
		});


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

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void removeGroup(MouseEvent event) {
		if(group.getContacts() != null)
		{
			List<Contact> list = new LinkedList<>();
			group.getContacts().forEach((Contact c)-> {
				list.add(c);
			});
			group.getContacts().removeAll(list);
		}
		System.out.println(group.getName());
		groups.removeGroup(group);
		groupsListView.setItems(groups.getGroups());

		Path filePath = Paths.get(group.getName()+".vcf");

		  try {
            // Controlla se il file esiste
            if (Files.exists(filePath)) {
                // Cancella il file
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
