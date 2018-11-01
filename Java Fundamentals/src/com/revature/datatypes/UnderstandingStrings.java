package com.revature.datatypes;

public class UnderstandingStrings {
	
	public static void main(String[] args) {
	
		String a = "hello";
		String b = new String ("hello");
		String c = "hello";
		String d = new String();
		
		System.out.println(a == b);			//false
		System.out.println(a.equals(b));	//true
		System.out.println(a == c);			//true
		System.out.println(d == null);		//false
		System.out.println(d.equals(""));	//true
		a.concat(" world");
		System.out.println(a);				// "hello"
		System.out.println(a.concat(" world")); // "hello world"
		
		// String Builder
		StringBuilder sbuild = new StringBuilder(a);
		sbuild.append(" -- building a string");			// actually changing the string builder
		System.out.println(sbuild);
		sbuild.reverse();								// !!
		
		// String Buffer
		StringBuffer sbuff = new StringBuffer("this is a string buffer");
		
//		static StringBuilder toBinary(int x){
//			String out = "";
//			while (x >0){
//				out+= x%2;
//				x /= 2;
//				// etc.
//			}
//			return 
//		}
		
	}
	

}
