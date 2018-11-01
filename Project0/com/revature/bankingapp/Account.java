package com.revature.bankingapp;

public abstract class Account {
	
	private double balance;

	public double withraw(double amount) throws InsufficientFundsException {
		if (amount > balance) {
			throw new InsufficientFundsException();
		}
		if (balance - amount < 10) {
			System.out.println("Warning: You now have less than $10 in your account");
		}
		
		balance -= amount;
		return balance;
	}
	
	public double deposit(double amount) {
		
		return balance += amount;
	}
	
	public double checkBalance(Account a) {
		
		return balance;
	}
	
	public void transfer(Account a, double amount) throws InsufficientFundsException {
		if (amount > balance) {
			throw new InsufficientFundsException();
		}
		balance -= amount;
		a.deposit(amount);
	}
	
	
	
}
