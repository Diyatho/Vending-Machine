package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {
	
	private String slotId;
	private String itemName;
	private BigDecimal price;
	private int quantity;
	
	
	
	public Item(String slotId, String itemName, BigDecimal price) {
		this.slotId = slotId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = 5;
	}
	
	abstract String getMesage();
	
	public String getSlotId() {
		return slotId;
	}
	
	public String getItemName() {
		return itemName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
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

	public void setQuantity (int quantity) {
		this.quantity = quantity;
	}
	

	

}
