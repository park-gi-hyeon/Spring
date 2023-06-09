package com.lgy.spring_ex2_3;

public class DivAndReamins {
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void match() {
		int ten = num/10;
		int one = num%10;
		if (ten==one) {
			System.out.println("10의 자리와 1의 자리가 같습니다.");
		} else {
			System.out.println("10의 자리와 1의 자리가 다릅니다.");
		}
	}
}
