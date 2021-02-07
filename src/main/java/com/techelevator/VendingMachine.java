package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
	List<Item> inventory = new ArrayList<Item>();
	Balance balanceObject = new Balance();
	Log log = new Log();
	private BigDecimal balance;
	
	public VendingMachine() {
		balance = BigDecimal.ZERO;
	}
	
	public void stockInventory() {
		
		String[] inventoryData;
		File stockFile = new File("vendingmachine.csv");
		try(Scanner fileScanner = new Scanner(stockFile)){
			while(fileScanner.hasNextLine()) {
				String inventoryLine = fileScanner.nextLine();
				//System.out.println("inventory line " + inventoryLine);
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
	}
	
	public void displayMenu() {
		System.out.println("\nItem                  Count left            Price");
		System.out.println("_________________________________________________\n");
		for(Item item : inventory) {
			System.out.println(item.getItemName() + addSpace(item.getItemName().length()) + item.getQuantityRemaining() + addSpace(1) + item.getPrice());
		}
		System.out.println("\n\n");
		
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
	
	public boolean checkItem(String userCode) throws ChoiceFailException {
		boolean found = false;
		boolean isValid = true;
		for(Item item : inventory) {
			if(item.getSlotId().equals(userCode)) {
				found = true;
				
				if(item.getQuantityRemaining() == 0 ) {
					isValid = false;
					throw new ChoiceFailException("The item is SOLD OUT. Please select another item");
				}
				if(item.getPrice().compareTo(balance) > 0) {
					isValid = false;
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
	public void dispenseItem(String userCode) {
		Item userChoice = new Item();
		BigDecimal oldBalance = balance;
		for(Item item : inventory) {
			if(item.getSlotId().equals(userCode)) {
				userChoice = item;
				//prints line with item, price and available balance
				
				balance = balance.subtract(item.getPrice());
				System.out.println(item.getItemName()+ " " + item.getPrice() + "   " + balance);
				//decreases quantity by 1
				 item.setQuantityRemaining(item.getQuantityRemaining() - 1);
				 
				if (item.getCategory().equals("Chip")) {
					System.out.println("Crunch Crunch, Yum!");
					break;
				}
				else if (item.getCategory().equals("Candy")) {
					System.out.println("Munch Munch, Yum!");
					break;
				}
				else if (item.getCategory().equals("Drink")) {
					System.out.println("Glug Glug, Yum!");
					break;
				}
				else if (item.getCategory().equals("Gum")) {
					System.out.println("Chew Chew, Yum!");
					break;
				}
			}
		}
		String arg1 =userChoice.getItemName() + " " + userChoice.getSlotId();
		log.createLogEntry(arg1, oldBalance, balance);
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal currentBalance) {
		this.balance = currentBalance;
	}
	
	public BigDecimal updateBalance(BigDecimal inputMoney) {
		balance = balance.add(inputMoney);
		log.createLogEntry("FEED MONEY:",inputMoney, balance);
		return balance;
	}
	
	public void giveChange() {
		balanceObject.makeChange(balance);
		log.createLogEntry("GIVE CHANGE:", balance, BigDecimal.ZERO);
		log.writeLog();
		balance = BigDecimal.ZERO;
	}
}
