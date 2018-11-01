package com.revature.bankingapp;

import java.util.Scanner;

public class Actions {
	
	// Create account with username, email, pw
	public static User createUser() {
		
		Scanner in = new Scanner(System.in);
		String username;
		String password;
		String email;
		
		// USERNAME VALIDATION
		System.out.println("Enter a username: ");
		String userInput = in.nextLine();
		// IF THE USERNAME DOES NOT ALREADY EXIST:
		username = userInput;
		
		// PASSWORD VALIDATION
		System.out.println("Enter a password: ");
		while(in.hasNext()) {
			password = in.nextLine();
			System.out.println("Re-enter password: ");
			if ( in.nextLine().equals(password) ) {
				break;
			}
			else {
				System.out.println("Passwords did not match\nEnter a password: ");
			}
		}
		
		
		
		
		
		return null;
		
	}
	
	// 

}
