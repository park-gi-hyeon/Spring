package com.lgy.spring_ex2_5;

public class MultipleTriangle {
	public static void main(String[] args) {
		Multiple multiple = new Multiple();
		Triangle triangle = new Triangle();
		
		multiple.setNum(240);
		multiple.process();
		
		triangle.process(4, 3, 5);
	}
}
