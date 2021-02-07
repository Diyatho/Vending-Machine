package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import com.techelevator.Item;

import com.techelevator.VendingMachine;



public class VendingMachineTest {

	private VendingMachine VendingMachineTest;
	
	public void setup() {
		VendingMachineTest = new VendingMachine();
		List<Item> inventory = new ArrayList<Item>();
		inventory.add(new Chip("A1", "Potato Crisps", new BigDecimal("3.05")));
	}
	
	
	
	@Test
	public void isValidProductSlotKeyWorksProperly() throws ChoiceFailException {
		
		Assert.assertTrue(VendingMachineTest.checkItem("A1"));
		/*
		Assert.assertTrue(VendingMachineTest.checkItem("B2"));
		Assert.assertTrue(VendingMachineTest.checkItem("C3"));
		Assert.assertTrue(VendingMachineTest.checkItem("D4"));
		
		Assert.assertFalse(VendingMachineTest.checkItem("D5"));
		Assert.assertFalse(VendingMachineTest.checkItem("5D"));
		
		*/

	
	}
	
	//@Test
	//public void itemIsOutOfStock() {
		//String result = VendingMachineTest.checkItem();
		//Assert.assertEquals("5", result);
//	}
	
	@Test
	public void getAttributesMountainMelter() {
		Item mountainMelter = new Drink("C3", "Mountain Melter", new BigDecimal("1.50"));
		
		Assert.assertEquals("Mountain Melter", mountainMelter.getItemName());
		Assert.assertEquals("C3", mountainMelter.getSlotId());
		Assert.assertEquals(5, mountainMelter.getQuantity());
	}





	
	
}
