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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    } 
    public void createPlayer() throws IOException
    {

        playerName.getText();
        MenuController.newPlayerId = MenuController.databaseObj.addNewPlayer(playerName.getText());
//        Parent root1 = FXMLLoader.load(getClass().getResource("GetIdScreen.fxml"));
//        Scene loginScene = new Scene(root1, 600, 400);
        
        AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("GetIdScreen.fxml"));
        signUpScreen.getChildren().setAll(fxmlLoader);
//        Main.primaryStage.setScene(loginScene);
//        Main.primaryStage.show();
        
        
//            Stage primaryStage = new Stage();
//            primaryStage.setResizable(false);
//            Main.primaryStage.setScene(loginScene);
//            Main.primaryStage.show();
    }
    public void canelSingUp(){
        
    }
}

