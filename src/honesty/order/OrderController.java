package honesty.order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import honesty.product.Product;

@SuppressWarnings("unused")
public class OrderController {
	
	private static String url = "jdbc:mysql://localhost:3306/?user=root&useSSL=false";
	private static String username = "Gerome";
	private static String password = "Divcun4s";

	public static void newOrder(Order order) throws SQLException {
		

		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();

		stmt.executeUpdate("INSERT INTO mydb.Order (OrderID, Accommodation, Date, Total, Name) VALUES(\"" 
		+ order.getOrderID()
		+ "\",\"" + order.getAccommodation() 
		+ "\",\"" + order.getDatetime() 
		+ "\"," + order.getTotal()
		+ ",\"" + order.getName() 
		+ "\");");
		
		for(Product product : order.getItemList()) {
			
			stmt.executeUpdate("INSERT INTO mydb.OrderDetail (OrderID, ProductID, ProductName, Quantity, LineTotal) VALUES(\"" 
			+ order.getOrderID() 
			+ "\",\"" + product.getProductID() 
			+ "\",\"" + product.getProductName()
			+ "\","   + product.getQuantity()
			+ "," 	  + (product.getSellPrice().setScale(2, RoundingMode.UP).doubleValue() * product.getQuantity()) 
			+ ");");
			
			stmt.executeUpdate("UPDATE mydb.Product "
					+ "SET StockLevel = StockLevel - " + product.getQuantity() 
					+ " WHERE ProductID = " + product.getProductID());
		}
		
		System.out.println("Finished the purchase"); 
	}

	public static ArrayList<Order> getAllOrders() throws ClassNotFoundException, SQLException {

		ResultSet rst = getResultSet("SELECT * FROM Order");

		ArrayList<Order> orderList = new ArrayList<>();

		while (rst.next()) {
			Order order = new Order(rst.getString("OrderID"), rst.getString("AccommodationID"), rst.getString("DateTime"),
					rst.getDouble("Total"), rst.getString("Name"));

			orderList.add(order);
		}
		return orderList;
	}

	public static ArrayList<Order> getOrdersBetween(String from, String to, String accommodation) throws SQLException {
		
		ResultSet rst = getResultSet("SELECT * FROM mydb.Order"
			+ " WHERE (Date between \'" + from  + "\' AND \'" + to + "\');");

		ArrayList<Order> orderList = new ArrayList<>();

		while (rst.next()) {
			Order order = new Order(rst.getString("OrderID"), rst.getString("AccommodationID"), rst.getString("DateTime"),
					rst.getDouble("Total"), rst.getString("Name"));

			orderList.add(order);
		}
		
		return orderList;

	}

	private static ResultSet getResultSet(String sql) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
		Statement stm;
		stm = conn.createStatement();
		ResultSet rst;
		rst = stm.executeQuery(sql);
		return rst;
	}

	public static String generateOrderID() {
		String uniqueID = UUID.randomUUID().toString();
		return uniqueID;
	}

}
