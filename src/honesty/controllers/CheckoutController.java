package honesty.controllers;

import java.sql.SQLException;

import honesty.Main;
import honesty.checkout.CheckoutModel;
import honesty.product.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class CheckoutController extends ControlledView {

	@FXML
	private TextField inputField;
	@FXML
	private TableView<Product> productTable;
	@FXML
	private Text totalTextBox;

	private CheckoutModel model;

	@FXML
	void cancelClicked(ActionEvent event) {
		System.out.println("Cancel Clicked: " + getClass());

		productTable.getItems().clear();
		inputField.setText("");
		totalTextBox.setText("0.00");

		this.getControllerParent().setScreen(Main.accommodationScreenID);
	}

	@FXML
	void confirmClicked(ActionEvent event) throws SQLException {
		System.out.println("Confirm Clicked: " + getClass());

		
		
		
		model.finishCheckout();
		productTable.getItems().clear();
		totalTextBox.setText("0.00");

		this.getControllerParent().setScreen(Main.accommodationScreenID);

	}

	@FXML
	void inputFieldOnAction(ActionEvent event) {
		System.out.println("Enter Pressed Clicked");

		if (!inputField.getText().equals("")) {
			if (model.checkout(inputField.getText())) {

				try {
					addProductToTable(ProductController.getProduct(inputField.getText()));
					totalTextBox.setText(model.getBasketTotal().toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("Please input a product number");
		}

		inputField.setText("");
	}

	@FXML
	void mouseMoved(MouseEvent event) {
		inputField.requestFocus();

	}

	@FXML
	void clearItem(ActionEvent event) {
		model.removeProduct();
		productTable.getItems().remove(productTable.getItems().size() - 1);
		totalTextBox.setText(model.getBasketTotal().toString());

	}

	public void setCheckoutModel(CheckoutModel model) {
		this.model = model;
	}

	public void addProductToTable(Product product) {
		productTable.getItems().add(product);
	}

}
