package com.luv2code.springdemo.aop;

import java.util.List;
import java.util.logging.Logger;

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
	Logger logger = Logger.getLogger(getClass().getName());
	@Before("com.luv2code.springdemo.aop.LogAopPointcutSupport.allpublicOnDao()")
	public void beforeLogInApp(JoinPoint jp) {
		// display method signature
		logger.info(jp.getSignature().toShortString());
		// display method args
		for (Object arg : jp.getArgs()) {
			logger.info(arg.toString());
		}
		logger.info("[before] Executing beforeLogInApp...");
	}
	
	@AfterReturning(
			pointcut = "execution(* com.luv2code.springdemo.dao.CustomerDAO.getCustomers(..))",
			returning = "result")
	public void AfterReturningLogInApp(JoinPoint jp, List<Customer> result) {
		logger.info("[after-returning] Executing " + jp.getSignature() + "...");
		logger.info("[after-returning] Result is " + result);
	}
	
	@After("execution(* com.luv2code.springdemo.dao.CustomerDAO.getCustomers(..))")
	public void AfterLogInApp(JoinPoint jp) {
		logger.info("[after] Executing " + jp.getSignature() + "...");
	}
	
}
