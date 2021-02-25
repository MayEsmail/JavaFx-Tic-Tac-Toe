package sample;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import java.util.concurrent.TimeUnit;

public class ReplayController implements Initializable{
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
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        show();
    }
    public void show(){
        System.out.println("hello");
        try{
          FileInputStream fis=new FileInputStream("game.txt");
          Scanner in=new Scanner(fis);
            while(in.hasNext()){
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
                    case "three":
                        three.setText(text);
                    case "four":
                        four.setText(text);
                    case "five":
                        five.setText(text);
                    case "six":
                        six.setText(text);
                    case "seven":
                        seven.setText(text);
                    case "eight":
                        eight.setText(text);
                    case "nine":
                        nine.setText(text);
                 }
//            TimeUnit.SECONDS.sleep(2);                
            }  
        }
        catch(Exception e){e.printStackTrace();}
    } 
}
