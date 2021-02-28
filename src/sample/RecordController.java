package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class RecordController {
    public static boolean recordme;
    @FXML
    private FlowPane parent_record;
    public void yesRecord() throws  Exception{
        try {
            recordme=true;
            FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            parent_record.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void noRecord() throws  Exception{
        try {
            recordme=false;
            FlowPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            parent_record.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
