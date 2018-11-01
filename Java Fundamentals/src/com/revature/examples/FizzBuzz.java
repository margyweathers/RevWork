package com.revature.examples;

public class FizzBuzz {

	public static void main(String[] args) {
		fizzBuzz(16);
	}
	
	static void fizzBuzz(int n){
		for(int i = 1; i <= n; i++){
//			if((i%3 == 0) && (i%5 == 0)){
//				System.out.println("fizzBuzz");
//			}
			if(i%15 == 0){
				System.out.println("fizzBuzz");
			}
			else if (i%3 == 0){
				System.out.println("fizz");
			}
			else if (i%5 == 0){
				System.out.println("Buzz");
			}
			else System.out.println(i);
			
		}
		
	}
}
