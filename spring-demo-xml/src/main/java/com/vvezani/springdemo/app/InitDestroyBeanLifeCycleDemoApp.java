package com.vvezani.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vvezani.springdemo.coach.Coach;

public class InitDestroyBeanLifeCycleDemoApp {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beansLifeCycleApplicationContext.xml");

    Coach singletonCoach = ctx.getBean("singletonCoach", Coach.class);

    Coach prototypeCoach = ctx.getBean("prototypeCoach", Coach.class);

    ctx.close();
  }

}
