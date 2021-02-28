package sample;

import java.io.*;
import java.net.Socket;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class OnlineGame extends Controller implements Initializable{
    volatile String message = "";
    volatile String recievedMessage = "";
    static Socket s;
    static BufferedReader din;
    static PrintStream dout;
    String playerTurn = "o";
    static String userName = "";
    static int userId;
    volatile boolean closeConnection = false;
    static GameDatabase databaseObj;
    static boolean checkDB = false;
    boolean isRecording = false;
    FileWriter fw;

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
    private Button backBtn;
    @FXML
    private FlowPane onlineGame;
    @FXML
    private TextField msgText;
    @FXML
    private Label msgLabel;
    @FXML
    private Button sendBtn;

    public void onPlay(ActionEvent event){
        Button btn = (Button) event.getSource();
        String pos = mapIdToPosition(btn.getId().charAt(3));
        App_Stage= (Stage)((Node) event.getSource()).getScene().getWindow();
        if(!gameEnd && btn.getText().length() == 0) {
            sendMsg(playerTurn + btn.getId().charAt(3));
            saveToFile(pos, playerTurn);
            btn.setText(playerTurn);
            if(playerTurn.equals("x"))
                turnX = false;
            if(playerTurn.equals("o"))
                turnX = true;
            System.out.println(turnX);
            setButtonsState(true);
            end();
            checkGameState();
        }

    }

    public String mapIdToPosition(char id){
        switch (id){
            case '1':
                return "one";
            case '2':
                return "two";
            case '3':
                return "three";
            case '4':
                return "four";
            case '5':
                return "five";
            case '6':
                return "six";
            case '7':
                return "seven";
            case '8':
                return "eight";
            case '9':
                return "nine";
            default:
                return "";
        }
    }

    public void saveToFile(String pos, String symbol){
        System.out.println(pos);
        System.out.println(symbol);
        if(isRecording){
            try{
                fw.write(pos+"\r\n");
                fw.write(symbol+"\r\n");
            }catch(Exception ex){ex.printStackTrace();}

        }
    }

    public void checkGameState(){
        if(gameEnd) {
            backBtn.setVisible(true);
            try{
                if(isRecording)
                    fw.close();
            }catch(Exception ex){ex.printStackTrace();}

            dout.println("close");
            if(winner == '-'){
                databaseObj.updatePlayerRecord(OnlineGame.userId, PlayerState.TIE);
                change_screen("tie");
            }else{
                if(!turnX && playerTurn.equals("x")){
                    databaseObj.updatePlayerRecord(OnlineGame.userId, PlayerState.WIN);
                    change_screen("win");
                }else if(turnX && playerTurn.equals("o")){
                    databaseObj.updatePlayerRecord(OnlineGame.userId, PlayerState.WIN);
                    change_screen("win");
                }else{
                    databaseObj.updatePlayerRecord(OnlineGame.userId, PlayerState.LOSE);
                    change_screen("lose");
                }
            }

        }
    }

    public void change_screen(String state){
        switch (state){
            case "win":
                loadScreen("Win.fxml");
                break;
            case "lose":
                loadScreen("lose.fxml");
                break;
            case "tie":
                loadScreen("Draw.fxml");
                break;
            default:
                break;
        }
    }

    public void loadScreen(String screen){
        try {
            Parent Win_Parent=FXMLLoader.load(getClass().getResource(screen));
            Scene Win_Scene=new Scene(Win_Parent);
            App_Stage.setScene(Win_Scene);
            App_Stage.show();
        } catch(IOException e) {
            e.printStackTrace();
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
        backBtn.setVisible(false);
        initializeList();
        setButtonsState(true);
        sendBtn.setDisable(true);
        isRecording = RecordController.recordme;

        try{
            if(isRecording)
                fw = new FileWriter("game.txt");
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
        counter++;
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

    public void handleChat(ActionEvent event) {
        String msg;
        if(!(msgText.getText().trim().length() == 0)){
            msg = playerTurn + "m:" + msgText.getText().trim();
            dout.println(msg);
            msgLabel.setText("You: " + msgText.getText().trim());
            msgText.setText("");
        }
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
                    else if(recievedMessage.equals("u:x"))
                        playerTurn = "x";
                    else if(recievedMessage.charAt(1) == 'm')
                        displayMessage(recievedMessage);
                    else if(recievedMessage.equals("go")){
                        setButtonsState(false);
                        sendBtn.setDisable(false);
                    }
                    else if(recievedMessage.equals("close"))
                        break;
                    else
                        playMove(recievedMessage);
                }catch(Exception ex){}

            }

            try{
                din.close();
                dout.close();
                s.close();
                System.out.println("closed");
            }catch(Exception ex){}
        }

    }

    synchronized  public  void displayMessage(String msg){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                msgLabel.setText("Oponent: "+ msg.substring(3));
            }
        });
    }

    synchronized public void playMove(String play){
        char position = play.charAt(1);
        String player = "" + play.charAt(0);
        String pos = mapIdToPosition(position);
        if(player.equals("x"))
            turnX = false;
        if(player.equals("o"))
            turnX = true;
        System.out.println(turnX);
        setButtonsState(false);
        Platform.runLater(new Runnable(){
            public void run(){
                counter++;
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
                saveToFile(pos, player);
                end();
                checkGameState();
                /*if (gameEnd)
                    backBtn.setVisible(true);*/
            }
        });
    }


}
