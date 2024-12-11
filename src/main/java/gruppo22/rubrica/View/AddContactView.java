/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Controller.AddContactController;
import java.awt.ScrollPane;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author simon
 */
public class AddContactView extends Pane{
    private AddContactController controller;
    private ContactList contactList;
    public AddContactView(){
		
	}	
    // Mostra la finestra modale
    public void showModal(String title, Stage ownerStage, ContactList contactList) {
        try {
            // Carica la vista FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gruppo22/rubrica/addContact.fxml"));
            Parent root = loader.load();  // Carica il nodo root dal file FXML

            // Recupera il controller e setta il messaggio di errore
            controller = loader.getController();
            controller.setContactList(contactList);

            // Crea e configura il stage modale
            Stage modalStage = new Stage();
            modalStage.setTitle(title);
            modalStage.initModality(Modality.WINDOW_MODAL);  // Imposta la finestra come modale
            modalStage.initOwner(ownerStage);  // Impedisce interazione con il parent stage

            // Crea la scena e imposta la vista FXML
            modalStage.setScene(new Scene(root));
            modalStage.showAndWait();  // Mostra la finestra modale
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}


