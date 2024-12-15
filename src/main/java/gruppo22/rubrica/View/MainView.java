/**
 * @file MainView.java
 * @brief This class represents the main view of the contact management
 * application. It initializes the header, search bar, contact list, and groups
 * list views, and organizes them in a layout.
 *
 * @author Loreal
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.HeaderController;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @class MainView
 * @brief A class that provides the main layout for the application, including
 * the header, search bar, and lists of contacts and groups.
 */
public class MainView extends VBox {

	private HeaderView header;
	private SearchBarView search;
	private ContactListView contactListView;
	private GroupsListView groupListView;
	private ContactList contactList;
	private Groups groups;

	public static StackPane contactSearch;

	/**
	 * @brief Constructs a MainView with the specified contact list, groups, and
	 * view mode.
	 *
	 * @param rubrica The contact list to be displayed.
	 * @param groups The groups associated with the contacts.
	 * @param groupView A boolean indicating whether to display the group view.
	 */
	public MainView(ContactList rubrica, Groups groups, boolean groupView) {
		header = new HeaderView();
		search = new SearchBarView();
		contactListView = new ContactListView(rubrica, groups);
		groupListView = new GroupsListView(rubrica, groups);

		HeaderController.contactListView = contactListView;
		HeaderController.groupListView = groupListView;

		setAlignment(Pos.CENTER);

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);

		VBox v = new VBox();

		v.getChildren().addAll(header, contactSearch, contactListView);
		box.getChildren().addAll(v);
		getChildren().add(box);

		HeaderController.v = v;
	}

	/**
	 * @brief Sets the contact list for the main view.
	 *
	 * @param contactList The contact list to be set.
	 */
	public void setContactList(ContactList contactList) {
		this.contactList = contactList;
	}

	/**
	 * @brief Sets the groups for the main view.
	 *
	 * @param groups The groups to be set.
	 */
	public void setGroups(Groups groups) {
		this.groups = groups;
	}
}
