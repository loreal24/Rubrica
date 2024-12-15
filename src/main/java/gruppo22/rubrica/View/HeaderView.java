/**
 * @file HeaderView.java
 * @brief This class represents the view for the header section of the contact
 * management application. It initializes the header view and sets up the
 * associated controller.
 *
 * @author Loreal
 */
package gruppo22.rubrica.View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 * @class HeaderView
 * @brief A class that provides the view for the header of the application.
 */
public class HeaderView extends Pane {

	/**
	 * @brief Constructs a HeaderView and initializes the FXML for the header.
	 */
	public HeaderView() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/header.fxml"));

		// Set the controller for the FXML file
		loader.setController(getClass().getResource("HeaderController.java"));
		try {
			Parent root = loader.load();
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
