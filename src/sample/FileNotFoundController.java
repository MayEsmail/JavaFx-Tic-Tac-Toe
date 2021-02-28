package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;

public class FileNotFoundController {
    public void back(ActionEvent event){
       new ScreenLoader().loadScene(event,"Menu.fxml");
    }
}
