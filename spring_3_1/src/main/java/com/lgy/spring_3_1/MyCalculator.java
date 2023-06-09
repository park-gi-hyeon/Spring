package com.lgy.spring_3_1;

public class MyCalculator {
	private Calculator calculator;
	private int firstNum;
	private int secondNum;
	
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	public void add() {
		calculator.addtion(firstNum, secondNum);
	}
	public void sub() {
		calculator.subtracion(firstNum, secondNum);
	}
	public void mul() {
		calculator.multiplication(firstNum, secondNum);
	}
	public void div() {
		calculator.division(firstNum, secondNum);
	}
}
