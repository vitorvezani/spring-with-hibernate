package com.luv2code.springdemo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	Logger logger = Logger.getLogger(getClass().getName());
	@Before("com.luv2code.springdemo.aop.LogAopPointcutSupport.allpublicOnDao()")
	public void logToCloundAsync() {
		logger.info("[before] Executing logToCloundAsync...");
	}
	
}
