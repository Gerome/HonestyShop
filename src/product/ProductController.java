package product;

import java.sql.*;
import java.util.ArrayList;

public class ProductController {

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
		
		Product productV = new Product("25294651", 
    			"Vitamins",
    			0.50,
    			1.50,
    			10,
    			20);
		
		Product productW = new Product("8410055150018", 
    			"Water",
    			2.00,
    			2.34,
    			10,
    			20);
		
		Product productP = new Product("8480000341907",
    			"Pepper",
    			2.00,
    			2.30,
    			10,
    			20);
		
		if(productID.equals("25294651")) return productV;
		else if(productID.equals("8410055150018")) return productW;
		else return productP;
	}
		/*
		ResultSet rst = getResultSet("SELECT productID FROM tProduct");
		
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
