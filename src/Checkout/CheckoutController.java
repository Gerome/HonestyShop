package Checkout;

public class CheckoutController {
	
	String accommodation;
	
	public CheckoutController(String accommodation){
		this.accommodation = accommodation;
		CheckoutView view = new CheckoutView();
		CheckoutModel model = new CheckoutModel();
	}
}
