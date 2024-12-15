/**
 * @file AddGroupModalView.java
 * @brief This class represents the view for adding a new group in the contact management application.
 * It handles the display of the modal dialog for group creation.
 * 
 * @author Loreal
 */

package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.AddGroupModalController;
import gruppo22.rubrica.Model.Groups;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @class AddGroupModalView
 * @brief A class that provides a modal view for adding a new group.
 */
public class AddGroupModalView extends Pane {
    
    /**
     * @brief Displays the modal dialog for adding a new group.
     * 
     * @param message A message to be displayed in the modal (currently unused).
     * @param ownerStage The owner stage of the modal dialog.
     * @param groups The groups object that will be modified by the controller.
     * @throws IOException If there is an error loading the FXML file.
     */
    public static void showModal(String message, Stage ownerStage, Groups groups) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(AddGroupModalView.class.getResource("/src/main/resources/gruppo22/rubrica/addGroupModal.fxml"));
            Stage modalStage = new Stage();
            loader.setControllerFactory((param) -> {
                return new AddGroupModalController(modalStage, groups);
            });
            Parent modalRoot = loader.load();

            modalStage.setTitle("Aggiungi Gruppo");
            modalStage.initModality(Modality.WINDOW_MODAL);
            modalStage.initOwner(ownerStage);

            modalStage.setScene(new Scene(modalRoot));
            modalStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}