package com.lgy.spring_ex3_7;

public class Rectangle {
	
	public void precoess(int x, int y) {
		if (100<=x&&x<=200&&y>=100&&y<=200) {
			System.out.println("("+x+","+y+")"+"는 사각형 안에 있습니다.");
		} else {
			System.out.println("("+x+","+y+")"+"는 사각형 안에 없습니다.");
		}
	}
}
