package com.revature.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UnderstandingExceptions {

	public static void main(String[] args) throws MyException {

		throwCustomAgain();
		
	}

	static void test() throws IOException{
		try {
			int x = 2 + 2;
			throw new IOException();
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}

		//unreachable code
		/*	catch(NumberFormatException nfe) {
			nfe.printStackTrace();
		}*/
	}



	static void tryWithResourcesExample() {
		//to write to file, we use bufferedwriter and filewriter
		String filename = "test";
		/*
		 * Try-With-Resources, added to the Java API since 1.7
		 * is intended to avoid need for finally block to close 
		 * resources. This can ONLY be implemented with objects
		 * that implement the AutoCloseable interface
		 * 
		 * "parameterized try block in which the parameters are 
		 * resources that implement the AutoClosable interface"
		 */
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
				BufferedReader br = new BufferedReader(new FileReader(filename));
				) {
			bw.write("this would write to my file if i had a file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void throwingCustom()throws MyException {
		//risky code
		//something goes wrong
		throw new MyException("hey this is an exception message");
	}

	static void throwCustomAgain() throws MyException{
		throw new MyException();
	}
}








