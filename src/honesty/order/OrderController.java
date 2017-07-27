package honesty.order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import Database.DatabaseConnector;
import honesty.product.Product;

@SuppressWarnings("unused")
public class OrderController {


	private static String url = DatabaseConnector.getUrl();
	private static String username = DatabaseConnector.getUsername();
	private static String password = DatabaseConnector.getPassword();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void newOrder(Order order) throws SQLException {

		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();

		stmt.executeUpdate("INSERT INTO mydb.Order (OrderID, Accommodation, Date, Total, Name) VALUES(\""
				+ order.getOrderID() + "\",\"" + order.getAccommodation() + "\",\"" + order.getDatetime() + "\","
				+ order.getTotal() + ",\"" + order.getName() + "\");");

		for (Product product : order.getItemList()) {

			stmt.executeUpdate(
					"INSERT INTO mydb.OrderDetail (OrderID, ProductID, ProductName, Quantity, LineTotal) VALUES(\""
							+ order.getOrderID() + "\",\"" + product.getProductID() + "\",\"" + product.getProductName()
							+ "\"," + product.getQuantity() + ","
							+ (product.getSellPrice().doubleValue()
									* product.getQuantity())
							+ ");");

			stmt.executeUpdate("UPDATE mydb.Product " + "SET StockLevel = StockLevel - " + product.getQuantity()
					+ " WHERE ProductID = " + product.getProductID());
		}

		
		stmt.close();
		conn.close();
	}

	public static ArrayList<Order> getAllOrders() throws ClassNotFoundException, SQLException {

		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM Order");

		ArrayList<Order> orderList = new ArrayList<>();

		while (rs.next()) {
			Order order = new Order(rs.getString("OrderID"), rs.getString("AccommodationID"), rs.getString("DateTime"),
					rs.getBigDecimal("Total"), rs.getString("Name"));

			orderList.add(order);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return orderList;
	}

	public static ArrayList<Order> getOrdersBetween(String from, String to, String accommodation) throws SQLException {

		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM mydb.Order" + " WHERE (Date between \'" 
						+ from + "\' AND \'" 
						+ to + "\') AND \""
						+ accommodation +"\" = Accommodation;");

		ArrayList<Order> orderList = new ArrayList<>();

		while (rs.next()) {
			Order order = new Order(rs.getString("OrderID"), rs.getString("Accommodation"), rs.getString("Date"),
					rs.getBigDecimal("Total"), rs.getString("Name"));

			orderList.add(order);
		}
		
		rs.close();
		stmt.close();
		conn.close();

		return orderList;

	}

	public static ArrayList<OrderDetail> getDetailsFromOrder(Order order)
			throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM mydb.OrderDetail" + " WHERE \'" + order.getOrderID() + "\' = OrderID");

		ArrayList<OrderDetail> orderDetailList = new ArrayList<>();

		while (rs.next()) {
			OrderDetail orderDetail = new OrderDetail(
					rs.getString("ProductName"), 
					rs.getInt("Quantity"), 
					rs.getDouble("LineTotal"), 
					order.getDatetime(), 
					order.getName()
					);

			orderDetailList.add(orderDetail);
		}
		
		rs.close();
		stmt.close();
		conn.close();

		return orderDetailList;

	}

	

	public static String generateOrderID() {
		String uniqueID = UUID.randomUUID().toString();
		return uniqueID;
	}

}
