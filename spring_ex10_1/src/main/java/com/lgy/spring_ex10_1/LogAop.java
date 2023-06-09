package com.lgy.spring_ex10_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
	@Pointcut("within(com.lgy.spring_ex10_1.*)")
	private void pointCutMethod() {}
	
	@Around("pointCutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println("@@@##start===>"+signatureStr);
		Object obj=null;
		try {
			obj = joinPoint.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			long et = System.currentTimeMillis();
			System.out.println("@@@##start===>"+signatureStr);
		
		}
		
		return obj;
	}
}