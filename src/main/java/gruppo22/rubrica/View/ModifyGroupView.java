/**
 * @file ModifyGroupView.java
 * @brief This class represents the view for modifying a group in the contact management application.
 * It handles the display of the modal dialog for editing group details.
 * 
 * @author Loreal
 */

package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.ModifyGroupController;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @class ModifyGroupView
 * @brief A class that provides a modal view for modifying a group's details.
 */
public class ModifyGroupView extends Pane {

	/**
	 * @brief Displays the modal dialog for modifying a group.
	 *
	 * @param message A message to be displayed in the modal (currently unused).
	 * @param ownerStage The owner stage of the modal dialog.
	 * @param group The group to be modified.
	 * @param groups The groups object that contains all groups.
	 * @throws IOException If there is an error loading the FXML file.
	 */
	public static void showModal(String message, Stage ownerStage, Group group, Groups groups) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(ModifyGroupView.class.getResource("/src/main/resources/gruppo22/rubrica/modifyGroup.fxml"));
			Stage modalStage = new Stage();
			loader.setControllerFactory((param) -> {
				return new ModifyGroupController(modalStage, group, groups);
			});
			Parent modalRoot = loader.load();

			modalStage.setTitle("Modifica Gruppo");
			modalStage.initModality(Modality.WINDOW_MODAL);
			modalStage.initOwner(ownerStage);

			modalStage.setScene(new Scene(modalRoot));
			modalStage.showAndWait(); // Show the modal and wait for it to be closed
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
