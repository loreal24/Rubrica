/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.Model.Rubrica;
import gruppo22.rubrica.View.MainView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author loreal
 */
public class SearchBarController {

    private ContactList rubrica;
    private Groups groups;
    public static ContactListController contactListController;
    public static GroupsListController groupsListController;

    @FXML
    private TextField contactTextField, groupTextField;

    @FXML
    private StackPane groupSearch, contactSearch;

    public SearchBarController(ContactList rubrica, Groups groups) {
        this.rubrica = (Rubrica) rubrica;
        this.groups = groups;
    }

    /**
     * Initializes the contactListController class.
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

        contactTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            contactListController.filterList(newValue);
        });
        contactTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // If newValue is false, the TextField lost focus
                contactTextField.setText("a");
                contactTextField.setText("");
            }
        });

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
