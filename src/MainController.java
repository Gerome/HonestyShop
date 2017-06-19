

public class MainController {

	MainModel model;
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
	}
	
}
