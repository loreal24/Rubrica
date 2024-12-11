package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.ErrorModalController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorModalView {
    
    private ErrorModalController controller;
    
    // Costruttore che carica la vista FXML
    public ErrorModalView() {
        // Non c'è bisogno di estendere Pane, visto che stai creando una finestra separata
    }

    // Mostra la finestra modale
    public void showModal(String title, Stage ownerStage, String errorMessage) {
        try {
            // Carica la vista FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gruppo22/rubrica/errorModal.fxml"));
            Parent root = loader.load();  // Carica il nodo root dal file FXML

            // Recupera il controller e setta il messaggio di errore
            controller = loader.getController();
            controller.setErrorMessage(errorMessage);

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
