package honesty.product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@SuppressWarnings("unused")
public class ProductController {

	private static String url = "jdbc:mysql://localhost:3306/?user=root";
	private static String username = "Gerome";
	private static String password = "Divcun4s";

	public static void newProduct(Product product) throws SQLException {

		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();

		stmt.executeUpdate(
				"INSERT INTO mydb.Product (ProductID, ProductName, BuyPrice, SellPrice, StockLevel, NormalLevel) VALUES("
						+ product.getProductID() + ",\"" + product.getProductName() + "\"," + product.getBuyPrice()
						+ "," + product.getSellPrice() + "," + product.getStockLevel() + "," + product.getNormalLevel()
						+ ");");
	}

	public static ArrayList<Product> getAllProducts() throws ClassNotFoundException, SQLException {

		Product product = null;

		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.Product");

		ArrayList<Product> productList = new ArrayList<>();

		while (rs.next()) {
			product = new Product(rs.getString("ProductID"), rs.getString("ProductName"), rs.getBigDecimal("BuyPrice"),
					rs.getBigDecimal("SellPrice"), rs.getInt("StockLevel"), rs.getInt("NormalLevel"));
			productList.add(product);
		}

		return productList;
	}

	public static Product getProduct(String productID) throws SQLException {

		Product product = null;

		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.Product WHERE ProductID = " + productID);

		if (rs.next()) {

			product = new Product(rs.getString("ProductID"), rs.getString("ProductName"), rs.getBigDecimal("BuyPrice"),
					rs.getBigDecimal("SellPrice"), rs.getInt("StockLevel"), rs.getInt("NormalLevel"));

		}

		rs.close();
		stmt.close();
		conn.close();

		return product;

	}

	public static ArrayList<Product> getShoppingList() throws ClassNotFoundException, SQLException {

		Product product = null;

		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.Product " + "WHERE StockLevel < NormalLevel");

		ArrayList<Product> shoppingList = new ArrayList<>();

		while (rs.next()) {

			product = new Product(rs.getString("ProductID"), rs.getString("ProductName"), rs.getBigDecimal("BuyPrice"),
					rs.getBigDecimal("SellPrice"), rs.getInt("StockLevel"), rs.getInt("NormalLevel"));

			shoppingList.add(product);

		}

		return shoppingList;
	}

}
