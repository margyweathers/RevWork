package com.revature.junit;

public class Methods {

	
	public int add(int... nums){
		/*
		 * VAR ARGS
		 * - variable number of arguments of a specific type
		 * - reference these args in the method as if it were an array
		 * - MUST be the last argument in a method
		 * - only allowed to have one var args per method
		 */
		
		int total = 0;
		for(int i : nums){
			total += i;
		}
		
		return total;
	}
	
	public boolean isPalindrome(String str){
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String newStr = sb.toString();
		if(str.equals(newStr)){
			return true;
		}
		else return false;		
	}
}
