/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.GroupListController;
import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author loreal
 */
public class GroupListView {
	public static void showModal(String message, Stage ownerStage, ContactList rubrica, Group group, Groups groups) {
        try {
            FXMLLoader loader = new FXMLLoader(ContactListView.class.getResource("/src/main/resources/gruppo22/rubrica/groupList.fxml"));
            Stage modalStage = new Stage();
			loader.setControllerFactory((param) -> {
				return new GroupListController(rubrica, group, groups, modalStage);
			});

            Parent modalRoot = loader.load();

            // Ottieni il controller e imposta il messaggio

            // Crea un nuovo stage per il dialogo modale
            modalStage.setTitle("Dialogo Modale");
            modalStage.initModality(Modality.WINDOW_MODAL);
            modalStage.initOwner(ownerStage);

            modalStage.setScene(new Scene(modalRoot));
            modalStage.showAndWait(); // Mostra il modale e aspetta che venga chiuso
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
