package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import com.techelevator.Item;

public class ItemTest {
	
	private Item ItemTest;
	
	@Test
	public void initializesTheItemsCorrectly() {
		Assert.assertEquals("A1", ItemTest.getSlotId());
		Assert.assertEquals("Potato Crisps", ItemTest.getItemName());
		Assert.assertEquals(5, ItemTest.getQuantity());

	}

}
