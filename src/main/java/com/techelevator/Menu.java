package com.techelevator;

import java.math.BigDecimal;

import com.techelevator.Balance;
import com.techelevator.Inventory;

public class Menu {

	public void printMainMenu (){
		System.out.println("> > (1) Display Vending Machine Items > (2) Purchase > (3) Exit >");
		
	}
	
	public void printPurchaseMenu (BigDecimal balance) {
		System.out.println(">>(1) Feed Money >(2) Select Product >(3) Finish Transaction > Current Money Provided: "+ balance);
		
		
	}
	
}
