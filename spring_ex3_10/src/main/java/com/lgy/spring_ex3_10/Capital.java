package com.lgy.spring_ex3_10;

public class Capital {
	public void alphabet(String str) {
		char c = 'A';
		char c2 = str.charAt(0);
		
		for (char i = c2; i >=c; i--) {
			for (char j = c; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
	}
}
