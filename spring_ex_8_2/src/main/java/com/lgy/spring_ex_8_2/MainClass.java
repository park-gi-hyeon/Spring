package com.lgy.spring_ex_8_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationCTX.xml");
		dbConnection bconnection = ctx.getBean("dbConnection",dbConnection.class);
		
		System.out.println("mssqlID : "+bconnection.getMssqlId());
		System.out.println("mssqlPW : "+bconnection.getMssqlPw());
		System.out.println("mysqlID : "+bconnection.getMysqlId());
		System.out.println("mysqlPW : "+bconnection.getMysqlPw());
	}
}
