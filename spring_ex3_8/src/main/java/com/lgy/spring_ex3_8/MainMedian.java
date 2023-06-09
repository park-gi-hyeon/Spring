package com.lgy.spring_ex3_8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainMedian {
	public static void main(String[] args) {
		String configLoc = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyMedian mymedian = ctx.getBean("myMedian",MyMedian.class);
		
		mymedian.process();
	}
}
