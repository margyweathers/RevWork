package com.revature.hw1.q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Q14_2 {

	private double squareRoot;
	private String dateString;
	private String[] words;

	void performSwitch(int c) {
		switch(c) {
		case 1:
			int n = 64;
			squareRoot = Math.sqrt(n);
			System.out.println(squareRoot);
			break;
		case 2:
			dateString = printDate();
			System.out.println(dateString);
			break;
		case 3:
			words = splitString("I am learning Core Java", " ");
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
	
	
	
	public static void main(String[] args) {
		Q14_2 q = new Q14_2();
		
		q.performSwitch(1);
		System.out.println(q.squareRoot);
	}

	public double getSquareRoot() {
		return squareRoot;
	}

	public void setSquareRoot(double squareRoot) {
		this.squareRoot = squareRoot;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}
	
	
	
	
}


