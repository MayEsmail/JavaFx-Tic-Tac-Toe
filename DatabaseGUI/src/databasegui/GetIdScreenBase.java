package databasegui;

import static databasegui.DatabaseGUI.primaryStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

//public class GetIdScreenBase extends AnchorPane {
//
////    protected final Label label;
////    protected final Label label0;
////    protected final Label IdArea;
////    protected final Button okButton;
//
//    /*public GetIdScreenBase(int id) {
//
//        label = new Label();
//        label0 = new Label();
//        IdArea = new Label();
//        okButton = new Button();
//
//        setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
//        setId("AnchorPane");
//        setPrefHeight(400.0);
//        setPrefWidth(600.0);
//        setStyle("-fx-background-color: #1F2741; -fx-border-color: FFBB00; -fx-border-width: 5;");
//
//        label.setLayoutX(77.0);
//        label.setLayoutY(72.0);
//        label.setText("Welcome to the coolest XO game");
//        label.setTextFill(javafx.scene.paint.Color.valueOf("#4eb6c7"));
//        label.setFont(new Font("Forte", 32.0));
//
//        label0.setLayoutX(227.0);
//        label0.setLayoutY(134.0);
//        label0.setText("Your ID is ");
//        label0.setTextFill(javafx.scene.paint.Color.valueOf("#4eb6c7"));
//        label0.setFont(new Font("Forte", 30.0));
//
//        IdArea.setLayoutX(265.0);
//        IdArea.setLayoutY(200.0);
//        IdArea.setText("Label");
//        IdArea.setTextFill(javafx.scene.paint.Color.valueOf("#ffbb00"));
//        IdArea.setFont(new Font("Forte", 30.0));
//
//        okButton.setLayoutX(259.0);
//        okButton.setLayoutY(270.0);
//        okButton.setMnemonicParsing(false);
//        okButton.setStyle("-fx-background-color: #6B11D2;");
//        okButton.setText("OK");
//        okButton.setTextFill(javafx.scene.paint.Color.WHITE);
//        okButton.setFont(new Font("Forte", 30.0));
//
//        getChildren().add(label);
//        getChildren().add(label0);
//        getChildren().add(IdArea);
//        getChildren().add(okButton);
//
//    }*/
//}

public class GetIdScreenBase implements  Initializable{

    @FXML
    Label idField;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idField.setText(Integer.toString(DatabaseGUI.newPlayerId));
    } 
    public void seeId() throws IOException
    {
        Parent root1 = FXMLLoader.load(getClass().getResource("SingUpScreen.fxml"));
        Scene loginScene = new Scene(root1, 520, 300);
        primaryStage.setScene(loginScene);
        DatabaseGUI.primaryStage.show();
    }
}
