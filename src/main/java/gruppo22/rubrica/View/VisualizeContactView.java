/**
 * @file VisualizeContactView.java
 * @brief This class represents the view for visualizing a contact's details in
 * the contact management application. It handles the display of the modal
 * dialog for viewing contact information.
 *
 * @author lpane
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Controller.VisualizeContactController;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @class VisualizeContactView
 * @brief A class that provides a modal view for visualizing a contact's
 * details.
 */
public class VisualizeContactView extends Pane {

	/**
	 * @brief Displays the modal dialog for visualizing a contact's details.
	 *
	 * @param message A message to be displayed in the modal (currently unused).
	 * @param ownerStage The owner stage of the modal dialog.
	 * @param contact The contact to be visualized.
	 * @param rubrica The contact list that contains the contact.
	 * @param groups The groups associated with the contacts.
	 */
	public static void showModal(String message, Stage ownerStage, Contact contact, ContactList rubrica, Groups groups) {
		try {
			FXMLLoader loader = new FXMLLoader(VisualizeContactView.class.getResource("/src/main/resources/gruppo22/rubrica/visualizeContact.fxml"));
			Parent modalRoot = loader.load();

			// Get the controller and set the contact details
			VisualizeContactController controller = loader.getController();
			controller.setContact(contact);
			controller.setContactList(rubrica);
			controller.setGroups(groups);

			// Create a new stage for the modal dialog
			Stage modalStage = new Stage();
			modalStage.setTitle("Dialogo Modale");
			modalStage.initModality(Modality.WINDOW_MODAL);
			modalStage.initOwner(ownerStage);
			controller.setStage(modalStage); // Pass the stage to the controller

			modalStage.setScene(new Scene(modalRoot));
			modalStage.showAndWait(); // Show the modal and wait for it to be closed
		} catch (Exception e) {
			e.printStackTrace(); // Print the stack trace in case of an exception
		}
	}
}
