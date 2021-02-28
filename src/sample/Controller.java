package sample;

import java.io.FileOutputStream;
import java.io.FileWriter;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Controller implements Initializable {
    public int xSCore=0;
    public int oScore=0;
    boolean gameEnd;
    boolean turnX;
    int counter;
    Random random=new Random();
    int num;
    static boolean playOnline = false;
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
    private FlowPane parent_sample;
    public ScreenLoader screenLoader=new ScreenLoader();
    @FXML
    private Label turn;
    @FXML
    private Label fPScore;
    @FXML
    private Label sPScore;
    private String player = "X";
    Button[] buttons=new Button[9];
    protected char winner='-';
    Stage App_Stage;
    ComputerAI computer;
    public FileWriter computerFos;
    static  Button button;
    
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
        if(MenuController.computerPlay ||MenuController.local){
            change_screen(winner);
        }

    }

    public void back(ActionEvent event) {
        screenLoader.loadScene(event,"Menu.fxml");
    }

    public void playAction(ActionEvent e){
        button=(Button) e.getSource();
        App_Stage= (Stage)((Node) e.getSource()).getScene().getWindow();
        int row=0 ;
        int col=0 ;
        int position ;
        if(gameEnd==false && button.getText().equals("")){
            //////////multiplay
            //Manage.computerPlay=false;
            if(MenuController.computerPlay==false){
                if(turnX){
                    button.setStyle("-fx-text-fill: #ad03fc");
                    button.setText("X");
                    positions[counter]=button.getId();
                    texts[counter]=button.getText();
                }
                else{
                    button.setStyle("-fx-text-fill: #fcba03");
                    button.setText("O");
                    positions[counter]=button.getId();
                    texts[counter]=button.getText();
                }
                counter++;
                end();
                turnX=!turnX;
            }
            //////////single play

            if(MenuController.computerPlay){
                App_Stage= (Stage)((Node) e.getSource()).getScene().getWindow();

                turnX=true;
                button.setStyle("-fx-text-fill: #ad03fc");
                button.setText("X");
                playerRecord(button);
                end();
                if (!gameEnd){
                    ComputerAI.Move move=computer.getBestMove();
                    row = move.row;
                    col = move.col;
                    position = calculatePosition(row,col);

                    counter+=2;
                    if(position>-1)
                        computerRecord(position);
                    end();

                }
            }
        }
    }
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
    private void closeStream(){
        try {
            if(computerFos!=null)
                computerFos.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void change_screen(char myWinner){

        if(MenuController.local){
            if(myWinner=='X'){
                screenLoader.loadScene(App_Stage,"Local_XWin.fxml");
            }
            else if(myWinner=='O'){
                screenLoader.loadScene(App_Stage,"Local_OWin.fxml");
            }
            else{
                screenLoader.loadScene(App_Stage,"Draw.fxml");
            }
        }
        else if(MenuController.computerPlay){
            if(player.equals(""+myWinner)){
                closeStream();
                screenLoader.loadScene(App_Stage,"Win.fxml");
            }
            else if(myWinner=='-'){
                closeStream();
                screenLoader.loadScene(App_Stage,"Draw.fxml");
            }

            else{
                closeStream();
                screenLoader.loadScene(App_Stage,"lose.fxml");
            }

        }
    }
    private void endAndRecord(){
        gameEnd=true;
        if(!MenuController.computerPlay&&!Controller.playOnline)
            record();
    }
    public void end(){
        String[] text=new String[9];
        for(int i=0;i<9;i++){
            text[i]=buttons[i].getText();
        }
        ///check winner
        if(!gameEnd) {
            if(text[0].equals(text[1]) && text[0].equals(text[2]) && !text[0].equals("")){
                winGround(buttons[0],buttons[1],buttons[2]);
                endAndRecord();
            }
            if(text[0].equals(text[3]) && text[0].equals(text[6]) && !text[0].equals("")){
                winGround(buttons[0],buttons[3],buttons[6]);
                endAndRecord();
            }
            if(text[0].equals(text[4]) && text[0].equals(text[8]) && !text[0].equals("")){
                winGround(buttons[0],buttons[4],buttons[8]);
                endAndRecord();
            }
            if(text[1].equals(text[4]) && text[1].equals(text[7]) && !text[1].equals("")){
                winGround(buttons[1],buttons[4],buttons[7]);
                endAndRecord();
            }
            if(text[2].equals(text[5]) && text[2].equals(text[8]) && !text[2].equals("")){
                winGround(buttons[2],buttons[5],buttons[8]);
                endAndRecord();
            }
            if(text[3].equals(text[4]) && text[3].equals(text[5]) && !text[3].equals("")){
                winGround(buttons[3],buttons[4],buttons[5]);
                endAndRecord();
            }
            if(text[6].equals(text[7]) && text[6].equals(text[8]) && !text[6].equals("")){
                winGround(buttons[6],buttons[7],buttons[8]);
                endAndRecord();
            }
            if(text[2].equals(text[4]) && text[2].equals(text[6]) && !text[2].equals("")){
                winGround(buttons[2],buttons[4],buttons[6]);
                endAndRecord();
            }
            ///check out of squares
            if(counter>=9){
                endAndRecord();
                turnX=true;
                counter=0;
                if(MenuController.computerPlay ||MenuController.local){
                    change_screen(winner);
                }
            }
        }
    }
    public int  calculatePosition(int row,int col){
        int position;
        switch (row){
            case 0 :
                position=row+col+1;
                return position;
            case 1:
                position=row+col+3;
                return position;
            case 2:
                position=row+col+5;
                return position;
            default:
                return -1;

        }
    }
    public void playerRecord(Button btn){

        try{
            if(RecordController.recordme){
                String id = btn.getId();
                computerFos.write(id+"\n");
                computerFos.write("X\n");
            }
        }catch(Exception e){e.printStackTrace();}
    }
    public void computerRecord(int position){
        String [] mappedPositions = new String[9];
        mappedPositions[0] = "one\n";
        mappedPositions[1] = "two\n";
        mappedPositions[2] = "three\n";
        mappedPositions[3] = "four\n";
        mappedPositions[4] = "five\n";
        mappedPositions[5] = "six\n";
        mappedPositions[6] = "seven\n";
        mappedPositions[7] = "eight\n";
        mappedPositions[8] = "nine\n";

        try{
            if(RecordController.recordme){

                computerFos.write(mappedPositions[position-1]);
                computerFos.write("O\n");
            }
        }catch(Exception e){e.printStackTrace();}
    }
    private void increaseScore(String player) {
        if (player.toLowerCase().equals("x")) {

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
        computer = new ComputerAI(buttons);
        try{
            if(RecordController.recordme){
                computerFos=new FileWriter("game.txt");

            }
        }catch(Exception e){e.printStackTrace();}

    }
}
