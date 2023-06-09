package com.lgy.spring_10_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student = ctx.getBean("student", Student.class);
//		학생정보 출력(핵심기능 - 메소드)
		student.getStudentInfo();
		
		Worker worker = ctx.getBean("worker", Worker.class);
//		노동자정보 출력(핵심기능 - 메소드)
		worker.getWorkerInfo();
		
//		공통기능
//		Worker.getWorkerInfo()is start.
		
//		핵심기능
//		이름 : 홍길순
//		나이 : 35
//		직업 : 개발자
		
//		공통기능
//		Worker.getWorkerInfo()is finished.
//		Worker.getWorkerInfo()의 경과시간 : 0
		
//		공통기능
//		Student.getStudentInfo()is start.
		
//		핵심기능
//		이름 : 홍길동
//		나이 : 10
//		학년 : 3
//		반 : 5
		
//		공통기능
//		Student.getStudentInfo()is finished.
//		Student.getStudentInfo()의 경과시간 : 0
	}
}






