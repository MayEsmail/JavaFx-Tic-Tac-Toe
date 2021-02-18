package myproject;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GamePane extends Pane {
    Label fPName=new Label();
    Label sPName=new Label();
    Label fPScore=new Label("0");
    Label sPScore=new Label("0");
    GridPane board=new GridPane();
    Button[] buttons=new Button[9];
    boolean gameEnd;
    boolean turnX;
    int counter;
    Random random=new Random();
    int num;
    private void winGround(Button b1,Button b2,Button b3){
        b1.setStyle("-fx-background-color: yellow");
        b2.setStyle("-fx-background-color: yellow");
        b3.setStyle("-fx-background-color: yellow");
    }
    private void gameBoard(){
        int row=0;
        int col=0;
        for(int i=0;i<9;i++){
            buttons[i]=new Button();
            buttons[i].setPrefSize(90, 90);
            buttons[i].setFocusTraversable(false);
            board.add(buttons[i], col, row);
            buttons[i].addEventHandler(ActionEvent.ACTION,e->{actionPerformed(e);});
            col++;
            if(col==3){
                row++;
                col=0;
            }
        }
    }
    private void actionPerformed(ActionEvent e){
        Button button=(Button) e.getSource();
        if(gameEnd==false && button.getText().equals("")){
            //////////multiplay
            //Manage.computerPlay=false;
            if(Manage.computerPlay==false){
                if(turnX){
                    button.setText("X");
                }
                else{
                    button.setText("O");
                }
                counter++;
                end();
                turnX=!turnX;
            }
            //////////single play
            
            if(Manage.computerPlay){
                counter++;
                turnX=true;
                button.setText("X");
                end();
                if(gameEnd==false){
//                    for(Button btn:buttons){
//                        btn.removeEventHandler(ActionEvent.ACTION, eventHandler);
//                    }
                    counter++;
                    turnX=false;
                    for(;;){
                        num=random.nextInt(9);
                        if(buttons[num].getText()==""){
                            buttons[num].setText("O");
                            break;
                        }
                      }
                    end();
//                    for(Button btn:buttons){
//                        btn.addEventHandler(ActionEvent.ACTION, eventHandler);
//                    }
                }
            }
        }
    }
    private void end(){
        String[] text=new String[9];
        for(int i=0;i<9;i++){
            text[i]=buttons[i].getText();
        }
        ///check winner
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
        ///check out of squars 
        if(counter>=9){
            gameEnd=true;
            turnX=true;
            counter=0;
        }
        ///icrease score of winner    >>>check
        if(gameEnd){
            if(turnX)
               fPScore.setText(Integer.valueOf(fPScore.getText())+1+"");
            else
               sPScore.setText(Integer.valueOf(sPScore.getText())+1+"");
            counter=0;
        }
    }
    private void startGame(){
        gameEnd=false;
        for(Button btn: buttons){
            btn.setText("");
            btn.setStyle("-fx-background-color: none");
        }
    }
    public GamePane(){
        board.setPrefSize(300, 300);
        board.setTranslateX(45);
        board.setTranslateY(105);
        gameBoard();
        getChildren().add(fPName);
        getChildren().add(sPName);
        getChildren().add(fPScore);
        getChildren().add(sPScore);
        getChildren().add(board);
        Manage.computerPlay=false;
        startGame();
    }        
}
