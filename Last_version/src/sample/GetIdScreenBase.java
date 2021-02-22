package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class GetIdScreenBase implements  Initializable{

    @FXML
    private AnchorPane getIdScreen; 
    @FXML
    Label idField;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idField.setText(Integer.toString(SingUpScreen.newPlayerId));
    } 
    public void seeId() throws IOException
    {
        AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("onlineGame.fxml"));
        getIdScreen.getChildren().setAll(fxmlLoader);
    }
}
