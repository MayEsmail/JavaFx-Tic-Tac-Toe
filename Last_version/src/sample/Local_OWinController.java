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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class Local_OWinController implements Initializable {

    @FXML
    private Label playerx;
    @FXML
    private Label playero;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backToMenu(ActionEvent event) {
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

}