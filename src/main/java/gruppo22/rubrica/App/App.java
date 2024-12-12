package gruppo22.rubrica.App;

import gruppo22.rubrica.Controller.ContactListController;
import gruppo22.rubrica.Controller.HeaderController;
import gruppo22.rubrica.Exceptions.InvalidContactException;
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
import java.util.LinkedList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException, InvalidContactException, InterruptedException {
		ContactList rubrica = new Rubrica();

		List numbers = new LinkedList();
		numbers.add("089825713");

		List emails = new LinkedList();
		emails.add("franco23@gmail.com");

		rubrica.addContact(new Contact("Franco", "B", new Email(emails), new PhoneNumber(numbers), "Porterai Minecraft, vabè Maincraiff uhm no"));

		Groups groups = new Groups();
		groups.addGroup(new Group("Nome", "Descrizione"));

		boolean groupView = false;


                
                //FXMLLoader loader_1 = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/header.fxml"));	

		//Object load_1 = loader_1.load();
		//HeaderController controller_1 = loader_1.getController();
                System.out.println("Sono nell'App : " + rubrica);
                //controller_1.setContactList(rubrica);
                HeaderController.contactList=rubrica;
                HeaderController.groupView=groupView;

        MainView mainView = new MainView(rubrica,groups, groupView);
        scene = new Scene(mainView, 650, 800);
        
        stage.setScene(scene);
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
    //commitsemoo
    // ennesimo commento
}