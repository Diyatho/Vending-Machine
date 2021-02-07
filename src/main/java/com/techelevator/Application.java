package com.techelevator;

public class Application {

	public static void main(String[] args) {

		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.stockInventory();
		InputConsole inputConsole = new InputConsole(vendingMachine);
		inputConsole.getUserInput();
		System.out.println("Exiting Application...");

	}

}
