package com.lgy.spring_2_1;

public class Draw {
	public static void main(String[] args) {
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		
		circle.setNum(10);
		rectangle.setWidth(20);
		rectangle.setHeight(30);
		
		circle.circlearea();
		rectangle.getArea();
	}
}
