package com.luv2code.springdemo.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.entity.Customer;

@Aspect
@Component
@Order(3)
public class MyLogInAppAspect {

	@Before("com.luv2code.springdemo.aop.LogAopPointcutSupport.allpublicOnDao()")
	public void beforeLogInApp(JoinPoint jp) {
		// display method signature
		System.out.println(jp.getSignature());
		// display method args
		for (Object arg : jp.getArgs()) {
			System.out.println(arg);
		}
		System.out.println("[before] Executing beforeLogInApp...");
	}
	
	@AfterReturning(
			pointcut = "execution(* com.luv2code.springdemo.dao.CustomerDAO.getCustomers(..))",
			returning = "result")
	public void AfterReturningLogInApp(JoinPoint jp, List<Customer> result) {
		System.out.println("[after-returning] Executing " + jp.getSignature() + "...");
		System.out.println("[after-returning] Result is " + result);
	}
	
	@After("execution(* com.luv2code.springdemo.dao.CustomerDAO.getCustomers(..))")
	public void AfterLogInApp(JoinPoint jp) {
		System.out.println("[after] Executing " + jp.getSignature() + "...");
	}
	
}
