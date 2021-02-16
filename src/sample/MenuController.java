package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;



public class MenuController {
    @FXML
    private AnchorPane rootPane;
    public void PlayOnline() throws  Exception{
        try {
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            rootPane.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void Exit(){

    }
    public void PlayLocally() throws  Exception{
        try {
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            rootPane.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void PlayAgainstComp() throws  Exception{
        try {
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("sample.fxml"));
            rootPane.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
