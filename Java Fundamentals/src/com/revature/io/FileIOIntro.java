package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOIntro {
	/*
	 * Some of the many tools that can be used to read from 
	 * and write to files are BufferedReader/Writer and 
	 * FileReader/Writer of the java.io package
	 */

	public static void main(String[] args) {
		System.out.println(read());
//		write("We are now appending text to our file again");
	}
	public static void write(String text) {
		/*
		 * TRY-WITH-RESOURCES -> parameterized try block. Can 
		 * only be used with resources that implement the 
		 * Autocloseable interface so that you do not need a 
		 * finally block to close the resource
		 */
		try(BufferedWriter bw = 
				new BufferedWriter(new FileWriter("text.txt", true));){
		
			bw.write(text + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String read() {
		String text = "";
		try(BufferedReader br = new BufferedReader(new FileReader("text.txt"))){
			 text = "";
			String line = null;
			while((line = br.readLine())!=null) {
				text += line + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
}
