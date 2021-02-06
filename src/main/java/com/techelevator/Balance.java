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
	private int quarters = 0;
	Log log = new Log();

	public BigDecimal getBalance() {
		return balance;
	}

	public Balance() {
		balance = BigDecimal.ZERO;
	}

	public void setBalance(BigDecimal currentBalance) {
		this.balance = currentBalance;
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
		return amountCheck.equals("1") || amountCheck.equals("2") || amountCheck.equals("5") || amountCheck.equals("10")
				|| amountCheck.equals("20");
	}

	public BigDecimal updateBalance(BigDecimal inputMoney) {
		balance = balance.add(inputMoney);
		log.createLogEntry("FEED MONEY:",inputMoney, balance);
		return balance;
	}

	public void giveChange() {

		int totalCoins = balance.intValue() * 100;

		while (totalCoins > 0) {

			if (totalCoins >= 25) {
				quarters++;
				totalCoins -= 25;
			} else if (totalCoins >= 10) {
				dimes++;
				totalCoins -= 10;
			} else if (totalCoins >= 5) {
				nickels++;
				totalCoins -= 5;

			}
		}
		System.out.println("Total Change: " + quarters + "Quarters, " + dimes + "Dimes, " + nickels + "Nickels,");
		log.createLogEntry("GIVE CHANGE:", balance, BigDecimal.ZERO);
		
		balance = BigDecimal.ZERO;
	}
}
