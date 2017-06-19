

public class MainController {

	MainModel model;
	MainView view;
	
	public MainController() {
		model = new MainModel();
		view = new MainView();
	}
	
	public void launchCheckout(String accommodation) {
		model.launchCheckout(accommodation);
	}
	
	public void launchStaffArea() {
		model.launchStaffArea();
	}
	
}
