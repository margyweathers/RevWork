package com.ex.threads;

import java.util.ArrayList;
import java.util.Vector;

public class ThreadsafeJob implements Runnable{
	
	public ArrayList<String> notsafe;
	public Vector<String> safe;
	public static int exceptionsCaught;

	@Override
	public void run() {
		for (int i=0;i<100;i++) {
			try {
				this.notsafe.add("a");
			} catch (Exception e) {
				exceptionsCaught++; // count all the exceptions thrown when trying to access an ArrayList
				e.printStackTrace(); // also print the stack trace
			}
			this.safe.add("a"); // this should not cause us any problems, as Vector is synchronized
		}
	}
	
	public ThreadsafeJob(ArrayList<String> al,Vector<String> v) {
		this.notsafe = al;
		this.safe = v;
	}



}
