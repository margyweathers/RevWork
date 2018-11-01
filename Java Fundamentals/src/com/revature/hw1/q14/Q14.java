package com.revature.hw1.q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Q14 {

	public static void main(String[] args) {
		
		// Random number 0-10,000 for possible sqrt
		int n = (int) (Math.random() * 10000);
		double squareRoot;	// Declare outside of switch
		
		// String to store date
		String dateString;
		
		// String to split
		String s = "I am learning Core Java";
		// Choose delimeter
		String delim = " ";
		// Array to store split string
		String[] words;
		
		// Random case number between 1 and 3
		int c = (int) (1 + Math.random() * 3);
		
		// Switch statement
		switch(c) {
		case 1:
			System.out.print("Case 1: The square root of " + n + " is ");
			squareRoot = Math.sqrt(n);
			System.out.println(squareRoot);
			break;
		case 2:
			System.out.print("Case 2: Today's date is ");
			dateString = printDate();
			System.out.println(dateString);
			break;
		case 3:
			System.out.print("Case 3: ");
			words = splitString(s, delim);
			System.out.println(Arrays.toString(words));
		}		
		
	}
	
	
	static String printDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // SimpleDateFormat extends dateFormat
		Date date = new Date();
//		System.out.println(dateFormat.format(date));
		return dateFormat.format(date);
	}
	
	static String[] splitString(String s, String delim) {
		String[] words = s.split(delim);		
		return words;
	}
	

	
}
