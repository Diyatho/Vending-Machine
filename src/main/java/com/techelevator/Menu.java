package com.techelevator;

import java.math.BigDecimal;

import com.techelevator.Balance;

public class Menu {

	public void printMainMenu (){
		System.out.println(">\n > (1) Display Vending Machine Items\n > (2) Purchase\n > (3) Exit >\n");
		
	}
	
	public void printPurchaseMenu (BigDecimal balance) {
		System.out.println("\n>>(1) Feed Money\n >(2) Select Product\n >(3) Finish Transaction\n > Current Money Provided: "+ "$" + balance.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		
	}
	
}
