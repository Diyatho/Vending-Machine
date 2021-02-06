package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
	List<Item> inventory = new ArrayList<Item>();
	
	public void stockInventory() {
		
		String[] inventoryData;
		File stockFile = new File("vendingmachine.csv");
		try(Scanner fileScanner = new Scanner(stockFile)){
			while(fileScanner.hasNextLine()) {
				String inventoryLine = fileScanner.nextLine();
				System.out.println("inventory line " + inventoryLine);
				inventoryData = inventoryLine.split("[|]");
				Item item = new Item();
				item.setSlotId(inventoryData[0]);
				item.setItemName(inventoryData[1]);
				item.setPrice(new BigDecimal(inventoryData[2]));
				item.setCategory(inventoryData[3]);
				item.setQuantityRemaining(5);
				inventory.add(item);
			}
		}catch (Exception e) {
			System.out.println("Error while stocking inventory");
		}
		for(Item item: inventory) {
			System.out.println(item.getItemName());
		}
	}
	
	public void displayMenu() {
		System.out.println("Item                  Count left            Price");
		System.out.println("_________________________________________________\n");
		for(Item item : inventory) {
			System.out.println(item.getItemName() + addSpace(item.getItemName().length()) + item.getQuantityRemaining() + addSpace(1) + item.getPrice());
		}
		
	}
	
	public String addSpace(int length)
	{
		String space ="";
		for(int i = length; i < 22; i++) {
			space += " ";
		}
		return space;
	}
	public void displayVendingMenu() {
		for(Item item : inventory) {
			System.out.println(item.getSlotId() + "      " + item.getItemName() + addSpace(item.getItemName().length()) + item.getPrice());
		}
	}
	
	public boolean checkItem(String userCode, BigDecimal balance) throws ChoiceFailException {
		boolean found = false;
		boolean isValid = true;
		for(Item item : inventory) {
			if(item.getSlotId().equals(userCode)) {
				found = true;
				
				if(item.getQuantityRemaining() == 0 ) {
					isValid = false;
					//break;
					throw new ChoiceFailException("The item is SOLD OUT. Please select another item");
				}
				if(item.getPrice().compareTo(balance) > 0) {
					isValid = false;
					//break;
					throw new ChoiceFailException("The balance is not enough to buy this item. Please update your balance");
				}
				
			}
		}
		if(found == false) {
			isValid = false;
			throw new ChoiceFailException("This is not a valid code. Please try again");
		}
		return isValid;
	}
	
	
	//dispenseItem
	public BigDecimal dispenseItem(String userCode, BigDecimal currentBalance) {
		BigDecimal balance = currentBalance;
		for(Item item : inventory) {
			if(item.getSlotId().equals(userCode)) {
				//prints line with item, price and available balance
				balance = balance.subtract(item.getPrice());
				System.out.println(item.getItemName()+ " " + item.getPrice() + "   " + balance);
				//decreases quantity by 1
				 item.setQuantityRemaining(item.getQuantityRemaining() - 1);
				 
				if (item.getCategory().equals("Chip")) {
					System.out.println("Crunch Crunch, Yum!");
				}
				else if (item.getCategory().equals("Candy")) {
					System.out.println("Munch Munch, Yum!");
				}
				else if (item.getCategory().equals("Drinks")) {
					System.out.println("Glug Glug, Yum!");
				}
				else if (item.getCategory().equals("Gum")) {
					System.out.println("Chew Chew, Yum!");
				}
			}
		}
		return balance;
	}

	
	public void start() {
		
	}
	
}
