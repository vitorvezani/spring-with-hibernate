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
		System.out.println("Executing performApiAnalytics...");
	}
	
}
