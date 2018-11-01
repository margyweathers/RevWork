package com.revature.hw1.q2;
import java.util.Arrays;

public class Q2 {

	public static void main(String[] args) {
		// Number of Fibonacci numbers to display
		int n = 25;
		String fibString = fibonacci(n);
		// Display numbers
		System.out.println(fibString);
	}
	
	static String fibonacci(int n){
		int[] fib = new int[n];
		// Manually add first two elements
		fib[0] = 0;
		fib[1] = 1;
		for(int i = 2; i < n; i++){
			fib[i] = fib[i-1] + fib [i-2];
		}
		
		return Arrays.toString(fib);
	}
}
