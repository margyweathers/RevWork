package com.ex.threads;

public class Threads101 {

	/*
	 * Thread - single path of execution 
	 * 
	 * Multithreading - the process of creating multiple flows 
	 * of control in program execution 
	 * 
	 * there is always at least one thread in an application. The
	 * main() method executes on the main thread. We can spin up
	 * separate threads of execution by either implementing the 
	 * Runnable interface or extending the thread class
	 * 
	 * JVM determines when no more user threads are active
	 * 
	 * Thread States:
	 * New - thread is new 
	 * Runnable - thread is ready to run(may already be running, or
	 * 	is ready to run at any time)
	 * Blocked - aka waiting state. When a thread is temporarily 
	 * 	inactive. A thread is in the blocked state when it tries to
	 * 	access a protected(synchronized) section of code that is 
	 * 	currently locked in another thread
	 * Waiting - threads can be made to wait for other actions 
	 * Timed Waiting - threads can be made to wait for a specified
	 * 	amount of time 
	 * Terminated - a thread terminates either because it completes
	 * 	its task naturally or some exceptional event occurs
	 * 
	 * Related topics: Object class methods vs Thread class methods, 
	 * 	deadlock, starvation, producer-consumer problem
	 * 
	 * 
	 */


	public static void main(String[] args) {
		//main thread 
		
		ExtendsThread et = new ExtendsThread();
		ExtendsThread et2 = new ExtendsThread();
		
		et.setPriority(1);
//		System.out.println(et.getState());
		
		ImplementsRunnable ir = new ImplementsRunnable();
		//creates a thread (so we can actually start() it) with the run()
		// functionality of the runnable object created
		Thread it = new Thread(ir);
		
		et.start();
		it.start();
		et2.start();
//		System.out.println(et.getState());
		for(int i = 0; i < 20; i++) {
			System.out.println(i + ") IN MAIN THREAD");
		}
		
		System.out.println(et.getState());
		
		
		
		//LAMBDA INTRO
		//this variable lambda is an instance of a class that implements Runnable
		Runnable lambda = ()->{
			//IMPLEMENT RUN METHOD OF RUNNABLE INTERFACE WITHOUT CREATING NEW CLASS
			for(int i = 0; i < 20; i++) {
				System.out.println(i + ") IN LAMBDA THREAD");
			}
		};
		
		Runnable lambda3 = lambda; 		
		Runnable lambda2 = () -> System.out.println("do things");
		
		Thread lamThread = new Thread(lambda);
		lamThread.start();
//		lamThread.start(); //BAD -- leads to IllegalThreadStateException bc thread is already started
		Thread lam3Thread = new Thread(lambda3);
		Thread lam2Thread = new Thread(lambda2);
		lam2Thread.start();
		lam3Thread.start();
		
		//ANONYMOUS CLASSES -- nested class
		//anon var is an instance of an ANONYMOUS (not named) class that extends thread
		Thread anon = new Thread() {
			@Override
			public void run() {	test(); }			
			public synchronized void test() {
				System.out.println("In test method of anonymous class");
			}
		};
			
		Runnable anon2 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub			
			}			
		};
		
		anon.start();

		
	}
}
