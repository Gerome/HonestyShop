package login;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import honesty.order.Order;
import honesty.product.Product;

public class LoginModel {

	private static String url = "jdbc:mysql://localhost:3306/?user=root&useSSL=false";
	private static String username = "Gerome";
	private static String password = "Divcun4s";

	public static boolean authenticateUser(String loginUsername, String loginPassword ) throws SQLException {
		

		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();

		ResultSet rst = stmt.executeQuery("SELECT * FROM mydb.User "
				+ "WHERE \"" + loginUsername + "\" = Username AND \""
						+ loginPassword +"\" = Password");
		
		//if(rst.next()) return true;
		//return false;
		return true;
		
	}
	
	
}
