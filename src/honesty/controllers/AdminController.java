package honesty.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import honesty.Main;
import honesty.product.Product;
import honesty.product.ProductController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminController extends ControlledView {
	
	private static ArrayList<Product> mercShoppingList;
	private static ArrayList<Product> gmShoppingList;
	
	private SimpleDateFormat SDF = new SimpleDateFormat("EEE, dd MMM");
	
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
    	
    	
    	mercShoppingList = ProductController.getMercShoppingList();
    	gmShoppingList = ProductController.getGmShoppingList();
    	
    	
    	
    	
    	try{
    		
    		

    		
    	    PrintWriter writer = new PrintWriter("Shopping list " + SDF.format(new Date()) + ".txt", "UTF-8");
    	    
    	    writer.write(String.format("%15s %10s %10s %15s %12s \r\n\n", "Product", "Buy Price", "Sell Price", "To Purchase", "Supplier"));
    	    
    	    	    
    	    for(int i = 0; i < mercShoppingList.size(); i++) {
        		
    	    	
    	    	
    	    	writer.write(String.format("%15s %10s %10s %15s %12s \r\n", mercShoppingList.get(i).getProductName(), 
    	    			mercShoppingList.get(i).getBuyPrice() + "€",
    	    			mercShoppingList.get(i).getSellPrice() + "€",
    	    			mercShoppingList.get(i).getNormalLevel() - mercShoppingList.get(i).getStockLevel(),
    	    			"Mercadona"
    	    			));
    	    	
        	}
        	
        	for(int i = 0; i < gmShoppingList.size(); i++) {
        		       		
        		writer.write(String.format("%15s %10s %10s %15s %12s \r\n", gmShoppingList.get(i).getProductName(), 
        				gmShoppingList.get(i).getBuyPrice() + "€",
        				gmShoppingList.get(i).getSellPrice() + "€",
        				gmShoppingList.get(i).getNormalLevel() - gmShoppingList.get(i).getStockLevel(),
    	    			"GM"
    	    			));
        		
        		//System.out.print(gmShoppingList.get(i).getProductName() + ": ");
        		//System.out.println(gmShoppingList.get(i).getNormalLevel() - gmShoppingList.get(i).getStockLevel());
        	}
        	
        	writer.close();
        	
    	} catch (IOException e) {
    	   System.out.println(e.getStackTrace());
    	}
    	
    }
    
}
