package com.lgy.spring_ex3_6;

public class MyDivAndRemains {
	private DivAndRemains divAndRemains;
	private int num;
	
	public DivAndRemains getDivAndRemains() {
		return divAndRemains;
	}
	public void setDivAndRemains(DivAndRemains divAndRemains) {
		this.divAndRemains = divAndRemains;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void process() {
		divAndRemains.process(num);
	}
}
