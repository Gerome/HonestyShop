package honesty.order;

import java.util.ArrayList;

import honesty.product.Product;

public class Order {
	
	private String orderID, accommodation, name, datetime;
	private Double total;
	private ArrayList<Product> productList;

	public Order(String orderID, String accommodation, 
			String date, Double total, String name) {
		this.setOrderID(orderID);
		this.setAccommodation(accommodation);
		this.setDatetime(date);
		this.setTotal(total);
		this.setName(name);
	}

	public Double getTotal() {
		return total;
	}

	void setTotal(Double total) {
		this.total = total;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String date) {
		this.datetime = date;
	}

	public String getOrderID() {
		return orderID;
	}

	private void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getAccommodation() {
		return accommodation;
	}

	private void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public ArrayList<Product> getItemList() {
		return productList;
	}

	public void setItemList(ArrayList<Product> itemList) {
		this.productList = itemList;
	}
	
	
	
	
}
