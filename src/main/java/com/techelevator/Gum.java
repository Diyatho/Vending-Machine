package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item {
	
	public Gum(String slotId, String itemName, BigDecimal price) {
		super(slotId, itemName, price);

	}

	@Override
	String getMesage() {
		return "Chew Chew, Yum!";
	}


}
