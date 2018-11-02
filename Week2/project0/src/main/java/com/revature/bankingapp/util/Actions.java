package com.revature.bankingapp.util;

import java.util.Scanner;

import com.revature.bankingapp.pojos.User;

public class Actions {

	// Create account with username, pw, firstname, lastname
	public static User createUser() {	
		Scanner in = new Scanner(System.in);
		String username;
		String password = null;
		String first = null;
		String last = null;

		// Get first and last names
		System.out.println("Enter your first name: ");
		while(in.hasNextLine()) {
			first = in.nextLine();
			if (!first.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")) {
				System.out.println("Names must only contain an alphabetical character or hyphen\n+"
						+ "Please enter a valid first name: ");
			}
			else break;
		}
		System.out.println("Enter your last name: ");
		while(in.hasNextLine()) {
			first = in.nextLine();
			if (!first.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")) {
				System.out.println("Names must only contain an alphabetical character or hyphen\n"
						+ "Please enter a valid last name: ");
			}
			else break;
		}

		// USERNAME VALIDATION
		System.out.println("Enter a username: ");
		String userInput = in.nextLine();
		// IF THE USERNAME DOES NOT ALREADY EXIST:
			// getAllUsernames. (what happens when returned list is null?)
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
		in.close();
		return new User(username, password, first, last);			
	}



}
