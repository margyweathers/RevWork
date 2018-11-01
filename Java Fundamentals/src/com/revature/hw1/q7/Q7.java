package com.revature.hw1.q7;

import java.util.ArrayList;
import java.util.Collections;

public class Q7 {
	
	public static void main(String[] args) {
		
		// Create list of Employees to sort
		ArrayList<Employee> eList = new ArrayList<Employee>();
		eList.add(new Employee("Sherry", "Trainer" , 20));
		eList.add(new Employee("Margy", "Associate", 24));
		// Print unsorted list
		System.out.println("Unsorted: " + eList + "\n");
		
		// Collections.sort([list to be sorted],[instance of comparator])
		// Sort by name
		Collections.sort(eList, new SortByName());
		System.out.println("Sorted by name: " + eList);
		// Sort by dept
		Collections.sort(eList, new SortByDepartment());
		System.out.println("Sorted by Department: " + eList);
		// Sort by age
		Collections.sort(eList, new SortByAge());
		System.out.println("Sorted by age: " + eList);
		
		
		
		
	}

}
