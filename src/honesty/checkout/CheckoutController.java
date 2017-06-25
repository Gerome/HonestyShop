package honesty.checkout;

public class CheckoutController {
	
	
	CheckoutView view;
	CheckoutModel model;
	
	//public static void main(String args[]) {
	//	new CheckoutController("villa");
	//}
	
	public CheckoutController(String accommodation){
		
		//view = new CheckoutView();
		model = new CheckoutModel(accommodation);

		
	}
}
