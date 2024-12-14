package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.AddGroupModalController;
import gruppo22.rubrica.Controller.DeleteModalController;
import gruppo22.rubrica.Controller.ModifyGroupController;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModifyGroupView extends Pane {
	public static void showModal(String message, Stage ownerStage, Group group, Groups groups) throws IOException {
		try{
			FXMLLoader loader = new FXMLLoader(ModifyGroupView.class.getResource("/src/main/resources/gruppo22/rubrica/modifyGroup.fxml"));
			Stage modalStage = new Stage();
			loader.setControllerFactory((param) -> {
				return new ModifyGroupController(modalStage, group, groups);
			});
			Parent modalRoot = loader.load();

			modalStage.setTitle("Modifica Gruppo");
			modalStage.initModality(Modality.WINDOW_MODAL);
			modalStage.initOwner(ownerStage);

			modalStage.setScene(new Scene(modalRoot));
			modalStage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
