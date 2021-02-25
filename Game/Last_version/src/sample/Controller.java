package sample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
import java.util.concurrent.TimeUnit;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Controller implements Initializable {
    public int xSCore=0;
    public int oScore=0;
    boolean gameEnd;
    boolean turnX;
    int counter;
    Random random=new Random();
    int num;
    private static String[] positions=new String[9];
    private static String[] texts=new String[9];
    
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
    private char winner='-';
    Stage App_Stage;
    
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
        if("X".equals(b1.getText()))
            winner='X';
        else
            winner='O';
        change_screen(winner);
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
            if(MenuController.computerPlay==false){
                if(turnX){
                    button.setStyle("-fx-text-fill: #ad03fc");
                    button.setText("X");
                    positions[counter]=button.getId();
                    texts[counter]="X";
                }
                else{
                    button.setStyle("-fx-text-fill: #fcba03");
                    button.setText("O");
                    positions[counter]=button.getId();
                    texts[counter]="O";
                }
                counter++;
                end();
                turnX=!turnX;
            }
            //////////single play
            if(MenuController.computerPlay){
                App_Stage= (Stage)((Node) e.getSource()).getScene().getWindow();
//                counter++;
                turnX=true;
                button.setStyle("-fx-text-fill: #ad03fc");
                button.setText("X");
                ////new addition
                positions[counter]=button.getId();
                texts[counter]="X";
                counter++;
                ////////
                end();
                if(gameEnd==false){
//                    counter++;
                    turnX=false;
                    for(;;){
                        num=random.nextInt(9);
                        if(buttons[num].getText().equals("")){
//                            TimeUnit.SECONDS.sleep(2);
                            buttons[num].setStyle("-fx-text-fill: #fcba03");
                            buttons[num].setText("O");
                            /////addition
                            String pos;
                            switch(num){
                                    case 0:
                                        pos="one";
                                        positions[counter]=pos;
                                        break;
                                    case 1:
                                        pos="two";
                                        positions[counter]=pos;
                                        break;
                                    case 2:
                                        pos="three";
                                        positions[counter]=pos;
                                        break;
                                    case 3:
                                        pos="four";
                                        positions[counter]=pos;
                                        break;
                                    case 4:
                                        pos="five";
                                        positions[counter]=pos;
                                        break;
                                    case 5:
                                        pos="six";
                                        positions[counter]=pos;
                                        break;
                                    case 6:
                                        pos="seven";
                                        positions[counter]=pos;
                                        break;
                                    case 7:
                                        pos="eight";
                                        positions[counter]=pos;
                                        break;
                                    case 8:
                                        pos="nine";
                                        positions[counter]=pos;
                                        break;
                            }
//                            positions[counter]=pos;
                            texts[counter]="O";
                            break;
                        }
                    }
                    counter++;
                    end();
                }
            }
        }
    }
    ////addition
    public void record(){
        try{
            if(RecordController.recordme){
                FileOutputStream fos=new FileOutputStream("game.txt");
                PrintWriter pw=new PrintWriter(fos);
                for(int i=0;i<positions.length;i++){
                    pw.println(positions[i]);
                    pw.println(texts[i]);
                }
                pw.close();
//                System.out.println(positions[0]);
            }
        }
        catch(Exception e){e.printStackTrace();}
    }
    ///////////
    public void change_screen(char myWinner){
        if(MenuController.computerPlay){
            //int sec=LocalDateTime.now().getSecond();
            //while(LocalDateTime.now().getSecond()<sec+2);
            switch (myWinner) {
                case 'X':
                    try {
                        Parent Menu_Parent=FXMLLoader.load(getClass().getResource("Win.fxml"));
                        Scene Menu_Scene=new Scene(Menu_Parent);
                        App_Stage.setScene(Menu_Scene);
                        App_Stage.show();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }   break;
                case 'O':
                    try {
                        Parent Menu_Parent=FXMLLoader.load(getClass().getResource("lose.fxml"));
                        Scene Menu_Scene=new Scene(Menu_Parent);
                        App_Stage.setScene(Menu_Scene);
                        App_Stage.show();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }   break;
                default:
                    try {
                        Parent Menu_Parent=FXMLLoader.load(getClass().getResource("Draw.fxml"));
                        Scene Menu_Scene=new Scene(Menu_Parent);
                        App_Stage.setScene(Menu_Scene);
                        App_Stage.show();
                    } catch(IOException e){
                        e.printStackTrace();
                    }   break;
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
                record();
                gameEnd=true;
            }
            if(text[0].equals(text[3]) && text[0].equals(text[6]) && text[0]!=""){
                winGround(buttons[0],buttons[3],buttons[6]);
                record();
                gameEnd=true;
            }
            if(text[0].equals(text[4]) && text[0].equals(text[8]) && text[0]!=""){
                winGround(buttons[0],buttons[4],buttons[8]);
                record();
                gameEnd=true;
            }
            if(text[1].equals(text[4]) && text[1].equals(text[7]) && text[1]!=""){
                winGround(buttons[1],buttons[4],buttons[7]);
                record();
                gameEnd=true;
            }
            if(text[2].equals(text[5]) && text[2].equals(text[8]) && text[2]!=""){
                winGround(buttons[2],buttons[5],buttons[8]);
                record();
                gameEnd=true;
            }
            if(text[3].equals(text[4]) && text[3].equals(text[5]) && text[3]!=""){
                winGround(buttons[3],buttons[4],buttons[5]);
                record();
                gameEnd=true;
            }
            if(text[6].equals(text[7]) && text[6].equals(text[8]) && text[6]!=""){
                winGround(buttons[6],buttons[7],buttons[8]);
                record();
                gameEnd=true;
            }
            if(text[2].equals(text[4]) && text[2].equals(text[6]) && text[2]!=""){
                winGround(buttons[2],buttons[4],buttons[6]);
                record();
                gameEnd=true;
            }
            ///check out off squares to play in 
            if(counter>=9){
                record();
                gameEnd=true;
                turnX=true;
                counter=0;
                change_screen(winner);
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
