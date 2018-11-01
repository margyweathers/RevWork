package com.revature.designpatterns;

public class Driver {
/*
 * Design patterns are established general solutions to commonly occurring software development problems
 * 
 * 
 */
	
	
	public static void main(String[] args) {
		singletonDemo();
	}
	
	static void singletonDemo() {
////		Singleton s1 = new Singleton(); // WILL NOT COMPILE because constructor is private
//		Singleton s1 = Singleton.getInstance();
//		s1.setName("first singleton instance");
//		Singleton s2 = Singleton.getInstance();
//		s2.setName("second singleton reference");		
//		System.out.println(s1.getName());
		
		Singleton.test();			// Anything static automatically loads
		LazySingleton.test();
		
		factoryDemo("cake");
		factoryDemo("brownie");
//		factoryDemo("not a desert"); 	// Throws exception
				
	}
	
	static void factoryDemo(String dessertType) {
		Dessert d = DessertFactory.getDessert(dessertType);
		System.out.println(d.makeMe());
	}
}
