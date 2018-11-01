package com.revature.hw1.q13;

public class Q13 {

	public static void main(String[] args) {

		// Number of lines to print
		int numLines = 4;
		printPattern(numLines);

	}

	static String printPattern(int numLines) {
		if (numLines <= 0) {
			System.out.println("No pattern will print");
			System.exit(0);
		}	
		// String for test case
		String pattern = "";

		boolean printZero = true;
		for(int i = 1; i <= numLines; i++) {
			for(int j = 1; j <= i; j++) {
				if(printZero) {
					System.out.print(0 + " ");
					pattern += "0 ";
					printZero = false;
				}
				else {
					System.out.print(1 + " ");
					pattern += "1 ";
					printZero = true;
				}
			}
			if(i == numLines) break;	// Prevents from printing extra line at the end
			System.out.println();
			pattern += "\n";
		}

		return pattern;		
	}

}


