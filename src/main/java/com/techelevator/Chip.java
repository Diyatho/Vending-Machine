package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Item {

	public Chip(String slotId, String itemName, BigDecimal price) {
		super(slotId, itemName, price);

	}

	@Override
	String getMesage() {
		return "Crunch Crunch, Yum!";
	}

}
