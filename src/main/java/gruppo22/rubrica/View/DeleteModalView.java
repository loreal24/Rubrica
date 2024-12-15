/**
 * @file DeleteModalView.java
 * @brief This class represents the view for the modal dialog used to delete a
 * contact in the contact management application. It handles the display of the
 * modal dialog and the interaction with the associated controller.
 *
 * @author Loreal
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.DeleteModalController;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @class DeleteModalView
 * @brief A class that provides a modal view for deleting a contact.
 */
public class DeleteModalView extends Pane {

	/**
	 * @brief Displays the modal dialog for deleting a contact.
	 *
	 * @param message A message to be displayed in the modal (currently unused).
	 * @param ownerStage The owner stage of the modal dialog.
	 * @param contact The contact to be deleted.
	 * @param rubrica The contact list that contains the contact.
	 * @param groups The groups associated with the contacts.
	 * @throws IOException If there is an error loading the FXML file.
	 */
	public static void showModal(String message, Stage ownerStage, Contact contact, ContactList rubrica, Groups groups) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(DeleteModalView.class.getResource("/src/main/resources/gruppo22/rubrica/deleteModal.fxml"));
			Parent modalRoot = loader.load();
			DeleteModalController controller = loader.getController();
			controller.setContact(contact);
			controller.setGroups(groups);
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
