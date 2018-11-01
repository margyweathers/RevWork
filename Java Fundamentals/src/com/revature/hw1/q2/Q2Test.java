package com.revature.hw1.q2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q2Test {

	// Number of fib numbers
	int n;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		n = 25;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String expected = "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, "
				+ "10946, 17711, 28657, 46368]";
		assertEquals(expected, Q2.fibonacci(n));
		
	}

}
