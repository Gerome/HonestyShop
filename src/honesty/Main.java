package honesty;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	/*MainModel model;
	MainView view;
	
	public static void main(String args[]) {
		new MainController();
	}
	
	public MainController() {
		model = new MainModel();
		view = new MainView(this);
	}
	
	public void launchCheckout(String accommodation) {
		model.launchCheckout(accommodation);
	}
	
	public void launchStaffArea() {
		model.launchStaffArea();
	}*/
	
	public static String accommodationScreenID    = "accommodation";
	public static String accommodationScreenFXML  = "/resources/FXML/AccomodationPick.fxml";
	public static String adminScreenID            = "admin";
	public static String adminScreenFXML          = "/resources/FXML/AdminScreen.fxml";
	public static String editStockScreenID        = "edit";
	public static String editStockScreenFXML      = "/resources/FXML/EditStockScreen.fxml";
	public static String getBillScreenID          = "bill";
	public static String getBillScreenFXML        = "/resources/FXML/GetBillScreen.fxml";
	public static String checkoutScreenID         = "checkout";
	public static String checkoutScreenFXML       = "/resources/FXML/CheckoutScreen.fxml";
	public static String authenticationScreenID   = "auth";
	public static String authenticationScreenFXML = "/resources/FXML/AuthenticationScreen.fxml";
	public static String iconPath = "src\\resources\\Lanzarote-Logo.png";
	
	public static void main( String args[] ){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create Main Controller
		ScreensController mainController = new ScreensController();
		
		// Load in all Screens
		mainController.loadScreen(accommodationScreenID, accommodationScreenFXML);
		mainController.loadScreen(adminScreenID, adminScreenFXML);
		mainController.loadScreen(editStockScreenID, editStockScreenFXML);
		mainController.loadScreen(getBillScreenID, getBillScreenFXML);
		mainController.loadScreen(checkoutScreenID, checkoutScreenFXML);
		mainController.loadScreen(authenticationScreenID, authenticationScreenFXML);
		
		// Set the opening screen to the accommodation screen.
		mainController.setScreen(accommodationScreenID);
		
		// Add the scene to the stage and display
		Group root = new Group();
		root.getChildren().addAll(mainController);
		Scene scene = new Scene(root);
		
		Image image = new Image(new File(iconPath).toURI().toString());
		
		primaryStage.setFullScreen(true);
		primaryStage.getIcons().add(image);
		
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
}
