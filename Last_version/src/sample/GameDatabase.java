/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;
import java.sql.*;
import java.util.*;
/**
 *
 * @author hp
 */

enum Game {
  TIC_TAC_TOE
}

enum PlayerState {
  WIN,
  LOSE,
  TIE
}
public class GameDatabase
{
    static Connection con;
    private final static String  DATABASE_NAME = "javagame";
    private final static String USER_NAME = "root";
    private final static String  PASSWORD = "12345";
    private final static String TIC_TAC_TOE_GAME = "TicTacTocGame";
    private static Game SelectedGame;
    public static void main(String[] args)
    {
            GameDatabase databaseObj = new GameDatabase(Game.TIC_TAC_TOE);
            databaseObj.displayLeaderBoard();
            System.out.print(databaseObj.displayUserInfo(1).get("Name"));
//            databaseObj.addNewPlayer("Ali","000");
//            databaseObj.displayLeaderBoard();
//            databaseObj.updatePlayerRecord(5 , PlayerState.WIN);
//            databaseObj.updatePlayerRecord(6 , PlayerState.LOSE);
//            databaseObj.updatePlayerRecord(7 , PlayerState.TIE);
//            databaseObj.displayLeaderBoard();
//            databaseObj.removePlayer(29);
//            databaseObj.displayLeaderBoard();
//            databaseObj.removePlayer(30);
//            databaseObj.displayLeaderBoard();
//            databaseObj.removePlayer(30);
//            databaseObj.displayLeaderBoard();
//            databaseObj.editPlayerName(1,"Dakhly");
//            databaseObj.displayLeaderBoard();
            
    }
	public GameDatabase(Game userGame)
        {
            
            SelectedGame = userGame;
            try
            {
                //stablish the connection
                GameDatabase.connectDB();
            }
            catch(SQLException exc)
            {
                    exc.printStackTrace();
            }
	}
    private static void connectDB() throws SQLException
    {
        //Conecct with MySQL database management system using Database name, User name and User password. 
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception ex){}
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javagame"  , USER_NAME , PASSWORD);
    }
    
    private static void disconnectDB() throws SQLException
    {
        //Disconnect with database. 
        con.close();
    } 
    //user information
    //public String[] displayUserInfo(int id)
    public HashMap<String, String> displayUserInfo(int id)
    {
        try
        {
            Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("select * from " + GameDatabase.TIC_TAC_TOE_GAME + " ORDER BY Score DESC");
            }
            else 
            {
                queryString = new String("select * from" + "anotherGame" + " ORDER BY Score DESC");
            }
            ResultSet rs = stmt.executeQuery(queryString);
            int counter = 1;
            //String[] data = new String[7];
            HashMap<String, String> data = new HashMap<String, String>();
            while(rs.next())
            {
                if(rs.getInt("Id") == id)
                {
                    
//                    data[0] = Integer.toString(rs.getInt("Id"));
//                    data[1] = rs.getString("Name");
//                    data[2] = Integer.toString(counter);
//                    data[3] = Integer.toString(rs.getInt("Score"));
//                    data[4] = Integer.toString(rs.getInt("Win"));
//                    data[5] = Integer.toString(rs.getInt("Lose"));
//                    if(rs.getInt("Lose") != 0)
//                    {
//                        data[6] = Integer.toString(rs.getInt("Win") * 100 / (rs.getInt("Lose") + rs.getInt("Win")));
//                    }
//                    else
//                    {
//                        data[6] = "100";
//                    }
                    data.put("Id", Integer.toString(rs.getInt("Id")));
                    data.put("Name", rs.getString("Name"));
                    data.put("Rank", Integer.toString(counter));
                    data.put("Score", Integer.toString(rs.getInt("Score")));
                    data.put("Win", Integer.toString(rs.getInt("Win")));
                    data.put("Lose", Integer.toString(rs.getInt("Lose")));
                    if(rs.getInt("Lose") != 0)
                    {
                        data.put("percentage", Integer.toString(rs.getInt("Win") * 100 / (rs.getInt("Lose") + rs.getInt("Win"))));
                    }
                    else
                    {
                        data.put("percentage", "100");;
                    }
                }
                counter++;
            }
            stmt.close();
            return data;
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        }
        return null;
    }
    //DashBoard
    public String[][] displayLeaderBoard()
    {
        try
        {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("select * from " + GameDatabase.TIC_TAC_TOE_GAME + " ORDER BY Score DESC");
            }
            else 
            {
                queryString = new String("select * from" + "anotherGame" + " ORDER BY Score DESC");
            }
            ResultSet rs = stmt.executeQuery(queryString);
            int counter = 1;
            while(rs.next())
            {
                counter++;
            }
            String[][] data = new String[counter][5];
            counter = 1;
            rs.beforeFirst();
            while(rs.next())
            {
                data[counter] = new String[5];
                data[counter][0] = Integer.toString(counter);
                data[counter][1] = rs.getString("Name");
                data[counter][2] = Integer.toString(rs.getInt("Score"));
                data[counter][3] = Integer.toString(rs.getInt("Win"));
                data[counter][4] = Integer.toString(rs.getInt("Lose"));
                counter++;
            }
//            System.out.println(data[1][3]);
            stmt.close();
            return data;
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        }
        return null;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //add new user 2 Methods
    public int addNewPlayer(String name , String password)
    {
        int ret = -1;
        try
        {
            Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("INSERT INTO " + GameDatabase.TIC_TAC_TOE_GAME + "(Name,Password,SavedFile) VALUES('" + name + "'," + password + ",null)");
            }
            else 
            {
                queryString = new String("INSERT INTO " + "anotherGame" + "VALUES('" + name + "','" + password + "',null");
            }
            stmt.executeUpdate(queryString);
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("SELECT Id FROM " + GameDatabase.TIC_TAC_TOE_GAME + " ORDER BY Id DESC LIMIT 1");
            }
            else 
            {
                queryString = new String("SELECT Id FROM " + "anotherGame" + " ORDER BY Id DESC LIMIT 1");
            }
            ResultSet rs = stmt.executeQuery(queryString);
            rs.next();
            ret = rs.getInt("Id");
            stmt.close();
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        } 
        return ret;
    }
    
    public int addNewPlayer(String name)
    {
        int ret = -1;
        try
        {
            Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("INSERT INTO " + GameDatabase.TIC_TAC_TOE_GAME + "(Name,Password,SavedFile) VALUES('" + name + "',null,null)");
            }
            else 
            {
                queryString = new String("INSERT INTO " + "anotherGame" + "VALUES('" + name + "',null,0,0,0,null");
            }
            stmt.executeUpdate(queryString);
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("SELECT Id FROM " + GameDatabase.TIC_TAC_TOE_GAME + " ORDER BY Id DESC LIMIT 1");
            }
            else 
            {
                queryString = new String("SELECT Id FROM " + "anotherGame" + " ORDER BY Id DESC LIMIT 1");
            }
            ResultSet rs = stmt.executeQuery(queryString);
            rs.next();
            ret = rs.getInt("Id");
            stmt.close();
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        } 
        return ret;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //upload table with result of match
    public void updatePlayerRecord(int id , PlayerState pState)
    {
        try
        {
            int oldScore;
            int oldWin;
            int oldLose;
            Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("SELECT * FROM " + GameDatabase.TIC_TAC_TOE_GAME + " WHERE Id = " + id);
            }
            else 
            {
                queryString = new String("SELECT * FROM " + "anotherGame" + " WHERE Id = " + id);
            }
            ResultSet rs = stmt.executeQuery(queryString);
            rs.next();
            oldScore = rs.getInt("Score");
            oldLose = rs.getInt("Lose");
            oldWin = rs.getInt("Win");
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                switch(pState)
                {
                    case WIN:
                        queryString = new String("UPDATE " + GameDatabase.TIC_TAC_TOE_GAME + " SET Score = " 
                        + (oldScore + 10) + ", Win = " + (oldWin + 1) + " WHERE Id = " + id);
                        break;
                    case LOSE:
                        queryString = new String("UPDATE " + GameDatabase.TIC_TAC_TOE_GAME + " SET Lose = " 
                        + (oldLose + 1) + " WHERE Id = " + id);
                        break;
                    case TIE:
                        queryString = new String("UPDATE " + GameDatabase.TIC_TAC_TOE_GAME + " SET Score = " 
                        + (oldScore + 5) + " WHERE Id = " + id);
                        break;
                }
            }
            else 
            {
                switch(pState)
                {
                    case WIN:
                        queryString = new String("UPDATE " + "anotherGame" + "SET Score = " 
                        + (oldScore + 10) + ", Win = " + (oldWin + 1) + " WHERE Id = " + id);
                        break;
                    case LOSE:
                        queryString = new String("UPDATE " + "anotherGame" + "SET Lose = " 
                        + (oldLose + 1) + " WHERE Id = " + id);
                        break;
                    case TIE:
                        queryString = new String("UPDATE " + "anotherGame" + "SET Score = " 
                        + (oldScore + 5) + " WHERE Id = " + id);
                        break;
                }
            }
            stmt.executeUpdate(queryString);
            stmt.close();
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        } 
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //delete Player
    public void removePlayer(int id)
    {
        try
        {
            Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("DELETE FROM " + GameDatabase.TIC_TAC_TOE_GAME + " WHERE Id = " + id);
            }
            else 
            {
                queryString = new String("DELETE FROM " + "anotherGame"+ " WHERE Id = " + id);
            }
            stmt.executeUpdate(queryString);
            stmt.close();
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        } 
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Edit Player Name
    public void editPlayerName(int id , String name)
    {
        try
        {
            Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("UPDATE " + GameDatabase.TIC_TAC_TOE_GAME + " SET Name = '" + name + "' WHERE Id = " + id);
            }
            else 
            {
                queryString = new String("UPDATE " + "anotherGame" + " SET Name = '" + name + "' WHERE Id = " + id);
            }
            stmt.executeUpdate(queryString);
            stmt.close();
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        } 
    }
    public String loginPlayer(int id)
    {
        try
        {
            Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("SELECT * FROM " + GameDatabase.TIC_TAC_TOE_GAME + " WHERE Id = " + id);
            }
            else 
            {
                queryString = new String("DELETE FROM " + "anotherGame"+ " WHERE Id = " + id);
            }           
            ResultSet rs = stmt.executeQuery(queryString);
            if(rs.next())
            {
                return rs.getString("Name").trim();
            }
            stmt.close();
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        } 
        return "";
    }
    public boolean checkLogin(int id)
    {
        try
        {
            Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("SELECT LoginStatus FROM " + GameDatabase.TIC_TAC_TOE_GAME + " WHERE Id = " + id);
            }
            else 
            {
                queryString = new String("SELECT LoginStatus FROM " + "anotherGame"+ " WHERE Id = " + id);
            }           
            ResultSet rs = stmt.executeQuery(queryString);
            if(rs.next())
            {
                if(! rs.getBoolean("LoginStatus"))
                {
                    if(SelectedGame == Game.TIC_TAC_TOE)
                    {    
                        queryString = new String("UPDATE " + GameDatabase.TIC_TAC_TOE_GAME + " SET LoginStatus = TRUE WHERE Id = " + id);
                    }
                    else 
                    {
                        queryString = new String("UPDATE " + "anotherGame" + " SET LoginStatus = TRUE WHERE Id = " + id);
                    }
                    stmt.executeUpdate(queryString);
                    stmt.close();
                    return true;
                }
            }
            stmt.close();
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        } 
        return false;
    }
    public void LoginOut(int id)
    {
        try
        {
            Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("UPDATE " + GameDatabase.TIC_TAC_TOE_GAME + " SET LoginStatus = FALSE WHERE Id = " + id);
            }
            else 
            {
                queryString = new String("UPDATE " + "anotherGame" + " SET LoginStatus = FALSE WHERE Id = " + id);
            }
            stmt.executeUpdate(queryString);
            stmt.close();
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        } 
    }
}
