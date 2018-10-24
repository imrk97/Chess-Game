//package Frontend;
/*
 * Created by Rohan Karmakar (imrk97)
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//import java.util.Scanner;
public class insert_name {
	public insert_name(String name) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Connection con = DriverManager.getConnection(url, "chess_game", "1234");
			String name_insert = "insert into score values(?,0,0,0,0)";
			PreparedStatement ps_name_insert = con.prepareCall(name_insert);
			ps_name_insert.setString(1, name);
			int i = ps_name_insert.executeUpdate();
			System.out.println(i);
			con.commit();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}

	}

	public static void main(String args[]) {
		new insert_name("Rohan");
		new insert_name("Rahul");
	}
}
