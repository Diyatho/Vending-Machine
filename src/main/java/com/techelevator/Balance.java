package com.techelevator;

public class Balance {
	
	private int giveChange;
	private int feedMoney;
	private double dollars;
	private double cents;
	private int totalCoins;
	private int nickels = 0;
	private int dimes = 0;
	private int quaters = 0;
	
	
	
	public double getDollars() {
		return dollars;
	}
	
	public double getCents() {
		return cents;
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
	


