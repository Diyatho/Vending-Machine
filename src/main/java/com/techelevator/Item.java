package com.techelevator;

public class Item {
	
	private String slotId;
	private String itemName;
	private double price;
	private String category;
	private int quantityRemaining;
	
	
	public String getSlotId() {
		return slotId;
	}
	
	public String getItemname() {
		return itemName;
	}
	public double getPrice() {
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
	
	

}
