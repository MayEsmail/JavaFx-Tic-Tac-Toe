package sample;

import javafx.event.ActionEvent;

public class LoseController{

    public void PlayAgain(ActionEvent event) throws  Exception{
        new ScreenLoader().loadScene(event,"Menu.fxml");
         
    }
}
