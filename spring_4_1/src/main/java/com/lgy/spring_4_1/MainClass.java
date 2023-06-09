package com.lgy.spring_4_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLog = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLog);
		MyInfo myInfo = ctx.getBean("myInfo",MyInfo.class);
		
		myInfo.getInfo();
	}
}
