/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static sample.OnlineGame.s;

/**
 *
 * @author pc
 */

public class ScreenLoader {
    public void loadScene(ActionEvent e,String screen){
        Stage App_Stage= (Stage)((Node) e.getSource()).getScene().getWindow();
        this.loadScene(App_Stage, screen);
    }
    private void shutdown(Stage mainWindow) {
    // you could also use your logout window / whatever here instead
        Alert alert = new Alert(Alert.AlertType.NONE, "Do you really want to close the game?", ButtonType.YES, ButtonType.NO);
        if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
            mainWindow.close();
        }
}

    public void loadScene(Stage App_Stage,String screen){
        try {
            Screen myscreen = Screen.getPrimary();
            javafx.geometry.Rectangle2D bounds = myscreen.getVisualBounds();
            
            Parent next_Parent=FXMLLoader.load(getClass().getResource(screen));
            Scene next_Scene=new Scene(next_Parent);
            App_Stage.setScene(next_Scene);
            App_Stage.setX(bounds.getMinX());
            App_Stage.setY(bounds.getMinY());
            App_Stage.setWidth(bounds.getWidth());
            App_Stage.setHeight(bounds.getHeight());
            
            App_Stage.setResizable(false);
            App_Stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
            App_Stage.setOnCloseRequest(event -> {
                // prevent window from closing
                event.consume();
                shutdown(App_Stage);
    });

    }
}
