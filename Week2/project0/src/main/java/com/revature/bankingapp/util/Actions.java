package com.revature.bankingapp.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.revature.bankingapp.pojos.User;
import com.revature.bankingapp.service.UserService;

public class Actions {

	static UserService us = new UserService();

	/**
	 * Create a new user account with username, password, first name, and last name entered by the user
	 * @return User
	 */
	public static User createUser() {	
		Scanner in = new Scanner(System.in);
		String username = null;
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
			else {
				first = first.substring(0, 1).toUpperCase() + first.substring(1);
				break;
			}
		}
		System.out.println("Enter your last name: ");
		while(in.hasNextLine()) {
			last = in.nextLine();
			if (!last.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")) {
				System.out.println("Names must only contain an alphabetical character or hyphen\n"
						+ "Please enter a valid last name: ");
			}
			else {
				last = last.substring(0, 1).toUpperCase() + last.substring(1);
				break;
			}
		}
		// USERNAME VALIDATION
		List<String> usernames = us.getAllUsernames();
		System.out.println("Enter a username: ");
		while (in.hasNextLine()) {
			username = in.nextLine();
			username = username.toLowerCase();		//	Store all usernames in the db as lower case
			if (usernames.isEmpty()) {				// If there are no users in the database
				break;
			}
			else if (username == null || username.isEmpty()) {
				System.out.println("Username must contain at least 1 character. Please enter a valid username: ");
			}
			else if (usernames.contains(username)) {
				System.out.println("Username already exists. Please enter a different username: ");
			}
			else break;	
		}
		// PASSWORD VALIDATION
		System.out.println("Enter a password: ");
		while(in.hasNextLine()) {
			password = in.nextLine();
			if (password == null || password.isEmpty()) {
				System.out.println("Password must contain at least 1 character. Please enter a valid password: ");
			}
			else {
				System.out.println("Re-enter password: ");
				if ( in.nextLine().equals(password) ) {
					break;
				}
				else {
					System.out.println("Passwords did not match\nEnter a password: ");
				}
			}
		}
		in.close();
		return new User(username, password, first, last);			
	}



}
