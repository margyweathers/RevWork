package com.revature.designpatterns;

public class DessertFactory {
	/*
	 * The factory design pattern is a pattern which 
	 * creates objects where the precise type may not 
	 * be known until runtime (create a reference to a
	 * parent class or interface but instantiate with 
	 * the particular implementing class based on some 
	 * sort of user input)
	 * 
	 * To make a factory we need:
	 * - abstract data type
	 * - classes which inherit the abstract data type
	 * - static method that returns a concrete instance
	 * of the abstract data type
	 */
	
	public static Dessert getDessert(String type) {
		switch(type) {
		case "cake":
			return new Cake();
		case "cookie":
			return new Cookie();
		case "brownie":
			return new Brownie();
		default:
			throw new DessertNotFoundException();
		}
	}
}

//Good practice to throw an exception if the desired concrete class is not found
class DessertNotFoundException extends RuntimeException{}

//abstract type
interface Dessert{
	String makeMe();
}

class Cake implements Dessert{

	@Override
	public String makeMe() {
		return "bake a cake with lots of sugar and things";
	}
}

class Cookie implements Dessert{

	@Override
	public String makeMe() {
		return "chocolate chip";
	}
}

class Brownie implements Dessert{

	@Override
	public String makeMe() {
		return "yum";
	}
	
}