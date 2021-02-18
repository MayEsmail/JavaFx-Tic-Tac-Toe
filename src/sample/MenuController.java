package sample;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;



public class MenuController {
    public static boolean computerPlay;
    @FXML
    private AnchorPane rootPane;

    public void PlayOnline() throws  Exception{
        try {
            computerPlay=false;
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            rootPane.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void Exit(){
        Platform.exit();
    }
    public void PlayLocally() throws  Exception{
        try {
            computerPlay = false;
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            rootPane.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void PlayAgainstComp() throws  Exception{
        try {
            computerPlay = true;
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            rootPane.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
