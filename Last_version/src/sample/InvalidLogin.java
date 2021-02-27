package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class InvalidLogin  implements  Initializable{

    @FXML
    private FlowPane InvalidIdScreen; 
    @FXML
    private Label invalidMessage;
    
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
        Parent login_Parent=FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene login_Scene=new Scene(login_Parent);
        Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
        App_Stage.setScene(login_Scene);
        App_Stage.show();
//        FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("login.fxml"));
//        InvalidIdScreen.getChildren().setAll(fxmlLoader);
    }
}
