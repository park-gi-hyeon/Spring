package com.lgy.spring_ex2_2;

public class SeasonDollar {
	public static void main(String[] args) {
		//의존+주입(dependecy Injection): DI
		Season season = new Season();
		
		//의존+주입(dependecy Injection): DI
		Won2dollar won2dollar = new Won2dollar();
		
		season.setMonth(9);
		season.process();
		won2dollar.setWon(3300);
		won2dollar.change();
	}
}
