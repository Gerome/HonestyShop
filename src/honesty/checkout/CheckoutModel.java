package honesty.checkout;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import honesty.product.Product;
import honesty.product.ProductController;

public class CheckoutModel {

	private String accommodation;
	private Scanner sc;
	private String barcode;
	private BigDecimal basketTotal = new BigDecimal("0");
	private ArrayList<Product> basket = new ArrayList<>();
	private Boolean finished = false;
	private Product currentProduct;
	
	private NumberFormat euCostFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

	public CheckoutModel(String accommodation) {
		setAccommodation(accommodation);
		sc = new Scanner(System.in);
		euCostFormat.setMinimumFractionDigits(2);
		euCostFormat.setMaximumFractionDigits(2);
		currentProduct = null;
	}

	public void checkout(String barcode) {

	
			try {
				currentProduct = ProductController.getProduct(barcode);

				basketTotal = basketTotal.add(currentProduct.getSellPrice());

				if (!basket.contains(currentProduct))
					basket.add(currentProduct);

				currentProduct.setStockLevel(currentProduct.getStockLevel() - 1);

				System.out.println("Added " + currentProduct.getProductName() + " to basket");
				System.out.println("Current total is: " + euCostFormat.format(basketTotal));

			} catch (SQLException e) {

				e.printStackTrace();

			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			System.out.println("Basket size is: " + basket.size());
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
