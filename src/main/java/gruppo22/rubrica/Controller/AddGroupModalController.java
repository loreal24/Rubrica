/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import java.net.URL;
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
public class AddGroupModalController {

	private Groups groups;

	public static TextField groupSearch;
	private Stage stage;

	@FXML
	private TextField groupNameTextField;

	@FXML
	private TextArea groupDescriptionTextArea; 

	public AddGroupModalController(Stage ownerStage, Groups groups) {
		this.stage = ownerStage;
		this.groups = groups;
	}

	/**
	 * Initializes the controller class.
	 */
	@FXML
	public void initialize(URL url, ResourceBundle rb) {
	}	

	public void setGroups(Groups groups){
		this.groups = groups;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
	public void handleConfirm() {
		Group group = new Group(groupNameTextField.getText(), groupDescriptionTextArea.getText());
		groups.addGroup(group);
		groupSearch.setText("a");
		groupSearch.setText("");
		
		stage.close();
	}

	@FXML
	public void handleUndo() {
		stage.close();
	}
	
}
