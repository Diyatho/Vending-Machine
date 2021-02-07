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
	SalesReport salesReport = new SalesReport();
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
				if("Chip".equals(inventoryData[3])){
					Item item = new Chip(inventoryData[0], inventoryData[1],new BigDecimal(inventoryData[2]));
					inventory.add(item);
				}
				if("Candy".equals(inventoryData[3])){
					Item item = new Candy(inventoryData[0], inventoryData[1],new BigDecimal(inventoryData[2]));
					inventory.add(item);
				}
				if("Drink".equals(inventoryData[3])){
					Item item = new Drink(inventoryData[0], inventoryData[1],new BigDecimal(inventoryData[2]));
					inventory.add(item);
				}
				if("Gum".equals(inventoryData[3])){
					Item item = new Gum(inventoryData[0], inventoryData[1],new BigDecimal(inventoryData[2]));	
					inventory.add(item);
				}
				salesReport.addToSalesMap(inventoryData[1], 0);
			}
		}catch (Exception e) {
			System.out.println("Error while stocking inventory");
		}
		salesReport.printMap();
	}
	
	public void displayMenu() {
		System.out.println("\nItem                  Count left            Price");
		System.out.println("_________________________________________________\n");
		for(Item item : inventory) {
			System.out.println(item.getItemName() + addSpace(item.getItemName().length()) + item.getQuantity() + addSpace(1) + item.getPrice());
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
			if(item.getSlotId().equalsIgnoreCase(userCode)) {
				found = true;
				
				if(item.getQuantity() == 0 ) {
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
		//Item userChoice = ;
		BigDecimal oldBalance = balance;
		for(Item item : inventory) {
			if(item.getSlotId().equalsIgnoreCase(userCode)) {
				//prints line with item, price and available balance	
				balance = balance.subtract(item.getPrice());
				
				System.out.println(item.getItemName()+ " " + item.getPrice() + "   " + balance);
				//decreases quantity by 1
				 item.setQuantity(item.getQuantity() - 1);
				 
				 //prints custom message for Chip, Candy, Drink and Gum
				 item.getMesage();
				 
				 //creates the log entry in the format 01/01/2016 12:01:25 PM Cowtales B2 $8.50 $7.50
				 String arg1 =item.getItemName() + " " + item.getSlotId();
				 log.createLogEntry(arg1, oldBalance, balance);
				 
				 //updates the salesMap
				 salesReport.update(item.getItemName(),item.getPrice());
			}
		}
		
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
	
	public void endApplication() {
		salesReport.writeSalesReport();
	}
}
