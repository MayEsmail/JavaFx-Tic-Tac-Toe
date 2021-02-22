package sample;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class OnlineGame extends Controller implements Initializable{
    volatile String message = "";
    volatile String recievedMessage = "";
    static Socket s;
    static BufferedReader din;
    static PrintStream dout;
    String playerTurn = "x";
    volatile boolean closeConnection = false;

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private AnchorPane onlineGame;

    public void onPlay(ActionEvent event){
//        counter++
        end();
        Button btn = (Button) event.getSource();
        if(!gameEnd) {
            sendMsg(playerTurn + btn.getId().charAt(3));
            btn.setText(playerTurn);
            setButtonsState(true);
        }

    }

    public void setButtonsState(boolean state){
        btn1.setDisable(state);
        btn2.setDisable(state);
        btn3.setDisable(state);
        btn4.setDisable(state);
        btn5.setDisable(state);
        btn6.setDisable(state);
        btn7.setDisable(state);
        btn8.setDisable(state);
        btn9.setDisable(state);
    }

    public void back() {
        try {
            dout.println("stop");
            closeConnection = true;
            AnchorPane fxmlLoader =  FXMLLoader.load(getClass().getResource("Menu.fxml"));
            onlineGame.getChildren().setAll(fxmlLoader);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void playAction(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeList();

        try{
            s = new Socket("localhost", 5555);
            //din = new DataInputStream(s.getInputStream());
            din = new BufferedReader(new InputStreamReader(s.getInputStream()));
            dout = new PrintStream(s.getOutputStream(), true);
        }catch(Exception ex){ex.printStackTrace();}

        ClientHandler ch = new ClientHandler();
        //ch.setDaemon(true);
        ch.start();
    }

    public void sendMsg(String msg){
        dout.println(msg);
    }

    public void initializeList(){
        buttons[0] = btn1;
        buttons[1] = btn2;
        buttons[2] = btn3;
        buttons[3] = btn4;
        buttons[4] = btn5;
        buttons[5] = btn6;
        buttons[6] = btn7;
        buttons[7] = btn8;
        buttons[8] = btn9;
    }

    class ClientHandler extends Thread{

        public void run(){
            while(true){

                try{
                    if(closeConnection)
                        break;
                    System.out.println("before");
                    recievedMessage = din.readLine();
                    if(recievedMessage.length() == 1)
                        playerTurn = recievedMessage;
                    else
                        playMove(recievedMessage);
                }catch(Exception ex){}

            }

            try{
                din.close();
                dout.close();
                s.close();
            }catch(Exception ex){}
        }

    }

    synchronized public void playMove(String play){
        char position = play.charAt(1);
        String player = "" + play.charAt(0);
        if(player.equals("x"))
            playerTurn = "o";
        if(player.equals("o"))
            playerTurn = "x";
        setButtonsState(false);
        Platform.runLater(new Runnable(){
            public void run(){
                switch(position){
                    case '1':
                        btn1.setText(player);
                        break;
                    case '2':
                        btn2.setText(player);
                        break;
                    case '3':
                        btn3.setText(player);
                        break;
                    case '4':
                        btn4.setText(player);
                        break;
                    case '5':
                        btn5.setText(player);
                        break;
                    case '6':
                        btn6.setText(player);
                        break;
                    case '7':
                        btn7.setText(player);
                        break;
                    case '8':
                        btn8.setText(player);
                        break;
                    case '9':
                        btn9.setText(player);
                        break;
                    default:
                        break;
                }
                end();
            }
        });
    }


}
