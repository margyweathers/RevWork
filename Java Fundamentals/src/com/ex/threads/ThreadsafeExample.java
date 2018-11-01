package com.ex.threads;

import java.util.ArrayList;
import java.util.Vector;

public class ThreadsafeExample {
	
	/*
	 * A simple example which shows why using the synchronized Vector class is necessary for multi-threading
	 *  - each ThreadsafeJob adds 100 strings to both the arraylist and vector objects
	 *  - we start two threads and then wait for them to finish executing
	 *  - then we report the number of exceptions thrown and null values inserted using arraylist
	 *  - thus we can see directly the advantage of Vector in multithreading applications
	 *  
	 *  the unexpected behavior with ArrayList may be sporadic or unpredictable as it depends on thread execution,
	 *  but without a synchronized class we cannot be sure that we won't have problems
	 */
	public static ArrayList<String> notsafe;
	public static Vector<String> safe;
	public static int numNullValues;

	public static void main(String[] args) {
		runExample();
		/* uncomment me for aggreggate statistics:
		for (int i=0;i<10;i++) {
			runExample(); // run the example multiple times
		}
		// display resulting average statistics
		float avgExceptions = (float) ThreadsafeJob.exceptionsCaught / 10;
		float avgNulls = numNullValues / 10;
		System.out.println("# Total exceptions: " + ThreadsafeJob.exceptionsCaught);
		System.out.println("# Total nulls: " + numNullValues);
		System.out.println("# Avg exceptions: " + avgExceptions);
		System.out.println("# Avg nulls: " + avgNulls);
		*/
	}
	
	public static void runExample() {
		notsafe = new ArrayList<>();
		safe = new Vector<>();
		Thread t1 = new Thread(new ThreadsafeJob(notsafe, safe));
		Thread t2 = new Thread(new ThreadsafeJob(notsafe, safe));
		System.out.println("Starting threads...");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
			System.out.println("Threads have finished executing");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ArrayList: "+notsafe);
		System.out.println("Vector:    "+safe);
		for (String s : notsafe) {
			if (s == null) {
				numNullValues++;
			}
		}
		System.out.println("# Exceptions thrown while adding to ArrayList: " + ThreadsafeJob.exceptionsCaught);
		System.out.println("# null values in ArrayList: " + numNullValues);
	}


}