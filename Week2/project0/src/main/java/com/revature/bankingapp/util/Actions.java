package com.revature.bankingapp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bankingapp.pojos.Account;
import com.revature.bankingapp.pojos.User;
import com.revature.bankingapp.service.AccountService;
import com.revature.bankingapp.service.UserService;

public class Actions {

	static UserService us = new UserService();
	static AccountService as = new AccountService();

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

	/**
	 *
	 * @param username
	 * @return True if the user exists in the database
	 */
	public static boolean userExists(String username) {
		List<String> usernames = us.getAllUsernames();
		if (usernames.contains(username)) return true;
		else return false;
	}

	/**
	 * Prompts the user to login
	 */
	public static User login() {
		User user = new User();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String username = null;
		while(in.hasNextLine()) {
			username = in.nextLine();
			boolean exists = Actions.userExists(username);					
			if (exists == false) {
				System.out.println("A user account with this username does not exist. Please enter an existing username: ");
			}
			else if (exists == true) {
				//Create User object from username and retrieve password
				user = us.getUserByUsername(username);
				String password = user.getPw();
				String input;
				System.out.println("Enter your password: ");
				while (in.hasNextLine()) {
					input = in.nextLine();
					if (!input.equals(password)) {
						System.out.println("You entered the wrong password. Please try again: ");
					}
					else {
						System.out.println("Hello " + user.getFirst() + "!");
						break;
					}
				}			
				break;
			}
		}
		in.close();
		return user;
	}

	public static void giveOptions(User user) {
		Scanner in = new Scanner(System.in);
		String userInput;
		int userId = user.getUsrId();
		List<Account> accounts = as.getAccountsByUserID(userId);

		// If user does not have any existing accounts
		if (accounts == null) {
			System.out.println("You don't have any active bank accounts. Would you like to create one? [y/n]");
			while(in.hasNext()) {
				userInput = in.nextLine();
				if( (userInput.equalsIgnoreCase("n")) || (userInput.equalsIgnoreCase("no")) ) {
					System.out.println("Okay, Goodbye!");
					System.exit(0);
				}
				else if ( (userInput.equalsIgnoreCase("y")) || (userInput.equalsIgnoreCase("yes")) ) {
					System.out.println("Let's create an account.");
				}
				else {
					System.out.println("Please enter [y] or [n]");
				}
			}
		}
		else {
			System.out.println("Select a transacion:"
					+ "\n[1] Withdrawal"
					+ "\n[2] Deposit"
					+ "\n[3] Transfer"
					+ "\n[4] View Balance"
					+ "\n[5] View All Transactions"
					+ "\n[6] Create Bank Account"
					+ "\n[7] Deactivate Account");
		}
	}





}
