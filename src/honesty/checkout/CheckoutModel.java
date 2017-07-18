package honesty.checkout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import honesty.order.Order;
import honesty.order.OrderController;
import honesty.product.Product;
import honesty.product.ProductController;
import javafx.animation.PauseTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CheckoutModel {

	private String accommodation;
	private BigDecimal basketTotal = new BigDecimal("0.00");
	private ArrayList<Product> basket = new ArrayList<>();
	private Product currentProduct;
	private Order order;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private NumberFormat euCostFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

	public CheckoutModel(String accommodation) {
		setAccommodation(accommodation);
		euCostFormat.setMinimumFractionDigits(2);
		euCostFormat.setMaximumFractionDigits(2);
		currentProduct = null;
	}

	public boolean checkout(String barcode) {

		try {
			
			currentProduct = ProductController.getProduct(barcode);

			if (!basket.isEmpty() && basketContainsProductWith(barcode)) {
				currentProduct = getProductFromBasket(barcode);
				currentProduct.setQuantity(currentProduct.getQuantity() + 1);
				System.out.println("Increased quantity of " + currentProduct.getProductName() + "\nCurrent quantity is:"
						+ currentProduct.getQuantity());
			} else {
				currentProduct.setQuantity(1);
				basket.add(currentProduct);
				System.out.println("Added new product:" + currentProduct.getProductName());
			}

			setBasketTotal(getBasketTotal().add(currentProduct.getSellPrice()));

			currentProduct.setStockLevel(currentProduct.getStockLevel() - 1);

			System.out.println("Added " + currentProduct.getProductName() + " to basket");
			System.out.println("Current total is: " + euCostFormat.format(getBasketTotal()));
			return true;
			
		} catch (SQLException e) {

			e.printStackTrace();

			return false;
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			System.out.println(this.getClass() + " This product is not in our Database");
			
			displayPopup();
			
			return false;
		}

	}

	public void displayPopup() {
		Stage popup = new Stage();
		
		Group rootGroup = new Group();
		
		Scene scene = new Scene(rootGroup);
		
		popup.setScene(scene);
		
		// configure UI for popup etc...

		// hide popup after 3 seconds:
		PauseTransition delay = new PauseTransition(Duration.seconds(3));
		delay.setOnFinished(e ->popup.hide());

		
		popup.setX(300);
		popup.setY(300);
		
		popup.setFullScreen(false);
		
		
		
		
		popup.show();
		delay.play();
	}

	private Product getProductFromBasket(String barcode) {
		for (Product product : basket) {
			if (product.getProductID().equals(barcode)) {
				return product;
			}
		}
		return null;
	}

	private boolean basketContainsProductWith(String barcode) {
		for (Product product : basket) {
			if (product.getProductID().equals(barcode)) {
				return true;
			}
		}
		return false;
	}

	public void finishCheckout() throws SQLException {

		if (basket.isEmpty())
			return;

		order = new Order(sdf.format(new Date()) + accommodation, accommodation, sdf.format(new Date()),
				getBasketTotal(), "Gerome");
		order.setItemList(basket);
		System.out.println(order.getDatetime());
		OrderController.newOrder(order);
		
		displayPopup();
		
	}

	public void removeProduct() {

		if (!basket.isEmpty()) {
			Product product = basket.get(basket.size() - 1);

			if (product.getQuantity() <= 1) {
				basket.remove(product);
			} else {
				product.setQuantity(product.getQuantity() - 1);
			}

			setBasketTotal(getBasketTotal().subtract(currentProduct.getSellPrice()));
		}
	}

	String getAccommodation() {
		return accommodation;
	}

	void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	public BigDecimal getBasketTotal() {
		return basketTotal;
	}

	private void setBasketTotal(BigDecimal basketTotal) {
		this.basketTotal = basketTotal;
	}

}
