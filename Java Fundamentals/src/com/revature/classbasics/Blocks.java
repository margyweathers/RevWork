package com.revature.classbasics;

public class Blocks {
	/*
	 * static blocks execute first
	 * non-static blocks execute when class is instantiated
	 */
	static{
		System.out.println("static block before main");
	}
	
	{
		System.out.println("non-static block before main");
	}
	
	public static void main(String[] args) {
		System.out.println("in main");
		Blocks b = new Blocks();
	}
	
	static{
		System.out.println("static block after main");
	}
	
	{
		System.out.println("non-static block after main");
	}
	
}
