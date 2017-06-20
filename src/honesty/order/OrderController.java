package honesty.order;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import honesty.product.Product;

@SuppressWarnings("unused")
public class OrderController {

	public static ArrayList<Order> getAllOrders() throws ClassNotFoundException, SQLException {

		ResultSet rst = getResultSet("SELECT * FROM tOrder");

		ArrayList<Order> orderList = new ArrayList<>();

		while (rst.next()) {
			Order order = new Order(rst.getString("OrderID"), rst.getString("AccommodationID"), rst.getDate("DateTime"),
					rst.getDouble("Total"), rst.getString("Name"));

			orderList.add(order);
		}
		return orderList;
	}

	public static Order getOrder(String orderID) throws SQLException {

		Order order1 = new Order("Villa20170601", "Villa", new Date(), 23.59, "Logan paul");

		Order order2 = new Order("Yurt20170601", "Yurt", new Date(), 39.99, "Jake Paul");

		if (order1.equals("Villa20170601"))
			return order1;
		else
			return order2;

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
