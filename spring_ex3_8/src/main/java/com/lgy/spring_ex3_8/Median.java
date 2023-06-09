package com.lgy.spring_ex3_8;

public class Median {
	public void processs(int num1,int num2,int num3) {
		if (num1<num2 && num1>num3 ||num1>num2 && num1<num3) {
			System.out.println("입력된 정수가"+num1+"와 "+num2+"와 "+num3+"의 중간값은 "+num1);
		}else if(num1<num2 && num2< num3 || num3<num2 && num2<num1) {
			System.out.println("입력된 정수가"+num1+"와 "+num2+"와 "+num3+"의 중간값은 "+num2);
		}else {
			System.out.println("입력된 정수가"+num1+"와 "+num2+"와 "+num3+"의 중간값은 "+num3);
		}
	}
}
