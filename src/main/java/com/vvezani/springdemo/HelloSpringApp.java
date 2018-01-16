package com.vvezani.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

  public static void main(String[] args) {
    // load the spring bean configuration file
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from spring container
    Coach coach = ctx.getBean("myCoach", Coach.class);

    // calling the method
    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());

    // close the appContext
    ctx.close();
  }
}
