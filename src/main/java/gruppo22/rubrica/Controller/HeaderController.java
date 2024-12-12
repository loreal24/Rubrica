package gruppo22.rubrica.Controller;

import gruppo22.rubrica.App.App;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.View.AddContactView;
import gruppo22.rubrica.View.AddGroupModalView;
import gruppo22.rubrica.View.ContactListView;
import gruppo22.rubrica.View.GroupsListView;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HeaderController {
    
    //private ContactList contactList;
    public static ContactList contactList;
    public static boolean groupView;
    public static ContactListView contactListView;
    public static GroupsListView groupListView;
	public static Groups groups;
    public static VBox v;
    @FXML
    Button addButton, visualizeGroupsButton, addGroupButton; 

    @FXML
    public void handlerAddButton(){
        addButton.setOnAction(e-> {
            System.out.println("sono nell'header" + contactList);
            AddContactView view = new AddContactView();
            view.showModal("Aggiungi Contatto", (Stage) addButton.getScene().getWindow(), contactList);
        });
    }

    @FXML
    public void handlerAddGroupButton(MouseEvent event){
			try {
				AddGroupModalView.showModal("Aggiungi Gruppo", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), groups);
			} catch (IOException ex) {
				Logger.getLogger(HeaderController.class.getName()).log(Level.SEVERE, null, ex);
			}
    }
    
    @FXML
    public void handlerVisualizeGroupsButton(){
        visualizeGroupsButton.setOnAction(e->{
			groupView = !groupView;
			if(groupView) {
				visualizeGroupsButton.setText("Contatti");
				v.getChildren().remove(contactListView);
				v.getChildren().add(groupListView);
				addGroupButton.setVisible(true);
				addButton.setVisible(false);
			}
			else {
				visualizeGroupsButton.setText("Gruppi");
				v.getChildren().remove(groupListView);
				v.getChildren().add(contactListView);
				addButton.setVisible(true);
				addGroupButton.setVisible(false);
			}
        });
    }
    
    @FXML
    public void initialize(){
		addGroupButton.setVisible(false);
        handlerAddButton();
        handlerVisualizeGroupsButton();
    }
    
   
            
            
            
    /*public void setContactList(ContactList contactList){
        System.out.println("Sono nel metodo ContactList dell'headerController " + contactList);
        this.contactList=contactList;
    }*/
}