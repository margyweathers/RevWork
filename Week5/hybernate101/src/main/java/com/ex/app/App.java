package com.ex.app;

import java.util.List;

import com.ex.dao.UserDao;
import com.ex.models.User;

// NOTES IN GIT

public class App {

	static UserDao dao = new UserDao();
//	static PostDao postDao = new PostDao();
	
	public static void main(String[] args) {
	
//		System.out.println("Retrieving user of id 50 with GET");
//		User u50 = dao.getById(50);
//		System.out.println("User with get: " + u50.toString());
		
		User u = dao.findByUsername("ter");
		System.out.println(u);
		
		}
	
	static void testingSave() {
		User u1 = new User("username", "password", "firstname", "lastname");
		User u2 = new User("mweathers", "pass", "Margy", "Weathers");
		User u3 = new User("test", "123", "Test", "User");
		
		dao.save(u1);
		dao.save(u2);
		dao.save(u3);				
	}
	
		

	}


