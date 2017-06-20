package honesty.product;

import java.math.BigDecimal;

public class Product {

	private String productID, productName;
	private BigDecimal buyPrice, sellPrice;
	private int stockLevel, normalLevel;
	
	public Product(String productID, 
			String productName,
			BigDecimal buyPrice, 
			BigDecimal sellPrice,
			int stockLevel, 
			int normalLevel) {
		
		this.setProductID(productID);
		this.setProductName(productName);
		this.setBuyPrice(buyPrice);
		this.setSellPrice(sellPrice);
		this.setStockLevel(stockLevel);
		this.setNormalLevel(normalLevel);
		
		
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
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

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	
	
}
