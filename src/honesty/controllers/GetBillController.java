package honesty.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import honesty.Main;
import honesty.order.Order;
import honesty.order.OrderController;
import honesty.order.OrderDetail;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	private SimpleDateFormat SDF = new SimpleDateFormat("EEE, dd MMM");

	@FXML
	private Button printBillButton;

	@FXML
	private Text totalTextBox;
	

	@FXML
	void openToPicker(ActionEvent event) {
		if (toPicker.getValue() == (null))
				toPicker.show();
	}
	
	@FXML
	void openAccommodationDropdown() {
		if (accommodationPicker.getSelectionModel().isEmpty())
			accommodationPicker.show();
	}
	
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

			PrintWriter writer = new PrintWriter(accommodationPicker.getValue() + " Receipt " + SDF.format(new Date()) + ".txt", "UTF-8");

			writer.write(String.format("%s \r\n\n", accommodationPicker.getValue()));

			for (int i = 0; i < orderTable.getItems().size(); i++) {

				writer.write(String.format("%15s %10s \r\n", orderTable.getItems().get(i).getProductName(),
						orderTable.getItems().get(i).getLineTotal() + "€"));

			}

			writer.write(String.format("%s %s \r\n", "Total: ", totalTextBox.getText() + "€"));

			writer.close();

		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}

	}

	@FXML
	void goClicked(ActionEvent event) throws SQLException {
		System.out.println("Go Clicked: " + getClass());

		if (fromPicker.getValue() == (null) || toPicker.getValue() == (null))
			displayErrorPopup(
					"Invalid date", 
					"One of the dates is incorrect", 
					"Please select a valid date");
		
		

		if (accommodationPicker.getSelectionModel().isEmpty())
			displayErrorPopup(
					"Accommodation error", 
					"You have not selected your accommodation",
					"Please select one from the drop to the right of the date picker");

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
		if(fromPicker.getValue().isAfter(toPicker.getValue())) {
			displayErrorPopup(
					"Invalid date", 
					"\"From\" cannot be after your \"To\" date", 
					"Please adjust the dates");
		}
		else if(orderList.isEmpty()) {
			displayInfoPopup("Nothing to show", "Nothing has been bought between these dates", "");
		}
		else {
			printBillButton.setDisable(false);
		}

		totalTextBox.setText(billTotal.toString());

		orderTable.getItems().addAll(orderDetailList);

		

	}

	public void displayErrorPopup(String title, String header, String context) {

		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(context);

		alert.initOwner(Main.getStage());

		alert.show();

	}
	
	public void displayInfoPopup(String title, String header, String context) {

		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle(title);
		alert.setHeaderText(header);
		
		alert.initOwner(Main.getStage());
	
		alert.show();

	}
}
