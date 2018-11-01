/**
 * 
 */
package com.revature.bankingapp;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Margy
 * 
 */
public class User {
	
	private String username;
	private String email;
	private String pw;
	private ArrayList<Account> accounts;
	
	public User(String username, String email, ArrayList<Account> accounts) {
		super();
		this.username = username;
		this.email = email;
		this.accounts = accounts;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	public void addAccount(Account a) {
		accounts.add(a);
	}
	
	public boolean removeAccount(Account a) {
		// Validate that account exists? Probably do that elsewhere...
		// Validate that the user still has accounts? 
		
		Iterator<Account> itr = accounts.iterator();
		while(itr.hasNext()) {
			if (itr.next().equals(a)) {
				itr.remove();
				return true;
			}
		}
		
		return false;
	}
	
	public boolean changePw(String p) {
		if(p.equals(pw)) {
			System.out.println("You provided the same password");
			return false;
		}
		
		// pw strength??
		
		pw = p;
		return true;
	}
	
	

}
