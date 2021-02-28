package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class GetIdScreenBase implements  Initializable{
    @FXML
    Label idField;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idField.setText(Integer.toString(SingUpScreen.newPlayerId));
    } 
    public void seeId(ActionEvent event) throws IOException{
        OnlineGame.userName =OnlineGame.databaseObj.loginPlayer(SingUpScreen.newPlayerId);
        OnlineGame.userId = SingUpScreen.newPlayerId;
        OnlineGame.databaseObj.checkLogin(SingUpScreen.newPlayerId);
        MenuController.is_loggedin = true;
        if(ProfileController.profileCheck){
            new ScreenLoader().loadScene(event,"Profile.fxml");
            ProfileController.profileCheck=false;
        }
        else{
            Controller.playOnline=true;
            new ScreenLoader().loadScene(event,"Record.fxml");
        }
    }
}
