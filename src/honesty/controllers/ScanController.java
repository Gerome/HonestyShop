package honesty.controllers;

import honesty.Main;
import honesty.checkout.CheckoutController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ScanController extends ControlledView {
	
	@FXML
    private TextField inputField;

    @FXML
    void backClicked(ActionEvent event) {
    	System.out.println("Back Clicked: " + getClass());
    	this.getControllerParent().setScreen(Main.accommodationScreenID);
    }
    
    @FXML
    void inputFieldOnAction(ActionEvent event) {
    	System.out.println("Enter Pressed Clicked");
    	new CheckoutController("Barn");
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
    
}
