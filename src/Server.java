import java.net.*;
import java.io.*;
import java.util.Vector;

public class Server{

    ServerSocket serverSocket;
    public static int counter = 1;

    public Server() throws Exception{//constructor

        serverSocket = new ServerSocket(5555);

        while(true){

            Socket s = serverSocket.accept();
            new GameHandler(s, counter);
            System.out.println("counter = " + counter);
            counter++;
        }

    }

    public static void main(String[] args) throws Exception{
        System.out.println("Server is listening!!!");
        new Server();
    }

}

class GameHandler extends Thread{

    DataInputStream dis;
    PrintStream ps;
    Socket s;
    String symbol;
    static Vector<GameHandler> clientsVector = new Vector<GameHandler>();//array of chat threads

    public GameHandler(Socket clientSocket, int counter) throws Exception{//constructor

        dis = new DataInputStream(clientSocket.getInputStream());

        ps = new PrintStream(clientSocket.getOutputStream());

        s = clientSocket;

        if(counter == 1)
            symbol = "x";
        else
            symbol = "o";

        ps.println(symbol);
        clientsVector.add(this);
        start();//start the thread

    }

    public void run(){
        while(true){
            String str = "";
            try{
                str = dis.readLine();//get any new messages

                if(str.trim().equals("stop")){

                    ps.close();
                    dis.close();
                    s.close();
                    Server.counter -= 1;

                }else if(str.trim().length() == 0){
                    System.out.println("Empty Message");
                }else{

                    sendMessageToAll(str);//send the message to all the clients

                }
            }catch(Exception ex){}

        }
    }

    public void sendMessageToAll(String str){
        //loop on all chat threads and send the message

        String firstChar = "" + str.charAt(0);
        for(GameHandler ch : clientsVector){
            if(!ch.symbol.equals(firstChar))
                ch.ps.println(str);
        }
    }

}