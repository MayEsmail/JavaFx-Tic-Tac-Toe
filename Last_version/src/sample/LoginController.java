/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private void back(ActionEvent event){
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

    @FXML
    private void login(ActionEvent event){
        //check database
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
