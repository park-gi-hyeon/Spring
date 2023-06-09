package com.lgy.spring_3_1;

public class MainClass {
	public static void main(String[] args) {
		MyCalculator myCalculator = new MyCalculator();
		//myCalculation에 클래스를 받아오기 위한 Calculator셋팅
		myCalculator.setCalculator(new Calculator());
		
		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(2);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
	}
}
