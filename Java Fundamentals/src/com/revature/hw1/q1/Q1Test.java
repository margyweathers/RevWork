package com.revature.hw1.q1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q1Test {

	
	
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
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		int[] sorted = {0,1,2,3,3,4,5,6,7,8,9};
		assertTrue(Arrays.equals(sorted, Q1.bubbleSort(array)));
		
	}

}
