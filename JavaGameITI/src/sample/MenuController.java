package sample;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class MenuController {
    public static boolean computerPlay;
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private AnchorPane signUpScreen;
    
    //dakhly
    static int newPlayerId = 0;
    static GameDatabase databaseObj;

    public void PlayOnline() throws  Exception{
        try {
            computerPlay=false;
            
            //dakhly
            databaseObj = new GameDatabase(Game.TIC_TAC_TOE);
//            Parent root = FXMLLoader.load(getClass().getResource("SingUpScreen.fxml"));
//            Scene scene = new Scene(root, 520, 300);
//            //Main.primaryStage.setTitle("X Sign Up O");
////            Main.primaryStage.setResizable(false);
////            Main.primaryStage.setScene(scene);
////yy            Main.primaryStage.show();
//            Stage primaryStage = new Stage();
//            primaryStage.setResizable(false);
//            Main.primaryStage.setScene(scene);
//            Main.primaryStage.show();
            
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("SingUpScreen.fxml"));
            rootPane.getChildren().setAll(fxmlLoader);
            
            
//            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("onlineGame.fxml"));
//            rootPane.getChildren().setAll(fxmlLoader);
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
