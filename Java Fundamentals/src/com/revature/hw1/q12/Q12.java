package com.revature.hw1.q12;

public class Q12 {

	public static void main(String[] args) {
		
		// Number of items to store
		final int N = 100;
		
		// Instantiate and initialize array
		int[] nums = new int[N];
		for(int i = 1; i <= N; i++) {
			nums[i-1] = i; 
		}
		
		// Enhanced for loop to print out even #'s
		for(int x : nums) {
			if (x % 2 == 0) {
				System.out.print(x + " ");
			}
		}
		
		
	}
}
