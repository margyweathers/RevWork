package com.revature.hw1.q8;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q8Test {

	ArrayList<String> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<String>();
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("sexes");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("madam");
		expected.add("civic");
		expected.add("radar");
		expected.add("sexes");
		expected.add("kayak");
		expected.add("refer");
		expected.add("did");
		
		assertEquals(expected, Q8.palindromeList(list));
		
	}

}
