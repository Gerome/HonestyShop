package order;

import java.util.Date;

public class Order {
	
	private String orderID, accommodation, name;
	private Date datetime;
	private Double total;

	public Order(String orderID, String accommodation, 
			Date datetime, Double total, String name) {
		this.orderID = orderID;
		this.accommodation = accommodation;
		this.datetime = datetime;
		this.setTotal(total);
		this.name = name;
	}

	Double getTotal() {
		return total;
	}

	void setTotal(Double total) {
		this.total = total;
	}
	
	
	
	
}
