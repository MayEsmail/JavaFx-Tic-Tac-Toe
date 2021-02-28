package sample;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;

public class LeaderBoard implements Initializable{

    @FXML
    private FlowPane leaderboard;
    @FXML
    private TableView<TableContent> buildLeaderBoard;
    @FXML
    private TableColumn<TableContent , String> rank_column;
    @FXML
    private TableColumn<TableContent , String> name_column;
    @FXML
    private TableColumn<TableContent , String> win_column;
    @FXML
    private TableColumn<TableContent , String> lose_column;
    @FXML
    private TableColumn<TableContent , String> score_column;
    @FXML
    private Label playerIdInfo;
    @FXML
    private Label playerNameInfo;
    @FXML
    private Label playerRankInfo;
    @FXML
    private Label playerScoreInfo;
    @FXML
    private Label playerWinInfo;
    @FXML
    private Label playerLoseInfo;
    @FXML
    private Label playerPerInfo;
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rank_column.setCellValueFactory(new PropertyValueFactory<>("rank"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        win_column.setCellValueFactory(new PropertyValueFactory<>("win"));
        lose_column.setCellValueFactory(new PropertyValueFactory<>("lose"));
        score_column.setCellValueFactory(new PropertyValueFactory<>("score"));
        buildLeaderBoard.setItems(getRecords());
        //buildLeaderBoard.getColumns().addAll(rank_column , name_column , win_column , lose_column , score_column);
    } 
    public void buildLeaderBoard() throws IOException
    {
        
    }
    public class TableContent{
        private String rank;
        private String name;
        private String win;
        private String lose;
        private String score;
        
        public TableContent(String rank , String name , String win , String lose , String score){
            this.rank = rank;
            this.name = name;
            this.win = win;
            this.lose = lose;
            this.score = score;
        }
        
        public String getRank() {
            return rank;
        }

        public String getName() {
            return name;
        }

        public String getWin() {
            return win;
        }

        public String getLose() {
            return lose;
        }

        public String getScore() {
            return score;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setWin(String win) {
            this.win = win;
        }

        public void setLose(String lose) {
            this.lose = lose;
        }

        public void setScore(String score) {
            this.score = score;
        }
        
        
    }
    
    ObservableList<TableContent> getRecords(){
         ObservableList<TableContent> content = FXCollections.observableArrayList();
        if(!OnlineGame.checkDB){
            OnlineGame.databaseObj = new GameDatabase(Game.TIC_TAC_TOE);
            OnlineGame.checkDB = true;
        }
        String[][] data = OnlineGame.databaseObj.displayLeaderBoard();
        System.out.println(data);
         for (int i = 0; i < data.length; i++)
         {
             content.add(new TableContent(data[i][0], data[i][1], data[i][3], data[i][4], data[i][2]));
         }
         HashMap<String , String> currentPlayerInfo = OnlineGame.databaseObj.displayUserInfo(OnlineGame.userId);
         playerIdInfo.setText(currentPlayerInfo.get("Id"));
         playerNameInfo.setText(currentPlayerInfo.get("Name"));
         playerRankInfo.setText(currentPlayerInfo.get("Rank"));
         playerScoreInfo.setText(currentPlayerInfo.get("Score"));
         playerWinInfo.setText(currentPlayerInfo.get("Win"));
         playerLoseInfo.setText(currentPlayerInfo.get("Lose"));
         playerPerInfo.setText(currentPlayerInfo.get("percentage")+"%");
         return content;
    }
    public void backFromLeaderboard(ActionEvent event) throws IOException{
        new ScreenLoader().loadScene(event,"Menu.fxml");
    }
}
