package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DatabaseConnector;

public class LoginModel {

	private static String url = DatabaseConnector.getUrl();
	private static String username = DatabaseConnector.getUsername();
	private static String password = DatabaseConnector.getPassword();
	
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
