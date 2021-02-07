package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class InputConsole{
	Balance balance = new Balance();
	private List<Item> inventory;
	VendingMachine vendingMachine = new VendingMachine();
	
	public InputConsole(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}
	

	public  void getUserInput() {
		Menu menu = new Menu();
		String purchaseMenuOption;
		
		Scanner scanner = new Scanner(System.in);
		String userInput;
		do {
			menu.printMainMenu();
			userInput = scanner.nextLine();
			if(userInput.equals("1")) {
				vendingMachine.displayMenu();
			}
			else if(userInput.equals("2")){
				do {
					menu.printPurchaseMenu(vendingMachine.getBalance());
					purchaseMenuOption = scanner.nextLine();
					if(purchaseMenuOption.equals("1")) {
						balance.feedMoney();
						String inputMoney = scanner.nextLine();
						boolean isValidAmount = balance.isValidAmount(inputMoney);
						if(isValidAmount) {
							System.out.println("Money entered is valid");
							System.out.println("Current balance is: "+ vendingMachine.updateBalance(new BigDecimal(inputMoney)));
						}
						else{
							System.out.println("Money entered is not valid. Please try again");
						}
					}
					else if(purchaseMenuOption.equals("2")) {
						vendingMachine.displayVendingMenu();
						System.out.print("Enter Code: ");
						String userCode = scanner.nextLine();
						boolean codeIsValid = false;
						try {
							codeIsValid = vendingMachine.checkItem(userCode);
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
						if(codeIsValid) {						
							vendingMachine.dispenseItem(userCode);				
						}
					}
					else if(purchaseMenuOption.equals("3")) {
						vendingMachine.giveChange();
					}
				} while(!purchaseMenuOption.equals("3"));
			}			
		}while(!userInput.equals("3"));
		if(userInput.equals("3")) {
			vendingMachine.endApplication();
		}
	}

}
