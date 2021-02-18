/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasegui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class DatabaseGUI extends Application {
    static int newPlayerId = 0;
    static Stage primaryStage;
    static GameDatabase databaseObj;
    @Override
    public void start(Stage primary) throws IOException {
        primaryStage = primary;
        databaseObj = new GameDatabase(Game.TIC_TAC_TOE);
        Parent root = FXMLLoader.load(getClass().getResource("SingUpScreen.fxml"));
        Scene scene = new Scene(root, 520, 300);
        primaryStage.setTitle("X Sign Up O");
        primaryStage.setResizable(false);
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
