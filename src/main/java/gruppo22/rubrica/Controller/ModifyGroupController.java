/*
 * @file ModifyGroupController.java
 * @brief Controller class for modifying group details in the application.
 * @author loreal
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.View.ErrorModalView;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This class handles the user interface for modifying an existing group,
 * including updating the group's name and description, and managing
 * the associated file operations.
 */
public class ModifyGroupController {

    private Group group; ///< The group being modified.
    private Groups groups; ///< The model containing all groups.

    public static TextField groupSearch; ///< TextField for searching groups.
    private Stage stage; ///< The stage for the current modal.

    @FXML
    private TextField groupNameTextField; ///< TextField for entering the group's name.

    @FXML
    private TextArea groupDescriptionTextArea; ///< TextArea for entering the group's description.

    /**
     * Constructor for ModifyGroupController.
     * 
     * @param ownerStage The owner stage for the modal.
     * @param group The group to be modified.
     * @param groups The groups model.
     */
    public ModifyGroupController(Stage ownerStage, Group group, Groups groups) {
        this.stage = ownerStage;
        this.group = group;
        this.groups = groups;
    }

    /**
     * Initializes the controller class.
     * This method sets the initial values for the text fields based on the group details.
     */
    @FXML
    public void initialize() {
        groupNameTextField.setText(group.getName());
        if (group.getDescription() != null && !group.getDescription().isEmpty()) {
            groupDescriptionTextArea.setText(group.getDescription());
        }
    }

    /**
     * Sets the group to be modified.
     * 
     * @param group The group to be modified.
     */
    public void setGroups(Group group) {
        this.group = group;
    }

    /**
     * Sets the stage for the modal.
     * 
     * @param stage The stage to be set.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Handles the confirmation action for modifying the group.
     * Validates the input and updates the group details.
     */
    @FXML
    public void handleConfirm() {
        if (groupNameTextField.getText().isEmpty() || groupNameTextField.getText() == null) {
            ErrorModalView modal = new ErrorModalView();
            modal.showModal("Errore", stage, "Il nome del gruppo non può essere vuoto");
        } else {
            groups.removeGroup(group);
            Path filePath = Paths.get(group.getName() + ".vcf");

            try {
                // Check if the file exists
                if (Files.exists(filePath)) {
                    // Delete the file
                    Files.delete(filePath);
                    System.out.println("File cancellato: " + filePath);
                } else {
                    System.out.println("Il file non esiste: " + filePath);
                }
            } catch (IOException e) {
                System.err.println("Errore durante la cancellazione del file: " + e.getMessage());
            }

            group.setName(groupNameTextField.getText());
			groupSearch.setText("a");
			groupSearch.setText("");
            if (groupDescriptionTextArea.getText() != null && !groupDescriptionTextArea.getText().isEmpty()) {
                group.setDescription(groupDescriptionTextArea.getText());
				groupSearch.setText("a");
				groupSearch.setText("");
            }

            groups.addGroup(group);

            groupSearch.setText("a");
            groupSearch.setText("");

            stage.close();

            groupSearch.setText("a");
            groupSearch.setText("");
        }
    }

    /**
     * Handles the undo action, closing the modal without saving changes.
     */
    @FXML
    public void handleUndo() {
        stage.close();
    }
}