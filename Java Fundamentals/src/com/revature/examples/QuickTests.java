package com.revature.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class QuickTests {

	public static void main(String[] args) {
        Welcome welcomeToALanguage =  language -> System.out.println("Welcome to world of " + language);
        welcomeToALanguage.welcome("Java");
        welcomeToALanguage.welcome("Groovy");
        welcomeToALanguage.welcome("Scala");
        
        
        
//        // create a list of strings 
//        List<String> names = 
//            Arrays.asList("Geek","GeeksQuiz","g1","QA","Geek2"); 
//  
//        // declare the predicate type as string and use 
//        // lambda expression to create object 
//        Predicate<String> p = (s)->s.startsWith("G"); 
//  
//        // Iterate through the list 
//        for (String st:names) 
//        { 
//            // call the test method 
//            if (p.test(st)) 
//                System.out.println(st); 
//        } 
        
	}

	interface Welcome {
		abstract void welcome(String string);
	}
}


