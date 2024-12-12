/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Rubrica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author loreal
 */
public class SearchBarController {
	private ContactList rubrica;
	public static ContactListController controller;

	@FXML 
	private TextField searchTextField;

	public SearchBarController(ContactList rubrica) {
		this.rubrica = (Rubrica)rubrica;
	} 

	/**
	 * Initializes the controller class.
	 */
	@FXML
	public void initialize() {
		searchTextField.textProperty().addListener((observable, oldValue, newValue) ->{
			controller.filterList(newValue);
		});
        searchTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // If newValue is false, the TextField lost focus
				searchTextField.setText("a");
				searchTextField.setText("");
            }
        });
	}	


	
}
