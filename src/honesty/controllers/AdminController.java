package honesty.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import honesty.Main;
import honesty.product.Product;
import honesty.product.ProductController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminController extends ControlledView {
	
	private static ArrayList<Product> shoppingList;

    @FXML
    void backClicked(ActionEvent event) {
    	System.out.println("Back Clicked: " + getClass());
    	this.getControllerParent().setScreen(Main.accommodationScreenID);
    }

    @FXML
    void editStockClicked(ActionEvent event) {
    	System.out.println("Edit Stock Clicked");
    	this.getControllerParent().setScreen(Main.editStockScreenID);
    }

    @FXML
    void getBillClicked(ActionEvent event) {
    	System.out.println("Get Bill Clicked");
    	this.getControllerParent().setScreen(Main.getBillScreenID);
    }

    @FXML
    void printListClicked(ActionEvent event) throws ClassNotFoundException, SQLException {
    	System.out.println("Print List Clicked");
    	
    	shoppingList = ProductController.getShoppingList();
    	
    	for(int i = 0; i < shoppingList.size(); i++) {
    		System.out.print(shoppingList.get(i).getProductName() + ": ");
    		System.out.println(shoppingList.get(i).getNormalLevel() - shoppingList.get(i).getStockLevel());
    	}
    	
    }
    
}
