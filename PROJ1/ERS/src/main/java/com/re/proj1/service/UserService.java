package com.re.proj1.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.re.proj1.DAO.UserDao;
import com.re.proj1.pojos.User;

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
	
	public List<User> getAllUsers(){
		List<User> users = ud.findAll();
		return users;
	}
	
	public List<User> safeGetAllUsers(){
		List<User> users = ud.safeFindAll();
		return users;
	}
	
	public List<User> getAllUsersExcludeCurrent(int current){
		List<User> users = this.getAllUsers();
		User u = null;
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			u = itr.next();
			if (u.getUserId() == current || u.getApproved() == 0) {			// Remove current manager and unapproved employees
				itr.remove();
			}	
		}
		return users;
	}
	
	
	public List<User> getAllPendingUsers(){
		User u = null;
		List<User> users = new ArrayList<User>();
		List<User> all = this.getAllUsers();
		Iterator<User> itr = all.iterator();
		while (itr.hasNext()) {
			u = itr.next();
			if (u.getApproved() == 0) {
				users.add(u);
			}	
		}
		return users;
	}
	
	
	

}
