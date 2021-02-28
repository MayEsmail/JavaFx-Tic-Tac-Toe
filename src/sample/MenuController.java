package sample;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;



public class MenuController implements Initializable{
    //we need to stord previos page for back and login and to know if the user is logged in by setting this variable to true in first login
    public static boolean is_loggedin=false;
    public static boolean computerPlay,local;
    @FXML
    Button logoutButton;
    @FXML
    private FlowPane parent_menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(is_loggedin)
            logoutButton.setVisible(true);
        else
            logoutButton.setVisible(false);
    } 
    
    public void PlayOnline(ActionEvent event) throws  Exception{
        if(!is_loggedin){
           try {
//                Parent Menu2_Parent=FXMLLoader.load(getClass().getResource("Login_or_Register.fxml"));
//                Scene Menu2_Scene=new Scene(Menu2_Parent);
//                Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
//                App_Stage.setScene(Menu2_Scene);
//                App_Stage.show();
            FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Login_or_Register.fxml"));
               parent_menu.getChildren().setAll(fxmlLoader);
            } catch(IOException e) {
               e.printStackTrace();
            }
        }
        else
        {
            try {
                    computerPlay=false;
//                    Parent Menu2_Parent=FXMLLoader.load(getClass().getResource("onlineGame.fxml"));
//                    Scene Menu2_Scene=new Scene(Menu2_Parent);
//                    Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
//                    App_Stage.setScene(Menu2_Scene);
//                    App_Stage.show();
            FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("onlineGame.fxml"));
                parent_menu.getChildren().setAll(fxmlLoader);
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
            local=true;
            computerPlay = false;
            FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Record.fxml"));

            parent_menu.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void PlayAgainstComp() throws  Exception{
        try {
            local=false;
            computerPlay = true;
            FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Record.fxml"));
            parent_menu.getChildren().setAll(fxmlLoader);
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
           
//           FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Profile.fxml"));
//           parent_login.getChildren().setAll(fxmlLoader);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void view_leaderboard(){
        try{
        FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
            parent_menu.getChildren().setAll(fxmlLoader);
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
    public void viewGame(ActionEvent event) throws Exception{
        try {
//            ReplayController.show();
            Parent Profile_Parent=FXMLLoader.load(getClass().getResource("Replay.fxml"));
            Scene Profile_Scene=new Scene(Profile_Parent);
            Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow();
            App_Stage.setScene(Profile_Scene);
            App_Stage.show();
//            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Replay.fxml"));
//            parent_menu.getChildren().setAll(fxmlLoader);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void logout() throws SQLException{
        is_loggedin = false;
        OnlineGame.databaseObj.LoginOut(OnlineGame.userId);
        OnlineGame.userId=0;
        GameDatabase.disconnectDB();
        OnlineGame.checkDB = false;
        logoutButton.setVisible(false);
    }
}
