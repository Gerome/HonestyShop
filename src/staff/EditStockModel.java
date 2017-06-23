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
		//createNewProduct("500000", "LOl", new BigDecimal("2.00"), new BigDecimal("3.00"), 5, 10);
		//for(int i = 0; i < productList.size(); i++)
		//	System.out.println(productList.get(i).getProductName());
		
	}
	
	public void createNewProduct(String productID, String productName, BigDecimal buyPrice, 
		BigDecimal sellPrice, int stockLevel, int normalLevel) throws SQLException {  // 
		
		Product productToAdd = new Product(productID, productName, buyPrice, 
				 sellPrice, stockLevel, normalLevel);
		
		ProductController.newProduct(productToAdd);
	}

	ArrayList<Product> getProductList() {
		return productList;
	}

}
