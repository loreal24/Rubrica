package gruppo22.rubrica.Controller;

import gruppo22.rubrica.App.App;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.View.AddContactView;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HeaderController {
    
    //private ContactList contactList;
    public static ContactList contactList;
    @FXML
    Button addButton; 
    
    @FXML
    public void handlerAddButton(){
        addButton.setOnAction(e-> {
            System.out.println("sono nell'header" + contactList);
            AddContactView view = new AddContactView();
            view.showModal("Aggiungi Contatto", (Stage) addButton.getScene().getWindow(), contactList);
        });
    }
    
    @FXML
    public void initialize(){
        handlerAddButton();
    }
    
   
            
            
            
    /*public void setContactList(ContactList contactList){
        System.out.println("Sono nel metodo ContactList dell'headerController " + contactList);
        this.contactList=contactList;
    }*/
}