package honesty.controllers;

import java.sql.SQLException;

import honesty.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login.LoginModel;

public class AuthController extends ControlledView {

	
    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void backClicked(ActionEvent event) {
    	System.out.println("Back Clicked: " + getClass());
    	userNameField.setText("");
		passwordField.setText("");
    	this.getControllerParent().setScreen(Main.accommodationScreenID);
    	
    }

    @FXML
    void loginClicked(ActionEvent event) throws SQLException {
    	System.out.println("Login Clicked");
    	if(LoginModel.authenticateUser(userNameField.getText(), passwordField.getText())) {
    		userNameField.setText("");
    		passwordField.setText("");
    		this.getControllerParent().setScreen(Main.adminScreenID);
    		
    	}
    }

}
