package honesty.controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import honesty.Main;
import honesty.order.Order;
import honesty.order.OrderController;
import honesty.order.OrderDetail;
import honesty.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

public class GetBillController extends ControlledView {
	
	 @FXML private TableView<OrderDetail> orderTable;
	 @FXML private DatePicker fromPicker;
	 @FXML private DatePicker toPicker;
	 @FXML private ComboBox<String> accommodationPicker;
	 @FXML private Button goButton;
	 
	 
	private ArrayList<Order> orderList = new ArrayList<>();
	private ArrayList<OrderDetail> orderDetailList = new ArrayList<>();

    @FXML
    void backClicked(ActionEvent event) {
    	System.out.println("Back Clicked: " + getClass());
    	
    	fromPicker.setValue(null);
    	toPicker.setValue(null);
    	accommodationPicker.getSelectionModel().clearSelection();
    	
    	this.getControllerParent().setScreen(Main.adminScreenID);
    }
    
    @FXML
    void goClicked(ActionEvent event) throws SQLException {
    	System.out.println("Go Clicked: " + getClass());
    	
    	
    	orderTable.getItems().clear();
    	orderDetailList.clear();
    	
    	//orderTable.getItems().removeAll(orderDetailList);
    	
	
    	orderList = OrderController.getOrdersBetween(fromPicker.getValue() + " 16:00:00", 
    			toPicker.getValue() + " 10:00:00", 
    			accommodationPicker.getValue().toString());
    	
    	for(Order order: orderList) {
    		orderDetailList.addAll(OrderController.getDetailsFromOrder(order));
    	}
    	
    	
    	orderTable.getItems().addAll(orderDetailList);
    		
    }
}
