package gruppo22.rubrica.Controller;

import gruppo22.rubrica.App.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class ContactCardController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
