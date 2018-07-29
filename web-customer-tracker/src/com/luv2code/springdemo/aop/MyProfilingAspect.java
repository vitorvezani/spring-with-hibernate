package com.luv2code.springdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-99)
public class MyProfilingAspect {

	@Around("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public Object performProfilingAnalytics(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[around-before] Executing performProfilingAnalytics for method " + pjp.getSignature());
		long begin = System.currentTimeMillis();
		Object result = pjp.proceed();
		long end = System.currentTimeMillis();
		long duration = end - begin;
		System.out.println("[around-after] Duration: " + duration + " milliseconds");
		return result;
	}
	
}
