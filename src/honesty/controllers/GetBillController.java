package honesty.controllers;

import java.math.BigDecimal;
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
import javafx.scene.text.Text;

public class GetBillController extends ControlledView {
	
	 @FXML private TableView<OrderDetail> orderTable;
	 @FXML private DatePicker fromPicker;
	 @FXML private DatePicker toPicker;
	 @FXML private ComboBox<String> accommodationPicker;
	 @FXML private Button goButton;
	 @FXML private Text totalTextBox; 
	
	private BigDecimal billTotal = new BigDecimal("0.00");
	private ArrayList<Order> orderList = new ArrayList<>();
	private ArrayList<OrderDetail> orderDetailList = new ArrayList<>();

    @FXML
    void backClicked(ActionEvent event) {
    	System.out.println("Back Clicked: " + getClass());
    	
    	fromPicker.setValue(null);
    	toPicker.setValue(null);
    	accommodationPicker.getSelectionModel().clearSelection();
    	orderTable.getItems().clear();
    	totalTextBox.setText("0.00");
    	
    	this.getControllerParent().setScreen(Main.adminScreenID);
    }
    
    @FXML
    void goClicked(ActionEvent event) throws SQLException {
    	System.out.println("Go Clicked: " + getClass());
    	
    	
    	orderTable.getItems().clear();
    	orderDetailList.clear();
    	billTotal = new BigDecimal("0.00");
    	
	
    	orderList = OrderController.getOrdersBetween(fromPicker.getValue() + " 16:00:00", 
    			toPicker.getValue() + " 10:00:00", 
    			accommodationPicker.getValue().toString());
    	
    	System.out.println(accommodationPicker.getValue().toString());
    	
    	for(Order order: orderList) {
    		orderDetailList.addAll(OrderController.getDetailsFromOrder(order));
    		billTotal = billTotal.add(order.getTotal());
    	}
    	
    	totalTextBox.setText(billTotal.toString());
    	
    	orderTable.getItems().addAll(orderDetailList);
    		
    }
}
