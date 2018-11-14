package com.revature.service;

import java.util.ArrayList;

import com.revature.pojos.User;

public class DummyUserService {

	/*
	 * 	Dummy service later with an in memory store of users
	 */
	
	static ArrayList<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("Margy", "123", "My data"));
		users.add(new User("Sample", "456", "Sample data"));
		users.add(new User("Test", "789", "Test data"));
	}
	
	//get all users
	public ArrayList<User> getUsers(){
		return users;
	}
	
	//get by username
	private User getByUsername(String name) {
		/* Could use enhanced for loop... Or...
		for(User u: users) {
			if(u.getUsername().equals(name)) {
				return u;
			}
		}
		*/
		
		// OR COULD USE STREAMS
		User u = users.stream()	// turns users into a stream
				.filter(x -> x.getUsername().equalsIgnoreCase(name))		// test from Predicate Functional Interface
				.findAny()
				.orElse(null);
		return u;
	}
	
	
	//validate password by username
	public User validateUser(String name, String password) {
		User u = getByUsername(name);
		if(u == null) return null;
		else if(u.getPassword().equals(password)) return u;		// Only case where user is successfully logged in
		else return null;
	}
	
}
