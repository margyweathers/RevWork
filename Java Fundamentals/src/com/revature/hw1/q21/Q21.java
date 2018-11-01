package com.revature.hw1.q21;


public class Q21 {

	public static void main(String[] args) {
		String test = "rreeaaapearat";
		System.out.println(test);
		System.out.println(removeRepeatChars(test));
	}
	
	static String removeRepeatChars(String s) {
		char c;
		StringBuilder sb = new StringBuilder("");
		// Traverse through string
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			// If the char exists before the index, it has already been appended to sb. Continue to next char
			if(s.indexOf(c) < i) {
				continue;
			}
			// Else c is a new character. Append to sb
			sb.append(c);
		}
		
		return sb.toString();
	}
}
