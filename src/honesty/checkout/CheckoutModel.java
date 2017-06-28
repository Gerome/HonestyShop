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
		//basketTotal = basketTotal.setScale(2, RoundingMode.UP);
		currentProduct = null;
	}

	public void checkout(String barcode) {

		try {
			currentProduct = ProductController.getProduct(barcode);

			basketTotal = basketTotal.add(currentProduct.getSellPrice()).setScale(2, RoundingMode.UP);

			if (!basket.contains(currentProduct))
				basket.add(currentProduct);

			currentProduct.setStockLevel(currentProduct.getStockLevel() - 1);

			System.out.println("Added " + currentProduct.getProductName() + " to basket");
			System.out.println("Current total is: " + euCostFormat.format(basketTotal));

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (NullPointerException e) {
			
			System.out.println("This product is not in our Database");
			//e.printStackTrace();
			
		}
	}

	public void finishCheckout() throws SQLException {
		order = new Order(OrderController.generateOrderID(), accommodation, sdf.format(new Date()), basketTotal.doubleValue(), "Gerome");
		order.setItemList(basket);
		System.out.println(order.getDatetime());
		OrderController.newOrder(order);
		
	}

	String getAccommodation() {
		return accommodation;
	}

	void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

}
