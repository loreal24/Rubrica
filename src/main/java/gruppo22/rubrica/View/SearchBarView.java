/**
 * @file SearchBarView.java
 * @brief This class represents the view for the search bar in the contact
 * management application. It initializes the search bar view and loads the
 * associated FXML layout.
 *
 * @author Loreal
 */
package gruppo22.rubrica.View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 * @class SearchBarView
 * @brief A class that provides the view for the search bar in the application.
 */
public class SearchBarView extends Pane {

	/**
	 * @brief Constructs a SearchBarView and initializes the FXML for the search
	 * bar.
	 */
	public SearchBarView() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/searchBar.fxml"));
			loader.getController(); // Retrieve the controller (currently unused)
			Parent root = loader.load(); // Load the root node from the FXML file
			getChildren().add(root); // Add the loaded root to this pane
		} catch (IOException e) {
			e.printStackTrace(); // Print the stack trace in case of an IOException
		}
	}
}
