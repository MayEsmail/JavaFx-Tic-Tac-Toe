package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public  Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        primaryStage.setTitle("Tic Tac Toe");
       new ScreenLoader().loadScene(primaryStage, "Menu.fxml");
    }
    public void stop() throws Exception{
        if(OnlineGame.checkDB == true)
        {
            OnlineGame.databaseObj.LoginOut(OnlineGame.userId);
            GameDatabase.disconnectDB();
            OnlineGame.checkDB = false;
        }
        
        super.stop();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
