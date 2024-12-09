/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 *
 * @author lpane
 */
public class DeleteModalGroupView extends Pane{
    public DeleteModalGroupView(){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/deleteModalGroup.fxml"));

		loader.setController(getClass().getResource("DeleteModalGroupController.java"));
		try{
			Parent root = loader.load();
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
