package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

public class Login_or_RegisterController {
    private ScreenLoader screenLoader=new ScreenLoader();
    @FXML
    private FlowPane parent_menu2;
    @FXML
    private void login(ActionEvent event) {
        screenLoader.loadScene(event,"login.fxml");
    }
    @FXML
    private void register(ActionEvent event) throws IOException {
        screenLoader.loadScene(event,"SingUpScreen.fxml");
    }

    @FXML
    private void back(ActionEvent event) {
            screenLoader.loadScene(event,"Menu.fxml");
    }
}
