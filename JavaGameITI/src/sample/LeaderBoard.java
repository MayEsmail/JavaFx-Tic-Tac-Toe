package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class LeaderBoard implements Initializable{

    @FXML
    TableView<TableContent> buildLeaderBoard;
    @FXML
    TableColumn<TableContent , String> rank_column;
    @FXML
    TableColumn<TableContent , String> name_column;
    @FXML
    TableColumn<TableContent , String> win_column;
    @FXML
    TableColumn<TableContent , String> lose_column;
    @FXML
    TableColumn<TableContent , String> score_column;
    public void initialize(URL location, ResourceBundle resources) {
        rank_column.setCellValueFactory(new PropertyValueFactory<>("rank"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        win_column.setCellValueFactory(new PropertyValueFactory<>("win"));
        lose_column.setCellValueFactory(new PropertyValueFactory<>("lose"));
        score_column.setCellValueFactory(new PropertyValueFactory<>("score"));
        buildLeaderBoard.setItems(getRecords());
        buildLeaderBoard.getColumns().addAll(rank_column , name_column , win_column , lose_column , score_column);
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
         
        String[][] data = MenuController.databaseObj.displayLeaderBoard();
         for (int i = 0; i < data.length; i++)
         {
             content.add(new TableContent(data[i][0], data[i][1], data[i][3], data[i][4], data[i][2]));
         }
         return content;
    }
}
