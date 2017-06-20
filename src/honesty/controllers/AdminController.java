package honesty.controllers;

import honesty.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminController extends ControlledView {

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
    void printListClicked(ActionEvent event) {
    	System.out.println("Print List Clicked");
    }
    
}
