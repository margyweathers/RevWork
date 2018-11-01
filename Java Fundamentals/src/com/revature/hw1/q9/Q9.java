package com.revature.hw1.q9;

import java.util.ArrayList;
import java.util.Iterator;

public class Q9 {


	public static void main(String[] args) {

		// number of ints to store
		int n = 100;
		System.out.println(primeString(n));
	}
	
	static String primeString(int n) {
		// Create ArrayList of 1 - n. Must use wrapper class
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		// Print prime numbers in class
		StringBuilder sb = new StringBuilder("");
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			int i = itr.next();		// Auto-unboxing
			if(isPrime(i)) {
//				System.out.print(i + " ");				// Could print numbers out directly
				sb.append(i + " ");
			}
		}
		String primes = sb.toString();
		primes = primes.trim();
		
		return primes;
	}

	
	static boolean isPrime(int n) {
		// By definition, primes must be greater than 1
		if(n <= 1) return false;

		// Standard procedure
		boolean prime = true;
		for(int i = 2; i <= n/2; i++) {
			if (n%i == 0) {
				prime = false;
				break;
			}
		}

		return prime;
	}

}
