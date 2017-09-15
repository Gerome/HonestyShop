package honesty.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import email.EmailSender;
import honesty.Main;
import honesty.checkout.CheckoutModel;
import honesty.product.Product;
import honesty.product.ProductController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AdminController extends ControlledView {
	
	private static ArrayList<Product> mercShoppingList;
	private static ArrayList<Product> gmShoppingList;
	private static String username;
	
	private SimpleDateFormat SDF = new SimpleDateFormat("EEE, dd MMM");
	
    @FXML
    void backClicked(ActionEvent event) {
    	System.out.println("Back Clicked: " + getClass());
    	AdminController.username = "";
    	this.getControllerParent().setScreen(Main.accommodationScreenID);
    }

    @FXML
    void editStockClicked(ActionEvent event) {
    	System.out.println("Edit Stock Clicked");
    	AdminController.username = "";
    	this.getControllerParent().setScreen(Main.editStockScreenID);
    }

    @FXML
    void getStaffBillClicked(ActionEvent event) {
    	System.out.println("Get Bill Clicked");
    	AdminController.username = "";
    	this.getControllerParent().setScreen(Main.getStaffBillScreenID);
    }
    
    @FXML
    void buyItemStaffClicked(ActionEvent event) {
    	System.out.println("Buy item Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Staff", AdminController.username));
    	AdminController.username = "";
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    

    @FXML
    void printListClicked(ActionEvent event) throws ClassNotFoundException, SQLException {
    	System.out.println("Print List Clicked");
    	
    	
    	mercShoppingList = ProductController.getMercShoppingList();
    	gmShoppingList = ProductController.getGmShoppingList();
    	
    	
    		
    	try{
    		
    		String filename = "Shopping list " + SDF.format(new Date()) + ".csv";

    	    PrintWriter writer = new PrintWriter(filename, "UTF-8");
    	    
    	    writer.write(String.format("%15s %10s %10s %15s %12s \r\n", "Product,", "Buy Price,", "Sell Price,", "To Purchase,", "Supplier"));
    	    
    	    	    
    	    for(int i = 0; i < mercShoppingList.size(); i++) {
        		
    	    	
    	    	
    	    	writer.write(String.format("%15s %10s %10s %15s %12s \r\n", mercShoppingList.get(i).getProductName() + ",", 
    	    			mercShoppingList.get(i).getBuyPrice() + ",",
    	    			mercShoppingList.get(i).getSellPrice() + ",",
    	    			mercShoppingList.get(i).getNormalLevel() - mercShoppingList.get(i).getStockLevel() + ",",
    	    			"Mercadona"
    	    			));
    	    	
        	}
        	
        	for(int i = 0; i < gmShoppingList.size(); i++) {
        		       		
        		writer.write(String.format("%15s %10s %10s %15s %12s \r\n", gmShoppingList.get(i).getProductName() + ",", 
        				gmShoppingList.get(i).getBuyPrice() + ",",
        				gmShoppingList.get(i).getSellPrice() + ",",
        				gmShoppingList.get(i).getNormalLevel() - gmShoppingList.get(i).getStockLevel() + ",",
    	    			"GM"
    	    			));
        		
        	}
        	
        	writer.close();
        	
        	EmailSender.sendEmail(filename);
        	
        	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Shopping list");
        	alert.setHeaderText("Shopping list");
        	alert.setContentText("The list has been sent to the info hut.\nMake sure you ask them to print it.");
        
        	alert.initOwner(Main.getStage());
        	
        	alert.show();
        	
    	} catch (IOException e) {
    	   System.out.println(e.getStackTrace());
    	}
    	
    }
    
    public static void setUsername(String name) {
    	AdminController.username = name;
    }
}
