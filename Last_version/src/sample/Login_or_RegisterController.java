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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login_or_RegisterController {
    @FXML
    private AnchorPane parent_menu2;
    @FXML
    private void login(ActionEvent event) {
        try {
//           Parent Login_Parent=FXMLLoader.load(getClass().getResource(".fxml"));
//           Scene Login_Scene=new Scene(Login_Parent);
//           Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
//           App_Stage.setScene(Login_Scene);
//           App_Stage.show();
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("login.fxml"));
            parent_menu2.getChildren().setAll(fxmlLoader);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void register(ActionEvent event) throws IOException {

        AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("SingUpScreen.fxml"));
        parent_menu2.getChildren().setAll(fxmlLoader);

    }

    @FXML
    private void back(ActionEvent event) {
        try {
           Parent Menu_Parent=FXMLLoader.load(getClass().getResource("Menu.fxml"));
           Scene Menu_Scene=new Scene(Menu_Parent);
           Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
           App_Stage.setScene(Menu_Scene);
           App_Stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
