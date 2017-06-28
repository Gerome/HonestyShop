package honesty.controllers;

import java.sql.SQLException;

import honesty.Main;
import honesty.checkout.CheckoutModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CheckoutController extends ControlledView {
	
	@FXML
    private TextField inputField;
	private CheckoutModel model; 

    @FXML
    void cancelClicked(ActionEvent event) {
    	System.out.println("Cancel Clicked: " + getClass());
    	this.getControllerParent().setScreen(Main.accommodationScreenID);
    }
    
    @FXML
    void confirmClicked(ActionEvent event) throws SQLException {
    	System.out.println("Confirm Clicked: " + getClass());
    	model.finishCheckout();
    	this.getControllerParent().setScreen(Main.accommodationScreenID);
    }
    
    @FXML
    void inputFieldOnAction(ActionEvent event) {
    	System.out.println("Enter Pressed Clicked");
    	if(!inputField.getText().equals(""))
    		model.checkout(inputField.getText());
    	else
    		System.out.println("Please input a product number");
    	inputField.setText("");
    }
    
    @FXML
    void mouseEntered(MouseEvent event) {
    	mouseMoved(event);
    }

    @FXML
    void mouseMoved(MouseEvent event) {
    	inputField.requestFocus();
    	
    }
    
    @FXML
    void backgroundClicked(MouseEvent event) {
    	mouseMoved(event);
    }
    
    public void setCheckoutModel(CheckoutModel model){
    	this.model = model;
    }
    
}
