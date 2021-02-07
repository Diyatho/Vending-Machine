package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{
	public Candy(String slotId, String itemName, BigDecimal price) {
		super(slotId, itemName, price);

	}

	@Override
	String getMesage() {
		return "Munch Munch, Yum!";
	}


}
