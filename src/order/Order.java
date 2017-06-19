package order;

import java.util.Date;

public class Order {
	
	private String orderID, accommodation, name;
	private Date datetime;
	private Double total;

	public Order(String orderID, String accommodation, 
			Date datetime, Double total, String name) {
		this.setOrderID(orderID);
		this.setAccommodation(accommodation);
		this.setDatetime(datetime);
		this.setTotal(total);
		this.setName(name);
	}

	Double getTotal() {
		return total;
	}

	void setTotal(Double total) {
		this.total = total;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
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
	
	
	
	
}
