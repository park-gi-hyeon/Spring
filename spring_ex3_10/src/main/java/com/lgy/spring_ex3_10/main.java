package com.lgy.spring_ex3_10;

public class main {
	public static void main(String[] args) {
		StringBuffer strBuf = new StringBuffer();
		char c= 'A';
		char c2 = 'F';
		
		for (int i = 2; i >= c; i++) {
			for (int j = c; j <= i; j++) {
				strBuf.append(j);
			}
			strBuf.append("\n");
		}
		System.out.println(strBuf);

	}
	public void alphabet(char c2) {
		StringBuffer strBuf = new StringBuffer();
		char c= 'A';
		
		for (int i = c2; i >= c; i++) {
			for (int j = c; j <= i; j++) {
				strBuf.append(j);
			}
			strBuf.append("\n");
		}
		System.out.println(strBuf);
	}
}
