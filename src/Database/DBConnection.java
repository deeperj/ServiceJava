package database;
import java.sql.*;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Views.MultiLogin;

public class DBConnection {
	
	public ResultSet getConnection(String username, String password,String usertype) throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/";
			String rootname = "root";
			String rootpassword =""; // "Root";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, rootname, rootpassword);
			System.out.println("Connected");

			
			
			Statement st = conn.createStatement();
            //st.executeQuery("USE multiuserlogin");
            st.executeQuery("USE test");
			st.executeQuery("select * from users where Username='"+username+"' and Password='"+password+
					"' and Usertype='"+usertype+"'");
			ResultSet rs = st.getResultSet();
			return rs;
			} catch(Exception e) {System.out.println(e);}
		
		return null;

		}
	}


