package honesty.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class GetBillController extends ControlledView {

	@FXML
	private TableView<OrderDetail> orderTable;
	@FXML
	private DatePicker fromPicker;
	@FXML
	private DatePicker toPicker;
	@FXML
	private ComboBox<String> accommodationPicker;
	@FXML
	private Button goButton;
	
	@FXML
	private Button printBillButton;
	
	@FXML
	private Text totalTextBox;

	@FXML
	private TextField fromHour;
	@FXML
	private TextField fromMin;
	@FXML
	private TextField toHour;
	@FXML
	private TextField toMin;

	private BigDecimal billTotal = new BigDecimal("0.00");
	private ArrayList<Order> orderList = new ArrayList<>();
	private ArrayList<OrderDetail> orderDetailList = new ArrayList<>();

	@FXML
	void backClicked(ActionEvent event) {
		System.out.println("Back Clicked: " + getClass());

		resetScreen();

		this.getControllerParent().setScreen(Main.accommodationScreenID);
	}

	void resetScreen() {
		fromPicker.setValue(null);
		toPicker.setValue(null);
		accommodationPicker.getSelectionModel().clearSelection();
		orderTable.getItems().clear();
		totalTextBox.setText("0.00");
		printBillButton.setDisable(true);

		fromHour.setText("16");
		fromMin.setText("00");
		toHour.setText("10");
		toMin.setText("00");
		
		
	}

	@FXML
	void printBillClicked(ActionEvent event) {

		System.out.println("Print Clicked: " + getClass());
		
		try {

			PrintWriter writer = new PrintWriter("receipt.txt", "UTF-8");

			writer.write(String.format("%s \r\n\n", accommodationPicker.getValue()));

			for (int i = 0; i < orderTable.getItems().size(); i++) {

				writer.write(String.format("%s %10s \r\n", orderTable.getItems().get(i).getProductName(),
						orderTable.getItems().get(i).getLineTotal() + "€"));
				
			}

			
			writer.write(String.format("%s %s \r\n", "Total: ",
					totalTextBox.getText() + "€"));

			writer.close();

		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}

	}

	@FXML
	void goClicked(ActionEvent event) throws SQLException {
		System.out.println("Go Clicked: " + getClass());

		orderTable.getItems().clear();
		orderDetailList.clear();
		billTotal = new BigDecimal("0.00");

		orderList = OrderController.getOrdersBetween(
				fromPicker.getValue() + " " + fromHour.getText() + ":" + fromMin.getText() + ":00",
				toPicker.getValue() + " " + toHour.getText() + ":" + toMin.getText() + ":00",
				accommodationPicker.getValue().toString());

		System.out.println(accommodationPicker.getValue().toString());

		for (Order order : orderList) {
			orderDetailList.addAll(OrderController.getDetailsFromOrder(order));
			billTotal = billTotal.add(order.getTotal());
		}

		totalTextBox.setText(billTotal.toString());

		orderTable.getItems().addAll(orderDetailList);
		
		printBillButton.setDisable(false);

	}
}
