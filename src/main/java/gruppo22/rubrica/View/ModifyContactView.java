/**
 * @file ModifyContactView.java
 * @brief This class represents the view for modifying a contact in the contact
 * management application. It handles the display of the modal dialog for
 * editing contact details.
 *
 * @author Loreal
 */
package gruppo22.rubrica.View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @class ModifyContactView
 * @brief A class that provides a modal view for modifying a contact's details.
 */
public class ModifyContactView extends Pane {

	/**
	 * @brief Displays the modal dialog for modifying a contact.
	 *
	 * @param message A message to be displayed in the modal (currently unused).
	 * @param ownerStage The owner stage of the modal dialog.
	 * @throws IOException If there is an error loading the FXML file.
	 */
	public static void showModal(String message, Stage ownerStage) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(ModifyContactView.class.getResource("/src/main/resources/gruppo22/rubrica/modifyContact.fxml")); // Load the FXML view
			Parent modalRoot = loader.load();  // Load the root node from the FXML file

			// Create and configure the modal stage
			Stage modalStage = new Stage();
			modalStage.setTitle("Dialogo Modale");
			modalStage.initModality(Modality.WINDOW_MODAL); // Set the window as modal
			modalStage.initOwner(ownerStage); // Prevent interaction with the parent stage

			// Create the scene and set the FXML view
			modalStage.setScene(new Scene(modalRoot));
			modalStage.showAndWait(); // Show the modal and wait for it to be closed
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
