package com.revature.hw1.q16;

public class Q16 {

	static int numChars;	// for test case
	
	public static void main(String[] args) {
		
		try {
			String input = args[0];
			numChars = input.length();
			System.out.println("Number of characters in [" + input + "] is: " + numChars);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Did not provide command line arguments.");
		}
	
	}
	
}
