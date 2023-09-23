package com.promineotech;

import java.util.Random;


public class TestDemo {

	public int addPositive(int a, int b) {
		int sum = 0;
		
		if (a > 0 && b > 0) {
			sum = a + b;
		} else if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		
		return sum;
	}
	
	public double divideTwoIntegers(double c, double d) {
		double quotient = 0.0;
		
		if (d == 0) {
			throw new ArithmeticException("You cant divide by zero.");
		} else {
			quotient = c / d;
			return quotient;
		} 	
	}
	public int randomNumberSquared() {
		int ranInt = getRandomInt(); 
		
		return ranInt * ranInt; 	
	}
	
	int getRandomInt() {
		Random random = new Random(); 
		
		return random.nextInt(10) + 1;
	}
	
	
}