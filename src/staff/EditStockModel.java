package staff;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import honesty.product.Product;
import honesty.product.ProductController;

public class EditStockModel {
	
	private ArrayList<Product> productList;
	
	public EditStockModel() throws ClassNotFoundException, SQLException {
		
		productList = ProductController.getAllProducts();
		
		
	}
	
	public void createNewProduct(String productID, String productName, BigDecimal buyPrice, 
		BigDecimal sellPrice, int stockLevel, int normalLevel) throws SQLException {  
		
		Product productToAdd = new Product(productID, productName, buyPrice, 
				 sellPrice, stockLevel, normalLevel);
		
		ProductController.newProduct(productToAdd);
	}

	ArrayList<Product> getProductList() {
		return productList;
	}

}
