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
        System.out.println(clientsVector);
        clientsVector.add(this);
        start();//start the thread

    }

    public void run(){
        System.out.println(Thread.currentThread().getName());
        if(Server.counter == 2)
            sendMessageToAll("u:x");
        if(Server.counter > 2)
            sendMessageToAll("go");
        while(true){
            String str = "";
            try{
                str = dis.readLine();//get any new messages

                if(str.trim().equals("stop")){

                    ps.close();
                    dis.close();
                    s.close();
                    Server.counter -= 1;

                }else if(str.trim().equals("close")){
                    sendMessageToAll(str);
                    Server.counter = 1;
                    for(GameHandler ch : clientsVector){
                        try{
                            ch.ps.close();
                            ch.dis.close();
                            ch.s.close();
                            System.out.println("Client closed");
                        }catch (Exception ex){ex.printStackTrace();}
                    }
                    clientsVector.clear();
                    break;
                }else if(str.trim().length() == 0){
                    System.out.println("Empty Message");
                }else{

                    sendMessageToAll(str);//send the message to all the clients

                }
            }catch(Exception ex){}

        }

        try{
            this.stop();
        }catch(Exception ex){ex.printStackTrace();}

        /*try{
            ps.close();
            dis.close();
            s.close();
            System.out.println("Client closed");
        }catch (Exception ex){ex.printStackTrace();}*/
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