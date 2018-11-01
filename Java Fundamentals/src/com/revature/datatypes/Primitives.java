package com.revature.datatypes; // Package name is 1st line of every class

public class Primitives {

	// DELCARE primitive variables
	int a; 		//number type - 4 bytes
				//default = 0
	boolean b; 	// T or F
	char c; 	// 2 bytes
	double d;	// decimal type - 8 bytes - more precise than float
	long e;		// large number - 8 bytes
	float f;	// floating decimal - 4 bytes
	short g;	// small numbers - 2 bytes
	byte h;		// 1 byte (8 bits: 00000000)
	
	public static void test(){
		int x = 5; // INITIALIZE variable
		// int x = 10; can't redeclare variable in the same scope
		int largeNumber = 100_000_000;
		short smallNumber = (short) largeNumber; // Casting: changing reference type of object
												// large --> small = Explicit Casting
												// If you try to fit 3 bytes into a 2-byte type you lose precision
		long bigNumber = smallNumber; 			// small --> large: Implicit Casting
		long hugeNumber = 1000000000000000000L;	// must indicate it's a long with 'L' (if it's out of int range)
		long longNumber = 100;
		System.out.println(longNumber);
		
		//INSTANTIATE:
		String hello = new String("hello");
		
		//WRAPPER CLASSES: classes that give object functionality to primitives
		//can be initialized via boxing or instantiation
		Integer wrapInt = x; // boxing int x into it's wrapper class
		Character wrapChar = 'a';
		Float wrapFloat = new Float(99.01);
		float flo = wrapFloat; // unboxing wrapper class value into primitive value
		
		// Double testDouble = (Double) wrapFloat		incompatible types
		double testd = 10.0;
		float t = (float) testd;	// primitive casting is more flexible than object casting
		
		// Binary
		int base2 = 0b101;
		int binary = 0B10101; 		//0b or 0B
		System.out.println(base2);
		//Octal
		int base8 = 01274;
		//Hexadecimal: 0-9, a-f
		int base16 = 0x10bc34;
		System.out.println(base16);
		
	}
	
	public static void main(String[] args) {
		test();
	}
	
}
