package honesty.controllers;

import java.sql.SQLException;

import honesty.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import staff.EditStockModel;

public class EditStockController extends ControlledView {

    @FXML
    void backClicked(ActionEvent event) {
    	this.getControllerParent().setScreen(Main.adminScreenID);
    	try {
			new EditStockModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void editStockClicked(ActionEvent event) {

    }
}
