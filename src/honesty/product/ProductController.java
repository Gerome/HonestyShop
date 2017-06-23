package honesty.product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@SuppressWarnings("unused")
public class ProductController {


	public static void newProduct(Product product) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/?user=root&useSSL=false";
		String username = "Gerome";
		String password = "Divcun4s";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("INSERT INTO mydb.Product (ProductID, ProductName, BuyPrice, SellPrice, StockLevel, NormalLevel) VALUES(" 
		+ product.getProductID() 
		+ ",\"" + product.getProductName() 
		+ "\"," + product.getBuyPrice()
		+ "," + product.getSellPrice()
		+ "," + product.getStockLevel()
		+ "," + product.getNormalLevel()
		+ ");");
	}
	
	
	public static ArrayList<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		
		Product product = null;
		
		String url = "jdbc:mysql://localhost:3306/?user=root&useSSL=false";
		String username = "Gerome";
		String password = "Divcun4s";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.Product");
	    
	    ArrayList<Product> productList = new ArrayList<>();
	    
	    while (rs.next()) {
	    	product = new Product(rs.getString("ProductID"), 
	    			rs.getString("ProductName"),
	    			rs.getBigDecimal("BuyPrice"),
	    			rs.getBigDecimal("SellPrice"),
	    			rs.getInt("StockLevel"),
	    			rs.getInt("NormalLevel"));
	        productList.add(product);
	    }
	    
	    return productList;
	}

	
	
	public static Product getProduct(String productID) throws SQLException {
		
		Product product = null;
		
		String url = "jdbc:mysql://localhost:3306/?user=root&useSSL=false";
		String username = "Gerome";
		String password = "Divcun4s";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM mydb.Product WHERE ProductID = " + productID);
		
		if(rs.next()) {
			
			product = new Product(
				rs.getString("ProductID"), 
    			rs.getString("ProductName"),
    			rs.getBigDecimal("BuyPrice"),
    			rs.getBigDecimal("SellPrice"),
    			rs.getInt("StockLevel"),
    			rs.getInt("NormalLevel"));
		
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return product;
			/*
		if(productID.equals("25294651")) return productV;
		else if(productID.equals("8410055150018")) return productW;
		else return productP;
	
		
		ResultSet rst = getResultSet("SELECT " + productID + " FROM mydb.Product");
		
		Product product = new Product(rst.getString("ProductID"), 
    			rst.getString("ProductName"),
    			rst.getBigDecimal("BuyPrice"),
    			rst.getBigDecimal("SellPrice"),
    			rst.getInt("StockLevel"),
    			rst.getInt("NormalLevel"));
		
		return product;
		*/
		
	}
	
	private static ResultSet getResultSet(String sql) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/?user=root";
		String username = "Gerome";
		String password = "Divcun4s";

		System.out.println("Connecting database...");

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		    Statement stm;
		    stm = conn.createStatement();
		    ResultSet rst;
		    rst = stm.executeQuery(sql);
		    conn.close();
		    stm.close();
			return rst;
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
	    
	   
	}
	
	
	
}
