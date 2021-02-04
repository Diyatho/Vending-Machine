package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
	
	List<Item> inventory = new ArrayList<Item>();
	
	
	
	
	public List<Item> stockInventory() {
		
		String[] inventoryData;
		try(Scanner fileScanner = new Scanner("vendingmachine.csv")){
			while(fileScanner.hasNextLine()) {
				String inventoryLine = fileScanner.nextLine();
				inventoryData = inventoryLine.split("[|]");
				Item item = new Item();
				item.setSlotId(inventoryData[0]);
				item.setItemName(inventoryData[1]);
				item.setPrice(Double.parseDouble(inventoryData[2]));
				item.setCategory(inventoryData[3]);
				item.setQuantityRemaining(5);
				inventory.add(item);
			}
		}
		return inventory;
	}

}
