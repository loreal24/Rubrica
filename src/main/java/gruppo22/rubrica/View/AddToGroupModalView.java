package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.AddToGroupModalController;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author loreal
 */
public class AddToGroupModalView extends Pane {
	public static void showModal(String message, Stage ownerStage, Contact contact, ContactList rubrica) throws IOException {
		try{
			FXMLLoader loader = new FXMLLoader(ModifyContactView.class.getResource("/src/main/resources/gruppo22/rubrica/addToGroupModal.fxml"));
			Parent modalRoot = loader.load();
			AddToGroupModalController controller = loader.getController();	
			controller.setContact(contact);
			controller.setContactList(rubrica);
			controller.setStage(ownerStage);

			Stage modalStage = new Stage();
			modalStage.setTitle("Dialogo Modale");
			modalStage.initModality(Modality.WINDOW_MODAL);
			modalStage.initOwner(ownerStage);
			controller.setStage(modalStage);

			modalStage.setScene(new Scene(modalRoot));
			modalStage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
