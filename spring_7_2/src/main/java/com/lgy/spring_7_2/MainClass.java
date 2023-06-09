package com.lgy.spring_7_2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
//		@# afterPropertiesSet()1.  빈생성 시 호출
//		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@2957fcb0: startup date [Mon May 22 14:53:21 KST 2023]; root of context hierarchy
//		INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2d3fcdbd: defining beans [student,otherStudent]; root of factory hierarchy
//		@# destroy()4. 소멸후 호출 -->close()하면서 호출이 됨
		ctx.refresh();
		
//		xml에 있는 namespaces에 context를 체크해야함
//		xml에 있는 <context:annotation-config></context:annotation-config> 추가하면 @PostConstruct,@PreDestroy 2개가 동작됨
//		@# afterPropertiesSet()
//		@# initMethod()
//		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@2957fcb0: startup date [Mon May 22 14:57:01 KST 2023]; root of context hierarchy
//		INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@36d4b5c: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,student,otherStudent,org.springframework.context.annotation.ConfigurationClassPostProcessor$ImportAwareBeanPostProcessor#0]; root of factory hierarchy
//		@# destroyMethod()
//		@# destroy()
		
		ctx.close();
	}
}
