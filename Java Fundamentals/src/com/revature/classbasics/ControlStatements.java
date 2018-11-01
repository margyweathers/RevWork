package com.revature.classbasics;

public class ControlStatements {

	public static void main(String[] args) {
		
		// int[row][col] ??
		int[][] twoD = new int[4][5]; // Arrays are NOT dynamically sized
		
		// FOR EACH ("enhanced for loops") - at runtime, get converted behind the scenes to a regular
		// for loop used to iterate over arrays or collections
		String[] strings = {"string 1", "string 2", "string 3 "};
		for(String s : strings){
			s.replaceAll(" ", "--");
			System.out.println(s);
			System.out.println(s.replaceAll(" ", "--"));
			
		}
		
		// DO WHILE		
		int x;
		do {
			x=1;
			x++;
		}
		while(x<10);
		
		// SWITCH: use only for discrete options
		//		can only use prims that can be cast to an int (short, byte, char).
		//		can use enums and Strings
		// 		so can use: byte, short, char, int
		//					Byte, Short, Character, Integer
		//					Enums(enumerations, special characters)
		//					Strings
		int fromUser = 2;
			/*
			 * Will print:	2
			 * 				10
			 * 				default
			 */
		switch(fromUser){
		case 1:
			System.out.println("1");
			break;
		//	System.out.println("unreachable");	// Unreachable code does not compile
		case 2:
			System.out.println("2");
		case 10:
			System.out.println("10");
		default: System.out.println("default");
		}
		
		
		

	}
}

