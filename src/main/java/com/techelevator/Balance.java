package com.techelevator;

import java.math.BigDecimal;

public class Balance {

	public void feedMoney() {

		System.out.println("Please Feed The Money $1, $2, $5, $10, or $20");

	}

	public boolean isValidAmount(String amountCheck) {
		return amountCheck.equals("1") || amountCheck.equals("2") || amountCheck.equals("5") || amountCheck.equals("10")
				|| amountCheck.equals("20");
	}

	public void makeChange(BigDecimal balance) {
		int nickels = 0;
		int dimes = 0;
		int quarters = 0;

		int totalCoins = balance.multiply(BigDecimal.valueOf(100)).intValue();

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
		System.out.println("Total Change: " + quarters + " Quarters, " + dimes + " Dimes, " + nickels + " Nickels");
	}
}
