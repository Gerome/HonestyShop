package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginModel {

	private static String url = "jdbc:mysql://172.16.1.16:3306/?user=root&useSSL=false";
	private static String username = "Gerome";
	private static String password = "Divcun4s";

	public static boolean authenticateUser(String loginUsername, String loginPassword ) throws SQLException {
		

		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.User "
				+ "WHERE \"" + loginUsername + "\" = Username AND \""
						+ loginPassword +"\" = Password");
		
		
		
		if(rs.next()){
			rs.close();
			stmt.close();
			conn.close();
			return true;
		} else {
			rs.close();
			stmt.close();
			conn.close();
			return false;
		}
		
		
		
	}
	
	
}
