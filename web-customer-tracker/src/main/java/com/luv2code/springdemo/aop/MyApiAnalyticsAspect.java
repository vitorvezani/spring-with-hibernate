package com.luv2code.springdemo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("com.luv2code.springdemo.aop.LogAopPointcutSupport.forAllMvcLayers()")
	public void performApiAnalytics(JoinPoint jp) {
		logger.info("[before] Executing performApiAnalytics...");
	}
	
}
