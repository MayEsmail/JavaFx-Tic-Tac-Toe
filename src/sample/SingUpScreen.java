package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

   
public class SingUpScreen implements  Initializable{

    @FXML
    private FlowPane signUpScreen; 
    @FXML
    private TextField playerName;
    public static int newPlayerId;
    private ScreenLoader screenLoader = new ScreenLoader();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    } 
    public void createPlayer(ActionEvent event) throws IOException
    {
        if(!OnlineGame.checkDB){
            OnlineGame.databaseObj = new GameDatabase(Game.TIC_TAC_TOE);
            OnlineGame.checkDB = true;
        }
        if(! playerName.getText().equals(""))
        {
            newPlayerId = OnlineGame.databaseObj.addNewPlayer(playerName.getText());
            OnlineGame.userName = playerName.getText();
            OnlineGame.userId = newPlayerId;
            screenLoader.loadScene(event,"GetIdScreen.fxml");
        }


    }
    public void canelSingUp(ActionEvent event) throws IOException{
        screenLoader.loadScene(event,"Login_or_Register.fxml");
//        FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Login_or_Register.fxml"));
//        signUpScreen.getChildren().setAll(fxmlLoader);
    }
}

