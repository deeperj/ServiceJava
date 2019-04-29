package database;
import java.sql.*;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Views.MultiLogin;

public class DBConnection {
    protected Connection conn;
    protected Statement st;

    public DBConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String rootname = "root";
        String rootpassword =""; // "Root";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, rootname, rootpassword);
            st = conn.createStatement();
            System.out.println("Connected");
        }catch(ClassNotFoundException c){
            c.printStackTrace();
            System.out.println(c.getMessage());
        }catch(SQLException c){
            c.printStackTrace();
            System.out.println(c.getMessage());
        }
    }
	
	public ResultSet getConnection(String username, String password,String usertype) throws Exception{
		try {
            //st.executeQuery("USE multiuserlogin");
            //st.executeQuery("USE test");
			st.executeQuery("select * from users where Username='"+username+"' and Password='"+password+
					"' and Usertype='"+usertype+"'");
			ResultSet rs = st.getResultSet();
			return rs;
		} catch(Exception e) {System.out.println(e);
		}
        return null;
    }
    protected void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}


