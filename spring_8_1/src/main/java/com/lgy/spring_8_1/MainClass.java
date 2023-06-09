package com.lgy.spring_8_1;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableApplicationContext 인터페이스를 이용해서 Environment 객체 생성
		ConfigurableEnvironment env = ctx.getEnvironment();
//		getPropertySources()를 이용해서 프로퍼티 소스 객체 생성
		MutablePropertySources propertySources = env.getPropertySources();
		try {
//			ResourcePropertySource 객체를 이용해서 외부파일 정보를 가져와서 프로퍼티 소스에 추가
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
//			@#  id ===>abcde
//			@#  pw ===>12345
			System.out.println("@#  id ===>"+env.getProperty("admin.id"));
			System.out.println("@#  pw ===>"+env.getProperty("admin.pw"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		GenericXmlApplicationContext 클래스로 다운 캐스팅
		GenericXmlApplicationContext gctx = (GenericXmlApplicationContext) ctx;
//		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationCTX.xml]
		gctx.load("applicationCTX.xml");
//		객체 생성전과 객체 생성시 해당되는 메소드 호출 ->프로퍼티 값들 저장(값들이 xml에는 없는데 파일쪽에 있던 값을 빈을 만들면서 생겼음) 
//		private Environment env; // 객체 생성전에 environment 객체를 받아서 저장
//		private String adminId;
//		private String adminPW;
		
		
//		@# setEnvironment()
//		@# afterPropertiesSet()
		gctx.refresh();
		
//		admin ID : abcde
//		admin PW : 12345
		
		AdminConnection adminConnection = gctx.getBean("adminConnection",AdminConnection.class);
		System.out.println("admin ID : "+adminConnection.getAdminId());
		System.out.println("admin PW : "+adminConnection.getAdminPw());
	}
}
