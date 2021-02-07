package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SalesReport {
	
	private BigDecimal grossSales;
	Map<String, Integer> salesReport = new HashMap<>();
	
	public SalesReport() {
		grossSales = BigDecimal.ZERO;
	}
	//while the inventory is restocked, the map is created with quantity initialized to 0
	public void addToSalesMap(String itemName, int quantity) {
		salesReport.put(itemName,Integer.valueOf(quantity));
	}
	
	public void printMap() {
		for(String key: salesReport.keySet()) {
			System.out.println(key + "|" + salesReport.get(key));
		}
	}	
	//File inputFile = new File("SalesReport.txt");
	
	public void update(String itemName, BigDecimal itemPrice) {
		
		//increment the quantity (value) by 1
		if(salesReport.containsKey(itemName)) {
			System.out.println("Incrementing quantity in map");
			Integer currentValue = salesReport.get(itemName);
			currentValue++;
			System.out.println("quantity now :" + currentValue);
			salesReport.put(itemName, currentValue);
			System.out.println("updating map :" + itemName + ": " + salesReport.get(itemName));
		}
		
		//increase gross sales by the price of the item that just got sold
		grossSales = grossSales.add(itemPrice);
		
	}
	
	
	public void writeSalesReport() {
		File myFile = new File("SalesReport.txt");
		try {
			myFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(PrintWriter writer = new PrintWriter(myFile)){ 
			
			for(String key : salesReport.keySet()) {
				writer.println(key + "|" + salesReport.get(key));
			}
			writer.println("TOTAL SALES : $"+ grossSales);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}





}
