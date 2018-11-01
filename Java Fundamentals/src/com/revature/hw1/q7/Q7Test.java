package com.revature.hw1.q7;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q7Test {

	Employee e1;
	Employee e2;
	Employee e3;
	ArrayList<Employee> eList;
	SortByName sortName;
	SortByDepartment sortDept;
	SortByAge sortAge;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		eList = new ArrayList<Employee>();
		sortName = new SortByName();
		sortDept = new SortByDepartment();
		sortAge = new SortByAge();
		
		e1 = new Employee("Sherry", "Trainer" , 20);
		e2 = new Employee("Margy", "Associate", 24);
		e3 = new Employee("Margy", "Associate", 24);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// Should create new test methods for different asserts...
		assertTrue(sortName.compare(e1, e2) > 0);
		assertTrue(sortDept.compare(e1, e2) > 0);
		assertTrue(sortAge.compare(e1, e2) < 0);	
	}

	@Test
	public void testForEquality() {
		assertTrue(sortName.compare(e3, e2) == 0);
		assertTrue(sortDept.compare(e3, e2) == 0);
		assertTrue(sortAge.compare(e3, e2) == 0);	
	}

}
