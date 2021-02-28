package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class InvalidLogin  implements  Initializable{
    @FXML
    private Label invalidMessage;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switch(LoginController.invalidType)
        {
            case 1:
                invalidMessage.setText("This ID doesn't exist");
                break;
            case 2:
                invalidMessage.setText("This ID is already logged in");
                break;
            case 3:
                invalidMessage.setText("It isn't accepted ID");
                break;
        }
    } 

    public void invalidIdOk(ActionEvent event) throws IOException {
        new ScreenLoader().loadScene(event,"login.fxml");
    }
}
