package com.revature.classbasics;

public class Operators {

	/*
	 * Operators are special symbols that can be applied to a set of variables, 
	 * values, or literals (referred to as operands) that return a result
	 * 
	 * There are unary, binary, and ternary operators with 1, 2, and 3 operands, respectively.
	 */
	
	public static void main(String[] args) {
		System.out.println(postIncrement(4)); // false
		System.out.println(preIncrement(4)); // true
		testUnary(4);						// 5
		System.out.println(complement(5));	// -6
		Object o = new Integer(5);
		System.out.println(relational(o));	// false
		System.out.println(ternary(6));
		moreTern(true, 6);
	}
	
	static boolean postIncrement(int count){
		return count++ == 5;
	}
	static boolean preIncrement(int count){
		return ++count == 5;
	}
	static void testUnary(int count){
		if(count++ < 5){
			System.out.println(count);
		}
	}
	// Two's complement: n = -(n+1)
	static int complement (int x){
		return ~x;
	}
	
	// Bit shift << >> >>>
	/*
	 * Signed Left Shift
	 * 212		=	 11010100
	 * 212 << 1 =	110101000	= 424
	 */
	static int leftShift(int num, int shift){
		return num << shift;
	}
	
	static boolean relational(Object obj){
		if(obj instanceof String){
			return true;
		}
		else return false;
	}
	
	/* Bitwise &, |
	 * 	compare the corresponding bits of the operands
	 * 
	 * 12	->	001100 
	 * |25	->	011001
	 * 		= 	011101 = 29
	 */
	static int bitwiseOr(int a, int b){
		return a|b;
	}
	
	/* Ternary
	 * 3 operands
	 * [expression] ? [val for T]:[val for F]
	 */
	static String ternary(int x){
		return x > 0 ? "x is greater than 0" : "x is less than 0";
	}
	
	static void moreTern(boolean cond, int x){
		String testing = cond ? (x>0 ? "op1" : "op2") : "op3";
		System.out.println(testing);
	}
	
	static void toBinary(int num){
		int binary;
		while (num > 0){
			
		}
	}
}





