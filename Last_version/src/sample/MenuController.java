package sample;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class MenuController {
    public static boolean computerPlay;
    @FXML
    private AnchorPane rootPane;
    //we need to stord previos page for back and login and to know if the user is logged in by setting this variable to true in first login
    public boolean is_loggedin=false;
    public void PlayOnline(ActionEvent event) throws  Exception{
        if(!is_loggedin){
           try {
//                Parent Menu2_Parent=FXMLLoader.load(getClass().getResource("Login_or_Register.fxml"));
//                Scene Menu2_Scene=new Scene(Menu2_Parent);
//                Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
//                App_Stage.setScene(Menu2_Scene);
//                App_Stage.show();
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Login_or_Register.fxml"));
            rootPane.getChildren().setAll(fxmlLoader);
            } catch(IOException e) {
               e.printStackTrace();
            }
        }
//        try {
//            computerPlay=false;
//            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("onlineGame.fxml"));
//            rootPane.getChildren().setAll(fxmlLoader);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }
    public void Exit(){
        Platform.exit();
    }
    public void PlayLocally() throws  Exception{
        try {
            computerPlay = false;
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            rootPane.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void PlayAgainstComp() throws  Exception{
        try {
            computerPlay = true;
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            rootPane.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void open_profile(ActionEvent event) throws  Exception{
        try {
           Parent Profile_Parent=FXMLLoader.load(getClass().getResource("Profile.fxml"));
           Scene Profile_Scene=new Scene(Profile_Parent);
           Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
           App_Stage.setScene(Profile_Scene);
           App_Stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
