/**
 * @file App.java
 * @brief This class serves as the main entry point for the JavaFX contact
 * management application. It initializes the application, loads contact data
 * from VCF files, and sets up the main user interface.
 *
 * @author Loreal
 */
package gruppo22.rubrica.App;

import gruppo22.rubrica.Controller.HeaderController;
import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Exceptions.InvalidEmailException;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.Model.Rubrica;
import gruppo22.rubrica.View.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * @class App
 * @brief The main application class for the contact management system.
 */
public class App extends Application {

	private static Scene scene;

	/**
	 * @brief The main entry point for the JavaFX application.
	 *
	 * @param stage The primary stage for this application.
	 * @throws IOException If there is an error reading VCF files.
	 * @throws InvalidContactException If a contact is invalid.
	 * @throws InterruptedException If the thread is interrupted.
	 * @throws InvalidEmailException If an email is invalid.
	 * @throws InvalidPhoneNumberException If a phone number is invalid.
	 */
	@Override
	public void start(Stage stage) throws IOException, InvalidContactException, InterruptedException, InvalidEmailException, InvalidPhoneNumberException {
		ContactList rubrica = Rubrica.readVCF("rubrica.vcf");
		List<ContactList> contactLists = new ArrayList<>();
		Groups groups = new Groups();

		Path startDir = Paths.get("./");

		// Load additional VCF files and add groups
		try (Stream<Path> paths = Files.walk(startDir)) {
			paths.filter(Files::isRegularFile) // Ensure it's a file
					.filter(path -> path.toString().endsWith(".vcf")) // Filter for .vcf files
					.filter(path -> !path.getFileName().toString().equals("rubrica.vcf")) // Exclude rubrica.vcf
					.forEach((path) -> {
						try {
							groups.addGroup(Group.readVCF(path.getFileName().toString()));
						} catch (IOException | InvalidEmailException | InvalidPhoneNumberException | InvalidContactException ex) {
							Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
						}
					});
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean groupView = false;

		// Set up the header controller
		HeaderController.contactList = rubrica;
		HeaderController.groupView = groupView;
		HeaderController.groups = groups;

		// Initialize the main view
		MainView mainView = new MainView(rubrica, groups, groupView);
		scene = new Scene(mainView, 650, 800);
		stage.setScene(scene);

		// Set up the close request handler
		stage.setOnCloseRequest(event -> {
			// Show a confirmation dialog
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Confirm Exit");
			alert.setHeaderText("Are you sure you want to exit?");
			contactLists.add(rubrica);
			groups.getGroups().forEach((Group group) -> {
				contactLists.add(group);
			});

			// Show the dialog and wait for a response
			alert.showAndWait().ifPresent(response -> {
				if (response != ButtonType.OK) {
					// If the user did not click OK, consume the event to prevent closing
					event.consume();
				} else {
					// Save contact lists before exiting
					contactLists.forEach((ContactList list) -> {
						if (list instanceof Rubrica) {
							try {
								((Rubrica) list).saveVCF("rubrica.vcf");
							} catch (IOException ex) {
								Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
							}
						} else {
							try {
								((Group) list).saveVCF(((Group) list).getName() + ".vcf");
							} catch (IOException ex) {
								Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
					});
				}
				// If OK is clicked, the application will close
			});
		});

		// Show the main stage
		stage.show();
	}

	/**
	 * @brief Sets the root of the scene to a new FXML layout.
	 *
	 * @param fxml The name of the FXML file to load.
	 * @throws IOException If there is an error loading the FXML file.
	 */
	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	/**
	 * @brief Loads an FXML file and returns the corresponding Parent node.
	 *
	 * @param fxml The name of the FXML file to load.
	 * @throws IOException If there is an error loading the FXML file.
	 * @return The Parent node loaded from the FXML file.
	 */
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	/**
	 * @brief The main method that launches the JavaFX application.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
