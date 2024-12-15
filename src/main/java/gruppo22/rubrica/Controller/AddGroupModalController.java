/**
 * @file AddGroupModalController.java
 * @author loreal
 * @brief Controller for managing the Add Group modal in the application.
 *
 * This file contains the implementation of the AddGroupModalController class,
 * which handles user input for creating a new group, including validation and
 * interaction with the Groups model.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.View.ErrorModalView;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class for managing the Add Group modal. This class handles
 * the user input for creating a new group, including validation and interaction
 * with the Groups model.
 */
public class AddGroupModalController {

	/**
	 * The Groups model that holds all the groups.
	 */
	private Groups groups;

	/**
	 * A static TextField for searching groups.
	 */
	public static TextField groupSearch;

	/**
	 * The stage for the modal dialog.
	 */
	private Stage stage;

	/**
	 * TextField for entering the group name.
	 */
	@FXML
	private TextField groupNameTextField;

	/**
	 * TextArea for entering the group description.
	 */
	@FXML
	private TextArea groupDescriptionTextArea;

	/**
	 * Constructor for the AddGroupModalController.
	 *
	 * @param ownerStage The owner stage of the modal.
	 * @param groups The Groups model to manage group data.
	 */
	public AddGroupModalController(Stage ownerStage, Groups groups) {
		this.stage = ownerStage;
		this.groups = groups;
	}

	/**
	 * Sets the Groups model.
	 *
	 * @param groups The Groups model to set.
	 */
	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	/**
	 * Sets the stage for the modal dialog.
	 *
	 * @param stage The stage to set.
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Handles the confirm action when the user submits the group information.
	 * Validates the input and adds a new group to the Groups model. Displays an
	 * error modal if the group name is empty.
	 */
	@FXML
	public void handleConfirm() {
		if (groupNameTextField.getText().isEmpty() || groupNameTextField.getText() == null) {
			ErrorModalView modal = new ErrorModalView();
			modal.showModal("Errore", stage, "Il nome del gruppo non può essere vuoto");
		} else {
			Group group = new Group(groupNameTextField.getText(), groupDescriptionTextArea.getText());
			System.out.println(groups);
			groups.addGroup(group);

			try {
				group.saveVCF(group.getName() + ".vcf");
			} catch (IOException ex) {
				Logger.getLogger(AddGroupModalController.class.getName()).log(Level.SEVERE, null, ex);
			}

			groupSearch.setText("a");
			groupSearch.setText("");

			stage.close();
		}
	}

	/**
	 * Handles the undo action, closing the modal without making changes.
	 */
	@FXML
	public void handleUndo() {
		stage.close();
	}
}
