/**
 * @file GroupListView.java
 * @brief This class represents the view for displaying a list of groups in the
 * contact management application. It handles the display of the modal dialog
 * for managing groups.
 *
 * @author Loreal
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.GroupListController;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @class GroupListView
 * @brief A class that provides a modal view for displaying and managing a list
 * of groups.
 */
public class GroupListView {

	/**
	 * @brief Displays the modal dialog for managing a list of groups.
	 *
	 * @param message A message to be displayed in the modal (currently unused).
	 * @param ownerStage The owner stage of the modal dialog.
	 * @param rubrica The contact list associated with the groups.
	 * @param group The specific group to be managed.
	 * @param groups The groups object that contains all groups.
	 */
	public static void showModal(String message, Stage ownerStage, ContactList rubrica, Group group, Groups groups) {
		try {
			FXMLLoader loader = new FXMLLoader(GroupListView.class.getResource("/src/main/resources/gruppo22/rubrica/groupList.fxml"));
			Stage modalStage = new Stage();

			loader.setControllerFactory((param) -> {
				return new GroupListController(rubrica, group, groups, modalStage);
			});

			Parent modalRoot = loader.load();

			// Set the title and modality for the modal stage
			modalStage.setTitle("Dialogo Modale");
			modalStage.initModality(Modality.WINDOW_MODAL);
			modalStage.initOwner(ownerStage);

			modalStage.setScene(new Scene(modalRoot));
			modalStage.showAndWait(); // Show the modal and wait for it to be closed
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
