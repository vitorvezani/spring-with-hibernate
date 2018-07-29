package com.luv2code.springdemo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotifyOpsTeamAdvice {
	Logger logger = Logger.getLogger(getClass().getName());
	@AfterThrowing(pointcut = "com.luv2code.springdemo.aop.LogAopPointcutSupport.forController()",
			throwing = "exception")
	public void performApiAnalytics(JoinPoint jp, Throwable exception) {
		logger.info("[after-throwing] Notyfing OPS team for exception: " + exception.getMessage());
	}
	
}
