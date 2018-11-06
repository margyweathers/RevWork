package com.revature.bankingapp.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.bankingapp.pojos.Account;

public class AccountTransactions {

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
				withdraw(acc);
			}
			else {
				double newBalance = acc.withraw(amount);
				System.out.println("You just withdrew " + amount + "from your account.");
			}			
		} catch(InputMismatchException e) {
			System.out.println("Please enter a valid dollar an/or cents amount");
			withdraw(acc);
		} catch (InsufficientFundsException e) {
			System.out.println("You do not have enough funds in your account for this transaction. Please try again.");
			withdraw(acc);
		}
		return acc;
	}

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
				deposit(acc);
			}
			else {
				double newBalance = acc.deposit(amount);
				System.out.println("You just deposited " + amount + "from your account.");
			}			
		} catch(InputMismatchException e) {
			System.out.println("Please enter a valid dollar an/or cents amount");
			deposit(acc);
		}		
		return acc;
	}
	
	
	
	
	public static double round(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}


}
