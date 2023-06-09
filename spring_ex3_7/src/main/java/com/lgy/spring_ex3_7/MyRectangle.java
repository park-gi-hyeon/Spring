package com.lgy.spring_ex3_7;

public class MyRectangle {
	private Rectangle rectangle;
	private int x,y;
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void process() {
		rectangle.precoess(x, y);
	}
}
