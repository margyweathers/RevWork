package com.revature.hw1.q6;

public class Q6 {

	public static void main(String[] args) {
		// Number of type Integer
		Integer n = 12;
		System.out.println(isEven(n));

	}

	static boolean isEven(int n) {
		// Convert Integer into binary String
		String s = Integer.toBinaryString(n);
		
		// If the last character of the binary String is 0, then the number is even (true). 0 is even.
		// Else last character is 1 and the number is odd (false)
		return s.charAt(s.length()-1) == '0';		
	}
}
