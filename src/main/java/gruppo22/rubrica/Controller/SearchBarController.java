/**
 * @file SearchBarController.java
 * @brief Controller class for managing the search bar functionality in the
 * application.
 * @author loreal
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.View.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

/**
 * This class handles user input for searching contacts and groups. It updates
 * the respective controllers with the search queries and manages the focus
 * behavior of the search fields.
 */
public class SearchBarController {

	public static ContactListController contactListController; ///< Controller for managing the contact list.
	public static GroupsListController groupsListController; ///< Controller for managing the groups list.

	@FXML
	private TextField contactTextField; ///< TextField for searching contacts.

	@FXML
	private TextField groupTextField; ///< TextField for searching groups.

	@FXML
	private StackPane groupSearch; ///< StackPane for group search UI.

	@FXML
	private StackPane contactSearch; ///< StackPane for contact search UI.

	/**
	 * Initializes the search bar controller. This method sets up the search
	 * fields and their listeners for filtering contacts and groups based on
	 * user input.
	 */
	@FXML
	public void initialize() {
		HeaderController.groupSearch = groupSearch;
		HeaderController.contactSearch = contactSearch;
		MainView.contactSearch = contactSearch;
		AddContactController.contactSearch = contactTextField;
		AddGroupModalController.groupSearch = groupTextField;
		DeleteModalController.contactTextField = contactTextField;
		ModifyGroupController.groupSearch = contactTextField;

		// Listener for contact search field
		contactTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			contactListController.filterList(newValue);
		});
		contactTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) { // If newValue is false, the TextField lost focus
				contactTextField.setText("a");
				contactTextField.setText("");
			}
		});

		// Listener for group search field
		groupTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			groupsListController.filterList(newValue);
		});
		groupTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) { // If newValue is false, the TextField lost focus
				groupTextField.setText("a");
				groupTextField.setText("");
			}
		});
	}
}
