package com.revature.proj1.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.proj1.DAO.UserDao;
import com.revature.proj1.pojos.User;

public class UserService {
	
	static UserDao ud = new UserDao();
	
	/**
	 * 
	 * @param email
	 * @return User from DB. Null if no users with this email exist
	 */
	public User getUserByEmail(String email) {
		if (email == null) return null;
		User u = ud.findByEmail(email);
		return u;
	}
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @return User for corresponding email/password combo. Null if correct combination does not exist in DB.
	 */
	public User getUserByEmailPassword(String email, String password) {
		// Handle null inputs here or elsewhere?
		if (email == null || password == null) return null;
		User u = ud.findByEmailPassword(email, password);
		return u;
	}
	
	/**
	 * 
	 * @return list of all emails. Null if none exist in DB
	 */
	public List<String> getAllEmails(){
		List<String> emails = new ArrayList<String>();
		emails = ud.findAllEmails();
		return emails;
	}
	

}
