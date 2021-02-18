package myproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyProject extends Application {
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
//        root.getChildren().add(Manage.singlePane);
//        root.getChildren().add(Manage.multiPane);
        root.getChildren().add(Manage.gamePane);
//        root.getChildren().add(Manage.startPane);
//        Manage.view(manage.startPane);
        Manage.view(Manage.gamePane);
        
        Scene scene = new Scene(root,380,500);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}