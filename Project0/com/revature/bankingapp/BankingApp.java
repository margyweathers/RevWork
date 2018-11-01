package com.revature.bankingapp;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp {

	// data bases
	static ArrayList<User> users = new ArrayList<User>();
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String userInput;
		
		// Welcome message
		System.out.println("Welcome to your online banking application!\n"
				+ "Do you have an existing account? [y/n]" );
		while(in.hasNext()) {
			userInput = in.next();
			if ( (userInput.equalsIgnoreCase("y")) || (userInput.equalsIgnoreCase("yes")) ) {
				// Go to login page
				System.out.println("then login");
				break;
			}
			else if( (userInput.equalsIgnoreCase("n")) || (userInput.equalsIgnoreCase("no")) ) {
				// Go to create account page
				System.out.println("then make an account");
				Actions.createUser();
				break;
			}
			else {
				System.out.println("Please enter [y] or [n]");
			}
		}
		
		
	}
	
	
	
	
	
}
