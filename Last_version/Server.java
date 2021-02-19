//package clientservertic;

import java.net.*;  
import java.io.*;
import java.util.Vector;

public class Server{

  ServerSocket serverSocket;

  public Server() throws Exception{//constructor

    serverSocket = new ServerSocket(5555);

    while(true){

      Socket s = serverSocket.accept();
      new GameHandler(s);
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
  static Vector<GameHandler> clientsVector = new Vector<GameHandler>();//array of chat threads

  public GameHandler(Socket clientSocket) throws Exception{//constructor

    dis = new DataInputStream(clientSocket.getInputStream());

    ps = new PrintStream(clientSocket.getOutputStream());

    s = clientSocket;

    clientsVector.add(this);
    start();//start the thread

  }

  public void run(){
    while(true){
      String str = "";
      try{
        str = dis.readLine();//get any new messages  

        if(str.trim().equals("STOP")){

          ps.close();
          dis.close();
          s.close();

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

    for(GameHandler ch : clientsVector){
      ch.ps.println(str);
    }
  }

}