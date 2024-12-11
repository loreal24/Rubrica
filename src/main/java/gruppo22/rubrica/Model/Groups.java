/**
 * @file Groups.java
 * @brief This file contains the implementation of the List of Groups created by
 * the user.
 * @author loreal
 */
package gruppo22.rubrica.Model;

import java.util.LinkedList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Groups {
	private ObservableList<Group> groups;

	/**
	 * @brief Default Constructor
	 */
	public Groups() {
		groups = FXCollections.observableArrayList();
	}

	/**
	 * @brief Allows to add a group to the list of groups 
	 * @param g The group you want to add
	 */
	public void addGroup(Group g) {
		groups.add(g);	

		groups.sort(new GroupComparator());
	}

	/**
	 * @brief Allows to remove a group from the list of groups
	 * @param g The group you want to remove
	 */
	public void removeGroup(Group g) {
		if(!groups.isEmpty()) {
			groups.remove(g);
		}
	}
	
	public ObservableList<Group> getGroups() {
		return groups;
	}
}
