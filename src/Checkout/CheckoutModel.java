package checkout;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import product.Product;
import product.ProductController;

import java.util.Scanner;

public class CheckoutModel {

	private String accommodation;
	private Scanner sc;
	private String barcode;
	private double basketTotal = 0;
	private ArrayList<Product> basket = new ArrayList<>();

	public CheckoutModel(String accommodation) {
		setAccommodation(accommodation);
		sc = new Scanner(System.in);
		loop();
	}

	private void loop() {

		while (true) {
			if (sc.hasNextLine()) {
				
				barcode = sc.nextLine();
				
				try {
					basket.add(ProductController.getProduct(barcode));
					System.out.println("Product is: " + ProductController.getProduct(barcode).getProductName());
					basketTotal += ProductController.getProduct(barcode).getSellPrice().doubleValue();
					System.out.println("Current total is: " + basketTotal);
				} catch (SQLException e) {

					e.printStackTrace();
					
				}
				System.out.println(basket.size());
			}
		}
	}

	public void finishCheckout() {
		System.out.println(basket);
	}

	String getAccommodation() {
		return accommodation;
	}

	void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

}
