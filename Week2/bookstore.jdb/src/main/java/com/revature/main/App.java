package com.revature.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.projos.Book;
import com.revature.service.BookService;

public class App {
	
	static BookService bService = new BookService();
	
	public static void main(String[] args) {
			run();
		
//		DAO<Genre, Integer> gDao = new GenreDao();
		
//		List<Genre> genres = gDao.findAll();
//		for(Genre g : genres) {
//			System.out.println(g);
//		}
//		
//		System.out.println();
//		Genre g = gDao.findById(2);
//		System.out.println(g);

		
//		Genre g = gDao.save(new Genre("New Saved Genre"));
	}
	
	static void run() {
		System.out.println("Barne's and Noble options:"
				+ "\n1. view all books"
				+ "\n2. view books by genre"
				+ "\n3. view books by author"
				+ "\n4. add book to the library");
		Scanner scan = new Scanner(System.in);
		int option = 0;
		try {
			option = scan.nextInt();
			switch(option) {
			case 1: viewAllBooks(); break;
			case 2:
			case 3:
			case 4:
			default:
				System.out.println("Not a valid number option");
				run(); break;
			}
		}catch(InputMismatchException e) {
			System.out.println("Must enter a numerical choice");
			run();
			
		}
	}
	
	static void viewAllBooks() {
		List<Book> books = bService.getAllBooks();
		if (books == null) {
			System.out.println("Book supply currently empty");
		}
		else {
			for (Book b : books) {
				System.out.println(b.getTitle());
			}
		}
	}

}
