package database_score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * Created by Rohan Karmakar (imrk97)
 * */

public class show_score {
	public show_score() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Connection con = DriverManager.getConnection(url, "chess_game", "1234");
			String showst = "select * from score";
			PreparedStatement showps = con.prepareCall(showst);
			// showst.setString(1, name);
			//int i = showps.executeUpdate();
			ResultSet showrs = showps.executeQuery();
			
			
			Score s;
			ArrayList <Score> scoreList=new ArrayList<>();
			
			
			while(showrs.next()) {
				s=new Score();
				s.setName(showrs.getString(1));
				s.setWin(showrs.getInt(2));
				s.setLose(showrs.getInt(3));
				s.setDraw(showrs.getInt(4));
				s.setGamesPlayed(showrs.getInt(5));
				scoreList.add(s);
				s=null;
				
			}
			
			con.commit();
			con.close();
			
			
			//for printing of the values
			
			for (Score s1:scoreList){
				System.out.println(s1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}

	}
	
	//for testing purposes only
	public static void main(String args[]) {
		new show_score();
	}
}