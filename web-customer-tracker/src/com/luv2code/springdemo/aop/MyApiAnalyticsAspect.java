package com.luv2code.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

	@Before("com.luv2code.springdemo.aop.LogAopPointcutSupport.forDaoPackageNoGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("Executing performApiAnalytics...");
	}
	
}
