package com.lgy.spring_ex5_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLoc = "classpath:circleCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		CircleInfo circleInfo = ctx.getBean("circleInfo", CircleInfo.class);
		circleInfo.getCircleInfo();
		
		Circle circle2 = ctx.getBean("circle2", Circle.class);
		circleInfo.setCircle(circle2);
		circleInfo.getCircleInfo();
		
		ctx.close();
	}
}


