package gruppo22.rubrica.View;
import gruppo22.rubrica.Controller.GroupListController;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 *
 * @author loreal
 */
public class GroupListView extends Pane {
	public GroupListView(ContactList rubrica, Groups groups){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/main/resources/gruppo22/rubrica/groupList.fxml"));
		try{
			loader.setControllerFactory((param) -> {
				return new GroupListController(rubrica, groups);
			});
			Parent root = loader.load();
			getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
}
