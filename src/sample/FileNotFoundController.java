package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;

public class FileNotFoundController {
    @FXML
    private FlowPane fileError;
    public void back(){
        try {
            FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Menu.fxml"));
            fileError.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
