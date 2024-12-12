package gruppo22.rubrica.Controller;

import gruppo22.rubrica.App.App;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.View.AddContactView;
import gruppo22.rubrica.View.ContactListView;
import gruppo22.rubrica.View.GroupListView;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HeaderController {
    
    //private ContactList contactList;
    public static ContactList contactList;
    public static boolean groupView;
    public static ContactListView contactListView;
    public static GroupListView groupListView;
    public static VBox v;
    @FXML
    Button addButton, visualizeGroupsButton; 
    
    @FXML
    public void handlerAddButton(){
        addButton.setOnAction(e-> {
            System.out.println("sono nell'header" + contactList);
            AddContactView view = new AddContactView();
            view.showModal("Aggiungi Contatto", (Stage) addButton.getScene().getWindow(), contactList);
        });
    }
    
    @FXML
    public void handlerVisualizeGroupsButton(){
        visualizeGroupsButton.setOnAction(e->{
			groupView = !groupView;
			if(groupView) {
				v.getChildren().remove(contactListView);
				v.getChildren().add(groupListView);
			}
			else {
				v.getChildren().remove(groupListView);
				v.getChildren().add(contactListView);
			}
        });
    }
    
    @FXML
    public void initialize(){
        handlerAddButton();
        handlerVisualizeGroupsButton();
    }
    
   
            
            
            
    /*public void setContactList(ContactList contactList){
        System.out.println("Sono nel metodo ContactList dell'headerController " + contactList);
        this.contactList=contactList;
    }*/
}