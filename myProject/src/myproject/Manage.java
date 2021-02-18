package myproject;

import javafx.scene.layout.Pane;

public class Manage {
  static  GamePane gamePane=new GamePane();
// static   SinglePane singlePane=new SinglePane();
//  static  StartPane startPane=new StartPane();
//  static  MultiPane multiPane=new MultiPane();
    static boolean computerPlay;
    public static void view(Pane pane){
        gamePane.setVisible(false);
//        singlePane.setVisible(false);
//        startPane.setVisible(false);
//        multiPane.setVisible(false);
          pane.setVisible(true);
    }    
}
