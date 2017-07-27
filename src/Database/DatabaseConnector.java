package Database;

public class DatabaseConnector {

	private static String url = "jdbc:mysql://192.168.0.15:3306/?user=root&useSSL=false";
	private static String username = "Gerome";
	private static String password = "help";
	
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		DatabaseConnector.url = url;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		DatabaseConnector.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		DatabaseConnector.password = password;
	}
	
	
	
}
