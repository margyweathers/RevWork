package com.revature.hw1.q8;

import java.util.ArrayList;
import java.util.Iterator;

public class Q8 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		    list.add("karan");
		    list.add("madam");
		    list.add("tom");
		    list.add("civic");
		    list.add("radar");
		    list.add("sexes");
		    list.add("jimmy");
		    list.add("kayak");
		    list.add("john");
		    list.add("refer");
		    list.add("billy");
		    list.add("did");
		    
		    System.out.println(palindromeList(list));
	}

	static ArrayList<String> palindromeList(ArrayList<String> list){
		ArrayList<String> pList = new ArrayList<String>();
		// Use iterator to traverse parameter list and create palindrome list
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			String s = itr.next();	
			if (isPalindrome(s)) {
				pList.add(s);
			}
		}
				
		return pList;
	}

	// Checks for Palindrome
	static boolean isPalindrome(String str){
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String newStr = sb.toString();
		if(str.equals(newStr)){
			return true;
		}
		else return false;		
	}
}
