package com.revature.exceptions;

public class MyException extends Exception {

	public MyException(){
		super("this is a custom exception");
	}
	
	//Can also do:
	public MyException(String message){
		super(message);
	}
}
