package com.ex.threads;

public class ExtendsThread extends Thread {

	@Override
	public void run() {
		// starting point of a separate path of execution

		for (int i = 0; i < 20; i++) {
			System.out.println(i + ") In Extended Thread");
		}
	}

}
