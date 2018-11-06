package com.revature.bankingapp.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.bankingapp.pojos.Account;
import com.revature.bankingapp.service.AccountService;

public class AccountTransactions {

	static DecimalFormat df = new DecimalFormat("#.00"); 
	static AccountService as = new AccountService();

	/**
	 * Withdraw
	 */
	public static Account withdraw(Account acc) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		double amount = 0;
		System.out.println("How much would you like to withdraw?");
		System.out.print("$");
		try {
			amount = in.nextDouble();
			amount = round(amount);
			if (amount <= 0) {
				System.out.println("You must enter a positive dollar amount.");
				acc = withdraw(acc);
			}
			else {
				double newBalance = acc.withraw(amount);
				System.out.println("You just withdrew $" + df.format(amount) + " from your account.");
			}			
		} catch(InputMismatchException e) {
			System.out.println("Please enter a valid dollar and/or cents amount");
			acc = withdraw(acc);
		} catch (InsufficientFundsException e) {
			System.out.println("You do not have enough funds in your account for this transaction. Please try again.");
			acc = withdraw(acc);
		}
		return acc;
	}

	
	/**
	 * Deposit
	 */
	public static Account deposit(Account acc) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		double amount = 0;
		System.out.println("How much would you like to deposit?");
		System.out.print("$");
		try {
			amount = in.nextDouble();
			amount = round(amount);
			if (amount <= 0) {
				System.out.println("You must enter a positive dollar amount.");
				acc = deposit(acc);
			}
			else {
				double newBalance = acc.deposit(amount);
				System.out.println("You just deposited $" + df.format(amount) + " to your account.");
			}			
		} catch(InputMismatchException e) {
			System.out.println("Please enter a valid dollar and/or cents amount");
			acc = deposit(acc);
		}		
		return acc;
	}

	
	/**
	 * Transfer
	 */
	public static void transfer(Account transTo, Account transFrom) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		double amount = 0;
		System.out.println("How much would you like to transfer?");
		System.out.print("$");
		try {
			amount = in.nextDouble();
			amount = round(amount);
			if (amount <= 0) {
				System.out.println("You must enter a positive dollar amount.");
				transfer(transTo, transFrom);
			}
			else {
				double newBalance1 = transFrom.withraw(amount);
				double newBalance2 = transTo.deposit(amount);
				as.updateAccount(transTo);
				as.updateAccount(transFrom);
				System.out.println("Transfer successful.");
			}			
		} catch(InputMismatchException e) {
			System.out.println("Please enter a valid dollar and/or cents amount");
			transfer(transTo, transFrom);
		} catch (InsufficientFundsException e) {
			System.out.println("You do not have enough funds in your account for this transaction.");
		}
	}


	/**
	 * View balance of account
	 */
	public static void viewBalance(Account acc) {
		double balance = acc.getBalance();
		System.out.println("Your current available balance is: $" + df.format(balance));
	}

	
	public static Account deActivateAccount(Account acc) {
		acc.setActive(0);	// 0 is inactive
		return acc;
	}
	
	

	/**
	 * Used to round to 2 decimal places
	 */
	public static double round(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}


}
