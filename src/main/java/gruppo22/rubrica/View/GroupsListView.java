/**
 * @file GroupsListView.java
 * @brief This class represents the view for displaying a list of groups in the
 * contact management application. It initializes the groups list view and sets
 * up the associated controllers.
 *
 * @author Loreal
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.GroupsListController;
import gruppo22.rubrica.Controller.SearchBarController;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 * @class GroupsListView
 * @brief A class that provides the view for displaying and managing a list of
 * groups.
 */
public class GroupsListView extends Pane {

	/**
	 * @brief Constructs a GroupsListView with the specified contact list and
	 * groups.
	 *
	 * @param rubrica The contact list to be displayed.
	 * @param groups The groups associated with the contacts.
	 */
	public GroupsListView(ContactList rubrica, Groups groups) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/groupsList.fxml"));
		try {
			loader.setControllerFactory((param) -> {
				GroupsListController controller = new GroupsListController(rubrica, groups);
				SearchBarController.groupsListController = controller;
				return controller;
			});
			Parent root = loader.load();
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
