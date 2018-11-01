package com.revature.hw1.q5;

public class Q5 {
	
	public static void main(String[] args) {
		
		// Perform and check output
		System.out.println(sub("String", 4));
	}
	
	static String sub(String str, int idx){
		// If index is 0 or negative. (If program were to take user input, should check that idx is a whole number)
		if (idx <= 0) {
			System.out.println("Index must be positive non-zero integer.");
			System.exit(0);     			// Not good practice... 
		}
		// If index is greater than string length
		if (idx > str.length()) {
			System.out.println("Index must be less than or equal to the string length.");
			System.exit(0);
		}
	
		// Create substring
		char[] charArray = str.toCharArray();
		String subString = "";
		for(int i = 0; i < idx; i++){
			subString += charArray[i];
		}
		
		return subString;
	}

}
