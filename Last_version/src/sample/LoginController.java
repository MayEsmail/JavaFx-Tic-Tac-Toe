/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class LoginController{

    /**
     * Initializes the controller class.
     */
    @FXML
    private FlowPane parent_login;
    @FXML
    private TextField loginIdField;
    @FXML
    public void back(){
        try {
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Menu.fxml"));
            parent_login.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void login(ActionEvent event) throws IOException{
        //check database
        GameDatabase databaseObj = new GameDatabase(Game.TIC_TAC_TOE);
        System.out.println(Game.TIC_TAC_TOE);
        int idNumber;
        String validInput = loginIdField.getText();
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(validInput);
        if(m.matches())
        {
            String idCheck = databaseObj.loginPlayer(Integer.parseInt(validInput));
            if(idCheck.equals(""))
            {
                Parent invalidId_Parent=FXMLLoader.load(getClass().getResource("InvalidLogin.fxml"));
                Scene invalid_Scene=new Scene(invalidId_Parent);
                Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
                App_Stage.setScene(invalid_Scene);
                App_Stage.show();
                
//                FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("InvalidLogin.fxml"));
//                parent_login.getChildren().setAll(fxmlLoader);
            }
            else
            {
                MenuController.computerPlay=false;
                
                Parent game_Parent=FXMLLoader.load(getClass().getResource("onlineGame.fxml"));
                Scene game_Scene=new Scene(game_Parent);
                Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
                App_Stage.setScene(game_Scene);
                App_Stage.show();
                
//                AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("onlineGame.fxml"));
//                parent_login.getChildren().setAll(fxmlLoader);
            }
        }
        else
        {
            Parent invalidId_Parent=FXMLLoader.load(getClass().getResource("InvalidLogin.fxml"));
            Scene invalid_Scene=new Scene(invalidId_Parent);
            Stage App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow(); 
            App_Stage.setScene(invalid_Scene);
            App_Stage.show();
            
//            FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("InvalidLogin.fxml"));
//            parent_login.getChildren().setAll(fxmlLoader);
        }

    }
    @FXML
    private void register(ActionEvent event){
        //try {
           //Parent SignUp_Parent=FXMLLoader.load(getClass().getResource("signup.fxml"));
           //Scene SignUp_Scene=new Scene(SignUp_Parent);
           //Stage App_Stage = (Stage)((Node) event.getSource()).getScene().getWindow(); 
           //App_Stage.setScene(SignUp_Scene);
           //App_Stage.show();
        //} catch(IOException e) {
        //    e.printStackTrace();
        //}
    }
    
}
