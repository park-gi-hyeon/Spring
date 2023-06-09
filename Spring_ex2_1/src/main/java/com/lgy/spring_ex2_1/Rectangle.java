package com.lgy.spring_ex2_1;

public class Rectangle {
	int width,height = 0;
	
	public void getArea() {
		System.out.println("사각형의 면적은 "+width*height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
