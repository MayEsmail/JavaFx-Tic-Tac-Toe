package sample;
import javafx.event.ActionEvent;

public class DrawController {
    public void PlayAgain(ActionEvent event) throws  Exception{
        new ScreenLoader().loadScene(event,"Menu.fxml");
    }
}
