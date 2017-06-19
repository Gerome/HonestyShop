package product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class ProductController {

	
	static Product productV = new Product("25294651", 
			"Vitamins",
			new BigDecimal(0.50),
			new BigDecimal(2.50),
			10,
			20);
	
	static Product productW = new Product("8410055150018", 
			"Water",
			new BigDecimal(2.00),
			new BigDecimal(2.50),
			10,
			20);
	
	static Product productP = new Product("8480000341907",
			"Pepper",
			new BigDecimal(1.00),
			new BigDecimal(1.99),
			10,
			20);
	
	/*
	public static ArrayList<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		
	    ResultSet rst = getResultSet("SELECT * FROM tProduct");
	    
	    ArrayList<Product> productList = new ArrayList<>();
	    
	    while (rst.next()) {
	    	Product product = new Product(rst.getString("ProductID"), 
	    			rst.getString("ProductName"),
	    			rst.getBigDecimal("BuyPrice"),
	    			rst.getBigDecimal("SellPrice"),
	    			rst.getInt("StockLevel"),
	    			rst.getInt("NormalLevel"));
	        productList.add(product);
	    }
	    return productList;
	}

	*/
	
	public static Product getProduct(String productID) throws SQLException {
			
		if(productID.equals("25294651")) return productV;
		else if(productID.equals("8410055150018")) return productW;
		else return productP;
	}
		/*
		ResultSet rst = getResultSet("SELECT " + productID + " FROM tProduct");
		
		Product product = new Product(rst.getString("ProductID"), 
    			rst.getString("ProductName"),
    			rst.getBigDecimal("BuyPrice"),
    			rst.getBigDecimal("SellPrice"),
    			rst.getInt("StockLevel"),
    			rst.getInt("NormalLevel"));
		
		return product;
		
		
	}
	
	public static ResultSet getResultSet(String sql) throws SQLException {
		Connection conn = DBConnection.getDBConnection().getConnection();  // TO FIX
	    Statement stm;
	    stm = conn.createStatement();
	    ResultSet rst;
	    rst = stm.executeQuery(sql);
		return rst;
	}
	
	*/
	
}
