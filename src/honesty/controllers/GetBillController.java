package honesty.controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import honesty.Main;
import honesty.order.Order;
import honesty.order.OrderController;
import honesty.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

public class GetBillController extends ControlledView {
	
	 @FXML private TableView<Order> orderTable;
	 @FXML private DatePicker fromPicker;
	 @FXML private DatePicker toPicker;
	 @FXML private ComboBox accommodationPicker;
	 @FXML private Button goButton;
	 
	 
	private ArrayList<Order> orderList = new ArrayList<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 

    @FXML
    void backClicked(ActionEvent event) {
    	System.out.println("Back Clicked: " + getClass());
    	this.getControllerParent().setScreen(Main.adminScreenID);
    }
    
    @FXML
    void goClicked(ActionEvent event) throws SQLException {
    	System.out.println("Go Clicked: " + getClass());
    	
    	//System.out.println(fromPicker.getValue() + " 00:00:00"+ toPicker.getValue() + " 00:00:00");
    	
    	
    	orderList = OrderController.getOrdersBetween(fromPicker.getValue() + " 00:00:00", toPicker.getValue() + " 00:00:00", "temp");
    	
    	orderTable.getItems().addAll(
    			//new Order("0001", "temp","2017-06-06", 19.21, "Gerome")
    			orderList
    			);
    	
    	for(int i = 0; i < orderList.size(); i++) {
    		
    		
        			//new Order("0001", "temp","2017-06-06", 19.21, "Gerome")
        			
        			
    		System.out.println(orderList.get(i).getDatetime());
    	}
    	/*
    	for(int i = 0; i < orderList.size(); i++) {
    		System.out.println(orderList.get(i).getDatetime());
    		
    		for(int j = 0; j < orderList.get(i).getItemList().size(); j++) {
    			orderTable.getItems().add(orderList.get(i).getItemList().get(j));
    		}
    		
    		
    	}
    	*/
    	 
         
        
    	
    	
    }
    

}
