/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
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
    private final static String  DATABASE_NAME = "JavaGame";
    private final static String USER_NAME = "root";
    private final static String  PASSWORD = "12345";
    private final static String TIC_TAC_TOE_GAME = "TicTacTocGame";
    private static Game SelectedGame;
    public static void main(String[] args)
    {
            GameDatabase databaseObj = new GameDatabase(Game.TIC_TAC_TOE);
            databaseObj.displayDashBoard();
            databaseObj.addNewPlayer("Ali","000");
            databaseObj.displayDashBoard();
            databaseObj.updatePlayerRecord(5 , PlayerState.WIN);
            databaseObj.updatePlayerRecord(6 , PlayerState.LOSE);
            databaseObj.updatePlayerRecord(7 , PlayerState.TIE);
            databaseObj.displayDashBoard();
            databaseObj.removePlayer(29);
            databaseObj.displayDashBoard();
            databaseObj.removePlayer(30);
            databaseObj.displayDashBoard();
            databaseObj.removePlayer(30); 
            databaseObj.displayDashBoard();
            
    }
	public GameDatabase(Game userGame)
        {
            
            SelectedGame = userGame;
            try
            {
                //display
                GameDatabase.connectDB();
                /*Statement stmt = con.createStatement();
                String queryString = new String("select * from students");
                ResultSet rs = stmt.executeQuery(queryString);
                System.out.println("display all data");
                while(rs.next())
                {
                        System.out.print(rs.getInt("idStudents") + "\t");
                        System.out.print(rs.getString("Names") + "\t\t");
                        System.out.print(rs.getInt("Age") + "\t");
                        System.out.println(" ");
                }*/

                /*//insert
                queryString = new String("INSERT INTO students VALUES(8 , 'John' , 50)");
                stmt.executeUpdate(queryString);
                queryString = new String("select * from students");
                rs = stmt.executeQuery(queryString);
                System.out.println("display all data after Insert query");
                while(rs.next())
                {
                        System.out.print(rs.getInt("idStudents") + "\t");
                        System.out.print(rs.getString("Names") + "\t\t");
                        System.out.print(rs.getInt("Age") + "\t");
                        System.out.println(" ");
                }*/

                //delete
                /*queryString = new String("DELETE FROM students WHERE idStudents=8");
                stmt.executeUpdate(queryString);
                queryString = new String("select * from students");
                rs = stmt.executeQuery(queryString);
                System.out.println("display all data Delete");
                while(rs.next())
                {
                        System.out.print(rs.getInt("idStudents") + "\t");
                        System.out.print(rs.getString("Names") + "\t\t");
                        System.out.print(rs.getInt("Age") + "\t");
                        System.out.println(" ");
                }*/

                /*//update
                queryString = new String("UPDATE students SET Names='Khaled' WHERE idStudents=8");
                stmt.executeUpdate(queryString);
                queryString = new String("select * from students");
                rs = stmt.executeQuery(queryString);
                System.out.println("display all data update");
                while(rs.next())
                {
                        System.out.print(rs.getInt("idStudents") + "\t");
                        System.out.print(rs.getString("Names") + "\t\t");
                        System.out.print(rs.getInt("Age") + "\t");
                        System.out.println(" ");
                }*/
            }
            catch(SQLException exc)
            {
                    exc.printStackTrace();
            }
	}
    private static void connectDB() throws SQLException
    {
        //Conecct with MySQL database management system using Database name, User name and User password. 
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE_NAME , USER_NAME , PASSWORD);
    }
    
    private static void disconnectDB() throws SQLException
    {
        //Disconnect with database. 
        con.close();
    } 
    //DashBoard
    public void displayDashBoard()
    {
        
        try
        {
            Statement stmt = con.createStatement();
            String queryString;
            if(SelectedGame == Game.TIC_TAC_TOE)
            {    
                queryString = new String("select * from " + GameDatabase.TIC_TAC_TOE_GAME);
            }
            else 
            {
                queryString = new String("select * from" + "anotherGame");
            }
            ResultSet rs = stmt.executeQuery(queryString);
            while(rs.next())
            {
                    System.out.print(rs.getString("Name") + "\t");
                    System.out.print(rs.getInt("Score") + "\t\t");
                    System.out.print(rs.getInt("Win") + "\t");
                    System.out.print(rs.getInt("Lose") + "\t");
                    System.out.println(" ");
            }
            stmt.close();
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        }
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
                queryString = new String("DELETE FROM " + GameDatabase.TIC_TAC_TOE_GAME + " WHERE Id = " + id);
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
