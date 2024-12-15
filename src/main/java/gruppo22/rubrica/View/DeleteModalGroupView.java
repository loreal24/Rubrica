/**
 * @file DeleteModalGroupView.java
 * @brief This class represents the view for the modal dialog used to delete a
 * group in the contact management application. It initializes the delete group
 * modal view and sets up the associated controller.
 *
 * @author lpane
 */
package gruppo22.rubrica.View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 * @class DeleteModalGroupView
 * @brief A class that provides the modal view for deleting a group.
 */
public class DeleteModalGroupView extends Pane {

	/**
	 * @brief Constructs a DeleteModalGroupView and initializes the FXML for the
	 * delete group modal.
	 */
	public DeleteModalGroupView() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/deleteModalGroup.fxml"));

		// Set the controller for the FXML file
		loader.setController(getClass().getResource("DeleteModalGroupController.java"));
		try {
			Parent root = loader.load();
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
