
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Local_OWinController{

    @FXML
    private void backToMenu(ActionEvent event) {
        new ScreenLoader().loadScene(event,"Menu.fxml");
    }

}