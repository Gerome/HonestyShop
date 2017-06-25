package honesty.controllers;

import honesty.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AuthController extends ControlledView {

    @FXML
    private TextField userNameField;

    @FXML
    private TextField passwordField;

    @FXML
    void backClicked(ActionEvent event) {
    	System.out.println("Back Clicked: " + getClass());
    	this.getControllerParent().setScreen(Main.accommodationScreenID);
    }

    @FXML
    void loginClicked(ActionEvent event) {
    	System.out.println("Login Clicked");
    	this.getControllerParent().setScreen(Main.adminScreenID);
    }

}
