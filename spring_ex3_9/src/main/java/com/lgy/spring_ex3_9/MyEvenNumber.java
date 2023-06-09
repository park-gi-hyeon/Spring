package com.lgy.spring_ex3_9;

public class MyEvenNumber {
	private EvenNumber evenNumber;
	private int num;
	
	public EvenNumber getEvenNumber() {
		return evenNumber;
	}
	public void setEvenNumber(EvenNumber evenNumber) {
		this.evenNumber = evenNumber;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void process() {
		evenNumber.process(num);
	}
}
