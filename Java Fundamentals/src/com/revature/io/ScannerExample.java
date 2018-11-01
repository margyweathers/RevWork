package com.revature.io;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.pojos.Person;


public class ScannerExample {

	public static void main(String[] args) {

//		runGreeting();
		System.out.println(addNums());

	}

	static void runGreeting(){
		// Instantiate scanner
		Scanner scanner = new Scanner(System.in);	// 'in' is static field!

		System.out.println("name?");
		String name = scanner.nextLine();
		System.out.println("hobby?");
		String hobby = scanner.nextLine();
		System.out.println("age?");

		int age = 0;
		try{
			age = scanner.nextInt();	// Must declare and initialize age outside of block
			Person p = new Person(name, hobby, age);
			System.out.println(p);
		}
		catch(InputMismatchException e){
			System.out.println("InputMismatch, need int");
			//			e.printStackTrace();
			runGreeting();
		}

		//		THIS NOW NEEDS TO GO IN THE TRY BLOCK		
		//		Person p = new Person(name, hobby, age);
		//		System.out.println(p);			// override toString() in Person



		scanner.close();
	}
	
	static int addNums(){
		
		Scanner in = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int sum = 0;
		System.out.println("nums?");
		try{
			a = in.nextInt();
			b = in.nextInt();
			sum = a+b;
		}
		catch(InputMismatchException e){
			System.out.println("not an int");
			addNums();
		}
		finally{
			in.close();
		}
		
		return sum;
	}

}
