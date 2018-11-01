package com.revature.hw1.q22;

public class Q22 {

	public static void main(String[] args) {
		Area rectangle = (h, w) -> h*w;
		double recArea = rectangle.calculate(2, 3);
		System.out.println(recArea);
		
		Area triangle = (h, w) -> 0.5*h*w;
		double triArea = triangle.calculate(2, 3);
		System.out.println(triArea);
	}
	
	static double getRecArea(int a, int b) {
		Area rectangle = (h, w) -> h*w;
		return rectangle.calculate(a, b);		
	}
	
	static double getTriArea(int a, int b) {
		Area triangle = (h, w) -> 0.5*h*w;
		return triangle.calculate(a, b);
	}
}

