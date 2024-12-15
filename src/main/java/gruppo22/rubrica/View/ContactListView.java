/**
 * @file ContactListView.java
 * @brief This class represents the view for displaying a list of contacts in
 * the contact management application. It initializes the contact list view and
 * sets up the associated controllers.
 *
 * @author Loreal
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.ContactListController;
import gruppo22.rubrica.Controller.SearchBarController;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 * @class ContactListView
 * @brief A class that provides the view for displaying and managing a list of
 * contacts.
 */
public class ContactListView extends Pane {

	/**
	 * @brief Constructs a ContactListView with the specified contact list and
	 * groups.
	 *
	 * @param rubrica The contact list to be displayed.
	 * @param groups The groups associated with the contacts.
	 */
	public ContactListView(ContactList rubrica, Groups groups) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/contactList.fxml"));
		try {
			loader.setControllerFactory((param) -> {
				ContactListController controller = new ContactListController(rubrica, groups);
				SearchBarController.contactListController = controller;
				return controller;
			});
			Parent root = loader.load();
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
