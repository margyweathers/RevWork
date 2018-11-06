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
		System.out.println("How much would you like to withdraw?"
				+ "/n$: ");
		try {
			amount = in.nextDouble();
			amount = round(amount);
			System.out.println(amount);
			System.exit(0);
		} catch(InputMismatchException e) {
			System.out.println("Please enter a valid dollar an/or cents amount");
			withdraw(acc);
		}
		
		
		return null;
	}
	
	
	public static double round(double value) {
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	

}
