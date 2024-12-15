/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Controller.AddContactController;
import java.io.IOException;
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
    
    public AddContactView(){
		
	}	
    // Mostra la finestra modale
    public void showModal(String title, Stage ownerStage, ContactList contactList) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gruppo22/rubrica/addContact.fxml"));// Carica la vista FXML
            Parent root = loader.load();  // Carica il nodo root dal file FXML
            controller = loader.getController();// Recupera il controller
            controller.setContactList(contactList);//carica la lista di contatti della rubrica

            // Crea e configura il stage modale
            Stage modalStage = new Stage();
            modalStage.setTitle(title);
            modalStage.initModality(Modality.WINDOW_MODAL);// Imposta la finestra come modale
            modalStage.initOwner(ownerStage);// Impedisce interazione con il parent stage

            // Crea la scena e imposta la vista FXML
            modalStage.setScene(new Scene(root));
            modalStage.showAndWait();// Mostra la finestra modale
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}


