package com.lgy.spring_ex3_1;

public class MyCircle {
	private Circle circle;
	private int radius;
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public void area() {
		circle.getArea(radius);
	}
}
