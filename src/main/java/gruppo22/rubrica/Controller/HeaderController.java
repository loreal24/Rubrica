package gruppo22.rubrica.Controller;

import gruppo22.rubrica.App.App;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HeaderController {

    //private ContactList contactList;
    public static ContactList contactList;
    public static boolean groupView;
    public static ContactListView contactListView;
    public static GroupsListView groupListView;
    public static Groups groups;
    public static VBox v;
    public static StackPane contactSearch, groupSearch;
   // private ContactList contactList;
    //private boolean groupView;
    //private Groups groups;

    @FXML
    Button addButton, visualizeGroupsButton, addGroupButton;

    @FXML
    public void handlerAddButton() {
        addButton.setOnAction(e -> {
            System.out.println("sono nell'header" + contactList);
            AddContactView view = new AddContactView();
            view.showModal("Aggiungi Contatto", (Stage) addButton.getScene().getWindow(), contactList);
        });
    }

    @FXML
    public void handlerAddGroupButton(MouseEvent event) {
		System.out.println("GEOUPR" + groups.getGroups());
        try {
            AddGroupModalView.showModal("Aggiungi Gruppo", (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow(), groups);
        } catch (IOException ex) {
            Logger.getLogger(HeaderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void handlerVisualizeGroupsButton() {
        visualizeGroupsButton.setOnAction(e -> {
            groupView = !groupView;
            if (groupView) {
                visualizeGroupsButton.setText("Contatti");
                v.getChildren().remove(contactSearch);
                v.getChildren().add(groupSearch);
                v.getChildren().remove(contactListView);
                v.getChildren().add(groupListView);
                addGroupButton.setVisible(true);
                addButton.setVisible(false);
            } else {
                visualizeGroupsButton.setText("Gruppi");
                v.getChildren().remove(groupSearch);
                v.getChildren().add(contactSearch);
                v.getChildren().remove(groupListView);
                v.getChildren().add(contactListView);
                addButton.setVisible(true);
                addGroupButton.setVisible(false);
            }
        });
    }

    @FXML
    public void handleExport() throws IOException {
        exportToFile(new File("rubrica.vcf"));

    }

    @FXML
    public void handleImport() throws IOException, InvalidEmailException, InvalidPhoneNumberException, InvalidContactException {
        importFromFile();
    }

    @FXML
    public void initialize() {
        addGroupButton.setVisible(false);
        handlerAddButton();
        handlerVisualizeGroupsButton();
    }

    private void exportToFile(File exportFile) throws FileNotFoundException, IOException {
        ((Rubrica) contactList).saveVCF("rubrica.vcf");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("vCard File", "*.vcf"));
        File destination = fileChooser.showSaveDialog(null);

        if (destination == null) {
            return;
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
            System.out.println(contactList.getContacts());
            ((TextField) contactSearch.getChildren().get(0)).setText("a");
            ((TextField) contactSearch.getChildren().get(0)).setText("");
        });

    }

    private void copyFile(File source, File destination) throws IOException {
        // Use FileInputStream and FileOutputStream to copy the file content
        System.out.println(source.toString());
        try (FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
    }
    
	/*
    public void initializeData(ContactList contactList, boolean groupView, Groups groups) {
    this.contactList = contactList;
    this.groupView = groupView;
    this.groups = groups;
}
*/


}
