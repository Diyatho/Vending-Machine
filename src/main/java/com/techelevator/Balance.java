package com.techelevator;

import java.math.BigDecimal;

public class Balance {
	
	private BigDecimal balance;
	private int giveChange;
	private int feedMoney;
	private double dollars;
	private double cents;
	private int totalCoins;
	private int nickels = 0;
	private int dimes = 0;
	private int quaters = 0;
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public Balance() {
		balance = BigDecimal.ZERO;
	}
	
	
	public double getDollars() {
		return dollars;
	}

	public double getCents() {
		return cents;
	}

	public void feedMoney() {

		System.out.println("Please Feed The Money $1, $2, $5, $10, or $20");

	}

	public boolean isValidAmount(String amountCheck) {
		return amountCheck.equals("1") || amountCheck.equals("2") ||
				amountCheck.equals("5") || amountCheck.equals("10") ||
				amountCheck.equals("20");
	}
	
		
public BigDecimal updateBalance(BigDecimal inputMoney) {
	balance =  balance.add(inputMoney);
	return balance;
}
				
	

public void giveChange (){

	
	while (totalCoins > 0) {
	
	if (totalCoins >=25) {
		quaters ++;
		totalCoins -=25;
	}
	else if (totalCoins >= 10) {
		dimes ++;
		totalCoins -=10;
	}
	else if(totalCoins >= 5) {
		nickels ++;
		totalCoins -=5;
	}
	}
	System.out.println ("Total Change: " +quaters + "Quaters, " + dimes + "Dimes, " + nickels + "Nickles,");
	}
	}
	


