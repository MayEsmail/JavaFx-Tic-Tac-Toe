import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class ClientGui extends AnchorPane {

    protected final Button btn1;
    protected final Button btn2;
    protected final Button btn3;
    protected final Button btn4;
    protected final Button btn5;
    protected final Button btn6;
    protected final Button btn7;
    protected final Button btn8;
    protected final Button btn9;

    public ClientGui() {
        btn1 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn7 = new Button();
        btn8 = new Button();
        btn9 = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(490.0);

        btn1.setAlignment(javafx.geometry.Pos.CENTER);
        btn1.setLayoutX(118.0);
        btn1.setLayoutY(86.0);
        btn1.setMnemonicParsing(false);
        btn1.setPrefHeight(48.0);
        btn1.setPrefWidth(75.0);
        btn1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn1.setFont(new Font(24.0));

        btn2.setAlignment(javafx.geometry.Pos.CENTER);
        btn2.setLayoutX(221.0);
        btn2.setLayoutY(86.0);
        btn2.setMnemonicParsing(false);
        btn2.setPrefHeight(48.0);
        btn2.setPrefWidth(75.0);
        btn2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn2.setFont(new Font(24.0));

        btn3.setAlignment(javafx.geometry.Pos.CENTER);
        btn3.setLayoutX(121.0);
        btn3.setLayoutY(176.0);
        btn3.setMnemonicParsing(false);
        btn3.setPrefHeight(48.0);
        btn3.setPrefWidth(75.0);
        btn3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn3.setFont(new Font(24.0));

        btn4.setAlignment(javafx.geometry.Pos.CENTER);
        btn4.setLayoutX(224.0);
        btn4.setLayoutY(176.0);
        btn4.setMnemonicParsing(false);
        btn4.setPrefHeight(48.0);
        btn4.setPrefWidth(75.0);
        btn4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn4.setFont(new Font(24.0));

        btn5.setAlignment(javafx.geometry.Pos.CENTER);
        btn5.setLayoutX(318.0);
        btn5.setLayoutY(86.0);
        btn5.setMnemonicParsing(false);
        btn5.setPrefHeight(48.0);
        btn5.setPrefWidth(75.0);
        btn5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn5.setFont(new Font(24.0));

        btn6.setAlignment(javafx.geometry.Pos.CENTER);
        btn6.setLayoutX(321.0);
        btn6.setLayoutY(176.0);
        btn6.setMnemonicParsing(false);
        btn6.setPrefHeight(48.0);
        btn6.setPrefWidth(75.0);
        btn6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn6.setFont(new Font(24.0));

        btn7.setAlignment(javafx.geometry.Pos.CENTER);
        btn7.setLayoutX(324.0);
        btn7.setLayoutY(248.0);
        btn7.setMnemonicParsing(false);
        btn7.setPrefHeight(48.0);
        btn7.setPrefWidth(75.0);
        btn7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn7.setFont(new Font(24.0));

        btn8.setAlignment(javafx.geometry.Pos.CENTER);
        btn8.setLayoutX(227.0);
        btn8.setLayoutY(248.0);
        btn8.setMnemonicParsing(false);
        btn8.setPrefHeight(48.0);
        btn8.setPrefWidth(75.0);
        btn8.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn8.setFont(new Font(24.0));

        btn9.setAlignment(javafx.geometry.Pos.CENTER);
        btn9.setLayoutX(124.0);
        btn9.setLayoutY(248.0);
        btn9.setMnemonicParsing(false);
        btn9.setPrefHeight(48.0);
        btn9.setPrefWidth(75.0);
        btn9.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn9.setFont(new Font(24.0));

        getChildren().add(btn1);
        getChildren().add(btn2);
        getChildren().add(btn3);
        getChildren().add(btn4);
        getChildren().add(btn5);
        getChildren().add(btn6);
        getChildren().add(btn7);
        getChildren().add(btn8);
        getChildren().add(btn9);
    }
    
}