package honesty.order;


public class OrderDetail {
	
	private String productName, date, name;
	private int quantity;
	private String lineTotal;

	public OrderDetail(String productName, int quantity, 
			String string, String date, String name) {
		
		this.setName(name);
		this.setDate(date);
		this.setProductName(productName);
		this.setQuantity(quantity);
		this.setLineTotal(string);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(String string) {
		this.lineTotal = string;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	
}
