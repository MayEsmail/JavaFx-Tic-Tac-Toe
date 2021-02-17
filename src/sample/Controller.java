package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Controller {
    @FXML
    private  Button one;
    @FXML
    private  Button two;
    @FXML
    private  Button three;
    @FXML
    private  Button four;
    @FXML
    private  Button five;
    @FXML
    private  Button six;
    @FXML
    private  Button seven;
    @FXML
    private  Button eight;
    @FXML
    private  Button nine;
    @FXML
    private AnchorPane rootPane2;
    @FXML
    private Label turn;
    private String player = "X";
    public void playAction(ActionEvent event){
        //this has a problem
        Button btn = ((Button) event.getSource());
        String txt = btn.getText();
//        System.out.println(txt);
//        btn.setStyle("-fx-background-color: yellow");
        if (btn.getText().equals("")) {
            String id =btn.getId();
            System.out.println(id);
            btn.setText(player);

            changePlayer();

            if (player.equals("X")){

                btn.setStyle("-fx-text-fill: #ad03fc");

                System.out.println("am X ");

            }else{
                btn.setStyle("-fx-background-color: white");
                btn.setStyle("-fx-text-fill: #fcba03");
                System.out.println("am O");


            }

        }

    }

    private void changePlayer() {

        if (player.equals("X")) {
//            btn.setStyle("-fx-background-color: white");
//            btn.setStyle("-fx-text-fill: #ad03fc");

            player = "O";
        }
        else {
//            btn.setStyle("-fx-text-fill: #fcba03");
            player = "X";
        }
        turn.setText("Turn: " +player + " turn");
    }

    public void back() {
        try {
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Menu.fxml"));
            rootPane2.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
