package sample;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class InvalidLogin extends AnchorPane {

    @FXML
    private AnchorPane InvalidIdScreen; 

    public void invalidIdOk() throws IOException {
        AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("login.fxml"));
        InvalidIdScreen.getChildren().setAll(fxmlLoader);
    }
}
