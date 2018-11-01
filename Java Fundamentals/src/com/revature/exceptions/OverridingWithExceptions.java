package com.revature.exceptions;

import java.io.CharConversionException;
import java.io.IOException;

public class OverridingWithExceptions extends UnderstandingExceptions{
	/*
	 * An overriding method can throw any unchecked exceptions, 
	 * regardless of whether the overridden method throws exceptions
	 * or not. However, the overriding method should not throw 
	 * checked exceptions that are NEW OR BROADER than the ones 
	 * declared by the overridden method.
	 */
	
	//DOES NOT COMPILE
//	static void test() throws Exception{	}
	
	//WILL COMPILE - CAN THROW MORE SPECIFIC CHECKED EXCEPTIONS
	static void test() throws CharConversionException{		
	}
	
	//WILL COMPILE - CAN THROW ANY RUNTIMEEXCEPTIONS
//	static void test() throws IOException, NumberFormatException{	}

}
