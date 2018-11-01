package com.revature.hw1.q1;
import java.util.Arrays;

public class Q1 {

	public static void main(String[] args) {
		// Example int array
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		// Sort array and print
		bubbleSort(array);
		System.out.println(Arrays.toString(array));

	}


	static int[] bubbleSort(int[] array) {
		// Declare useful variables
		int temp;
		boolean didSwap = true;

		// Perform bubble sort
		// Outer loop passes through array until swaps are no longer necessary
		while(didSwap == true){
			didSwap = false;
			//Iterate through array
			for (int i = 0; i < (array.length-1); i++){
				if(array[i] > array[i+1]){
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					didSwap = true;
				}			
			}
		}
		
		return array;
	}

	
}
