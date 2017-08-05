package honesty.order;


public class OrderDetail {
	
	private String productName, date, name;
	private int quantity;
	private double lineTotal;

	public OrderDetail(String productName, int quantity, 
			double lineTotal, String date, String name) {
		
		this.setName(name);
		this.setDate(date);
		this.setProductName(productName);
		this.setQuantity(quantity);
		this.setLineTotal(lineTotal);
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

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
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
