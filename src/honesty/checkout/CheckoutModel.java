package honesty.checkout;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import honesty.order.Order;
import honesty.product.Product;
import honesty.product.ProductController;

public class CheckoutModel {

	private String accommodation;
	private BigDecimal basketTotal = new BigDecimal("0");
	private ArrayList<Product> basket = new ArrayList<>();
	private Product currentProduct;
	private Order order;

	private NumberFormat euCostFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

	public CheckoutModel(String accommodation) {
		setAccommodation(accommodation);
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
		order = new Order("temp", accommodation, new Date(), basketTotal.doubleValue(), "name");
		order.setItemList(basket);
	}

	String getAccommodation() {
		return accommodation;
	}

	void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

}
