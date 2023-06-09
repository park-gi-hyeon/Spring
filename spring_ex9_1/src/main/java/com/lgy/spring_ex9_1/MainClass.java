package com.lgy.spring_ex9_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Professor professor = ctx.getBean("professor",Professor.class);
		professor.getProfessorInfo(); //핵심기능 호출하면서 공통기능 호출
		
		Singer singer = ctx.getBean("singer",Singer.class);
		singer.getSingerInfo();
	}
}
