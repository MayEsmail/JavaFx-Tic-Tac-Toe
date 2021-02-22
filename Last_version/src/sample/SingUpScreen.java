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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


   
public class SingUpScreen implements  Initializable{

    @FXML
    private AnchorPane signUpScreen; 
    @FXML
    private TextField playerName;
    public static int newPlayerId;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    } 
    public void createPlayer() throws IOException
    {


        GameDatabase databaseObj = new GameDatabase(Game.TIC_TAC_TOE);
        newPlayerId = databaseObj.addNewPlayer(playerName.getText());
        AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("GetIdScreen.fxml"));
        signUpScreen.getChildren().setAll(fxmlLoader);

    }
    public void canelSingUp() throws IOException{
        AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Login_or_Register.fxml"));
        signUpScreen.getChildren().setAll(fxmlLoader);
    }
}

