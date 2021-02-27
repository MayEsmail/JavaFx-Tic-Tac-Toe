package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class RecordController {
    public static boolean recordme;
    @FXML
    private AnchorPane RecordPane;
    public void yesRecord() throws  Exception{
        try {
            recordme=true;
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            RecordPane.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void noRecord() throws  Exception{
        try {
            recordme=false;
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            RecordPane.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
