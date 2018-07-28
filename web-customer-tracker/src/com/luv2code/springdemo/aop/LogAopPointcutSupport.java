package com.luv2code.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAopPointcutSupport {

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void allOnDao() {}
	
	@Pointcut("execution(public * com.luv2code.springdemo.dao.*.*(..))")
	public void allpublicOnDao() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.get*(..))")
	public void gettersOnDao() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.set*(..))")
	public void settersOnDao() {}
	
	@Pointcut("allOnDao() && !(gettersOnDao() || settersOnDao())")
	public void forDaoPackageNoGetterAndSetter() {}

}
