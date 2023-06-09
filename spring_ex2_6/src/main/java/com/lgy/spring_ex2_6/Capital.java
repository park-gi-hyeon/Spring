package com.lgy.spring_ex2_6;

public class Capital {
	private char alpabet;

	public char getAlpabet() {
		return alpabet;
	}

	public void setAlpabet(char alpabet) {
		this.alpabet = alpabet;
	}
//	public void process() {
//	    StringBuilder output = new StringBuilder();
//	    for (char c = 'A'; c <= alpabet; c++) {
//	        output.append(c);
//	    }
//	    for (int i = output.length(); i > 0; i--) {
//	        System.out.println(output.substring(0, i));
//	    }
//	}
	public void process() {
		StringBuffer strBuf = new StringBuffer();
		char c= 'A';
		
		for (int i = alpabet; i >= c; i++) {
			for (int j = c; j <= i; j++) {
				strBuf.append(j);
			}
			strBuf.append("\n");
		}
		System.out.println(strBuf);
	}
}
