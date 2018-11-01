package com.revature.hw1Attemps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);

		System.out.println("input 1: ");
		long p = validatePrinciple(scanner);
		System.out.println("input 2: ");
		long s = validatePrinciple(scanner);
//
//		System.out.println("Enter principle: ");
//		String pString = in.nextLine();
//		System.out.println("Enter interest rate as decimal percentage: ");
//		String rString = in.nextLine();
//		System.out.println("Enter time in years: ");
//		String tString = in.nextLine();





	}


	// Must positive whole number greater than 1
	static long validatePrinciple(Scanner scanner) {
		long p = -1;
		//		Scanner scanner = new Scanner(System.in);
		try {
			p = scanner.nextLong();
			if (p <= 0) {
				System.out.println("Must be greater than 0. Enter Principle: ");
				p = validatePrinciple(scanner);
			}
		}catch(InputMismatchException e) {
			System.out.println("Not a valid a whole number. Enter principle: ");
			p = validatePrinciple(scanner);
		}
		//		finally {
		//			scanner.close();
		//		}

		return p;
	}

	// Must be between 0.00 exclusive and 1.00 inclusive
	static double validateRate() {
		double r = 0.0;
		Scanner scanner = new Scanner(System.in);
		try {
			r = scanner.nextDouble();
			if (r <= 0.0 || r > 1.0) {
				System.out.println("Rate must be a decimal percentage greater than 0. Enter rate: ");
				r = validateRate();
			}
		}catch(InputMismatchException e) {
			System.out.println("Not a valid number. Enter rate: ");
			r = validateRate();
		}finally {
			scanner.close();
		}

		return r;
	}


}
