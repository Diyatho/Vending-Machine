package com.techelevator;

import java.math.BigDecimal;

import com.techelevator.Balance;

public class Menu {

	public void printMainMenu (){
		System.out.println("> > (1) Display Vending Machine Items > (2) Purchase > (3) Exit >\n");
		
	}
	
	public void printPurchaseMenu (BigDecimal balance) {
		System.out.println("\n>>(1) Feed Money >(2) Select Product >(3) Finish Transaction > Current Money Provided: "+ balance);
		
		
	}
	
}
