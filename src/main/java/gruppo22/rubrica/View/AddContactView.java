/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import java.awt.ScrollPane;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
/**
 *
 * @author simon
 */
public class AddContactView extends Pane{
    public AddContactView(){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/addContact.fxml"));

		loader.setController(getClass().getResource("AddContactController.java"));
		try{
			Parent root = loader.load();
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
    
}
