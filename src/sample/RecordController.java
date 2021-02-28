package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

public class RecordController {
    private ScreenLoader screenloader=new ScreenLoader();
    public static boolean recordme;
    @FXML
    private FlowPane parent_record;
    public void yesRecord(ActionEvent event) throws  Exception{
        recordme=true;
        screenloader.loadScene(event,"sample.fxml");
    }
    public void noRecord(ActionEvent event) throws  Exception{
            recordme=false;
            screenloader.loadScene(event,"sample.fxml");
    }
}
