package database_score;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Created by Rohan Karmakar (imrk97)
 * */

public class show_score 
{
	public  ArrayList<Score> scoreList;
	@SuppressWarnings("static-access")
	public show_score() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Connection con = DriverManager.getConnection(url, "chess_game", "1234");
			String showst = "select * from score";
			PreparedStatement showps = con.prepareCall(showst);
			// showst.setString(1, name);
			// int i = showps.executeUpdate();
			ResultSet showrs = showps.executeQuery();

			Score s;
			scoreList = new ArrayList<>();

			while (showrs.next()) {
				s = new Score();
				s.setName(showrs.getString(1));
				s.setWin(showrs.getInt(2));
				s.setLose(showrs.getInt(3));
				s.setDraw(showrs.getInt(4));
				s.setGamesPlayed(showrs.getInt(5));
				scoreList.add(s);
				s = null;

			}

			con.commit();
			con.close();

			// for printing of the values
			System.out.println("\tName\t\tWin\t\tLose\t\tDraw\t\tGames Played\n");
			for (Score s1 : scoreList) {
				
				System.out.println(s1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		JFrame f = new JFrame("Game Stats");           
	    JTextArea jt=new JTextArea();
	    jt.append("\n------------------------------------------------------");
	    jt.append("------------------------------------------------------");
	    jt.append("---------------------------------------------------------");
	    jt.append("------------------------------------------\n");
	    jt.append("  Name\t\tWin\t\tLose\t\tDraw\t\tGames Played\n");
	    jt.append("------------------------------------------------------");
	    jt.append("------------------------------------------------------");
	    jt.append("------------------------------------------------------");
	    jt.append("---------------------------------------------\n");
	    //jt.append(str);
	    jt.setOpaque(false);
	    for (Score s1 : scoreList) {
			jt.append(s1.toString());
			System.out.println(s1);
		}
	    JScrollPane sp=new JScrollPane(jt);
		f.setBackground(new Color(250,249,231));
	    jt.setEditable(false);
	    f.add(sp); 
	    f.add(jt);
	    f.setSize(800,200);
	    f.setLocationRelativeTo(null);
	    f.setResizable(false);
	    f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
	    f.setVisible(true); 
		
	}
	
	
	// for testing purposes only
	public static void main(String args[]) {
		new show_score();
	}
}