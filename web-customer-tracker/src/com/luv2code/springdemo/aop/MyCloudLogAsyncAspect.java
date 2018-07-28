package com.luv2code.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.luv2code.springdemo.aop.LogAopPointcutSupport.allpublicOnDao()")
	public void logToCloundAsync() {
		System.out.println("Executing logToCloundAsync...");
	}
	
}
