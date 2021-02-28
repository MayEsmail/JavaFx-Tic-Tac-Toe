package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;

public class ReplayController implements Initializable {
    FileInputStream fis;
    Scanner in;
    int isRead=0;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private  Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private FlowPane replay;
    private ScreenLoader screenLoader =new ScreenLoader();
    boolean isFileError = false;
    public void updateGui(){

        try{
            if(in!=null &&in.hasNext()&& !isFileError){

                String data;
                data=in.nextLine();
                String text;
                text=in.nextLine();
                System.out.println(data);
                System.out.println(text);

                switch(data){
                    case "one":
                        one.setText(text);

                        break;
                    case "two":
                        two.setText(text);
                        break;

                    case "three":
                        three.setText(text);
                        break;

                    case "four":
                        four.setText(text);
                        break;

                    case "five":
                        five.setText(text);
                        break;

                    case "six":
                        six.setText(text);
                        break;

                    case "seven":
                        seven.setText(text);
                        break;

                    case "eight":
                        eight.setText(text);
                        break;

                    case "nine":
                        nine.setText(text);
                        break;

                }

                isRead++;

            }
        }
        catch(Exception e){e.printStackTrace();}
    }
    public void back(ActionEvent event){
            screenLoader.loadScene(event,"Menu.fxml");
    }
    public void playBack(ActionEvent event) {
        if(isFileError){
            screenLoader.loadScene(event,"FileNotFound.fxml");
        }

        Thread thread = new Thread(() -> {
            try {
                while(isRead!=9){

                    Platform.runLater(() -> updateGui()
                    );
                    Thread.sleep(1000);
                }



            } catch (Exception exc) {
                // should not be able to get here...
                throw new Error("Unexpected interruption");
            }
            checkWin();
        });
        thread.start();
    }
    public void checkWin(){
        String[] str=new String[9];
        str[0]=one.getText();
        str[1]=two.getText();
        str[2]=three.getText();
        str[3]=four.getText();
        str[4]=five.getText();
        str[5]=six.getText();
        str[6]=seven.getText();
        str[7]=eight.getText();
        str[8]=nine.getText();
        if(str[0].equals(str[1]) && str[0].equals(str[2]) && str[0]!=""){
            color(one,two,three);}
        if(str[0].equals(str[3]) &&str[0].equals(str[6]) && str[0]!=""){
            color(one,four,seven);}
        if(str[0].equals(str[4]) && str[0].equals(str[8]) && str[0]!=""){
            color(one,five,nine);}
        if(str[1].equals(str[4]) && str[1].equals(str[7]) && str[1]!=""){
            color(two,five,eight);}
        if(str[2].equals(str[5]) && str[2].equals(str[8]) && str[2]!=""){
            color(three,six,nine);}
        if(str[3].equals(str[4]) && str[3].equals(str[5]) && str[3]!=""){
            color(four,five,six);}
        if(str[6].equals(str[7]) && str[6].equals(str[8]) && str[6]!=""){
            color(seven,eight,nine);}
        if(str[2].equals(str[4]) && str[2].equals(str[6]) && str[2]!=""){
            color(three,five,seven);}
    }
    public void color(Button b1,Button b2,Button b3){
        b1.setStyle("-fx-background-color: yellow");
        b2.setStyle("-fx-background-color: yellow");
        b3.setStyle("-fx-background-color: yellow");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
               try {

           fis=new FileInputStream("game.txt");
           in=new Scanner(fis);
        }catch (FileNotFoundException ex){
          if(ex!=null){
               isFileError=true;
        
           }
       } System.out.println("in replay");
    }
}
