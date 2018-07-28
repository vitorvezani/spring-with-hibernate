package com.luv2code.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

	@Before("com.luv2code.springdemo.aop.LogAopPointcutSupport.allpublicOnDao()")
	public void performApiAnalytics(JoinPoint jp) {
		// display method signature
		System.out.println(jp.getSignature());
		// display method args
		for (Object arg : jp.getArgs()) {
			System.out.println(arg);
		}
		System.out.println("Executing performApiAnalytics...");
	}
	
}
