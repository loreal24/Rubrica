/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.VisualizeContactController;
import gruppo22.rubrica.Model.Contact;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author lpane
 */


public class VisualizeContactView extends Pane{
	private VisualizeContactController controller;
	private Contact contact;
	private Parent root;


	public static void showModal(String message, Stage ownerStage, Contact contact) {
        try {
            FXMLLoader loader = new FXMLLoader(VisualizeContactView.class.getResource("/src/main/resources/gruppo22/rubrica/visualizeContact.fxml"));
            Parent modalRoot = loader.load();

            // Ottieni il controller e imposta il messaggio
            VisualizeContactController controller = loader.getController();
            controller.setContact(contact);

            // Crea un nuovo stage per il dialogo modale
            Stage modalStage = new Stage();
            modalStage.setTitle("Dialogo Modale");
            modalStage.initModality(Modality.WINDOW_MODAL);
            modalStage.initOwner(ownerStage);
            controller.setStage(modalStage); // Passa lo stage al controller

            modalStage.setScene(new Scene(modalRoot));
            modalStage.showAndWait(); // Mostra il modale e aspetta che venga chiuso
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
