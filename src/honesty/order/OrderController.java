package honesty.order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import honesty.product.Product;

@SuppressWarnings("unused")
public class OrderController {

	public static void newOrder(Order order) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/?user=root&useSSL=false";
		String username = "Gerome";
		String password = "Divcun4s";

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
			
			stmt.executeUpdate("INSERT INTO mydb.OrderDetail (OrderID, ProductID, Quantity, LineTotal) VALUES(\"" 
			+ order.getOrderID() 
			+ "\",\""  + product.getProductID()
			+ "\"," 
			+ 1
			+ "," + (product.getSellPrice().setScale(2, RoundingMode.UP).doubleValue() * 1)  + 
			");");
			
		}
	}

	public static ArrayList<Order> getAllOrders() throws ClassNotFoundException, SQLException {

		ResultSet rst = getResultSet("SELECT * FROM tOrder");

		ArrayList<Order> orderList = new ArrayList<>();

		while (rst.next()) {
			Order order = new Order(rst.getString("OrderID"), rst.getString("AccommodationID"), rst.getString("DateTime"),
					rst.getDouble("Total"), rst.getString("Name"));

			orderList.add(order);
		}
		return orderList;
	}

	public static Order getOrder(String orderID) throws SQLException {
		return null;

		

	}

	private static ResultSet getResultSet(String sql) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
		Statement stm;
		stm = conn.createStatement();
		ResultSet rst;
		rst = stm.executeQuery(sql);
		return rst;
	}

}
