/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author simon
 */
public class ErrorModalController {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label errorLabel;

    @FXML
    Button goBackButton;

    @FXML
    public void close() {
        goBackButton.setOnAction(e -> {
            Stage stage = (Stage) goBackButton.getScene().getWindow();//recupera la finestra dal pulsante stesso
            stage.close();//chiude la finestra
        });
    }

    /*private void closeWindow() {
        // Ottieni la finestra corrente (Stage) e chiudila
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();
    }
     */
    public void setErrorMessage(String errorMessage) {
        if (errorLabel != null) {
            errorLabel.setText(errorMessage); // Imposta il testo dell'etichetta
        }
    }

    @FXML
    public void initialize() {
        close();
    }

}
