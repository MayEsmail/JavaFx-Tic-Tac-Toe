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
    }
	public GameDatabase(Game userGame)
        {
            
            SelectedGame = userGame;
            try
            {
                //display
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
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE_NAME , USER_NAME , PASSWORD);
    }
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
        }
        catch(SQLException exc)
        {
                exc.printStackTrace();
        }
    }
}
