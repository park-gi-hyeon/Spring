package com.lgy.spring_ex2_5;

public class Triangle {
	private int a,b,c;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	public void process(int a,int b,int c) {
		if(a+b>c ||a+c>b||b+c>a) {
			System.out.println("삼각형이 됩니다");
		}
	}
}
