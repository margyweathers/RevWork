package com.revature.hw1.q13;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q13Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int n = 4;
		String expected = "0 \n" + 
				"1 0 \n" + 
				"1 0 1 \n" + 
				"0 1 0 1 ";
		assertEquals(expected, Q13.printPattern(n));

	}

}
