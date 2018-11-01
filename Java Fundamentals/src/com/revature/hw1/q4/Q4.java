package com.revature.hw1.q4;

public class Q4 {

	public static void main(String[] args) {

		int n = 10;
		long nFactorial = factorial(n);
		System.out.println(nFactorial);
	}
	
	static long factorial(int n){
		// If n is negative, find factorial of positive
		if (n < 0) {
			System.out.println("Cannot calculate factorial of a negative number. Calculating factorial for "
					+ "corresponding positive.");
			n = Math.abs(n);
		}
		
		// 0! = 1 by convention.
		long f = 1;
		for(int i = 1; i <= n; i++){
			f *= i;
		}
		
		return f;
	}
	
}
