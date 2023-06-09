package com.lgy.spring_7_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		스프링 설정(xml 스프링 설정파일 로딩)
		ctx.load("classpath:applicationCTX.xml");
//		새로고침(설정 반영) : 생략해도 객체 정보 출력에는 문제 없음
		ctx.refresh();
		
		Student student = ctx.getBean("student",Student.class);
//		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationCTX.xml]
//		홍길순
//		30

//		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationCTX.xml]			INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@2957fcb0: startup date [Mon May 22 13:15:21 KST 2023]; root of context hierarchy
//		INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2d3fcdbd: defining beans [student]; root of factory hierarchy
//		홍길순
//		30
//		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@2957fcb0: startup date [Mon May 22 13:15:21 KST 2023]; root of context hierarchy
//		INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2d3fcdbd: defining beans [student]; root of factory hierarchy
		
		
		System.out.println(student.getName());
		System.out.println(student.getAge());
		
		ctx.close();
	}
}
