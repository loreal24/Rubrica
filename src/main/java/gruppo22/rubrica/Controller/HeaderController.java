package gruppo22.rubrica.Controller;

import gruppo22.rubrica.App.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class HeaderController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}