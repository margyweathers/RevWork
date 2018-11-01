/**
 * 
 */
package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Margy
 *
 */
public class MethodsTest {

	// Create instance of your class
	Methods m;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		m = new Methods();
		System.out.println("Setting up instance before test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		// deallocating space
		m = null;
		System.out.println("In tearDown");
	}

	@Test
	public void test() {
		// will call add(5,5)
		int expected = 10;
		int actual = m.add(5, 5);
		assertEquals(expected, actual);
		assertEquals(0, m.add());
		assertEquals(15, m.add(1, 9, 2, 3));
	}
	
	@Test
	public void test2(){
		assertEquals(true, m.isPalindrome("racecar"));
	}

}
