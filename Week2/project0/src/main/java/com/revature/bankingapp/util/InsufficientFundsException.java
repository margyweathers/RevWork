package com.revature.bankingapp.util;

public class InsufficientFundsException extends Exception {

	public InsufficientFundsException() {
		super("You have insufficient funds for this transaction.");
	}
	public InsufficientFundsException(String message) {
		super(message);
	}
}
