package honesty.checkout;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import honesty.Main;
import honesty.order.Order;
import honesty.order.OrderController;
import honesty.product.Product;
import honesty.product.ProductController;
import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.util.Duration;

public class CheckoutModel {

	private String accommodation;
	private BigDecimal basketTotal = new BigDecimal("0.00");
	private ArrayList<Product> basket = new ArrayList<>();
	private Product currentProduct;
	private Order order;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private NumberFormat euCostFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
	private String name;

	public CheckoutModel(String accommodation) {
		setAccommodation(accommodation);
		euCostFormat.setMinimumFractionDigits(2);
		euCostFormat.setMaximumFractionDigits(2);
		currentProduct = null;
	}

	public CheckoutModel(String accommodation, String username) {
		setAccommodation(accommodation);
		this.name = username;
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
		} catch (NullPointerException e) {
			
			System.out.println(this.getClass() + " This product is not in our Database");
			
			displayErrorPopup();
			
			return false;
		}

	}

	public void displayErrorPopup() {
		
		PauseTransition delay = new PauseTransition(Duration.seconds(3));
		Alert alert = new Alert(AlertType.ERROR);
		
		
		
    	alert.setTitle("Item Error");
    	alert.setHeaderText("Error finding this item");
    	alert.setContentText("Please contact staff about this item");
    	
    	alert.initOwner(Main.getStage());
    	
    	alert.show();	
    	
    	delay.setOnFinished(e -> alert.close());
 
	}
	
	public void displayConfirmedPopup() {
		
		
		Alert alert = new Alert(AlertType.INFORMATION);
		
    	alert.setTitle("Purchase confirmed");
    	alert.setHeaderText("Purchase confirmed");
    	alert.setContentText("Thank you for using the honesty shop");
    
    	alert.initOwner(Main.getStage());
    	
    	alert.show();	
    	
    	
 
	}
	
	public void getNamePopup() {
		
		
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Honesty shop name");
		dialog.setHeaderText("Please enter your name and put the correct change in the tin.");
		dialog.setContentText("Name:");
		
		dialog.initOwner(Main.getStage());

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		
		result.ifPresent(X -> this.name = X);
		
		
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

		if(this.accommodation.equals("Other"))
			getNamePopup();
		
		displayConfirmedPopup();
		
		order = new Order(sdf.format(new Date()) + accommodation, accommodation, sdf.format(new Date()),
				getBasketTotal(), this.name);
		
		
		
		order.setItemList(basket);
		
		OrderController.newOrder(order);
		
	 
			
			
		
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
