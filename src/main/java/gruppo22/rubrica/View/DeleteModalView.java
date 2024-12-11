package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.DeleteModalController;
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
public class DeleteModalView extends Pane {
	public static void showModal(String message, Stage ownerStage, Contact contact, ContactList rubrica) throws IOException {
		try{
			FXMLLoader loader = new FXMLLoader(DeleteModalView.class.getResource("/src/main/resources/gruppo22/rubrica/deleteModal.fxml"));
			Parent modalRoot = loader.load();
			DeleteModalController controller = loader.getController();	
			controller.setContact(contact);
			controller.setContactList(rubrica);

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
