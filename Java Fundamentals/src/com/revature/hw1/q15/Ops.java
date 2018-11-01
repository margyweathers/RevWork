package com.revature.hw1.q15;

// Implementing class
public class Ops implements Operations {
	

	public int addition(int a, int b) {
		return a+b;
	}

	public double addition(double a, double b) {
		return a+b;
	}

	public int subtraction(int a, int b) {
		return a-b;
	}

	public double subtraction(double a, double b) {
		return a-b;
	}

	public int multiplication(int a, int b) {
		return a*b;
	}

	public double multiplication(double a, double b) {
		return a*b;
	}

	public int division(int a, int b) throws ArithmeticException {
		if (b == 0) {
			throw new ArithmeticException();
		}	
		return a/b;
	}

	public double division(double a, double b) throws ArithmeticException {
		if (b == 0) {
			throw new ArithmeticException();
		}
		return a/b;
	}
	
	// Op's own method
	public int mod(int a, int b) {
		return a%b;
	}

}
