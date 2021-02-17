package databasegui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SingUpScreen extends AnchorPane {

    protected final TextField nameField;
    protected final Button createButton;
    protected final Button cancelButton;
    protected final PasswordField passwordField;
    protected final Label label;
    protected final Label label0;

    public SingUpScreen(Stage primaryStage , GameDatabase databaseObj) {

        nameField = new TextField();
        createButton = new Button();
        cancelButton = new Button();
        passwordField = new PasswordField();
        label = new Label();
        label0 = new Label();

        setId("AnchorPane");
        setPrefHeight(307.0);
        setPrefWidth(518.0);
        setStyle("-fx-background-color: #1F2741; -fx-border-color: FFBB00; -fx-border-width: 5;");

        nameField.setLayoutX(35.0);
        nameField.setLayoutY(121.0);
        nameField.setPrefHeight(47.0);
        nameField.setPrefWidth(196.0);
        nameField.setPromptText("Player Name");
        nameField.setFont(new Font(19.0));

        createButton.setDefaultButton(true);
        createButton.setLayoutX(84.0);
        createButton.setLayoutY(213.0);
        createButton.setMnemonicParsing(false);
        createButton.setPrefHeight(47.0);
        createButton.setPrefWidth(97.0);
        createButton.setStyle("-fx-background-color: FFBB00;");
        createButton.setText("Create");
        createButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        createButton.setFont(new Font("Forte", 19.0));
        createButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ex)
            {
                   nameField.getText() , passwordField.get
            }
        });

        cancelButton.setCancelButton(true);
        cancelButton.setLayoutX(343.0);
        cancelButton.setLayoutY(213.0);
        cancelButton.setMnemonicParsing(false);
        cancelButton.setPrefHeight(47.0);
        cancelButton.setPrefWidth(90.0);
        cancelButton.setStyle("-fx-background-color: #6B11D2;");
        cancelButton.setText("Cancel");
        cancelButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cancelButton.setTextFill(javafx.scene.paint.Color.WHITE);
        cancelButton.setFont(new Font("Forte", 19.0));

        passwordField.setLayoutX(290.0);
        passwordField.setLayoutY(121.0);
        passwordField.setPrefHeight(47.0);
        passwordField.setPrefWidth(196.0);
        passwordField.setPromptText("Password");
        passwordField.setFont(new Font(19.0));

        label.setText("Label");

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(161.0);
        label0.setLayoutY(36.0);
        label0.setPrefHeight(40.0);
        label0.setPrefWidth(196.0);
        label0.setText("Sign Up");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#4eb6c7"));
        label0.setFont(new Font("Forte", 26.0));

        getChildren().add(nameField);
        getChildren().add(createButton);
        getChildren().add(cancelButton);
        getChildren().add(passwordField);
        getChildren().add(label);
        getChildren().add(label0);

    }
}
