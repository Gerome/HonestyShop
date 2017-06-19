package checkout;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import product.Product;
import product.ProductController;

import java.util.Scanner;

public class CheckoutModel {

	private String accommodation;
	private Scanner sc;
	private String barcode;
	private BigDecimal basketTotal = new BigDecimal("0");
	private ArrayList<Product> basket = new ArrayList<>();
	private Boolean finished = false;
	
	private NumberFormat euCostFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
	

	public CheckoutModel(String accommodation) {
		setAccommodation(accommodation);
		sc = new Scanner(System.in);
		euCostFormat.setMinimumFractionDigits( 2 );
		euCostFormat.setMaximumFractionDigits( 2 );
		checkout();
	}

	private void checkout() {
	
		Product currentProduct = null;
		while (!finished) {
			
			if (sc.hasNextLine()) {
				
				barcode = sc.nextLine();
				
				try {
					currentProduct = ProductController.getProduct(barcode);
					basket.add(currentProduct);
					basketTotal = basketTotal.add(currentProduct.getSellPrice());
					System.out.println(currentProduct.getNormalLevel());
					currentProduct.setStockLevel(currentProduct.getStockLevel() - 1);
					System.out.println(currentProduct.getStockLevel());
					System.out.println("Added " + currentProduct.getProductName() + " to basket");
					System.out.println("Current total is: " + euCostFormat.format(basketTotal));
					
				} catch (SQLException e) {

					e.printStackTrace();
					
				}
				System.out.println("Basket size is: " + basket.size());
				//finishCheckout();
			}
		}
	}

	public void finishCheckout() {
		finished = true;
	}

	String getAccommodation() {
		return accommodation;
	}

	void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

}
