package com.luv2code.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAopPointcutSupport {

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDao() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forService() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forController() {}
	
	@Pointcut("forController() || forService() || forDao()")
	public void forAllMvcLayers() {}

}
