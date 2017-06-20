package honesty.controllers;

import honesty.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ScanController extends ControlledView {

    @FXML
    void backClicked(ActionEvent event) {
    	System.out.println("Back Clicked: " + getClass());
    	this.getControllerParent().setScreen(Main.accommodationScreenID);
    }
    
}
