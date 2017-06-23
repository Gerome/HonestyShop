package staff;

import java.sql.SQLException;
import java.util.ArrayList;

import honesty.product.Product;
import honesty.product.ProductController;

public class EditStockModel {
	
	private ArrayList<Product> productList;
	
	public EditStockModel() throws ClassNotFoundException, SQLException {
		
		productList = ProductController.getAllProducts();
		for(int i = 0; i < productList.size(); i++)
			System.out.println(productList.get(i).getProductName());
		
	}

	ArrayList<Product> getProductList() {
		return productList;
	}

}
