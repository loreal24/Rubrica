/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.ErrorModalController;
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
public class ErrorModalView extends Pane{
    
    private ErrorModalController controller;
    
    public ErrorModalView(){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/errorModal.fxml"));

		//loader.setController(getClass().getResource("ErrorModalController.java"));
		try{
			Parent root = loader.load();
                        controller = loader.getController();
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    // Recupera il controller per poter settare il messaggio
    public ErrorModalController getController() {
        return controller;
    }
    
    // Mostra la finestra modale
    public void showModal(String title, Stage ownerStage, String errorMessage) {
        Stage modalStage = new Stage();
        modalStage.setTitle(title);
        modalStage.initModality(Modality.WINDOW_MODAL); // Imposta la finestra come modale
        modalStage.initOwner(ownerStage); // Impedisce l'interazione con il parent stage fino alla chiusura

        // Setta il messaggio di errore nel controller
        controller.setErrorMessage(errorMessage);

        // Crea la scena e imposta la vista
        modalStage.setScene(new Scene( (Parent) getChildren().get(0)));
        modalStage.showAndWait(); // Mostra la finestra modale e blocca l'interazione finché non viene chiusa
    }
}
