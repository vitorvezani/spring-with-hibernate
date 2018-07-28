package com.luv2code.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAopSupport {

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void allOnDao() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.get*(..))")
	private void gettersOnDao() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.set*(..))")
	private void settersOnDao() {}
	
	@Pointcut("allOnDao() && !(gettersOnDao() || settersOnDao())")
	private void forDaoPackageNoGetterAndSetter() {}
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void logAll() {
		System.out.println("Executing logAll...");
	}
	
	@Before("allOnDao()")
	public void logDaoCalls() {
		System.out.println("Executing @Before advice on getCustomers");
	}
	
	@Before("allOnDao()")
	public void apiIntegration() {
		System.out.println("Executing apiIntegration...");
	}
}
