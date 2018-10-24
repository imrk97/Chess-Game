package database_score;


/*
 * Created by Rohan Karmakar (imrk97)
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class update_score {
	public update_score(String winner, String loser) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Connection con = DriverManager.getConnection(url, "chess_game", "1234");

			// database sql statement
			String winnerst = "select * from score where name=?";
			String loserst = "select * from score where name=?";

			// prepare statement
			PreparedStatement winnerps = con.prepareCall(winnerst);
			PreparedStatement loserps = con.prepareCall(loserst);

			// putting the values in sql statement
			winnerps.setString(1, winner);
			loserps.setString(1, loser);
			// winnerps.executeQuery();
			// loserps.executeQuery();
			// result set
			ResultSet winnerrs = winnerps.executeQuery();
			ResultSet loserrs = loserps.executeQuery();

			// calculations
			/*
			 * System.out.println(winnerrs.next()); System.out.println(loserrs.next());
			 */

			if (winnerrs.next()) {
				if (loserrs.next()) {

					System.out.println("inside if statement!!");
					// getting winner's wins and loser's loses
					int win_winner = winnerrs.getInt(2);
					// int lose_winner=winnerrs.getInt(3);
					// int win_loser=loserrs.getInt(2);
					int lose_loser = loserrs.getInt(3);
					int game_winner = winnerrs.getInt(5);
					int game_loser = loserrs.getInt(5);

					// logic changing the values
					win_winner += 1;
					lose_loser += 1;
					game_winner += 1;
					game_loser += 1;

					System.out.println(win_winner + " , " + lose_loser + " , " + game_winner + " , " + game_loser
							+ " , " + winner + " , " + loser);

					// !!!!!!updating the values in sql table!!!!!!

					// statements
					String winner_table_st = "update score set win=? , games_played=? where name=?";
					String loser_table_st = "update score set lose=? , games_played=? where name=?";

					// prepared statements
					PreparedStatement winner_table_ps = con.prepareCall(winner_table_st);
					PreparedStatement loser_table_ps = con.prepareCall(loser_table_st);

					// putting value in the statements
					winner_table_ps.setInt(1, win_winner);
					winner_table_ps.setString(3, winner);
					winner_table_ps.setInt(2, game_winner);
					loser_table_ps.setInt(1, lose_loser);
					loser_table_ps.setInt(2, game_loser);
					loser_table_ps.setString(3, loser);

					// executing the prepared statements
					winner_table_ps.executeUpdate();
					loser_table_ps.executeUpdate();
					con.commit();
					con.close();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	//for testing purposes only
	public static void main(String[] args) {
		
		new update_score("Rahul", "Rohan");
	}
}
