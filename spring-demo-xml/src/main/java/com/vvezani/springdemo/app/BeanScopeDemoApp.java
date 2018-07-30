package com.vvezani.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vvezani.springdemo.coach.Coach;

public class BeanScopeDemoApp {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beansLifeCycleApplicationContext.xml");

    Coach coach = ctx.getBean("baseballCoach", Coach.class);

    Coach alphaCoach = ctx.getBean("baseballCoach", Coach.class);

    System.out.println("coach: " + coach);
    System.out.println("alphaCoach: " + alphaCoach);

    System.out.println("Are the two beans the same object: " + String.valueOf(coach == alphaCoach));

    ctx.close();

  }

}
