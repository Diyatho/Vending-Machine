package com.techelevator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Application {

	public static void main(String[] args) {

		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.stockInventory();
		InputConsole inputConsole = new InputConsole(vendingMachine);
		inputConsole.getUserInput();
		System.out.println("Exiting Application...");

	}

}
