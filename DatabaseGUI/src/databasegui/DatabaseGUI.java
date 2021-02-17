/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasegui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class DatabaseGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GameDatabase databaseObj = new GameDatabase(Game.TIC_TAC_TOE);
        SingUpScreen root = new SingUpScreen(primaryStage , databaseObj);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("X Sign Up O");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
