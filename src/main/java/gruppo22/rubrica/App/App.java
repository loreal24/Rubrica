package gruppo22.rubrica.App;

import gruppo22.rubrica.Controller.ContactListController;
import gruppo22.rubrica.Controller.HeaderController;
import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Exceptions.InvalidEmailException;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Email;
import gruppo22.rubrica.Model.Group;
import gruppo22.rubrica.Model.Groups;
import gruppo22.rubrica.Model.PhoneNumber;
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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException, InvalidContactException, InterruptedException, InvalidEmailException, InvalidPhoneNumberException {
        ContactList rubrica = Rubrica.readVCF("rubrica.vcf");
        List<ContactList> contactLists = new ArrayList<>();
        List<Groups> groupsList = new ArrayList<>();

        List numbers = new LinkedList();
        numbers.add("089825713");

        List emails = new LinkedList();
        emails.add("franco23@gmail.com");

        //rubrica.addContact(new Contact("Franco", "B", new Email(emails), new PhoneNumber(numbers), "Porterai Minecraft, vabè Maincraiff uhm no"));
        Groups groups = new Groups();

        Path startDir = Paths.get("./");

        try (Stream<Path> paths = Files.walk(startDir)) {
            paths.filter(Files::isRegularFile) // Ensure it's a file
                    .filter(path -> path.toString().endsWith(".vcf")) // Filter for .vcf files
                    .filter(path -> !path.getFileName().toString().equals("rubrica.vcf")) // Exclude rubrica.vcf
                    .forEach((path) -> {
                        try {
                            groups.addGroup(Group.readVCF(path.getFileName().toString()));
                        } catch (IOException ex) {
                            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvalidEmailException ex) {
                            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvalidPhoneNumberException ex) {
                            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvalidContactException ex) {
                            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }); // Apply your method
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean groupView = false;

        //FXMLLoader loader_1 = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/header.fxml"));	
        //Object load_1 = loader_1.load();
        //HeaderController controller_1 = loader_1.getController();
        //controller_1.setContactList(rubrica);
        //HeaderController.contactList = rubrica;
        //HeaderController.groupView = groupView;
        //HeaderController.groups = groups;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/header.fxml"));
        Parent headerRoot = loader.load();
        HeaderController headerController = loader.getController();
        headerController.initializeData(rubrica, groupView, groups);

        MainView mainView = new MainView(rubrica, groups, groupView);
        scene = new Scene(mainView, 650, 800);
        stage.setScene(scene);
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
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);

    }

}
