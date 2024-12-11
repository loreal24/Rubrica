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
    
    private ContactList contactList;
    @FXML
    Button addButton; 
    
    @FXML
    public void handlerAddButton(){
        addButton.setOnAction(e-> {
            AddContactView view = new AddContactView(contactList);
            Scene scene = new Scene(view);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        });
    }
    
    public void setContactList(ContactList contactList){
        this.contactList=contactList;
    }
}