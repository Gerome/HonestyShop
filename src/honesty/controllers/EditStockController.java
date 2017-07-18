package honesty.controllers;

import java.sql.SQLException;

import honesty.Main;
import honesty.product.ProductController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class EditStockController extends ControlledView {

    @FXML
    void backClicked(ActionEvent event) {
    	this.getControllerParent().setScreen(Main.adminScreenID);
    	
    }
    
    @FXML
    void replenishStockClicked(MouseEvent event) throws ClassNotFoundException, SQLException {
    	
    	System.out.println(this.getClass() + " Replenish stock clicked");
    	
    	ProductController.replenishStock();
    	
    }
    
    @FXML
    void editStockClicked(ActionEvent event) {

    }
}
