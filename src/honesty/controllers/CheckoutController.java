package honesty.controllers;

import java.sql.SQLException;

import honesty.Main;
import honesty.checkout.CheckoutModel;
import honesty.order.OrderDetail;
import honesty.product.Product;
import honesty.product.ProductController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CheckoutController extends ControlledView {
	
	@FXML private TextField inputField;
	@FXML private TableView<Product> productTable;
	
	private CheckoutModel model; 
	

    @FXML
    void cancelClicked(ActionEvent event) {
    	System.out.println("Cancel Clicked: " + getClass());
    	
    	productTable.getItems().clear();
    	
    	this.getControllerParent().setScreen(Main.accommodationScreenID);
    }
    
    @FXML
    void confirmClicked(ActionEvent event) throws SQLException {
    	System.out.println("Confirm Clicked: " + getClass());
    	
    	model.finishCheckout();
    	productTable.getItems().clear();
    	
    	this.getControllerParent().setScreen(Main.accommodationScreenID);
    	
    }
    
    @FXML
    void inputFieldOnAction(ActionEvent event) {
    	System.out.println("Enter Pressed Clicked");
    	
    	if(!inputField.getText().equals("")){
    		model.checkout(inputField.getText());
    		
    		try {
				addProductToTable(ProductController.getProduct(inputField.getText()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	} else {
    		System.out.println("Please input a product number");
    	}
    	
    	inputField.setText("");
    }
    
    
  
    public void setCheckoutModel(CheckoutModel model){
    	this.model = model;
    }
    
    public void addProductToTable(Product product) {
    	productTable.getItems().add(product);
    }
    
}
