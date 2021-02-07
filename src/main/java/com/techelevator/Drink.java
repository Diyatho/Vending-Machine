package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item {
	
	public Drink(String slotId, String itemName, BigDecimal price) {
		super(slotId, itemName, price);

	}

	@Override
	String getMesage() {
		return "Glug Glug, Yum!";
	}


}
