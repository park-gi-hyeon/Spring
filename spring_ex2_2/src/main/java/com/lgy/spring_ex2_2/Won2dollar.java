package com.lgy.spring_ex2_2;

public class Won2dollar {
	private int won;
	
	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public void change() {
		System.out.println("$"+(won/1200.0));
	}
}
