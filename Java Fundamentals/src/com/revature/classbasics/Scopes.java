package com.revature.classbasics;

public class Scopes {

	/*
	 * variable scopes refer to the lifetime of accessibility
	 * of a variable 
	 * 
	 * There are 4 scopes 
	 * 
	 * class/static  (vars, methods, nested classes) - accessible 
	 * from outside of the class without an instance
	 * ie. Class.x or Class.method();
	 * 
	 * Regarding static variables, these values are shared throughout
	 * any instances of the class 
	 * class Test{ static int count = 0; }
	 * 
	 * from outside Test:
	 * 
	 * Test c = new Test();
	 * Test c2 = new Test();
	 * c.count = 10;
	 * . then c2.count would also be 10;
	 * 
	 * object/instance - the particular instance of the object's 
	 * state and behavior
	 * Class c = new Class();
	 * c.x; or c.method();
	 * 
	 * 
	 * method/local - parameters for method and any variable 
	 * declared within the method
	 * 
	 * block/loop - any variables defined in curly braces or
	 * in the () before a loop
	 */
	
	int instanceVar;
	static int staticInt;
	static Integer sInteger;
	static double sDouble;
	static float sFloat;
	static char sChar;
	static boolean bool;
	static Boolean sBool;
	
	
	public static void main(String[] args) {
		/*
		 * In order to access an instance method or variable from inside
		 * of a static method, we must instantiate the class within the
		 * class itself. From there we can access its instance fields.
		 */
		Scopes s = new Scopes();
		System.out.println(s.instanceVar);		// default value = 0
		System.out.println(staticInt);			// default value = 0
		int methodScope;
//		System.out.println(methodScope); // won't compile because not initialized
		//default values
		System.out.println(sInteger);	//null
		System.out.println(sDouble);	//0.0
		System.out.println(sFloat);		//0.0
		System.out.println(sChar);		//""
		System.out.println(bool);		//false
		System.out.println(sBool);		//null
		
		
		
	}
	
}

