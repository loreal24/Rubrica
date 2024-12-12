/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.ContactListController;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 *
 * @author loreal
 */
public class ContactListView extends Pane {
	public ContactListView(ContactList rubrica, Groups groups){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/contactList.fxml"));
		try{
			loader.setControllerFactory((param) -> {
				return new ContactListController(rubrica, groups);
			});
			Parent root = loader.load();
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
}
