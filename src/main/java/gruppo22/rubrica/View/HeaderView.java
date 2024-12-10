/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.HeaderController;
import gruppo22.rubrica.Model.ContactList;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 *
 * @author loreal
 */
public class HeaderView extends Pane {
	public HeaderView(ContactList contactList){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/header.fxml"));

		loader.setController(getClass().getResource("HeaderController.java"));
		try{
			Parent root = loader.load();
                        HeaderController controller = loader.getController();
                        controller.setContactList(contactList);
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
