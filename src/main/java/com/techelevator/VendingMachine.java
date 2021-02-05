package com.techelevator;

import java.util.Scanner;

public class VendingMachine {
	static Inventory inventory = new Inventory();
	static Balance balance = new Balance();
	
	public static void main(String args[]) {
		try {
			inventory.stockInventory();
			InputConsole inputConsole = new InputConsole();
			inputConsole.getUserInput();
		}catch(Exception e) {
			
		}
		
	}
	


	
	
	
	
}
