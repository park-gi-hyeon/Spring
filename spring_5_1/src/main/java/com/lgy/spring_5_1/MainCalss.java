package com.lgy.spring_5_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainCalss {
	public static void main(String[] args) {
		String configLoc ="classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		StudentInfo studentInfo = ctx.getBean("studentInfo",StudentInfo.class);
//		이름~반 출력
//		이름 : 홍길동
//		나이 : 10살
//		학년 : 3학년
//		반 : 2반
//		==============================
		studentInfo.getStudentInfo();
		
//		student2 : 홍길순 객체
		Student student2 =ctx.getBean("student2",Student.class);
		studentInfo.setStudent(student2);
		studentInfo.getStudentInfo();
		
		ctx.close();//자원반납
	}
}
