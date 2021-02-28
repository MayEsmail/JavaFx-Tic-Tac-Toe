/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.event.ActionEvent;

public class WinController{

    public void PlayAgain(ActionEvent event) throws  Exception{
        new ScreenLoader().loadScene(event, "Menu.fxml");
    }
    
}
