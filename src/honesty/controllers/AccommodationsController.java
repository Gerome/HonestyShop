package honesty.controllers;

import honesty.Main;
import honesty.checkout.CheckoutController;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class AccommodationsController extends ControlledView {

    @FXML
    void barnClicked(MouseEvent event) {
    	System.out.println("Barn Clicked");
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    	/*PauseTransition pause = new PauseTransition(Duration.millis(250));
    	pause.setOnFinished(e -> loadNewModel("Barn"));
    	pause.play();*/
    }
    
    @FXML
    void staffSettingsClicked(ActionEvent event) {
    	System.out.println("Staff Settings Clicked");
    	this.getControllerParent().setScreen(Main.authenticationScreenID);
    }
    
    private void loadNewModel(String accommodation){
    	new CheckoutController(accommodation);
    }
}
