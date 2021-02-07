package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Log {
	Queue<String> logEntries = new LinkedList<>(); 
	
	public void createLogEntry(String action, BigDecimal arg1, BigDecimal arg2) {
		String logEntry = "";
		 //Date
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		 Date date = new Date();  
		 //System.out.println(formatter.format(date)); 
		 String dateForLog = formatter.format(date);

		//time
		String pattern = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(pattern);
	    LocalTime now = LocalTime.now();
	   // System.out.println(now.format(DateTimeFormatter.ofPattern(pattern)));
	    String timeForLog = now.format(DateTimeFormatter.ofPattern(pattern));
	    //to print 5 as 5.00
	    logEntry = dateForLog + " " + timeForLog + " "+ action +  " $" + arg1.setScale(2, BigDecimal.ROUND_HALF_UP) + " $" + arg2.setScale(2, BigDecimal.ROUND_HALF_UP);
	    System.out.println("\nEntering in log: " + logEntry + "\n");
	    logEntries.add(logEntry);
	}
	
	public void writeLog() {
		File myFile = new File("log.txt");
		try {
			myFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(PrintWriter writer = new PrintWriter(myFile)){ 
			
			for(String logEntry : logEntries) {
				writer.println(logEntry);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
