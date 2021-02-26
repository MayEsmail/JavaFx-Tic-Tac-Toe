package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


   
public class SingUpScreen implements  Initializable{

    @FXML
    private FlowPane signUpScreen; 
    @FXML
    private TextField playerName;
    public static int newPlayerId;
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
            Parent getId_Parent=FXMLLoader.load(getClass().getResource("GetIdScreen.fxml"));
            Scene gitId_Scene=new Scene(getId_Parent);
            Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
            App_Stage.setScene(gitId_Scene);
            App_Stage.show();

    //        FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("GetIdScreen.fxml"));
    //        signUpScreen.getChildren().setAll(fxmlLoader);
        }


    }
    public void canelSingUp(ActionEvent event) throws IOException{
        
        Parent cancelId_Parent=FXMLLoader.load(getClass().getResource("Login_or_Register.fxml"));
        Scene cancel_Scene=new Scene(cancelId_Parent);
        Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
        App_Stage.setScene(cancel_Scene);
        App_Stage.show();
        
//        FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Login_or_Register.fxml"));
//        signUpScreen.getChildren().setAll(fxmlLoader);
    }
}

