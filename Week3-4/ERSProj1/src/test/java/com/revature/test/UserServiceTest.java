package com.revature.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.proj1.DAO.UserDao;
import com.revature.proj1.pojos.User;
import com.revature.proj1.service.UserService;

public class UserServiceTest {
	private static Logger log = Logger.getLogger(UserServiceTest.class);
	UserService us;
	
	@Before
	public void setUp() throws Exception{
		us = new UserService();
	}
	
	@After
	public void tearDown() throws Exception{
		us = null;
	}

	@Test
	public void test() {
		List<String> emails = us.getAllEmails();
		for (String e : emails) {
			log.debug(e);
		}
		assertNotNull(emails);
		assertFalse(emails.size() == 0);
	}

}
