package com.revature.hw1.q14;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q14_2Test {
	
	Q14_2 q;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		q = new Q14_2();
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testCase1() {
		q.performSwitch(1);
		assertEquals(8, (int) q.getSquareRoot());
	}

	@Test
	public void testCase3() {
		q.performSwitch(3);
		String[] words = {"I", "am", "learning", "Core", "Java"};
		assertTrue(Arrays.equals(words, q.getWords()));
	}
}
