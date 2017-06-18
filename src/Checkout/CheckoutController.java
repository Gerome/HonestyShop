package Checkout;

public class CheckoutController {
	
	
	
	public static void main(String[] args){
		CheckoutController cont = new CheckoutController("villa");
	}
	
	public CheckoutController(String accommodation){
		
		CheckoutView view = new CheckoutView();
		CheckoutModel model = new CheckoutModel(accommodation);
	}
}
