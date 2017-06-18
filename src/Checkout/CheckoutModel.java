package Checkout;

import java.util.Scanner;  

public class CheckoutModel {
	
	private String accommodation;
	Scanner sc;
	
	String barcode = "";

	
	public CheckoutModel(String accommodation){
		setAccommodation(accommodation);
		sc = new Scanner(System.in);
		loop();
	}

	public void loop(){
		
		while(true){
			barcode = sc.nextLine();
			System.out.println(barcode);
		}
	}

	String getAccommodation() {
		return accommodation;
	}

	void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}
	
	
	
	
}
