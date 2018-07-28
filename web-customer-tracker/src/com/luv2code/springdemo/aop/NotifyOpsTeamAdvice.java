package com.luv2code.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotifyOpsTeamAdvice {

	@AfterThrowing(pointcut = "execution(* com.luv2code.springdemo.controller.*.*(..))",
			throwing = "exception")
	public void performApiAnalytics(JoinPoint jp, Throwable exception) {
		System.out.println("Notyfing OPS team for exception: " + exception.getMessage());
	}
	
}
