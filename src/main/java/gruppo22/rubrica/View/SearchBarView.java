/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.SearchBarController;
import gruppo22.rubrica.Model.ContactList;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 *
 * @author loreal
 */
public class SearchBarView extends Pane {
	public SearchBarView(ContactList rubrica){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/searchBar.fxml"));
			loader.setControllerFactory((param -> {
				return new SearchBarController(rubrica);
			}));

			Parent root = loader.load();
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
