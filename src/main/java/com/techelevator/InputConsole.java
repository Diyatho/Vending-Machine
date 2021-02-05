package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputConsole extends VendingMachine{
	
	public  void getUserInput() {
		Menu menu = new Menu();
		String purchaseMenuOption;
		Scanner scanner = new Scanner(System.in);
		String userInput;
		do {
			menu.printMainMenu();
			userInput = scanner.nextLine();
			if(userInput.equals("1")) {
				inventory.displayMenu();
			}
			else if(userInput.equals("2")){
				do {
					menu.printPurchaseMenu();
					purchaseMenuOption = scanner.nextLine();
					if(purchaseMenuOption.equals("1")) {
						balance.feedMoney();
						String inputMoney = scanner.nextLine();
						boolean isValidAmount = balance.isValidAmount(inputMoney);
						if(isValidAmount) {
							System.out.println("Money entered is valid");
							System.out.println(" Current balance is: "+ balance.updateBalance(new BigDecimal(inputMoney)));
						}
						//update log
					}
					else if(purchaseMenuOption.equals("2")) {
						inventory.displayVendingMenu();
						System.out.println("Enter Code: ");
						String userCode = scanner.nextLine();
						boolean codeIsValid = inventory.checkItem(userCode);
						if(codeIsValid) {
							inventory.dispenseItem(userCode);
							//update balance
							//update log
							
						}
					}
					else if(purchaseMenuOption.equals("3")) {
						balance.giveChange();
						//update balance
						//update log
					}
				} while(!purchaseMenuOption.equals("3"));
			}			
			else if(userInput.equals("3")) {
				
					System.exit(1);
				}			
		}while(!userInput.equals("3"));
		
		
	}

}
