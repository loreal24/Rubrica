package gruppo22.rubrica.View;

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
public class ModifyContactView extends Pane {
	public static void showModal(String message, Stage ownerStage) throws IOException {
		try{
			FXMLLoader loader = new FXMLLoader(ModifyContactView.class.getResource("/src/main/resources/gruppo22/rubrica/modifyContact.fxml"));// Carica la vista FXML
			Parent modalRoot = loader.load();  // Carica il nodo root dal file FXML                      
                        
                        // Crea e configura il stage modale
			Stage modalStage = new Stage();
			modalStage.setTitle("Dialogo Modale");
			modalStage.initModality(Modality.WINDOW_MODAL);// Imposta la finestra come modale
			modalStage.initOwner(ownerStage);// Impedisce interazione con il parent stage
                        
                        // Crea la scena e imposta la vista FXML
			modalStage.setScene(new Scene(modalRoot));
			modalStage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
