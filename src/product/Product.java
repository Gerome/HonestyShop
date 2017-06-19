package product;

import java.math.BigDecimal;

public class Product {

	private String productID, productName;
	private double buyPrice, sellPrice;
	private int stockLevel, normalLevel;
	
	public Product(String productID, 
			String productName,
			double buyPrice, 
			double sellPrice,
			int stockLevel, 
			int normalLevel) {
		
		this.productID = productID;
		this.setProductName(productName);
		this.buyPrice = buyPrice;
		this.setSellPrice(sellPrice);
		this.setStockLevel(stockLevel);
		this.setNormalLevel(normalLevel);
		
		
	}

	public int getStockLevel() {
		return stockLevel;
	}

	private void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}

	public int getNormalLevel() {
		return normalLevel;
	}

	public void setNormalLevel(int normalLevel) {
		this.normalLevel = normalLevel;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	
	
}
