package com.techelevator;

import java.math.BigDecimal;

public class Item {
	
	private String slotId;
	private String itemName;
	private BigDecimal price;
	private String category;
	private int quantityRemaining;
	
	
	
	public String getSlotId() {
		return slotId;
	}
	
	public String getItemName() {
		return itemName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getQuantityRemaining() {
		return quantityRemaining;
	}
	
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public void setCategory (String category) {
		this.category = category;
	}
	public void setQuantityRemaining (int quantityRemaining) {
		this.quantityRemaining = quantityRemaining;
	}
	

}
