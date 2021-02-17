package tictactoe;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoseBase extends BorderPane {

    protected final FlowPane flowPane;
    protected final Label label;
    protected final Glow glow;
    protected final DropShadow dropShadow;
    protected final Label label0;
    protected final BorderPane borderPane;
    protected final Button button;
    protected final DropShadow dropShadow0;
    protected final InnerShadow innerShadow;

    public LoseBase() {

        flowPane = new FlowPane();
        label = new Label();
        glow = new Glow();
        dropShadow = new DropShadow();
        label0 = new Label();
        borderPane = new BorderPane();
        button = new Button();
        dropShadow0 = new DropShadow();
        innerShadow = new InnerShadow();

        setId("parent_lose");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/Win.css");

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setMaxHeight(164.0);
        flowPane.setMaxWidth(410.0);
        flowPane.setPrefHeight(164.0);
        flowPane.setPrefWidth(410.0);
        flowPane.setStyle("-fx-max-width: 310; -fx-max-height: 150;");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setPrefHeight(154.0);
        label.setPrefWidth(410.0);
        label.setText("Defeat!");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Comic Sans MS Bold Italic", 80.0));

        glow.setLevel(0.2);
        dropShadow.setInput(glow);
        dropShadow.setHeight(80.3);
        dropShadow.setRadius(52.932500000000005);
        dropShadow.setSpread(0.85);
        dropShadow.setWidth(133.43);
        label.setEffect(dropShadow);

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setPrefHeight(33.0);
        label0.setPrefWidth(410.0);
        label0.setText("Hard luck, You didn't win any coins.");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Bookman Old Style Bold", 20.0));
        setCenter(flowPane);

        BorderPane.setAlignment(borderPane, javafx.geometry.Pos.CENTER);
        borderPane.setPrefHeight(144.0);
        borderPane.setPrefWidth(600.0);

        BorderPane.setAlignment(button, javafx.geometry.Pos.CENTER);
        button.setId("play_btn");
        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(322.0);
        button.setStyle("-fx-background-color: #5F1987;");
        button.getStylesheets().add("/tictactoe/Win.css");
        button.setText("Play Again");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setWrapText(true);
        button.setFont(new Font("Bookman Old Style Bold Italic", 21.0));

        dropShadow0.setColor(Color.web("0x704b82"));
        dropShadow0.setHeight(118.6);
        dropShadow0.setRadius(56.5775);
        dropShadow0.setSpread(0.34);
        dropShadow0.setWidth(109.71);
        button.setEffect(dropShadow0);
        button.setCursor(Cursor.HAND);
        borderPane.setTop(button);
        setBottom(borderPane);

        innerShadow.setBlurType(javafx.scene.effect.BlurType.GAUSSIAN);
        innerShadow.setChoke(0.8);
        innerShadow.setHeight(251.66500000000002);
        innerShadow.setOffsetX(1.0);
        innerShadow.setOffsetY(1.0);
        innerShadow.setRadius(126.16625);
        innerShadow.setWidth(255.0);
        setEffect(innerShadow);

        flowPane.getChildren().add(label);
        flowPane.getChildren().add(label0);

    }
}
