/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author loreal
 */
public class ModifyGroupController {

    private Group group;
	private Groups groups;

    public static TextField groupSearch;
    private Stage stage;

    @FXML
    private TextField groupNameTextField;

    @FXML
    private TextArea groupDescriptionTextArea;

    public ModifyGroupController(Stage ownerStage, Group group, Groups groups) {
        this.stage = ownerStage;
        this.group = group;
		this.groups = groups;
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
		groupNameTextField.setText(group.getName());
		if(group.getDescription() != null && !group.getDescription().isEmpty())
			groupDescriptionTextArea.setText(group.getDescription());
    }

    public void setGroups(Group group) {
        this.group = group;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleConfirm() {
		if(groupNameTextField.getText().isEmpty() || groupNameTextField.getText() == null){
			ErrorModalView modal = new ErrorModalView();
			modal.showModal("Errore", stage, "Il nome del gruppo non può essere vuoto");
		}
		else{

			groups.removeGroup(group);
			Path filePath = Paths.get(group.getName() + ".vcf");

        try {
            // Controlla se il file esiste
            if (Files.exists(filePath)) {
                // Cancella il file
                Files.delete(filePath);
                System.out.println("File cancellato: " + filePath);
            } else {
                System.out.println("Il file non esiste: " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Errore durante la cancellazione del file: " + e.getMessage());
        }
			group.setName(groupNameTextField.getText());
			if(groupDescriptionTextArea.getText() != null && !groupDescriptionTextArea.getText().isEmpty())
				group.setDescription(groupDescriptionTextArea.getText());

			groups.addGroup(group);

        groupSearch.setText("a");
        groupSearch.setText("");

        stage.close();
		}
    }

    @FXML
    public void handleUndo() {
        stage.close();
    }

}
