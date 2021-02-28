package sample;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;


public class MenuController implements Initializable{
    //we need to stord previos page for back and login and to know if the user is logged in by setting this variable to true in first login
    public static boolean is_loggedin=false;
    public static boolean computerPlay,local;
    public ScreenLoader screenLoader=new ScreenLoader();
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
        //Controller.playOnline=true;
        if(!is_loggedin)
           screenLoader.loadScene(event,"Login_or_Register.fxml");
        else{
           computerPlay=local=false;
           screenLoader.loadScene(event,"onlineGame.fxml");
        }
    }
    public void Exit(){
        Platform.exit();
    }
    public void PlayLocally(ActionEvent event) throws  Exception{
        local=true;
        computerPlay = false;
        screenLoader.loadScene(event,"Record.fxml");
    }
    public void PlayAgainstComp(ActionEvent event) throws  Exception{
        local=false;
        computerPlay = true;
        screenLoader.loadScene(event,"Record.fxml");
    }
    public void open_profile(ActionEvent event) throws  Exception{
        screenLoader.loadScene(event,"Profile.fxml");
    }
    public void view_leaderboard(ActionEvent event){
        screenLoader.loadScene(event,"LeaderBoard.fxml");
    }
    public void viewGame(ActionEvent event) throws Exception{
        screenLoader.loadScene(event,"Replay.fxml");
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
