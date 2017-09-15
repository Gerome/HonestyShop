package honesty;

import java.io.File; 

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage primaryStage;
	public static String accommodationScreenID    = "accommodation";
	public static String accommodationScreenFXML  = "/resources/FXML/AccomodationPick.fxml";
	public static String adminScreenID            = "admin";
	public static String adminScreenFXML          = "/resources/FXML/AdminScreen.fxml";
	public static String editStockScreenID        = "edit";
	public static String editStockScreenFXML      = "/resources/FXML/EditStockScreen.fxml";
	public static String getBillScreenID          = "bill";
	public static String getBillScreenFXML        = "/resources/FXML/GetBillScreen.fxml";
	public static String getStaffBillScreenID     = "staff bill";
	public static String getStaffBillScreenFXML   = "/resources/FXML/GetStaffBillScreen.fxml";
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
		Main.primaryStage = primaryStage;
		
		ScreensController mainController = new ScreensController();
		
		// Load in all Screens
		mainController.loadScreen(accommodationScreenID, accommodationScreenFXML);
		mainController.loadScreen(adminScreenID, adminScreenFXML);
		mainController.loadScreen(editStockScreenID, editStockScreenFXML);
		mainController.loadScreen(getBillScreenID, getBillScreenFXML);
		mainController.loadScreen(getStaffBillScreenID, getStaffBillScreenFXML);
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
		
		primaryStage.setFullScreenExitHint("");
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("Shift+q"));
	
		primaryStage.show();	
	}
	
	public static Stage getStage() {
		return primaryStage;
	}
	
	
}
