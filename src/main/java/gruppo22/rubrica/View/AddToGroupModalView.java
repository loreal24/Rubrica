/**
 * @file AddToGroupModalView.java
 * @brief This class represents the view for adding a contact to a group in the
 * contact management application. It handles the display of the modal dialog
 * for adding a contact to a specified group.
 *
 * @author Loreal
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.AddToGroupModalController;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.Groups;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @class AddToGroupModalView
 * @brief A class that provides a modal view for adding a contact to a group.
 */
public class AddToGroupModalView extends Pane {

	/**
	 * @brief Displays the modal dialog for adding a contact to a group.
	 *
	 * @param message A message to be displayed in the modal (currently unused).
	 * @param ownerStage The owner stage of the modal dialog.
	 * @param contact The contact to be added to the group.
	 * @param groups The groups object that will be modified by the controller.
	 * @throws IOException If there is an error loading the FXML file.
	 */
	public static void showModal(String message, Stage ownerStage, Contact contact, Groups groups) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(AddToGroupModalView.class.getResource("/src/main/resources/gruppo22/rubrica/addToGroupModal.fxml"));
			loader.setControllerFactory((param) -> {
				return new AddToGroupModalController(ownerStage, contact, groups);
			});
			Parent modalRoot = loader.load();

			Stage modalStage = new Stage();
			modalStage.setTitle("Dialogo Modale");
			modalStage.initModality(Modality.WINDOW_MODAL);
			modalStage.initOwner(ownerStage);

			modalStage.setScene(new Scene(modalRoot));
			modalStage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
