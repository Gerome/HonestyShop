package honesty.controllers;

import honesty.Main;
import honesty.checkout.CheckoutModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class AccommodationsController extends ControlledView {

    @FXML
    void barnClicked(MouseEvent event) {
    	System.out.println("Barn Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Barn"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    
    @FXML
    void beachYurtClicked(MouseEvent event) {
    	System.out.println("Beach Yurt Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Beach Yurt"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void cabinClicked(MouseEvent event) {
    	System.out.println("Cabin Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Cabin"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void casitaClicked(MouseEvent event) {
    	System.out.println("Casita Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Casita"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void chicoYurtClicked(MouseEvent event) {
    	System.out.println("Chico Yurt Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Chico Yurt"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void chiquititaClicked(MouseEvent event) {
    	System.out.println("Chiquitita Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Chiquitita"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void farmhouseClicked(MouseEvent event) {
    	System.out.println("Farmhouse Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Farmhouse"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void gardenCottageClicked(MouseEvent event) {
    	System.out.println("Garden Cottage Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Garden Cottage"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void lodgeClicked(MouseEvent event) {
    	System.out.println("Lodge Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Lodge"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void palmYurtClicked(MouseEvent event) {
    	System.out.println("Palm Yurt Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Palm Yurt"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void royaleClicked(MouseEvent event) {
    	System.out.println("Royale Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Royale"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void yurtSuiteClicked(MouseEvent event) {
    	System.out.println("Yurt Suite Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Yurt Suite"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void towerClicked(MouseEvent event) {
    	System.out.println("Tower Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Tower"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void twinYurtClicked(MouseEvent event) {
    	System.out.println("Twin Yurt Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Twin Yurt"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void villaClicked(MouseEvent event) {
    	System.out.println("Villa Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Villa"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    @FXML
    void yurtClicked(MouseEvent event) {
    	System.out.println("Yurt Clicked");
    	((CheckoutController) getControllerParent().getControlledView(Main.checkoutScreenID)).setCheckoutModel(new CheckoutModel("Yurt"));
    	this.getControllerParent().setScreen(Main.checkoutScreenID);
    }
    
    
    @FXML
    void staffSettingsClicked(ActionEvent event) {
    	System.out.println("Staff Settings Clicked");
    	this.getControllerParent().setScreen(Main.authenticationScreenID);
    }
    
    
}
