package com.lgy.spring_ex2_4;

public class RectangleMedian {
	public static void main(String[] args) {
		Rectangle rectange = new Rectangle();
		Median median = new Median();
		
		rectange.precoess(150, 150);
		median.setA(20);;
		median.setB(100);;
		median.setC(33);;
		median.process();
	}
}
