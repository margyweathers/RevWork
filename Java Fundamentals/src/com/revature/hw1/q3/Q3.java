package com.revature.hw1.q3;

public class Q3 {

	public static void main(String[] args) {
		// String to reverse
		String s = "String";
		s = reverse(s);
		System.out.println(s);
	}
	
	static String reverse(String s){
		// Convert String into char Array and create an empty reversed String
		char[] charArray = s.toCharArray();
		String rev = "";
		// Update reverse String letter by letter
		for(int i = charArray.length-1; i >= 0; i--){
			rev += charArray[i];						// Could also use a StringBuilder
		}
		
		return rev;
	}
	
}
