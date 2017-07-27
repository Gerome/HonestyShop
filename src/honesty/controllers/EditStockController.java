package honesty.controllers;

import java.sql.SQLException;

import honesty.Main;
import honesty.product.ProductController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

public class EditStockController extends ControlledView {

    @FXML
    void backClicked(ActionEvent event) {
    	this.getControllerParent().setScreen(Main.adminScreenID);
    	
    }
    
    @FXML
    void replenishStockClicked(MouseEvent event) {
    	
    	System.out.println(this.getClass() + " Replenish stock clicked");
    	
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Reset all stock");
    	alert.setHeaderText("You are about to reset all stock level");
    	alert.setContentText("You will not be able to undo this");
    	alert.showAndWait().ifPresent(rs -> {
    	    if (rs == ButtonType.OK) {
    	    	try {
					ProductController.replenishStock();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    } else {
    	    	
    	    }
    	});
    	
    }
    
    @FXML
    void editStockClicked(ActionEvent event) {

    }
}
