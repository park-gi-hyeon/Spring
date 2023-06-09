package com.lgy.spring_2_1;

public class Circle {
	private int num  =0;
	
	public void circlearea() {
		System.out.println("원의 면적은 "+(num*num)*3.14);
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}
}
