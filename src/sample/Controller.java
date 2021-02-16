package sample;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class Controller {
    private String player = "X";
    public void playAction(ActionEvent event){
        //this has a problem
        Button btn = ((Button) event.getSource());
        String txt = btn.getText();
        System.out.println(txt);
//        btn.setStyle("-fx-background-color: yellow");
        if (btn.getText().equals("")) {
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
//        status.setText(player + " turn");
    }
}
