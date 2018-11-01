package com.revature.oop;

public class MultipleInheritance extends C implements A, B{
	/*
	 * Methods in interfaces are implicitly public and 
	 * abstract. In order to implement methods in interfaces
	 * you must apply the default keyword
	 * 
	 * Implementing two methods with the same default method
	 * will make your class not compile unless you override
	 * the method in question within the class
	 */
	
	public static void main(String[] args) {
		MultipleInheritance m = new MultipleInheritance();
		m.test();
	}

	@Override //not necessary but restricts method to follow overriding rules-9
	public void doAThings() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test() {
		System.out.println("Overriding the interface's default method");
		A.super.test();
	}

	@Override
	public void doBThings() {
		// TODO Auto-generated method stub
		
	}

}

interface A{
	void doAThings();
	default void test() {
		System.out.println("I am the test method of interface A");
	}
}

interface B{
	void doBThings();
	default void test() {
		System.out.println("I am the test method of interface B");
	}
}

abstract class C{
	
}
