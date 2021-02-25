package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class InvalidLogin{

    @FXML
    private FlowPane InvalidIdScreen; 

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
