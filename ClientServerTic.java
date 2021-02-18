import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import javafx.application.Platform;

public class ClientServerTic extends Application {

    volatile String message = "";
    volatile String recievedMessage = "";
    static Socket s;
    static BufferedReader din;
    static PrintStream dout;
    ClientGui root;

    public ClientServerTic(){
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

    @Override
    public void start(Stage stage){
        root = new ClientGui();

        Scene scene = new Scene(root); 
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);  
        stage.show();

        root.btn1.setOnAction(e->{
            sendMsg("x1");
        });
        root.btn2.setOnAction(e->{
            sendMsg("x2");
        });
        root.btn3.setOnAction(e->{
            sendMsg("x3");
        });
        root.btn4.setOnAction(e->{
            sendMsg("x4");
        });
        root.btn5.setOnAction(e->{
            sendMsg("x5");
        });
        root.btn6.setOnAction(e->{
            sendMsg("x6");
        });
        root.btn7.setOnAction(e->{
            sendMsg("x7");
        });
        root.btn8.setOnAction(e->{
            sendMsg("x8");
        });
        root.btn9.setOnAction(e->{
            sendMsg("x9");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void sendMsg(String msg){
        dout.println(msg);
    }

    class ClientHandler extends Thread{

        public void run(){
            while(true){

                try{
                    if(message.equals("stop"))
                        break;
                    System.out.println("before");
                    recievedMessage = din.readLine();
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
        System.out.println(position);
        Platform.runLater(new Runnable(){
            public void run(){
                switch(position){
                    case '1':
                        root.btn1.setText("x");
                        break;
                    case '2':
                        root.btn2.setText("x");
                        break;
                    case '3':
                        root.btn3.setText("x");
                        break;
                    case '4':
                        root.btn4.setText("x");
                        break;
                    case '5':
                        root.btn5.setText("x");
                        break;
                    case '6':
                        root.btn6.setText("x");
                        break;
                    case '7':
                        root.btn7.setText("x");
                        break;
                    case '8':
                        root.btn8.setText("x");
                        break;
                    case '9':
                        root.btn9.setText("x");
                        break;    
                    default:
                        break;
                }
            }
        });
    }

}
