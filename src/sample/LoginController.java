
package sample;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class LoginController{

    private ScreenLoader screenLoader=new ScreenLoader();
    public static int invalidType = 0; 
    @FXML
    private FlowPane parent_login;
    @FXML
    private TextField loginIdField;
    @FXML
    public void back(ActionEvent event){
        screenLoader.loadScene(event,"Menu.fxml");
    }

    @FXML
    private void login(ActionEvent event) throws IOException{
        //check database
        if(!OnlineGame.checkDB){
            OnlineGame.databaseObj = new GameDatabase(Game.TIC_TAC_TOE);
            OnlineGame.checkDB = true;
        }
        System.out.println(Game.TIC_TAC_TOE);
        int idNumber;
        String validInput = loginIdField.getText();
        int idLength = validInput.length();
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(validInput);
        if(m.matches() && idLength<6)
        {
            String idCheck = OnlineGame.databaseObj.loginPlayer(Integer.parseInt(validInput));
            if(idCheck.equals("")){
                invalidType = 1;                
                screenLoader.loadScene(event,"InvalidLogin.fxml");
            }
            else if (OnlineGame.databaseObj.checkLogin(Integer.parseInt(validInput))){
                OnlineGame.userName = idCheck;
                OnlineGame.userId = Integer.parseInt(validInput);
                MenuController.is_loggedin = true;
                
                if(!ProfileController.profileCheck)
                {
                    MenuController.computerPlay=false;
                    screenLoader.loadScene(event,"onlineGame.fxml");
                }
                else{
                    screenLoader.loadScene(event,"Profile.fxml");
                }
            }
            else{
                invalidType = 2;
                screenLoader.loadScene(event,"InvalidLogin.fxml");
            }
        }
        else{
            invalidType = 3;
            screenLoader.loadScene(event,"InvalidLogin.fxml");
        }

    }
    @FXML
    private void register(ActionEvent event){
        screenLoader.loadScene(event,"SingUpScreen.fxml");
    }
    
}
