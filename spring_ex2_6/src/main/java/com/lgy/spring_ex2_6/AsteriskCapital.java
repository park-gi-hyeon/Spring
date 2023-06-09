package com.lgy.spring_ex2_6;

public class AsteriskCapital {
	public static void main(String[] args) {
		Asterisk asterisk = new Asterisk();
		Capital capital = new Capital();
	
		asterisk.setNum(5);
		asterisk.process();
		
		capital.setAlpabet('F');
		capital.process();
	}	
}
