package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    public int xSCore=0;
    public int oScore=0;
    boolean gameEnd;
    boolean turnX;
    int counter;
    Random random=new Random();
    int num;
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
    @FXML
    private Label fPScore;
    @FXML
    private Label sPScore;
    private String player = "X";
    Button[] buttons=new Button[9];

    public void initializeList(){
        buttons[0] = one;
        buttons[1] = two;
        buttons[2] = three;
        buttons[3] = four;
        buttons[4] = five;
        buttons[5] = six;
        buttons[6] = seven;
        buttons[7] = eight;
        buttons[8] = nine;

    }




    private void winGround(Button b1,Button b2,Button b3){
        b1.setStyle("-fx-background-color: yellow");
        b2.setStyle("-fx-background-color: yellow");
        b3.setStyle("-fx-background-color: yellow");
        increaseScore(b1.getText());
    }



    public void back() {
        try {
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Menu.fxml"));
            rootPane2.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void playAction(ActionEvent e){
        Button button=(Button) e.getSource();
        if(gameEnd==false && button.getText().equals("")){
            //////////multiplay
            //Manage.computerPlay=false;
            if(MenuController.computerPlay==false){
                if(turnX){
                    button.setStyle("-fx-text-fill: #ad03fc");
                    button.setText("X");
                }
                else{
                    button.setStyle("-fx-text-fill: #fcba03");
                    button.setText("O");
                }
                counter++;
                end();
                turnX=!turnX;
            }
            //////////single play

            if(MenuController.computerPlay){
                counter++;
                turnX=true;
                button.setStyle("-fx-text-fill: #ad03fc");
                button.setText("X");
                end();
                if(gameEnd==false){

                    counter++;
                    turnX=false;
                    for(;;){
                        num=random.nextInt(9);
                        if(buttons[num].getText().equals("")){
                            buttons[num].setStyle("-fx-text-fill: #fcba03");
                            buttons[num].setText("O");
                            break;
                        }
                    }
                    end();

                }
            }
        }
    }
    public void end(){
        String[] text=new String[9];
        for(int i=0;i<9;i++){
            text[i]=buttons[i].getText();
        }
        ///check winner
        if(!gameEnd) {
            if(text[0].equals(text[1]) && text[0].equals(text[2]) && text[0]!=""){
                winGround(buttons[0],buttons[1],buttons[2]);
                gameEnd=true;
            }
            if(text[0].equals(text[3]) && text[0].equals(text[6]) && text[0]!=""){
                winGround(buttons[0],buttons[3],buttons[6]);
                gameEnd=true;
            }
            if(text[0].equals(text[4]) && text[0].equals(text[8]) && text[0]!=""){
                winGround(buttons[0],buttons[4],buttons[8]);
                gameEnd=true;
            }
            if(text[1].equals(text[4]) && text[1].equals(text[7]) && text[1]!=""){
                winGround(buttons[1],buttons[4],buttons[7]);
                gameEnd=true;
            }
            if(text[2].equals(text[5]) && text[2].equals(text[8]) && text[2]!=""){
                winGround(buttons[2],buttons[5],buttons[8]);
                gameEnd=true;
            }
            if(text[3].equals(text[4]) && text[3].equals(text[5]) && text[3]!=""){
                winGround(buttons[3],buttons[4],buttons[5]);
                gameEnd=true;
            }
            if(text[6].equals(text[7]) && text[6].equals(text[8]) && text[6]!=""){
                winGround(buttons[6],buttons[7],buttons[8]);
                gameEnd=true;
            }
            if(text[2].equals(text[4]) && text[2].equals(text[6]) && text[2]!=""){
                winGround(buttons[2],buttons[4],buttons[6]);
                gameEnd=true;
            }
            ///check out of squares
            if(counter>=9){
                gameEnd=true;
                turnX=true;
                counter=0;
            }
        }


    }
    private void increaseScore(String player) {
        if (player.equals("X")) {

            fPScore.setText("Player X Score :" + ++xSCore);
            sPScore.setText("Player O Score :" + oScore);
            counter = 0;

        } else {
            sPScore.setText("Player O Score :" + ++oScore);
            fPScore.setText("Player X Score :" + xSCore);
            counter = 0;
        }
    }
    private void startGame(){
        gameEnd=false;
        for(Button btn: buttons){
            btn.setText("");
        }
        System.out.println("in start game");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeList();
        startGame();
    }
}
