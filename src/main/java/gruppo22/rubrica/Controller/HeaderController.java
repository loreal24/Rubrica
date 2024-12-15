/**
 * @file HeaderController.java
 * @brief Controller class for managing the header actions in the application.
 * @author loreal 
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Exceptions.InvalidEmailException;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.Model.Rubrica;
import gruppo22.rubrica.View.AddContactView;
import gruppo22.rubrica.View.AddGroupModalView;
import gruppo22.rubrica.View.ContactListView;
import gruppo22.rubrica.View.GroupsListView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * This class handles user interactions related to adding contacts and groups,
 * visualizing groups, and importing/exporting contact data.
 */
public class HeaderController {

    public static ContactList contactList; ///< The contact list model.
    public static boolean groupView; ///< Flag indicating whether the group view is active.
    public static ContactListView contactListView; ///< The view for displaying contacts.
    public static GroupsListView groupListView; ///< The view for displaying groups.
    public static Groups groups; ///< The groups model.
    public static VBox v; ///< The main VBox layout.
    public static StackPane contactSearch, groupSearch; ///< Search panes for contacts and groups.

    @FXML
    Button addButton, visualizeGroupsButton, addGroupButton; ///< Buttons for adding contacts and groups.

    @FXML
    ImageView visualizeGroupImage; ///< Image view for displaying the current view icon.

    private Image contactImage, groupImage; ///< Images for contact and group views.

    /**
     * Handles the action for the add contact button.
     * Opens a modal to add a new contact.
     */
    @FXML
    public void handlerAddButton() {
        addButton.setOnAction(e -> {
            AddContactView view = new AddContactView();
            view.showModal("Aggiungi Contatto", (Stage) addButton.getScene().getWindow(), contactList);
        });
    }

    /**
     * Handles the action for the add group button.
     * Opens a modal to add a new group.
     * 
     * @param event The mouse event that triggered this action.
     */
    @FXML
    public void handlerAddGroupButton(MouseEvent event) {
        try {
            AddGroupModalView.showModal("Aggiungi Gruppo", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), groups);
        } catch (IOException ex) {
            Logger.getLogger(HeaderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the action for the visualize groups button.
     * Toggles between contact view and group view.
     */
    @FXML
    public void handlerVisualizeGroupsButton() {
        visualizeGroupsButton.setOnAction(e -> {
            groupView = !groupView;
            if (groupView) {
                visualizeGroupImage.setImage(groupImage);
                v.getChildren().remove(contactSearch);
                v.getChildren().add(groupSearch);
                v.getChildren().remove(contactListView);
                v.getChildren().add(groupListView);
                addGroupButton.setVisible(true);
                addButton.setVisible(false);
            } else {
                visualizeGroupImage.setImage(contactImage);
                v.getChildren().remove(groupSearch);
                v.getChildren().add(contactSearch);
                v.getChildren().remove(groupListView);
                v.getChildren().add(contactListView);
                addButton.setVisible(true);
                addGroupButton.setVisible(false);
            }
        });
    }

    /**
     * Handles the export action for contacts.
     * Exports the contact list to a VCF file.
     * 
     * @throws IOException If an I/O error occurs during export.
     */
    @FXML
    public void handleExport() throws IOException {
        exportToFile(new File("rubrica.vcf"));
    }

    /**
     * Handles the import action for contacts.
     * Imports contacts from a VCF file.
     * 
     * @throws IOException If an I/O error occurs during import.
     * @throws InvalidEmailException If an invalid email is encountered during import.
     * @throws InvalidPhoneNumberException If an invalid phone number is encountered during import.
     * @throws InvalidContactException If an invalid contact is encountered during import.
     */
    @FXML
    public void handleImport() throws IOException, InvalidEmailException, InvalidPhoneNumberException, InvalidContactException {
        importFromFile();
    }

    /**
     * Initializes the controller.
     * Sets up the initial state of the buttons and images.
     */
    @FXML
    public void initialize() {
        addGroupButton.setVisible(false);
        handlerAddButton();
        handlerVisualizeGroupsButton();
        contactImage = new Image(getClass().getResourceAsStream("/images/contact.png"));
        groupImage = new Image(getClass().getResourceAsStream("/images/groupIcon.png"));
        visualizeGroupImage.setImage(contactImage);
    }

    /**
     * Exports the contact list to a specified file.
     * 
     * @param exportFile The file to which the contact list will be exported.
     * @throws FileNotFoundException If the specified file is not found.
     * @throws IOException If an I/O error occurs during export.
     */
    private void exportToFile(File exportFile) throws FileNotFoundException, IOException {
        ((Rubrica) contactList).saveVCF("rubrica.vcf");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("vCard File", "*.vcf"));
        File destination = fileChooser.showSaveDialog(null);

        if (destination == null) {
            return; // User canceled the save dialog
        }

        // Show save file dialog
        if (exportFile != null) {
            try (FileInputStream fis = new FileInputStream(exportFile);
                 FileOutputStream fos = new FileOutputStream(destination)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
            }
        }
    }

    /**
     * Imports contacts from a selected VCF file.
     * 
     * @throws IOException If an I/O error occurs during import.
     * @throws InvalidEmailException If an invalid email is encountered during import.
     * @throws InvalidPhoneNumberException If an invalid phone number is encountered during import.
     * @throws InvalidContactException If an invalid contact is encountered during import.
     */
    private void importFromFile() throws IOException, InvalidEmailException, InvalidPhoneNumberException, InvalidContactException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File to Import");
        File sourceFile = fileChooser.showOpenDialog(null);

        // Check if a source file was selected
        if (sourceFile != null) {
            // Create a File object for the hardcoded destination file
            File destinationFile = new File("rubrica.vcf");

            try {
                copyFile(sourceFile, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ContactList list = Rubrica.readVCF("rubrica.vcf");

        list.getContacts().forEach((Contact contact) -> {
            try {
                contactList.addContact(contact);
            } catch (InvalidContactException ex) {
                Logger.getLogger(HeaderController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ((TextField) contactSearch.getChildren().get(0)).setText("a");
            ((TextField) contactSearch.getChildren().get(0)).setText("");
        });
    }

    /**
     * Copies a file from the source to the destination.
     * 
     * @param source The source file to copy.
     * @param destination The destination file where the content will be copied.
     * @throws IOException If an I/O error occurs during the copy.
     */
    private void copyFile(File source, File destination) throws IOException {
        // Use FileInputStream and FileOutputStream to copy the file content
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
    }
}


